package com.wzgiceman.xutilsdb;


import com.wzgiceman.dbutils.db.annotation.Column;
import com.wzgiceman.dbutils.db.annotation.Table;

/**
 * Created by WZG on 2017/1/9.
 */

@Table(name = "TestEntity")
public class TestEntity {

    @Column(name = "id",isId = true)
    private String id;

    @Column(name = "msg")
    private String msg;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "id->"+getId()+"\nmsg->"+getMsg();
    }
}
