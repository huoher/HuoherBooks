package top.qiuchi.huoher.entity;

import lombok.Data;


@Data
public class Book {
    private int id;
    private String bookname;
    private int writerid;
    private String bookcopyright;
    private int stocknum;
}
