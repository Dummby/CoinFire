package com.coinfire.property;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.coinfire.util.Constants;

public class PropertyLoader {

	    public Properties getProp() {

	    Properties prop = new Properties();
	    InputStream input = null;

	    try {

	      input = getClass().getResourceAsStream("config.properties");
	      prop.load(input);

	    } catch (IOException ex) {
	      ex.printStackTrace();
	    } finally {
	      if (input != null) {
	        try {
	          input.close();
	        } catch (IOException e) {
	          e.printStackTrace();
	        }
	      }
	    }
	    return prop;
	  }
	    
}
