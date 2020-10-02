package com.practice;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.net.MalformedURLException;

public class ecommerce_tc_1_1 extends Capabilities{

//    public static void main(String[] args) throws MalformedURLException, InterruptedException {
    public static void loginNegativeScenario(AndroidDriver<AndroidElement> driver) throws MalformedURLException, InterruptedException {

//        AndroidDriver<AndroidElement> driver = setup();

        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        //name attribute for toast message will have content
        Assert.assertEquals("Please enter your name", driver.findElement(By.xpath("//android.widget.Toast[1]")).getAttribute("name"));

    }
}
