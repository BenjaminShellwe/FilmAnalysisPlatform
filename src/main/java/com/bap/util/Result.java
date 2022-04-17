package com.bap.util;

/*
 * Copyright from TernaryProject (c) 2022.
 * Author BenjaminThomasShellwe
 * Date 2022/4/17 9:45:39
 */

/**
 * The type Result.
 */
public class Result {

    private int code = 200;
    private String msg = "操作成功";
    private Object data;

    /* Instantiates a new Result.
     * @param code the code
     * @param msg  the msg
     */
    public Result(int code, String msg){
        this.code = code;
        this.msg = msg;
    }
    /* Instantiates a new Result.
     * @param code the code
     * @param msg  the msg
     * @param data the data
     */
    public Result(int code, String msg, Object data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
    /* Instantiates a new Result.
     * @param data the data
     */
    public Result(Object data){
        this.data = data;
    }

    /**
     * Gets code.
     *
     * @return the code
     */
    public int getCode() {
        return code;
    }

    /**
     * Sets code.
     *
     * @param code the code
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * Gets msg.
     *
     * @return the msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * Sets msg.
     *
     * @param msg the msg
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * Gets data.
     *
     * @return the data
     */
    public Object getData() {
        return data;
    }

    /**
     * Sets data.
     *
     * @param data the data
     */
    public void setData(Object data) {
        this.data = data;
    }
}
