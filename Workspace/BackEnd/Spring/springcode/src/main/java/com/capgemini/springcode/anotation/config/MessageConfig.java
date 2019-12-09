package com.capgemini.springcode.anotation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.capgemini.springcode.anotation.bean.MessageBean;

@Configuration
public class MessageConfig {
	@Bean
	@Scope("prototype")
	public MessageBean getMessageBean() {
		MessageBean messageBean = new MessageBean();
		messageBean.setMessage("Come India Lets play football...");
		return messageBean;
	}

}//End of main
