# NotificationProject
android Notification 封装

## 使用

```groovy
implementation 'cn.zgy.notification:notification:0.0.1'
```

```java
Notifications.init(this).hungUpStyle()
            .title("hungup")
            .content("content")
            .smallIcon(R.mipmap.ic_launcher_round)
            .autoCancel(true)
            .defaultsAll()
            .intentUrl("http://www.baidu.com", 0)
            .build()
```

内部已自动创建Android O版本的各级别的channel，无需关心版本差异，以及channel问题，直接调用即可