package org.asteriskjava.manager.action;

/**
 * Fully restarts all zaptel channels and terminates any calls on Zap
 * interfaces.
 * <p>
 * Available since Asterisk 1.4.
 * 
 * @author srt
 * @since 0.3
 * @version $Id: ZapRestartAction.java,v 1.3 2008/12/12 07:05:02 zacw Exp $
 */
public class ZapRestartAction extends AbstractManagerAction
{
    /**
     * Serial version identifier.
     */
    private static final long serialVersionUID = 5899540386204706397L;

    /**
     * Creates a new ZapRestartAction.
     */
    public ZapRestartAction()
    {

    }

    @Override
    public String getAction()
    {
        return "ZapRestart";
    }
}
