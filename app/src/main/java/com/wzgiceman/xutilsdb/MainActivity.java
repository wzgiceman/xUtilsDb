package com.wzgiceman.xutilsdb;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.wzgiceman.dbutils.db.DbManager;
import com.wzgiceman.dbutils.db.ex.DbException;
import com.wzgiceman.dbutils.db.x;


public class MainActivity extends AppCompatActivity {
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DbManager.DaoConfig config = new DbManager.DaoConfig().setDbName("wzg").setDbVersion(1);
        final DbManager db =  x.getDb(config);

        tv=(TextView)findViewById(R.id.tv_msg);

        final TestEntity testEntity=new TestEntity();
        testEntity.setId("A");

        findViewById(R.id.tv_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    testEntity.setMsg("初始数据");
                    db.saveOrUpdate(testEntity);
                    tv.setText(testEntity.toString());
                } catch (DbException e) {
                    e.printStackTrace();
                }
            }
        });

        findViewById(R.id.tv_update).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    testEntity.setMsg("修改了数据");
                    db.saveOrUpdate(testEntity);
                    tv.setText(testEntity.toString());
                } catch (DbException e) {
                    e.printStackTrace();
                }
            }
        });

        findViewById(R.id.tv_find).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    TestEntity testEntity1=   db.findFirst(TestEntity.class);
                    tv.setText(testEntity1==null?"null":testEntity1.toString());
                } catch (DbException e) {
                    e.printStackTrace();
                }
            }
        });
        findViewById(R.id.tv_del).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    db.delete(testEntity);
                    TestEntity testEntity1= db.findFirst(TestEntity.class);
                    tv.setText(testEntity1==null?"null":testEntity1.toString());
                } catch (DbException e) {
                    e.printStackTrace();
                }
            }
        });

    }

}
