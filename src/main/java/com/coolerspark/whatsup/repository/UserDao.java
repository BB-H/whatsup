/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package com.coolerspark.whatsup.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.coolerspark.whatsup.entity.User;

public interface UserDao extends PagingAndSortingRepository<User, Long> {
	//User findByLoginName(String loginName);
	
	User findByName(String name);
}
