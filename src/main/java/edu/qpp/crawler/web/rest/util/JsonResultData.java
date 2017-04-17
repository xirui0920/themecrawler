package edu.qpp.crawler.web.rest.util;

/**
 *
 * @param <T>
 */
public class JsonResultData<T> extends JsonResult {

    private T data;

    public JsonResultData(int retCode, String retInfo, T data) {

        super(retCode, retInfo);
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
