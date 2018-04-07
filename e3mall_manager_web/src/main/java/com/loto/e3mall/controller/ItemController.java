package com.loto.e3mall.controller;

// 商品管理Controller

import com.loto.e3mall.common.pojo.EasyUIDataGridResult;
import com.loto.e3mall.common.utils.E3Result;
import com.loto.e3mall.pojo.TbItem;
import com.loto.e3mall.service.ItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

	// 查询所有商品列表，进行分页处理
	@RequestMapping("/item/list")
	@ResponseBody
	public EasyUIDataGridResult getItemList(Integer page, Integer rows) {
		// 调用服务查询商品列表
		EasyUIDataGridResult result = itemService.getItemList(page, rows);
		return result;
	}

	// 商品添加功能
	@RequestMapping(value="/item/save", method= RequestMethod.POST)
	@ResponseBody
	public E3Result addItem(TbItem item, String desc) {
		E3Result result = itemService.addItem(item, desc);
		return result;
	}
}
