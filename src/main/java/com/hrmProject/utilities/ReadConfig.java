package com.hrmProject.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig 
{
	Properties pro;
	public ReadConfig()
	{
		File src = new File("C:\\Users\\hp\\eclipse-workspace\\Admin_Project_1\\configuration\\config.properties");
		try
		{
		FileInputStream file = new FileInputStream(src);
	    pro = new Properties();
	    pro.load(file);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	public String getApplicationURL()
	{
		String url = pro.getProperty("baseURL");
		return url;
	}
	public String getUsername()
	{
		String username = pro.getProperty("username");
		return username;
	}
	public String getPassword()
	{
		String password = pro.getProperty("password");
		return password;
	}

}
