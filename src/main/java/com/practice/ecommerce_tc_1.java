package com.practice;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class ecommerce_tc_1 extends Capabilities{

//    public static void main(String[] args) throws MalformedURLException, InterruptedException {
    public static AndroidDriver<AndroidElement> loginPositiveScenario() throws MalformedURLException, InterruptedException {

        AndroidDriver<AndroidElement> driver = setup();

        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Hello");
        driver.hideKeyboard();

        driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();

        //1st click Listbox, 2nd scroll till Argentina, 3rd click the xpath of Argentina
        driver.findElement(By.id(("android:id/text1"))).click();
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));");
//        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"" + "Argentina" + "\").instance(0))"));
        driver.findElement(By.xpath("//*[@text='Argentina']")).click();

        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

        return driver;
    }
}
