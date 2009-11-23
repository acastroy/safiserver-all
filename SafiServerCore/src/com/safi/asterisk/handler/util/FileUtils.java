package com.safi.asterisk.handler.util;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;

public class FileUtils {

	private final static Logger log = Logger.getLogger(FileUtils.class.getName());

	public static byte[] readFile(String filename) throws IOException {
		File file = new File(filename);
		java.io.FileInputStream f = new java.io.FileInputStream(file);
		java.nio.channels.FileChannel ch = f.getChannel();
		byte[] result = null;
		try {
			byte[] barray = new byte[1024 * 8]; // 8k
			java.nio.ByteBuffer bb = java.nio.ByteBuffer.wrap(barray);
			// long checkSum = 0L;
			int nRead;
			int length = (int) file.length();
			result = new byte[length];
			int currentPos = 0;
			int totalRead = 0;
			while ((nRead = ch.read(bb)) != -1) {
				// System.arraycopy(barray, 0, result, currentPos, nRead);
				totalRead += nRead;
				bb.rewind();
				bb.get(result, currentPos, nRead);
				currentPos += nRead;
				bb.rewind();
				// for ( int i=0; i<nRead; i++ ){
				//          
				// checkSum += barray[i];
				//            
				// }

			}
		} finally {
			try {
				ch.close();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				f.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return result;
	}

	public static byte[] readFile(URL url) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

		
		String inputLine;

		StringBuffer buf = new StringBuffer();
		
		while ((inputLine = in.readLine()) != null)
			buf.append(inputLine).append('\n');

		in.close();
		
		return buf.toString().getBytes();
		
	}

	public static String convertStreamToString(InputStream is) {
		/*
		 * To convert the InputStream to String we use the BufferedReader.readLine()
		 * method. We iterate until the BufferedReader return null which means
		 * there's no more data to read. Each line will appended to a StringBuilder
		 * and returned as String.
		 */
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		StringBuilder sb = new StringBuilder();

		String line = null;
		try {
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return sb.toString();
	}

	public static void writeFile(String filename, byte[] bytes) throws IOException {
		File file = new File(filename);
		if (file.exists() && !file.delete()) {
			unlockFile(file);
			if (file.exists() && !file.delete()) {
				String message = "File " + filename + " exists and couldn't be deleted.";
				log.error(message);
				throw new IOException(message);
			}
		}
		writeFile(file, bytes);

	}

	private static void unlockFile(File file) {
		try {
			RandomAccessFile raf = new RandomAccessFile(file, "rw");
			FileChannel channel = raf.getChannel();
			try {
				if (channel.tryLock() == null) { // File is locked

					log.warn("File " + file.getAbsolutePath()
					    + " is locked and couldn't be released");
					return;
				}
			} finally {
				channel.close(); // Unlock in either case
			}
		} catch (IOException e) {
			e.printStackTrace();
			log.error("Couldn't unlock " + file, e);
		}
	}

	public static void writeFile(File file, byte[] bytes) throws IOException {
		java.io.FileOutputStream f = new java.io.FileOutputStream(file);
		final WritableByteChannel outputChannel = Channels.newChannel(f);
		final ReadableByteChannel inputChannel = Channels
		    .newChannel(new ByteArrayInputStream(bytes));
		try {
			fastChannelCopy(inputChannel, outputChannel);
			// closing the channels
		} finally {
			inputChannel.close();
			outputChannel.close();
		}

	}

	private static void fastChannelCopy(final ReadableByteChannel src,
	    final WritableByteChannel dest) throws IOException {
		final ByteBuffer buffer = ByteBuffer.allocateDirect(16 * 1024);
		while (src.read(buffer) != -1) {
			// prepare the buffer to be drained
			buffer.flip();
			// write to the channel, may block
			dest.write(buffer);
			// If partial transfer, shift remainder down
			// If buffer is empty, same as doing clear()
			buffer.compact();
		}
		// EOF will leave buffer in fill state
		buffer.flip();
		// make sure the buffer is fully drained.
		while (buffer.hasRemaining()) {
			dest.write(buffer);
		}
	}

	public static void copyFile(String from, String to) throws IOException {

		final InputStream input = new FileInputStream(from);
		final OutputStream output = new FileOutputStream(to);
		try {
			// get an channel from the stream
			copyStreams(input, output);
		} finally {
			input.close();
			output.close();
		}

	}

	public static void copyFile(File from, File to) throws IOException {

		final InputStream input = new FileInputStream(from);
		final OutputStream output = new FileOutputStream(to);
		// get an channel from the stream
		copyStreams(input, output);

	}

	public static void copyStreams(final InputStream input, final OutputStream output)
	    throws IOException {
		final ReadableByteChannel inputChannel = Channels.newChannel(input);
		final WritableByteChannel outputChannel = Channels.newChannel(output);
		try {
			// copy the channels
			fastChannelCopy(inputChannel, outputChannel);
			// closing the channels
		} finally {
			inputChannel.close();
			outputChannel.close();
		}
	}

	public static void main(String[] args) {
		try {
			readFile("C:\\winbakup\\Backup.bkf");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void deleteFileAndEmptyParents(File oldFile) throws IOException {
		File parent = oldFile.getParentFile();
		if (!oldFile.delete()) {
			throw new IOException("Couldn't delete file " + oldFile);
		}
		while (parent != null) {
			if (parent.list().length == 0) {
				File oldParent = parent;
				parent = parent.getParentFile();
				if (!oldParent.delete()) {
					log.warn("Couldn't delete empty directory " + oldParent);
					return;
				}
			} else
				// its not empty
				return;
		}

	}

	static public boolean deleteDirectory(File path) {
		if (path.exists()) {
			File[] files = path.listFiles();
			for (int i = 0; i < files.length; i++) {
				if (files[i].isDirectory()) {
					deleteDirectory(files[i]);
				} else {
					files[i].delete();
				}
			}
		}
		return (path.delete());
	}

	public static String[] getJarBaseNameAndSuffix(String name) {
		if (name.endsWith(".jar"))
			name = name.substring(0, name.length() - ".jar".length());
		int idx = name.lastIndexOf('_');
		String suffix = "";
		if (idx >= 0) {
			suffix = name.substring(idx, name.length());
			name = name.substring(0, idx);
			// if (log.isDebugEnabled())
			// log.debug("suffix is " + suffix + " and basename is " + name);

		}
		return new String[] { name, suffix };
	}

	public static boolean jarIsNewer(String newname, File[] libfiles) {
		if (libfiles == null)
			return true;
		String[] newnames = FileUtils.getJarBaseNameAndSuffix(newname);
		for (File lf : libfiles) {
			String[] names = FileUtils.getJarBaseNameAndSuffix(lf.getName());
			if (newnames[0].equals(names[0]) && newnames[1].compareTo(names[1]) <= 0)
				return false;
		}
		return true;
	}

	public static List<File> filterFiles(Collection<File> jars) {
		List<File> filtered = new ArrayList<File>();
		Map<String, List<File>> filemap = new HashMap<String, List<File>>();

		for (File lf : jars) {
			String[] names = FileUtils.getJarBaseNameAndSuffix(lf.getName());
			String name = names[0];
			List<File> grp = filemap.get(name);
			if (grp == null) {
				grp = new ArrayList<File>();
				filemap.put(name, grp);
			}
			grp.add(lf);

		}

		for (List<File> fl : filemap.values()) {
			if (!fl.isEmpty()) {
				Collections.sort(fl, new Comparator<File>() {
					@Override
					public int compare(File o1, File o2) {
						return o2.getName().compareTo(o1.getName());
					}
				});
				filtered.add(fl.get(0));
			}
		}
		return filtered;
	}
}
