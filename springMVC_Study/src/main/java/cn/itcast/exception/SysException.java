package cn.itcast.exception;

/**
 * 自定义的异常类
 */
public class SysException extends Exception {
    //储存异常信息
    private String msg;

    public SysException( String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
