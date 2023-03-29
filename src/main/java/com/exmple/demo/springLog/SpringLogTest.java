package com.exmple.demo.springLog;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class SpringLogTest {

	Logger log = LoggerFactory.getLogger(SpringLogTest.class);

	@PostConstruct
	public void logAllTest() {
		log.info("these are info logs in SpringLogTest");
		log.debug("these are debug logs in SpringLogTest");
		log.trace("these are trace logs in SpringLogTest");
		log.error("these are error logs in SpringLogTest");
		log.warn("these are warn logs in SpringLogTest");

	}

}
