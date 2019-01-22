package cn.zgy.notification.manager;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;

public abstract class NfManager {
    Context context;
    NotificationManager manager;
    Notification.Builder builder;
    int style;
    public NfManager(Context context, NotificationManager manager, Notification.Builder builder, int style) {
        this.context = context;
        this.manager = manager;
        this.builder = builder;
        this.style = style;

    }



    public void build(){
        manager.notify(style, builder.build());
    }

    public NotificationManager getManager(){
        return manager;
    }

    public Notification.Builder getBuilder(){
        return builder;
    }
}
