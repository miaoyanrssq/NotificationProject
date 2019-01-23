package cn.zgy.notification;


import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.widget.RemoteViews;
import cn.zgy.notification.channel.NotificationChannels;
import cn.zgy.notification.manager.*;
import cn.zgy.notification.module.Property;

import java.util.List;


/**
 * 通知管理类
 *
 * @author zhengy
 * create at 2019/1/22 下午4:25
 **/
public class Notifications {

    private Context context;
    private NotificationManager manager;
    private Notification.Builder builder;
    private int id;

    public static Notifications init(Context context, int id) {
        return new Notifications(context.getApplicationContext(), id);
    }


    private Notifications(Context context, int id) {
        this.context = context;
        this.id = id;
        manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannels.createAllNotificationChannels(context, manager);
        }
    }

    private void setBuilder(Context context, Property property) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            builder = new Notification.Builder(context, property.getName());
        } else {
            builder = new Notification.Builder(context);
            switch (property) {
                case HIGH:
                    builder.setDefaults(Notification.DEFAULT_ALL);
                    builder.setTicker("").setPriority(Notification.PRIORITY_HIGH);
                    break;
                case IMPORTANCE:
                    builder.setDefaults(Notification.DEFAULT_ALL);
                    break;
                case DEFAULT:
                case LOW:
                    break;
                default:
                    break;
            }
        }
    }

    public NfManager normal(Property property) {
        setBuilder(context, property);
        return new NfManager(context, manager, builder, id);
    }

    public NfManager hungUp() {
        setBuilder(context, Property.HIGH);
        builder.setTicker("").setPriority(Notification.PRIORITY_HIGH);
        return new NfManager(context, manager, builder, id);
    }

    public NfManager bigPicture(Bitmap bitmap, String bigContentTitle, String summaryText) {
        setBuilder(context, Property.DEFAULT);
        Notification.BigPictureStyle style = new Notification.BigPictureStyle();
        style.setBigContentTitle(bigContentTitle);
        style.setSummaryText(summaryText);
        style.bigPicture(bitmap);
        builder.setStyle(style);
        return new NfManager(context, manager, builder, id);
    }

    public NfManager bigText(String bigText, String bigContentTitle) {
        setBuilder(context, Property.DEFAULT);
        Notification.BigTextStyle style = new Notification.BigTextStyle();
        //bigText 给样式设置大文本内容
        style.bigText(bigText);
        //setBigContentTitle 给样式设置大文本的标题
        style.setBigContentTitle(bigContentTitle);
        //setStyle 将样式添加到通知
        builder.setStyle(style);
        return new NfManager(context, manager, builder, id);
    }

    public NfManager inBox(String bigContentTitle, List<String> contents) {
        setBuilder(context, Property.DEFAULT);
        Notification.InboxStyle style = new Notification.InboxStyle();
        style.setBigContentTitle(bigContentTitle);
        for (String content : contents) {
            style.addLine(content);
        }
        builder.setStyle(style);
        return new NfManager(context, manager, builder, id);
    }

    public NfManager remoteView(RemoteViews remoteViews) {
        setBuilder(context, Property.DEFAULT);
        builder.setContent(remoteViews);
        return new NfManager(context, manager, builder, id);
    }


}
