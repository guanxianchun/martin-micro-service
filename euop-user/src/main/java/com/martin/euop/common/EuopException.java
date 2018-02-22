package com.martin.euop.common;

import com.martin.euop.message.LocaleMessageSourceService;

import javax.annotation.Resource;
import java.util.Locale;

/**
 * Author 管贤春
 * Email psyche19830113@163.com
 * Date 2/6/18 11:25 AM
 * Descrition
 */
public class EuopException extends Exception {

    private String code;

    private Locale locale;

    private String message;
    @Resource
    private LocaleMessageSourceService messageSourceService;

    public  EuopException(String code){
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    @Override
    public String getMessage() {
        return "";
    }
}
