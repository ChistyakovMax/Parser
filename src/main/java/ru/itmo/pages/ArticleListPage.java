package ru.itmo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ArticleListPage extends Page{

    public ArticleListPage(WebDriver driver) {
        super(driver);
    }

    //xpath статьи
    private By getArticle (Integer num){
        return By.xpath(".//a[@id='Result_" + num + "']");
        //return By.cssSelector("[id = 'Result_1']");
    }

    //xpath автора
    private By getAuthors (Integer num){
        return By.xpath(".//a[@id='Result_" + num + "']/parent::h3/parent::div/div");
    }

    //вернуть название статьи
    public String getArticleTitle(Integer num){
        return driver.findElement(getArticle(num)).getAttribute("title");
    }

    //вернуть href статьи
    public String getArticleUrl(Integer num){
        return driver.findElement(getArticle(num)).getAttribute("href");
    }

    //вернуть авторов
    public String getAuthorsAsText(Integer num){
        return driver.findElement(getAuthors(num)).getText();
    }

}
