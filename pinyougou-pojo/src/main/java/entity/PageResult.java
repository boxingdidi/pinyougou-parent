/**
 * ClassName: PageResult <br/>
 * Description: <br/>
 * date: 2019-04-20 01:00<br/>
 *
 * @author liuzhuangzhuang<br />
 * @version
 * @since JDK 1.8
 */
package entity;

import java.io.Serializable;
import java.util.List;

public class PageResult implements Serializable {

    private long total;

    private List rows;

    public PageResult(long total, List rows) {
        this.total = total;
        this.rows = rows;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }
}