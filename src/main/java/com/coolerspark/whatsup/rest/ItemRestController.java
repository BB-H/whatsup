package com.coolerspark.whatsup.rest;

import java.util.List;

import javax.validation.Validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springside.modules.web.MediaTypes;

import com.coolerspark.whatsup.entity.Item;
import com.coolerspark.whatsup.service.item.ItemService;

@RestController
@RequestMapping(value = "/api/v1/item")
public class ItemRestController {
	
	private static Logger logger = LoggerFactory.getLogger(ItemRestController.class);

	@Autowired
	private ItemService itemService ;

	@Autowired
	private Validator validator;
	
	@RequestMapping(value = "/{id}",method = RequestMethod.GET, produces = MediaTypes.JSON_UTF_8)
	@Deprecated
	public List<Item> listMyItems1(@PathVariable("id") Long id) {
		return itemService.getAllMyItems(id);
	}
	
	@RequestMapping(value = "/instances",method = RequestMethod.GET, produces = MediaTypes.JSON_UTF_8)
	public List<Item> listMyItems(Long uid) {
		return itemService.getAllMyItems(uid);
	}

}
