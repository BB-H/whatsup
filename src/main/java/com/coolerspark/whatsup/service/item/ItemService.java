package com.coolerspark.whatsup.service.item;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springside.modules.persistence.DynamicSpecifications;
import org.springside.modules.persistence.SearchFilter;
import org.springside.modules.persistence.SearchFilter.Operator;

import com.coolerspark.whatsup.entity.Item;
import com.coolerspark.whatsup.repository.ItemDao;


//Spring Bean的标识.
@Component
//类中所有public函数都纳入事务管理的标识.
@Transactional
public class ItemService {
	
	private ItemDao itemDao;
	
	public List<Item> getAllMyItems(Long userId){
		Map<String, Object> searchParams = new HashMap<String, Object>();
		Specification<Item> spec = buildSpecification(userId, searchParams);
		return this.itemDao.findAll(spec);
	}

	@Autowired
	public void setItemDao(ItemDao itemDao) {
		this.itemDao = itemDao;
	}
	
	
	/**
	 * 创建动态查询条件组合.
	 */
	private Specification<Item> buildSpecification(Long userId, Map<String, Object> searchParams) {
		Map<String, SearchFilter> filters = SearchFilter.parse(searchParams);
		filters.put("user.id", new SearchFilter("user.id", Operator.EQ, userId));
		Specification<Item> spec = DynamicSpecifications.bySearchFilter(filters.values(), Item.class);
		return spec;
	}

}
