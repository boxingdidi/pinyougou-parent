package com.pinyougou.sellergoods.service;

import java.util.List;
import java.util.Map;

import com.pinyougou.pojo.TbBrand;
import entity.PageResult;
import entity.ResultMsg;

/**
 * 品牌接口
 * @author Administrator
 *
 */
public interface BrandService {

    /**
    * Description: 查询所有商品<br/>
    * @author: liuzhuangzhuang<br/>
    * @date: 2019-04-20 01:03<br/>
    * @param:[]<br/>
    * @return:java.util.List<com.pinyougou.pojo.TbBrand>
    */
    public List<TbBrand> findAll();

    /**
     * Description: 分页功能实现
     * @author: liuzhuangzhuang
     * @date: 2019-04-20
     * @param pageNum
     * @param pageSize
     * @return:entity.PageResult
     */
    public PageResult findPage(int pageNum,int pageSize);


    /**
     * Description: 增加品牌列表
     * @author: liuzhuangzhuang
     * @date: 2019-04-20
     * @param tbBrand
     * @return:void
     */
    public boolean add(TbBrand tbBrand);

    /**
     * Description:通过id查询品牌
     * @author: liuzhuangzhuang
     * @date: 2019-04-20
     * @param id
     * @return:com.pinyougou.pojo.TbBrand
     */
    public TbBrand findOneById(long id);


    /**
     * Description:更新品牌列表
     * @author: liuzhuangzhuang
     * @date: 2019-04-20
     * @param tbBrand
     * @return:void
     */
    public void update(TbBrand tbBrand);


    /**
     * Description: 删除品牌（删除多个）
     * @author: liuzhuangzhuang
     * @date: 2019-04-21
     * @param ids
     * @return:void
     */
    public void delete(Long[] ids);


    /**
     * Description:条件查询  在分页基础上实现
     * @author: liuzhuangzhuang
     * @date: 2019-04-21
     *
     * @param tbBrand
     * @param pageNum
     * @param pageSize
     *
     * @return:entity.PageResult
     */
    public PageResult findPage(TbBrand tbBrand,int pageNum,int pageSize);

    /**
     * Description: 查询brand 形成map形式
     * @author: liuzhuangzhuang
     * @date: 2019-04-23
     *
     * @param
     *
     * @return:java.util.List<com.pinyougou.pojo.TbBrand>
     */
    public List<Map> selectOptionList();
}
