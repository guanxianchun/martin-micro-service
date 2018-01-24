package com.martin.authcenter.auth.model;

/**
 * Author 管贤春
 * Email psyche19830113@163.com
 * Date 1/23/18 3:32 PM
 * Descrition
 */
public class Message {

    public static final int SUCCESS=200;

    public static final int FAILED=200;

    private Integer code;

    private String message;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
