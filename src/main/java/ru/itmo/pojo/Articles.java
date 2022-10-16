package ru.itmo.pojo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Articles {
    private List<Article> articleList = new ArrayList<>();

    public void addArticle(Article article){
        this.articleList.add(article);
    }

    /*public Articles(){
        articleList = new ArrayList<>();
    }*/

}
