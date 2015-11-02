package com.coolerspark.whatsup.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.coolerspark.whatsup.entity.Item;

public interface ItemDao extends PagingAndSortingRepository<Item, Long>,
		JpaSpecificationExecutor<Item> {
	
	public Page<Item> findMatchedItemsByUserId(Long id, Pageable pageRequest);

}
