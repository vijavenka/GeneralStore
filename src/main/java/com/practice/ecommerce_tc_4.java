package com.practice;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.util.LinkedList;
import java.util.List;

public class ecommerce_tc_4 extends Capabilities{

//    public static void main(String[] args) throws MalformedURLException, InterruptedException {
    public static void addingMultipleShoes(AndroidDriver<AndroidElement> driver) throws MalformedURLException, InterruptedException {

//        AndroidDriver<AndroidElement> driver = setup();

        int count = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
        List<String> productName = new LinkedList<>();
        List<String> productPrice = new LinkedList<>();
        double sumOfProductPrice = 0.0;

        for(int i=0; i<count; i++){
            productName.add(driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText());
            productPrice.add(driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(i).getText());
            sumOfProductPrice += Double.parseDouble(driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(i).getText().substring(1));
            driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
        }
        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

        System.out.println("sumOfProductPrice : " + sumOfProductPrice);
        Thread.sleep(4000);

        //Cart page validation
        count = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
        for(int i=0; i<count; i++){
            Assert.assertEquals(driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText(), productName.get(i));
            Assert.assertEquals(driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(i).getText(), productPrice.get(i));
        }
        Assert.assertEquals(driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText(), "$ "+sumOfProductPrice);
        Thread.sleep(4000);
    }
}
