package ru.itmo.pojo;
import lombok.Data;

@Data
public class Article {

    private int num;
    private String title;
    private String url;
    private String authors;
}
