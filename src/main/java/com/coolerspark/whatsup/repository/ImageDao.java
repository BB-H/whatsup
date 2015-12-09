package com.coolerspark.whatsup.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.coolerspark.whatsup.entity.Image;

public interface ImageDao extends PagingAndSortingRepository<Image, Long>,
		JpaSpecificationExecutor<Image> {

}
