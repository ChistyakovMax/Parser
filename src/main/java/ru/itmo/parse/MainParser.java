package ru.itmo.parse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.itmo.pages.ArticleListPage;
import ru.itmo.pages.MainPage;
import ru.itmo.pojo.Article;
import ru.itmo.pojo.Articles;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

public class MainParser {
    WebDriver driver;
    MainPage mainPage;
    ArticleListPage articleListPage;
    String search = "парсинг";

    Article article;

    Articles articles = new Articles();

    //общий класс для всех тестов
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void parse(){
        mainPage = new MainPage(driver);
        mainPage.setSearchInput(search);
        mainPage.searchButtonClick();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        articleListPage = new ArticleListPage(driver);

        try {
            for (String winHandle : driver.getWindowHandles()) {
                driver.switchTo().window(winHandle);
            }
        } catch (Exception e) {
            System.out.println("fail");
        }

        for (int i = 1; i < 21; i++){
            article = new Article();
            article.setNum(i);
            //System.out.println(article.getNum());

            article.setTitle(articleListPage.getArticleTitle(i));
            //System.out.println(article.getTitle());

            article.setUrl(articleListPage.getArticleUrl(i));
            //System.out.println(article.getUrl());

            article.setAuthors(articleListPage.getAuthorsAsText(i));
            //System.out.println(article.getAuthors());

            articles.addArticle(article);
        }

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(articles);
        System.out.println(json);

        try (PrintWriter out = new PrintWriter("result.json")) {
            out.println(json);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
