package com.practice;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;

import static io.appium.java_client.touch.offset.ElementOption.element;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.time.Duration;

public class ecommerce_tc_5 extends Capabilities{

//    public static void main(String[] args) throws MalformedURLException, InterruptedException {
    public static void termsButton(AndroidDriver<AndroidElement> driver) throws MalformedURLException, InterruptedException {


        TouchAction touchAction = new TouchAction(driver);

        WebElement termsButton = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
        Assert.assertEquals(termsButton.getText(), "Please read our terms of conditions");

//        long press for 2sec and release
        touchAction.longPress(longPressOptions().withElement(element(termsButton)).withDuration(Duration.ofSeconds(2))).release().perform();
        Thread.sleep(4000);

        driver.findElement(By.xpath("//android.widget.Button[@text='CLOSE']")).click();
        driver.findElement(By.className("android.widget.CheckBox")).click();
    }
}
