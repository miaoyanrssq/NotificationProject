package cn.zgy.notification.module;

/**
* 自定义通知级别，在api>=26 时起作用，对应NotificationChannel配置
* @author zhengy
* create at 2019/1/23 上午11:00
**/
public enum Property {

    HIGH("high"),
    IMPORTANCE("importance"),
    DEFAULT("default"),
    LOW("low"),
    MEDIA("media");

    String name;

    Property(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
