# xUtilsDb
独立Xutils3中的数据库模块，灵活扩展数据模块的使用


##依赖
```java
   allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}

```

```java
dependencies {
	     compile 'com.github.wzgiceman:xUtilsDb:1.0'
}

```

##使用

### 1.Application中初始数据
```java
public class App  extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(BuildConfig.DEBUG);
    }
}
```

### 2.使用注解标示数据表数据

```java
@Table(name = "TestEntity")
public class TestEntity {

    @Column(name = "id",isId = true)
    private String id;

    @Column(name = "msg")
    private String msg;

    xxxget-setxxxxx
  }
```

### 3.设置数据库信息，得到DbManager操作对象
```java
 DbManager.DaoConfig config = new DbManager.DaoConfig().setDbName("wzg").setDbVersion(1);
 DbManager db =  x.getDb(config);
```


### 3.简单的数据处理（增删改查）

```java
//添加或者更新数据
db.saveOrUpdate(testEntity);

//查找数据-还有很多方法
db.findFirst(TestEntity.class);

//删除数据
db.delete(testEntity);
```

### 4.其他使用方法，可参考xutils3使用Db使用规则

[xUtils3](https://github.com/wyouflf/xUtils3)
