package com.yangwulang.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @author yangwulang
 */
@Data
public class Notice {
    private long id;
    private String title;
    private String body;
    private Date time;

    public Notice() {
    }

    public Notice(long id, String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;
    }
}
