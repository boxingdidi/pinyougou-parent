package com.pinyougou.sellergoods.service.impl;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pinyougou.pojo.TbBrandExample;
import entity.PageResult;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.pinyougou.mapper.TbBrandMapper;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.pojo.TbBrandExample.Criteria;
import com.pinyougou.sellergoods.service.BrandService;
@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private TbBrandMapper brandMapper;

    @Override
    public List<TbBrand> findAll() {
        System.out.println("先走的这个=========");
        return brandMapper.selectByExample(null);
    }


    @Override
    public PageResult findPage(int pageNum, int pageSize) {

        //使用mybatis自带 PageHelper 插件进行分页
        PageHelper.startPage(pageNum,pageSize);

        Page<TbBrand> page = (Page<TbBrand>) brandMapper.selectByExample(null);

        return new PageResult(page.getTotal(),page.getResult());
    }

    @Override
    public boolean add(TbBrand tbBrand) {
        //进行数据哭查询比对是否存在品牌
        if (tbBrand != null){
            TbBrandExample tbBrandExample = new TbBrandExample();
            Criteria criteria = tbBrandExample.createCriteria();
            criteria.andNameEqualTo(tbBrand.getName());
            List<TbBrand> isHaveBrand=brandMapper.selectByExample(tbBrandExample);
            if (isHaveBrand.size()>0){
                return false;
            }else {
                brandMapper.insert(tbBrand);
                return true;
            }
        }
        return false;
    }

    @Override
    public TbBrand findOneById(long id) {
        return brandMapper.selectByPrimaryKey(id);
    }

    @Override
    public void update(TbBrand tbBrand) {
        brandMapper.updateByPrimaryKey(tbBrand);
    }

    @Override
    public void delete(Long[] ids) {
        for (Long id : ids){
            brandMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public PageResult findPage(TbBrand tbBrand, int pageNum, int pageSize) {
        //使用mybatis自带 PageHelper 插件进行分页
        PageHelper.startPage(pageNum,pageSize);

        //创建查询条件
        TbBrandExample tbBrandExample = new TbBrandExample();
        if (tbBrand != null){
            Criteria criteria =tbBrandExample.createCriteria();
            if (tbBrand.getName()!= null && tbBrand.getName().length()>0){
                criteria.andNameLike("%"+tbBrand.getName()+"%");
            }

            if (tbBrand.getFirstChar() != null && tbBrand.getFirstChar().length()> 0){
                criteria.andFirstCharLike("%"+tbBrand.getFirstChar()+"%");
            }
        }

        Page<TbBrand> page = (Page<TbBrand>) brandMapper.selectByExample(tbBrandExample);

        //使用mybatis自带 PageHelper 插件进行分页
        return new PageResult(page.getTotal(),page.getResult());
    }

    @Override
    public List<Map> selectOptionList() {
        return brandMapper.selectOptionList();
    }

}
