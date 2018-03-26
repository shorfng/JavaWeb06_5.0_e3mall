package com.loto.e3mall.controller;

// 商品管理Controller

import com.loto.e3mall.pojo.TbItem;
import com.loto.e3mall.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ItemController {

	@Autowired
	private ItemService itemService;

	// 根据商品id查询商品信息  http://localhost:8080/JavaWeb06_5.0_e3mall/item/536563
	@RequestMapping("/item/{itemId}")
	@ResponseBody
	public TbItem getItemById(@PathVariable Long itemId) {
		TbItem tbItem = itemService.getItemById(itemId);
		return tbItem;
	}
}
