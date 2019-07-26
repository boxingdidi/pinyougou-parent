package com.pinyougou.pojogroup;

import com.pinyougou.pojo.TbGoods;
import com.pinyougou.pojo.TbGoodsDesc;
import com.pinyougou.pojo.TbItem;

import java.io.Serializable;
import java.util.List;

/**
 * ClassName: GoodsGroup <br/>
 * Description: <br/>
 * date: 2019-05-05 20:57<br/>
 *
 * @author liuzhuangzhuang<br />
 */
public class GoodsGroup implements Serializable {

    private TbGoods goods;

    private TbGoodsDesc goodsDesc;

    private List<TbItem> itemsList;

    public TbGoods getGoods() {
        return goods;
    }

    public void setGoods(TbGoods goods) {
        this.goods = goods;
    }

    public TbGoodsDesc getGoodsDesc() {
        return goodsDesc;
    }

    public void setGoodsDesc(TbGoodsDesc goodsDesc) {
        this.goodsDesc = goodsDesc;
    }

    public List<TbItem> getItemsList() {
        return itemsList;
    }

    public void setItemsList(List<TbItem> itemsList) {
        this.itemsList = itemsList;
    }
}
