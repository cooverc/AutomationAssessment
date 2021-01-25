package com.assessment.framework.config;

import com.assessment.framework.base.BrowserType;
import com.assessment.framework.base.DeviceType;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    public static void PopulateSettings() throws IOException {
        ConfigReader reader = new ConfigReader();
        reader.ReadProperty();
    }

    private void ReadProperty() throws IOException {

        Properties p = new Properties();

        // Environment parameter
        String environment = System.getProperty("environment");
        //Load the PropertyAutos file available in same package
        String propertiesFile = "ConfigIntegration.properties";
//      String propertiesFile = "ConfigCertification.properties";

        //Creating the name of the file
        if (environment != null) {
            propertiesFile = "Config" + StringUtils.capitalize(environment) + ".properties";
        }

        p.load(getClass().getClassLoader().getResourceAsStream(propertiesFile));

        Settings.ScreenPath = p.getProperty("ScreenPath");
        Settings.LogPath = p.getProperty("LogPath");
        Settings.URLbase = p.getProperty("URLbase");
        Settings.URLService = p.getProperty("URLService");
        Settings.BrowserClose = p.getProperty("BrowserClose");
        Settings.DriversPath = p.getProperty("DriversPath");
        Settings.BrowserLess = p.getProperty("BrowserLess");
        Settings.ResourcePath = p.getProperty("ResourcePath");
        Settings.UrlServices_BASE_Auth = p.getProperty("UrlServices_BASE_Auth");
        Settings.UrlServices_URI_Auth = p.getProperty("UrlServices_URI_Auth");
        Settings.BrowserType = BrowserType.valueOf(p.getProperty("BrowserType"));
        Settings.DeviceType = DeviceType.valueOf(p.getProperty("Device"));

    }

}
