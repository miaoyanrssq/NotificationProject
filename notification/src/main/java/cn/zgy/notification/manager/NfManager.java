package cn.zgy.notification.manager;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.support.v4.app.NotificationCompat;
import cn.zgy.notification.NotificationUtils;

public abstract class NfManager {
    Context context;
    NotificationManager manager;
    NotificationCompat.Builder builder;
    int style;
    public NfManager(Context context, NotificationManager manager, NotificationCompat.Builder builder, int style) {
        this.context = context;
        this.manager = manager;
        this.builder = builder;
        this.style = style;

    }



    public void build(){
        Notification notification = builder.build();
        manager.notify(style, notification);
    }

    public NotificationManager getManager(){
        return manager;
    }

    public NotificationCompat.Builder getBuilder(){
        return builder;
    }
}
