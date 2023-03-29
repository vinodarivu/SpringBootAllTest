package com.example.demo.beans;

import org.springframework.stereotype.Component;


@Component
public class ConditionMissingBean {

	public void printBeanData() {
		System.out.println(
				"********************@Bean got created for ConditionMissingBean with autowire and printBeanData method been called ******************");
	}

}
