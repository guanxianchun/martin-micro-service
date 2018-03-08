package com.martin.euop.authcenter.auth.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.oauth2.provider.endpoint.FrameworkEndpoint;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.martin.euop.authcenter.auth.model.Message;

/**
 * Author 管贤春
 * Email psyche19830113@163.com
 * Date 1/23/18 3:35 PM
 * Descrition
 */

@FrameworkEndpoint
public class RevokeTokenEndpoint {
    @Autowired
    @Qualifier("consumerTokenServices")
    private ConsumerTokenServices consumerTokenServices;
    @RequestMapping(value = "/oauth/token",method = RequestMethod.DELETE)
    @ResponseBody
    public Message revokeToken(String access_token){
        Message message = new Message();
        if (consumerTokenServices.revokeToken(access_token)){
            message.setCode(Message.SUCCESS);
            message.setMessage("注销成功");
        }else {
            message.setCode(Message.FAILED);
            message.setMessage("注销失败");
        }
        return message;
    }
}
