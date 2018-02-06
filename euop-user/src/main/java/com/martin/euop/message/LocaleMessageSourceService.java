package com.martin.euop.message;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Locale;

/**
 * Author 管贤春
 * Email psyche19830113@163.com
 * Date 2/6/18 9:30 AM
 * Descrition 定义自己的国际化资源服务类
 */
@Component
public class LocaleMessageSourceService {
    @Resource
    private MessageSource messageSource;

    /**
     *
     * @param code
     * @return
     */
    public String getMessage(String code,Locale locale){
        return getMessage(code,null,locale);
    }

    /**
     *
     * @param code
     * @param args
     * @return
     */
    public String getMessage(String code,Object[] args,Locale locale){
        return getMessage(code,args,code,locale);
    }

    /**
     *
     * @param code
     * @param args
     * @param defaultMessage
     * @param locale
     * @return
     */
    public String getMessage(String code,Object[] args,String defaultMessage,Locale locale){
        return messageSource.getMessage(code,args,defaultMessage,locale);
    }
}
