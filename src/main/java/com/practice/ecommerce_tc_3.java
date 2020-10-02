package com.practice;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class ecommerce_tc_3 extends Capabilities{

//    public static void main(String[] args) throws MalformedURLException, InterruptedException {
    public static void verifyingCartPage(AndroidDriver<AndroidElement> driver) throws MalformedURLException, InterruptedException {

        String cart = driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")).getText();
        Assert.assertEquals("Cart", cart);

        String basketProduct = driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
        Assert.assertEquals("Nike Blazer Mid '77", basketProduct);
    }
}
