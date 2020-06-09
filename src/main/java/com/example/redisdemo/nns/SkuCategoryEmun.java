package com.example.redisdemo.nns;

public enum SkuCategoryEmun {
    CLOTHING(10,"服装类"),
    BOOK(40,"图书类");

    private Integer code;
    private String name;

    SkuCategoryEmun(Integer code, String name) {
        this.code = code;
        this.name = name;
    }
}
