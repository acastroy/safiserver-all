package com.safi.asterisk.handler.mbean;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.log4j.Appender;
import org.apache.log4j.Category;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggingEvent;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.jmx.export.notification.NotificationPublisher;
import org.springframework.jmx.export.notification.NotificationPublisherAware;
import org.springframework.jmx.export.notification.UnableToSendNotificationException;
import com.safi.asterisk.handler.GlobalVariableManager;
import com.safi.asterisk.handler.HandlerInfo;
import com.safi.asterisk.handler.SafletEngine;
import com.safi.asterisk.handler.connection.SFTPConnectionManager;
import com.safi.asterisk.handler.connection.SSHException;
import com.safi.asterisk.handler.util.FileUtils;
import com.safi.core.saflet.Saflet;
import com.safi.db.Variable;
import com.safi.db.manager.DBManager;
import com.safi.db.manager.DBManagerException;
import com.safi.db.manager.PooledDataSourceManager;
import com.safi.db.server.config.AsteriskServer;
import com.safi.db.server.config.Prompt;

public class SafiServerMonitorImpl implements NotificationPublisherAware,
    SafiServerMonitor, DisposableBean {

	private final static int DEFAULT_SERVER_UPDATE_PERIOD = 60;
	private final static Logger log = Logger.getLogger(SafiServerMonitor.class);
	private SafletEngine handlerEngine;
	private NotificationPublisher publisher;
	private final static AtomicInteger sequenceNumber = new AtomicInteger(0);
	private int threadCount;
	private Level tracelogLevel;
	private SafiWorkshopAppender remoteAppender;
	private FileAppender safiServerAppender;
	private static Timer serverInfoTimer = new Timer();
	private static ServerInfoTimerTask serverInfoUpdateTask;
	private int updatePeriod;
	private Map<Integer, DebugRemoteControl> debugSessionMap = new HashMap<Integer, DebugRemoteControl>();

	public SafiServerMonitorImpl() {
		updatePeriod = DEFAULT_SERVER_UPDATE_PERIOD;
		remoteAppender = new SafiWorkshopAppender();

	}

	@Override
	public void destroy() throws Exception {
		if (publisher != null && serverInfoUpdateTask != null)
			serverInfoUpdateTask.removePublisher(publisher);

	}

	public SafletEngine getHandlerEngine() {
		return handlerEngine;
	}

	public void setHandlerEngine(SafletEngine handlerEngine) {
		this.handlerEngine = handlerEngine;
		if (handlerEngine != null)
			handlerEngine.setServerMonitor(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.safi.asterisk.handler.SafiServerMonitor#getCurrentThreadCount()
	 */
	public int getCurrentThreadCount() {
		return handlerEngine.getThreadPool().getActiveCount();
	}

	public int getMaxThreadCount() {
		return handlerEngine.getThreadPool().getMaximumPoolSize();
	}

	private static int getCurrentThreadCountStatic() {
		return SafletEngine.getInstance().getThreadPool().getActiveCount();
	}

	private static int getMaxThreadCountStatic() {
		return SafletEngine.getInstance().getThreadPool().getMaximumPoolSize();
	}

	public void setCurrentThreadCount(int threadCount) {
		int oldCount = this.threadCount;
		this.threadCount = threadCount;
		if (publisher != null) {
			javax.management.Notification n = new javax.management.AttributeChangeNotification(
			    this, sequenceNumber.getAndIncrement(), System.currentTimeMillis(),
			    "CacheSize changed", "CacheSize", "int", oldCount, threadCount);
			publisher.sendNotification(n);
		}
	}

	public void postError(String title, String message)
	    throws UnableToSendNotificationException {
		if (publisher != null) {
			postError(publisher, title, message, this);
		}
	}

	private static void postError(NotificationPublisher publisher, String title,
	    String message, Object source) throws UnableToSendNotificationException {
		if (publisher != null) {
			log.error("Error posted: " + message);
			javax.management.Notification n = new javax.management.AttributeChangeNotification(
			    source, sequenceNumber.getAndIncrement(), System.currentTimeMillis(), message,
			    title, "Error", null, message);
			publisher.sendNotification(n);
		}
	}

	public void postInfo(String title, String message)
	    throws UnableToSendNotificationException {
		if (publisher != null) {
			postInfo(publisher, title, message, this);
		}
	}

	private static void postInfo(NotificationPublisher publisher, String title,
	    String message, Object source) throws UnableToSendNotificationException {
		if (publisher != null) {
			log.info("Info posted: " + message);
			javax.management.Notification n = new javax.management.AttributeChangeNotification(
			    source, sequenceNumber.getAndIncrement(), System.currentTimeMillis(), message,
			    title, "Info", null, message);
			publisher.sendNotification(n);
		}
	}

	public void postLogEvent(LoggingEvent event) {
		if (publisher != null) {
			postLogEvent(publisher, event, this);
		}
	}

	private static void postLogEvent(NotificationPublisher publisher, LoggingEvent event,
	    Object source) {
		if (publisher != null) {
			javax.management.Notification n = new javax.management.AttributeChangeNotification(
			    source, sequenceNumber.getAndIncrement(), System.currentTimeMillis(),
			    "New LogEvent", "LogEvent", LOG_EVENT_TYPE, null, event.getRenderedMessage());
			publisher.sendNotification(n);
		}
	}

	public static void sendDebugNotification(NotificationPublisher publisher,
	    ENotificationWrapper wrapper, Object source) {
		javax.management.Notification n = new javax.management.AttributeChangeNotification(
		    source, sequenceNumber.getAndIncrement(), System.currentTimeMillis(),
		    "New DebugEvent", "DebugEvent", DEBUG_EVENT_TYPE, null, wrapper);
		publisher.sendNotification(n);
	}

	public void postSystemInfo(SysInfo info) {
		if (publisher != null) {
			postSystemInfo(publisher, info, this);
		}
	}

	public static void postSystemInfo(NotificationPublisher publisher, SysInfo info,
	    Object source) {
		if (publisher != null) {
			javax.management.Notification n = new javax.management.AttributeChangeNotification(
			    source, sequenceNumber.getAndIncrement(), System.currentTimeMillis(),
			    "New SysInfoEvent", "SysInfoEvent", SYSINFO_EVENT_TYPE, null, info);
			publisher.sendNotification(n);
		}
	}

	public void setNotificationPublisher(NotificationPublisher notificationPublisher) {
		this.publisher = notificationPublisher;
		if (publisher != null) {
			if (serverInfoUpdateTask == null) {
				scheduleInfoUpdateTask();
			}
		}
	}

	private synchronized void scheduleInfoUpdateTask() {
		if (serverInfoUpdateTask == null) {
			getInfoUpdateTask();
			serverInfoTimer.schedule(serverInfoUpdateTask, 100, updatePeriod * 1000);
		}
		serverInfoUpdateTask.addPublisher(publisher);
	}

	private synchronized static TimerTask getInfoUpdateTask() {
		if (serverInfoUpdateTask == null)
			serverInfoUpdateTask = new ServerInfoTimerTask();
		return serverInfoUpdateTask;
	}

	@Override
	public int getServerInfoUpdateFrequency() {
		// TODO Auto-generated method stub
		return updatePeriod;
	}

	@Override
	public void setServerInfoUpdateFrequency(int seconds) {
		if (updatePeriod != seconds) {
			updatePeriod = seconds;
			if (publisher == null)
				return;
			if (serverInfoUpdateTask != null) {
				serverInfoUpdateTask.cancel();
			}
			if (updatePeriod > 0)
				scheduleInfoUpdateTask();
		}

	}

	@Override
	public void requestServerInfoUpdate() {
		try {
			postSystemInfo(getSystemInfo());
		} catch (Exception e) {
			log.error("Couldn't post system info", e);
		}
	}

	protected static SysInfo getSystemInfo() {

		SysInfoImpl info = new SysInfoImpl();
		info.setCurrentThreads(Thread.activeCount());
		info.setCoreThreadCount(getCurrentThreadCountStatic());
		info.setMaxCoreThreadCount(getMaxThreadCountStatic());
		info.setConnectionPoolData(PooledDataSourceManager.getInstance().getStats());
		info.setFreeMemory(Runtime.getRuntime().freeMemory());
		info.setTotalMemory(Runtime.getRuntime().totalMemory());
		info.setMaxMemory(Runtime.getRuntime().maxMemory());
		info.setUptime(System.currentTimeMillis()
		    - SafletEngine.getInstance().getStartupTime());
		info.setIpAddress(SafletEngine.getInstance().getBindIP());
		info.setMacAddress(SafletEngine.getMacAddress());
		info.setNumAgiRequests(SafletEngine.getInstance().getConnectionManager()
		    .getNumAgiRequests());
		info.setCustomInitiations(SafletEngine.getInstance().getConnectionManager()
		    .getNumCustomInitiations());
		info.setFreeSpace(new File(SafletEngine.ROOT_DIR).getFreeSpace());
		info.setTotalSpace(new File(SafletEngine.ROOT_DIR).getTotalSpace());
		info.setSafiServerVersion(SafletEngine.SAFISERVER_VERSION);
		info.setCPUUsage(getCPUUsage());
		ArrayList<GlobalVarInfo> vars = new ArrayList<GlobalVarInfo>();
		for (Variable v : GlobalVariableManager.getInstance().getGlobalVariables()) {
			GlobalVarInfo gi = new GlobalVarInfo();
			gi.setType(v.getType());
			gi.setName(v.getName());
			gi.setValue(v.getDefaultValue());
			vars.add(gi);
		}
		info.setGlobalVars(vars);
		return info;
	}

	public static double getCPUUsage() {
		OperatingSystemMXBean operatingSystemMXBean = ManagementFactory
		    .getOperatingSystemMXBean();
		// for (Method method :
		// operatingSystemMXBean.getClass().getDeclaredMethods()) {
		// method.setAccessible(true);
		// if (method.getName().startsWith("get")
		// && Modifier.isPublic(method.getModifiers())) {
		// Object value;
		// try {
		// value = method.invoke(operatingSystemMXBean);
		// } catch (Exception e) {
		// value = e;
		// } // try
		// System.out.println(method.getName() + " = " + value);
		// } // if
		// } // for

		return operatingSystemMXBean.getSystemLoadAverage();

	}

	@Override
	public String[] getLocalIPAddresses() throws UnknownHostException {
		List<String> addresses = SafletEngine.getInstance().getLocalIPAddresses();
		if (!addresses.contains("127.0.0.1"))
			addresses.add("127.0.0.1");

		if (!addresses.contains("0.0.0.0"))
			addresses.add("0.0.0.0");

		return addresses.toArray(new String[addresses.size()]);
	}

	@Override
	public void setTracelogLevel(String levelStr) {
		Level lvl = Level.toLevel(levelStr);
		tracelogLevel = lvl;
		remoteAppender.setThreshold(lvl);
		if (tracelogLevel == Level.OFF) {
			// Logger.getRootLogger().removeAppender(remoteAppender);
			Enumeration<Logger> enm = Logger.getRootLogger().getLoggerRepository()
			    .getCurrentLoggers();
			while (enm.hasMoreElements()) {
				Logger l = enm.nextElement();
				l.removeAppender(remoteAppender);
			}
		} else {
			Enumeration<Logger> enm = Logger.getRootLogger().getLoggerRepository()
			    .getCurrentLoggers();
			while (enm.hasMoreElements()) {
				Logger l = enm.nextElement();
				if (!isAttached(l))
					l.addAppender(remoteAppender);
			}
		}

	}

	private boolean isAttached(Category logger) {
		if (logger.isAttached(remoteAppender))
			return true;
		if (logger.getParent() != null)
			return isAttached(logger.getParent());

		return false;
	}

	@Override
	public String getTracelogLevel() {
		return tracelogLevel == null ? Level.DEBUG.toString() : tracelogLevel.toString();
	}

	@Override
	public void synchAudioFiles(int asteriskServerID) throws Exception {
		AsteriskServer server = DBManager.getInstance().getAsteriskServerConfig(
		    asteriskServerID);
		if (server == null) {
			throw new DBManagerException("Couldn't find AsteriskServer with ID "
			    + asteriskServerID);
		}
		SFTPConnectionManager.getInstance().synchronizePrompts(server);
	}

	@Override
	public byte[] getPromptFile(int promptID) throws Exception {
		Prompt p = DBManager.getInstance().getPromptByID(promptID);
		String root = SafletEngine.getInstance().getAudioDirectoryRoot();
		if (root == null)
			root = "";
		else {
			if (!(root.endsWith("/") || root.endsWith("\\")))
				root += File.separatorChar;
		}

		String filePath = p.getPath() + '.'
		    + (p.getExtension() == null ? "" : p.getExtension());
		String promptPath = root + filePath;
		File pf = new File(promptPath);
		if (!pf.exists()) {

			if (pf.getParentFile() != null && !pf.getParentFile().exists()) {
				if (!pf.getParentFile().mkdirs())
					throw new FileNotFoundException("Couldn't create parent directories of " + pf);
			}
			boolean transferred = false;
			for (AsteriskServer server : DBManager.getInstance().getAsteriskServers()) {
				try {
					if (SFTPConnectionManager.getInstance().retrieveAudioFile(filePath, server)) {
						transferred = true;
						break;
					}
				} catch (SSHException e) {
					log
					    .warn("Couldn't retrieve prompt from Asterisk server " + server.getName(),
					        e);
				}

			}
			if (!transferred) {
				throw new FileNotFoundException("Couldn't find prompt " + p.getName()
				    + " on any remote Asterisk server");
			}
			if (!pf.exists()) {
				throw new FileNotFoundException(
				    "Prompt "
				        + p.getName()
				        + " imported successfully from a remote Asterisk server but was not in the expected local directory");
			}

		}
		return FileUtils.readFile(pf.getAbsolutePath());
	}

	@Override
	public byte[] getServerLogFile() throws Exception {
		if (safiServerAppender == null) {
			Appender a = Logger.getRootLogger().getAppender("SERVER");
			if (a instanceof FileAppender)
				safiServerAppender = (FileAppender) a;
			else
				throw new Exception("FileAppender named SERVER couldn't be found");
		}
		String file = safiServerAppender.getFile();
		File logfile = new File(file);
		if (!logfile.exists())
			throw new Exception("SafiServer Log file " + file + " couldn't be found");
		return FileUtils.readFile(logfile.getAbsolutePath());
	}

	@Override
	public synchronized int debugSaflet(String projectName, String safletName)
	    throws Exception {
		try {

			com.safi.db.server.config.Saflet saflet = DBManager.getInstance().getSaflet(
			    projectName, safletName);
			if (saflet == null) {
				log
				    .error("Couldn't find Saflet " + projectName + "/" + safletName
				        + " in the DB");
				throw new Exception("Couldn't find Saflet " + projectName + "/" + safletName
				    + " in the DB");
			}

			Saflet handler = SafletEngine.getInstance().getDispatcher().loadHandler(
			    saflet.getCode());
			Object lock = new Object();
			HandlerInfo info = SafletEngine.getInstance().getDispatcher().registerDebugHandler(
			    projectName + "/" + safletName, handler, lock, null);

			DebugRemoteControl debugControl = new DebugRemoteControlImpl(lock, handler,
			    publisher);
			debugSessionMap.put(lock.hashCode(), debugControl);
			return lock.hashCode();
		} catch (Exception e) {
			log.error("Exception caught initiating debug session", e);
			throw e;
		}
	}

	@Override
	public void resumeDebug(int key) throws Exception {
		DebugRemoteControl debugControl = debugSessionMap.get(key);
		if (debugControl != null)
			debugControl.resume();

	}

	@Override
	public void stepDebug(int key) throws Exception {
		DebugRemoteControl debugControl = debugSessionMap.get(key);
		if (debugControl != null)
			debugControl.next();

	}

	@Override
	public void stopDebug(int key) throws Exception {
		DebugRemoteControl debugControl = debugSessionMap.remove(key);
		if (debugControl != null)
			debugControl.stop();

	}

	@Override
	public void setBreakPoint(int key, String uid, boolean b) throws Exception {
		DebugRemoteControl debugControl = debugSessionMap.get(key);
		if (debugControl != null) {
			debugControl.setBreakPoint(uid, b);

		}

	}

	public static class ServerInfoTimerTask extends TimerTask {
		private Set<NotificationPublisher> publishers = new HashSet<NotificationPublisher>();

		public void addPublisher(NotificationPublisher publisher) {
			publishers.add(publisher);
		}

		public void removePublisher(NotificationPublisher publisher) {
			publishers.remove(publisher);
		}

		@Override
		public void run() {
			if (publishers.isEmpty())
				return;
			synchronized (publishers) {
				SysInfo info = getSystemInfo();
				// final SafletEngine instance = SafletEngine.getInstance();
				for (NotificationPublisher publisher : publishers) {
					try {
						postSystemInfo(publisher, info, "ok");
					} catch (Exception e) {
						log.error("Couldn't post system info", e);
					}
				}

			}

		}
	}
}
