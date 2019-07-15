package com.wcd.exception;

/***
 * 系统的异常枚举对象
 * @author  wcd
 * @date 2019 7 1
 */
public enum ErrorEmun {

    /**这个枚举类，是IO读取中的异常*/
    IOutilError(1,"数据读取异常"),
    MoviceTypeNotFound(2,"没有找到这个板块");

    /**错误码*/
    int errorCode;

    /**错误提示信息*/
    String message;

    ErrorEmun(int errorCode,String message){
        this.errorCode = errorCode;
        this.message = message;
    }
}
