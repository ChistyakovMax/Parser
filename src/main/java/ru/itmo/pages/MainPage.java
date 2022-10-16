package ru.itmo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends Page {

    String pageUrl = "https://lib.itmo.ru/";

    public MainPage(WebDriver driver) {
        super(driver);
        driver.get(pageUrl);
    }

    private By searchInput = By.xpath(".//input[@class='eb-search__input-bquery']");

    private By searchButton = By.xpath(".//button[@class='eb-search__submit-button']");

    public void setSearchInput(String value){
        driver.findElement(searchInput).sendKeys(value);
    }

    public void searchButtonClick() {
        driver.findElement(searchButton).click();
    }

}
