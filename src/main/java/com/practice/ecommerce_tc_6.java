package com.practice;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Set;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class ecommerce_tc_6 extends Capabilities{

//    public static void main(String[] args) throws MalformedURLException, InterruptedException {
    public static void contextHandles(AndroidDriver<AndroidElement> driver) throws MalformedURLException, InterruptedException {

        driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
        Thread.sleep(7000);

        //getContextHandles() is used to switch between native app and web view
        Set<String> contexts = driver.getContextHandles();
        for(String context : contexts){
            System.out.println("context : " + context);
        }
        /* Output of driver.getContextHandles()
        context : NATIVE_APP
        context : WEBVIEW_chrome
        context : WEBVIEW_com.androidsample.generalstore*/

        //Setting web view context to the driver
        driver.context("WEBVIEW_com.androidsample.generalstore");

        driver.findElement(By.name("q")).sendKeys("Hello");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
//        Thread.sleep(4000);

        //Moving back from web view to app view
        //Pressing back button of mobile
        driver.pressKey(new KeyEvent(AndroidKey.BACK));

        Thread.sleep(7000);
        driver.context("NATIVE_APP");

    }
}
