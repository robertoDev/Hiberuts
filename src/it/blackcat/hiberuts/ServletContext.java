package it.blackcat.hiberuts;

import ognl.OgnlRuntime;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created with IntelliJ IDEA.
 * User: homeuser
 * Date: 14/10/13
 * Time: 12.41
 * To change this template use File | Settings | File Templates.
 */
public class ServletContext implements ServletContextListener {
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        //To change body of implemented methods use File | Settings | File Templates.
        OgnlRuntime.setSecurityManager(null);
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
