package entity;

import java.io.Serializable;

/**
 * ClassName: ResultMsg <br/>
 * Description: <br/>
 * date: 2019-04-20 14:19<br/>
 *
 * @author liuzhuangzhuang<br />
 */
public class ResultMsg implements Serializable {

    private boolean success; // 是否成功

    private String msg; //回传消息

    public ResultMsg(boolean success, String msg) {
        this.success = success;
        this.msg = msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
