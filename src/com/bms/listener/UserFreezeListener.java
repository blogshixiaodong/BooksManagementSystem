package com.bms.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;

import com.bms.server.impl.RecordServerImpl;

/**
 *  date : 2018年3月30日	
 * author: jiangjiamin
 * 
 */
@WebListener
public class UserFreezeListener implements ServletContextAttributeListener {

    
    public UserFreezeListener() {
        // TODO Auto-generated constructor stub
    }

	
    public void attributeAdded(ServletContextAttributeEvent event)  { 
         String name = event.getName();
         if("uid".equals(name)) {
        	 Integer uid = (Integer)event.getValue();
        	 
        	 RecordServerImpl recordServerImpl = new RecordServerImpl();
        	//设置超期状态
        	 recordServerImpl.setUserFreezeStatus(uid);
         }
    }

	
    public void attributeRemoved(ServletContextAttributeEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	
    public void attributeReplaced(ServletContextAttributeEvent arg0)  { 
         // TODO Auto-generated method stub
    }
	
}
