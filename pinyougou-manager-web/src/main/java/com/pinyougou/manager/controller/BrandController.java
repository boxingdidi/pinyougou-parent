/**
 * ClassName: BrandController <br/>
 * Description: <br/>
 * date: 2019-04-17 10:48<br/>
 *
 * @author liuzhuangzhuang<br />
 * @version
 * @since JDK 1.8
 */
package com.pinyougou.manager.controller;


import java.util.List;
import java.util.Map;

import entity.PageResult;
import entity.ResultMsg;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.BrandService;


@RestController
@RequestMapping("/brand")
public class BrandController {

    @Reference
    private BrandService brandService;


    @RequestMapping("/findAll")
    public List<TbBrand> findAll(){
        return brandService.findAll();
    }

    /**
     * Description:分页显示功能
     *
     *       想法：后端返回数据： {total: "总页数" ，rows : "当前也传回的数据"}
     *            前端传递数据： pageNum ：当前页
     *                         pageSize ：每页记录数大小
     *
     * @author: liuzhuangzhuang
     * @date: 2019-04-20
     * @param page
     * @param page
     * @return:entity.PageResult
     */
    @RequestMapping("/findPage")
    public PageResult findPage(int page,int size){
        return brandService.findPage(page,size);
    }


    /**
     * Description:增加品牌列表
     * @author: liuzhuangzhuang
     * @date: 2019-04-20
     * @param tbBrand
     * @return:entity.ResultMsg
     */
    @RequestMapping("/add")
    public ResultMsg add(@RequestBody TbBrand tbBrand){
       try {
           boolean isHaveBrand = brandService.add(tbBrand);
           if (isHaveBrand) {
               return new ResultMsg(true, "新增成功");
           }else {
               return new ResultMsg(false, "新增失败，当前已存在该品牌");
           }
       }catch (Exception e){
            e.printStackTrace();
            return new ResultMsg(false,"新增失败");
       }
    }


    /**
     * Description:通过id查询品牌列表，回显到修改框
     * @author: liuzhuangzhuang
     * @date: 2019-04-20
     * @param id
     * @return:com.pinyougou.pojo.TbBrand
     */
    @RequestMapping("/findOne")
    public TbBrand findOneById(long id){
        return brandService.findOneById(id);
    }


    /**
     * Description:更新品牌列表
     * @author: liuzhuangzhuang
     * @date: 2019-04-20
     * @param tbBrand
     * @return:entity.ResultMsg
     */
    @RequestMapping("/update")
    public ResultMsg update(@RequestBody TbBrand tbBrand){
        try {
            brandService.update(tbBrand);
            return new ResultMsg(true,"修改成功");
        }catch (Exception e){
            e.printStackTrace();
            return new ResultMsg(false,"修改失败");
        }
    }

    /**
     * Description:删除品牌
     * @author: liuzhuangzhuang
     * @date: 2019-04-21
     * @param ids
     * @return:entity.ResultMsg
     */
    @RequestMapping("/delete")
    public ResultMsg delete(Long[] ids){
        try {
            brandService.delete(ids);
            return new ResultMsg(true,"删除成功");
        }catch (Exception e){
            e.printStackTrace();
            return new ResultMsg(false,"删除失败");
        }
    }

    /**
     * Description:条件查询 在分页基础上实现
     * @author: liuzhuangzhuang
     * @date: 2019-04-21
     *
     * @param tbBrand
     * @param page
     * @param rows
     *
     * @return:entity.PageResult
     */
    @RequestMapping("/search")
    public PageResult search(@RequestBody TbBrand tbBrand, int page, int rows ){
        return brandService.findPage(tbBrand,page,rows);
    }



    /**
     * Description:查询brand数据，映射返回select2的下拉列表中
     * @author: liuzhuangzhuang
     * @date: 2019-04-23
     *
     * @param
     *
     * @return:java.util.List<java.util.Map>
     */
    @RequestMapping("/selectOptionList")
    public List<Map> selectOptionList(){
        return brandService.selectOptionList();
    }

}
