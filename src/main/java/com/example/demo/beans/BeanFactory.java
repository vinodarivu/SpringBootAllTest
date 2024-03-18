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
	 When a bean is annotated with @ConditionalOnMissingBean, it will only be created if there is no other bean of the same type already present in the application context.

	If a bean of the specified type is already defined in the context, the bean annotated with @ConditionalOnMissingBean will not be created, and Spring will use the existing bean.

This annotation is particularly useful when you want to provide default implementations for certain components, but allow users to override them with their own custom implementations if desired.
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
