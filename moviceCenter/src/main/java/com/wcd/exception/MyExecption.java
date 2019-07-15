package com.wcd.exception;

/***
 * 自定义异常类，接受一个 异常枚举类为对象
 * @author wcd
 * @date 2019 7 1
 */
public class MyExecption extends Exception{


    /**错误码*/
    private int errorCode;

    /**错误的信息*/
    private String message;

     public MyExecption(ErrorEmun errorEmun){
         this.errorCode = errorEmun.errorCode;
         this.message = errorEmun.message;
     }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
