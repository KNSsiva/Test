package com.siva;

import java.util.Iterator;

import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.SystemConfiguration;
 
public class ExampleCompositeConfiguration {
 
    public static void main(String[] args)  {
 
        CompositeConfiguration config = new CompositeConfiguration();
 
        // add config sources.
        // add SystemConfiguration first below we need to override properties
        // using java system properties
        config.addConfiguration(new SystemConfiguration());
        
        try {
			config.addConfiguration(new PropertiesConfiguration("F:/Softwares/config.properties"));
		} catch (ConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        System.out.println("----------------------------");
        System.out.println("Listing composite properties");
        System.out.println("----------------------------");
        Iterator<String> keys = config.getKeys();
        while (keys.hasNext()) {
            String key = keys.next();
            System.out.println(key + " = " + config.getProperty(key));
        }
 
    } // main() ends
}