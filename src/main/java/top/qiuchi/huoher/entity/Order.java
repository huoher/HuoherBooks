package top.qiuchi.huoher.entity;

import lombok.Data;

@Data
public class Order {
    private int orderid;
    private int userid;
    private int bookid;
    private String time;
}
