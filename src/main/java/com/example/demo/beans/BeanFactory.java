package com.example.demo.beans;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
public class BeanFactory {

	@Bean
	public MyBeanClass getMyBeanClass() {
		System.out.println("*****inside bean annotion for getMyBeanClass **** ");
		return new MyBeanClass();
	}

	/*
	 * that only matches when no beans meeting the specified requirements are
	 * already contained in the BeanFactory. None of the requirements must be met
	 * for the condition to match and the requirements do not have to be met by the
	 * same bean.
	 */

	@Bean
	@ConditionalOnMissingBean
	public ConditionMissingBean getConditionMissingBean() {
		System.out.println("*****inside bean annotion for ConditionMissingBean **** ");
		return new ConditionMissingBean();
	}

	/*
	 * By default, the Spring IoC container creates and initializes all beans as a
	 * singleton. But we can define the scope of a bean as singleton using the
	 * scope="singleton"
	 */

	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
	public SingletonBean getSingletonBean() {
		System.out.println("*****inside bean annotion for getSingletonBean **** ");
		return new SingletonBean();
	}
	
	

}
