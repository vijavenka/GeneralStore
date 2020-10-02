package com.practice;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class ecommerce_tc_2 extends Capabilities{

//    public static void main(String[] args) throws MalformedURLException, InterruptedException {
    public static void addingShoes(AndroidDriver<AndroidElement> driver) throws MalformedURLException, InterruptedException {

//        AndroidDriver<AndroidElement> driver = setup();

//        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Nike Blazer Mid '77\"));");
        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(new UiSelector().textMatches(\"Nike Blazer Mid '77\").instance(0))"));
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

        int count = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();

        String productName = null;
        for(int i=0; i<count; i++){
            productName = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();

            if(productName.equalsIgnoreCase("Nike Blazer Mid '77") ){

                driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
                break;
            }
        }
        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
        Thread.sleep(4000);

        String cart = driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")).getText();
        Assert.assertEquals("Cart", cart);

        String basketProduct = driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
        Assert.assertEquals("Nike Blazer Mid '77", basketProduct);
    }
}
