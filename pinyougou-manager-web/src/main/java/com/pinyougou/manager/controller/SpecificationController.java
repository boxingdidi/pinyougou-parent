package com.pinyougou.manager.controller;
import java.util.List;
import java.util.Map;

import com.pinyougou.pojogroup.SpecificationGroup;
import entity.PageResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbSpecification;
import com.pinyougou.sellergoods.service.SpecificationService;

import entity.ResultMsg;
/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/specification")
public class SpecificationController {

	@Reference
	private SpecificationService specificationService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<TbSpecification> findAll(){			
		return specificationService.findAll();
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageResult findPage(int page, int rows){
		return specificationService.findPage(page, rows);
	}



	/**
	 * 增加
	 * @param specificationGroup
	 * @return
	 */
	@RequestMapping("/add")
	public ResultMsg add(@RequestBody SpecificationGroup specificationGroup){
		try {
			System.out.println(specificationGroup.toString());
			specificationService.add(specificationGroup);
			return new ResultMsg(true, "增加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultMsg(false, "增加失败");
		}
	}
	
	/**
	 * 修改
	 * @param specificationGroup
	 * @return
	 */
	@RequestMapping("/update")
	public ResultMsg update(@RequestBody SpecificationGroup specificationGroup){
		try {
			specificationService.update(specificationGroup);
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
	public SpecificationGroup findOne(Long id){
		return specificationService.findOne(id);
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete")
	public ResultMsg delete(Long [] ids){
		try {
			specificationService.delete(ids);
			return new ResultMsg(true, "删除成功"); 
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultMsg(false, "删除失败");
		}
	}
	
		/**
	 * 查询+分页
	 * @param specification
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/search")
	public PageResult search(@RequestBody TbSpecification specification, int page, int rows  ){
		return specificationService.findPage(specification, page, rows);
	}

	/**
	 * Description: 查询规格属性下的属性名称，为前端显示准备
	 * @author: liuzhuangzhuang
	 * @date: 2019-04-23
	 *
	 * @param
	 *
	 * @return:java.util.List<java.util.Map>
	 */
	@RequestMapping("/selectOptionList")
	public List<Map> selectOptionList(){
		return specificationService.selectOptionList();
	}
	
}
