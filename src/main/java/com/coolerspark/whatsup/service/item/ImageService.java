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

import com.coolerspark.whatsup.entity.Image;
import com.coolerspark.whatsup.repository.ImageDao;


//Spring Bean的标识.
@Component
//类中所有public函数都纳入事务管理的标识.
@Transactional
public class ImageService {

	private ImageDao imageDao;

	@Autowired
	public void setImageDao(ImageDao imageDao) {
		this.imageDao = imageDao;
	}

	public List<Image> getImagesByItem(Long itemId) {
		Map<String, Object> searchParams = new HashMap<String, Object>();
		Specification<Image> spec = buildSpecification(itemId, searchParams);
		return this.imageDao.findAll(spec);
	}

	/**
	 * 创建动态查询条件组合.
	 */
	private Specification<Image> buildSpecification(Long itemId,
			Map<String, Object> searchParams) {
		Map<String, SearchFilter> filters = SearchFilter.parse(searchParams);
		filters.put("itemId", new SearchFilter("itemId", Operator.EQ, itemId));
		Specification<Image> spec = DynamicSpecifications.bySearchFilter(
				filters.values(), Image.class);
		return spec;
	}
}
