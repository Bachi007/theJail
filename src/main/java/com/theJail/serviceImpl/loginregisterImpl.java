package com.theJail.serviceImpl;

import org.apache.log4j.Logger;

import com.theJail.App;
import com.theJail.service.loginregister;

public class loginregisterImpl implements loginregister {
	static Logger log=Logger.getLogger(App.class);
	@Override
	public void registration() {
		// TODO Auto-generated method stub
		log.info("welcome to registration");
	}

	@Override
	public void login() {
		// TODO Auto-generated method stub
		log.info("welcome to Login");		
	}

}
