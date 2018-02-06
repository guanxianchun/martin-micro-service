package com.martin.euopuser;

import com.martin.euop.message.LocaleMessageSourceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceResourceBundle;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EuopUserApplicationTests {

//	@Resource
//	private LocaleMessageSourceService messageSourceService;

	@Test
	public void contextLoads() {
//		System.out.println(messageSourceService.getMessage("euop.user.login_name"));
	}

}
