package com.jbk.pages;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class PageBase {
	
	Logger logger=null;
	public Logger PageLogs(){
		logger=Logger.getLogger(this.getClass());
		String path=(System.getProperty("user.dir")+"/log4jPage.properties");
		PropertyConfigurator.configure(path);
		return logger;
		
		
	}

}
