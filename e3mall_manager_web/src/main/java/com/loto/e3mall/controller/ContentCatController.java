package com.loto.e3mall.controller;

import com.loto.e3mall.common.pojo.EasyUITreeNode;
import com.loto.e3mall.common.utils.E3Result;
import com.loto.e3mall.content.service.ContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Author：蓝田_Loto
 * Date：2019-05-30 18:41
 * PageName：ContentCatController.java
 * Function：内容分类管理
 */

@Controller
public class ContentCatController {
    @Autowired
    private ContentCategoryService contentCategoryService;

    // 根据parentId查询子节点列表
    @RequestMapping("/content/category/list")
    @ResponseBody
    public List<EasyUITreeNode> getContentCatList(@RequestParam(name = "id", defaultValue = "0") Long parentId) {
        List<EasyUITreeNode> list = contentCategoryService.getContentCatList(parentId);
        return list;
    }

    // 添加内容分类节点
    @RequestMapping(value = "/content/category/create", method = RequestMethod.POST)
    @ResponseBody
    public E3Result createContentCategory(Long parentId, String name) {
        // 调用服务添加节点
        E3Result e3Result = contentCategoryService.addContentCategory(parentId, name);
        return e3Result;
    }
}
