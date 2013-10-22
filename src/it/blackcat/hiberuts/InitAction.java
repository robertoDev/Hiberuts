package it.blackcat.hiberuts;

import com.opensymphony.xwork2.Action;

/**
 * Created with IntelliJ IDEA.
 * User: homeuser
 * Date: 12/10/13
 * Time: 11.21
 * To change this template use File | Settings | File Templates.
 */
public class InitAction {
        public String execute() {
            EMF.get();
            return Action.SUCCESS;
        }
}