package com.amazon.product.generic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class FileLib {
	
	public String readDataFromPropertiesiFile(String key)
	{  String data = null;
		try (BufferedReader br = new BufferedReader(new FileReader("./data/config.properties")))
		{
			Properties p = new Properties();
			p.load(br);
			data = p.getProperty(key);
			
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return data;
	}

}
