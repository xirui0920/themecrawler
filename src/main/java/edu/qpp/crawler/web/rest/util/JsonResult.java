package edu.qpp.crawler.web.rest.util;

import java.io.Serializable;

public class JsonResult implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    /**
     * 返回结果码 0成功，非0失败
     */
    private int retCode = 0;
    /**
     * 操作结果信息
     */
    private String retInfo;


    public JsonResult() {
    }

    public JsonResult(int retCode, String retInfo) {

        this.retCode = retCode;
        this.retInfo = retInfo;
    }

    public int getRetCode() {
        return retCode;
    }

    public void setRetCode(int retCode) {
        this.retCode = retCode;
    }

    public String getRetInfo() {
        return retInfo;
    }

    public void setRetInfo(String retInfo) {
        this.retInfo = retInfo;
    }
}
