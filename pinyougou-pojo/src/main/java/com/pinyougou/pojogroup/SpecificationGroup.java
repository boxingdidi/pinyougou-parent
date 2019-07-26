package com.pinyougou.pojogroup;

import com.pinyougou.pojo.TbSpecification;
import com.pinyougou.pojo.TbSpecificationOption;

import java.io.Serializable;
import java.util.List;

/**
 * ClassName: SpecificationGroup <br/>
 * Description: <br/>
 * date: 2019-04-22 19:26<br/>
 *
 * @author liuzhuangzhuang<br />
 */
public class SpecificationGroup implements Serializable {

    private TbSpecification tbspecification;

    private List<TbSpecificationOption> tbSpecificationOptionList;


    public TbSpecification getTbspecification() {
        return tbspecification;
    }

    public void setTbspecification(TbSpecification tbspecification) {
        this.tbspecification = tbspecification;
    }

    public List<TbSpecificationOption> getTbSpecificationOptionList() {
        return tbSpecificationOptionList;
    }

    public void setTbSpecificationOptionList(List<TbSpecificationOption> tbSpecificationOptionList) {
        this.tbSpecificationOptionList = tbSpecificationOptionList;
    }

    @Override
    public String toString() {
        return "SpecificationGroup{" +
                "tbspecification=" + tbspecification +
                ", tbSpecificationOptionList=" + tbSpecificationOptionList +
                '}';
    }
}
