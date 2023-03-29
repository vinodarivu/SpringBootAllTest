package com.example.demo.beans;

import org.springframework.stereotype.Component;

@Component
public class SingletonBean {

	public void printBeanData() {
		System.out.println(
				"********************@Bean got created for SingletonBean and printBeanData called  ******************");
	}

}
