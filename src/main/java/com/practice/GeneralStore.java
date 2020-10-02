package com.practice;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.net.MalformedURLException;

public class GeneralStore {

    static AndroidDriver<AndroidElement> driver;

    public static void main(String[] args) throws MalformedURLException, InterruptedException {

        driver = ecommerce_tc_1.loginPositiveScenario();
//        ecommerce_tc_2.addingShoes(driver);
//        ecommerce_tc_3.verifyingCartPage(driver); //Continuation of ecommerce_tc_2
        ecommerce_tc_4.addingMultipleShoes(driver);
        ecommerce_tc_5.termsButton(driver); //Continuation of ecommerce_tc_4
        ecommerce_tc_6.contextHandles(driver); //Continuation of ecommerce_tc_5
        ecommerce_tc_1_1.loginNegativeScenario(driver);
    }
}
