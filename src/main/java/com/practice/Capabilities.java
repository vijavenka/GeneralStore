package com.practice;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Capabilities {

    static AndroidDriver<AndroidElement> driver;

    public static AndroidDriver<AndroidElement> setup() throws MalformedURLException, InterruptedException {

        File f = new File("src");
        File fs = new File(f, "General-Store.apk"); //Works by installing apk

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Emulator"); //Works in emulator
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Uiautomator2");
        cap.setCapability(MobileCapabilityType.VERSION, "9.0");
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 300);
        cap.setCapability("appium:chromeOptions", ImmutableMap.of("w3c", false));

        cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath()); //Works by installing apk

        //Remote driver connection
        driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

        return driver;
    }
}
