package ru.itmo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public abstract class Page {
    WebDriver driver;

    Page(WebDriver driver){
        this.driver = driver;
    }

}
