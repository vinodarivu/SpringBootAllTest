package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.beans.ConditionMissingBean;
import com.example.demo.beans.MyBeanClass;

@Service
public class BeanServices {

	@Autowired
	MyBeanClass myBeanClass;
	
	@Autowired
	ConditionMissingBean conditionMissingBean;

	public void testAllBeans() {
		myBeanClass.printBeanData();
		conditionMissingBean.printBeanData();
	}

}
