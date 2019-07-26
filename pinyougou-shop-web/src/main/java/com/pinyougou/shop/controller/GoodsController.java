package com.pinyougou.shop.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbGoods;
import com.pinyougou.pojogroup.GoodsGroup;
import com.pinyougou.sellergoods.service.GoodsService;
import entity.PageResult;
import entity.ResultMsg;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {

	@Reference
	private GoodsService goodsService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<TbGoods> findAll(){			
		return goodsService.findAll();
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageResult  findPage(int page,int rows){			
		return goodsService.findPage(page, rows);
	}
	
	/**
	 * 增加
	 * @param goods
	 * @return
	 */
	@RequestMapping("/add")
	public ResultMsg add(@RequestBody GoodsGroup goods){
		try {
			String seller_id = SecurityContextHolder.getContext().getAuthentication().getName();
			goods.getGoods().setSellerId(seller_id);
			goodsService.add(goods);
			return new ResultMsg(true, "增加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultMsg(false, "增加失败");
		}
	}
	
	/**
	 * 修改
	 * @param goods
	 * @return
	 */
	@RequestMapping("/update")
	public ResultMsg update(@RequestBody TbGoods goods){
		try {
			goodsService.update(goods);
			return new ResultMsg(true, "修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultMsg(false, "修改失败");
		}
	}	


	/**
	 * 获取实体
	 * @param id
	 * @return
	 */
	@RequestMapping("/findOne")
	public TbGoods findOne(Long id){
		return goodsService.findOne(id);		
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete")
	public ResultMsg delete(Long [] ids){
		try {
			goodsService.delete(ids);
			return new ResultMsg(true, "删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultMsg(false, "删除失败");
		}
	}
	
		/**
	 * 查询+分页
	 * @param goods
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/search")
	public PageResult search(@RequestBody TbGoods goods, int page, int rows  ){
		return goodsService.findPage(goods, page, rows);		
	}
	
}
