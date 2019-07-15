package com.wcd.entity;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/***
 * Html，交互类型
 */
@Component
public class HtmlJson {
    /***
     * 错误码
     */
    private int errcode;

    /***
     * 错误信息
     */
    private String errorMessaage;


    /***
     * 页面总数
     */
    private int pageSize;

    /***
     * 数据总数
     */
    private long totoleSize;

    /***
     * 数据内容返回体
     */
    private Object htmlBody;


    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public String getErrorMessaage() {
        return errorMessaage;
    }

    public void setErrorMessaage(String errorMessaage) {
        this.errorMessaage = errorMessaage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotoleSize() {
        return totoleSize;
    }

    public void setTotoleSize(long totoleSize) {
        this.totoleSize = totoleSize;
    }

    public void setTotoleSize(int totoleSize) {
        this.totoleSize = totoleSize;
    }

    public Object getHtmlBody() {
        return htmlBody;
    }

    public void setHtmlBody(Object htmlBody) {
        this.htmlBody = htmlBody;
    }
}
