package cn.zgy.notification.manager;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;
import android.widget.RemoteViews;
import cn.zgy.notification.R;
import cn.zgy.notification.channel.NotificationChannels;

import java.util.List;

public  class NfManager {
    private Context context;
    private NotificationManager manager;
    private Notification.Builder builder;
    int id;
    int smallIconRes;
    public NfManager(Context context, NotificationManager manager, Notification.Builder builder, int id) {
        this.context = context;
        this.manager = manager;
        this.builder = builder;
        this.id = id;

    }

    public NfManager title(String title){
        builder.setContentTitle(title);
        return this;
    }

    public NfManager content(String content){
        builder.setContentText(content);
        return this;
    }

    public NfManager largeIcon(Bitmap bitmap){
        builder.setLargeIcon(bitmap);
        return this;
    }
    public NfManager largeIcon(@DrawableRes int resource){
        builder.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), resource));
        return this;
    }

    public NfManager smallIcon(@DrawableRes int resource){
        smallIconRes = resource;
        builder.setSmallIcon(resource);
        return this;
    }

    public NfManager intent(Intent intent, int requestCode){
        PendingIntent pendingIntent = PendingIntent.getActivity(context, requestCode, intent, 0);
        builder.setContentIntent(pendingIntent);
        return this;
    }

    public NfManager defaults(int defaults){
        builder.setDefaults(defaults);
        return this;
    }

    public NfManager defaultsAll(){
        builder.setDefaults(NotificationCompat.DEFAULT_ALL);
        return this;
    }

    public NfManager autoCancel(boolean auto){
        builder.setAutoCancel(auto);
        return this;
    }

    public NfManager when(long time){
        builder.setWhen(time);
        return this;
    }

    public NfManager progress(int max, int progress, boolean indeterminate){
        builder.setProgress(max, progress, indeterminate);
        return this;
    }

    public NfManager remoteView(RemoteViews remoteViews){
        builder.setContent(remoteViews);
        return this;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT_WATCH)
    public NfManager action(Notification.Action action){
        builder.addAction(action);
        return this;
    }
    @RequiresApi(api = Build.VERSION_CODES.KITKAT_WATCH)
    public NfManager extra(Bundle bundle){
        builder.addExtras(bundle);
        return this;
    }


    public NfManager hungUp(){
        builder.setTicker("").setPriority(Notification.PRIORITY_HIGH);
        return this;
    }

    public NfManager bigPicture(Bitmap bitmap, String bigContentTitle, String summaryText) {
        Notification.BigPictureStyle style = new Notification.BigPictureStyle();
        style.setBigContentTitle(bigContentTitle);
        style.setSummaryText(summaryText);
        style.bigPicture(bitmap);
        builder.setStyle(style);
        return this;
    }

    public NfManager bigText(String bigText, String bigContentTitle){
        Notification.BigTextStyle style = new Notification.BigTextStyle();
        //bigText 给样式设置大文本内容
        style.bigText(bigText);
        //setBigContentTitle 给样式设置大文本的标题
        style.setBigContentTitle(bigContentTitle);
        //setStyle 将样式添加到通知
        builder.setStyle(style);
        return this;
    }

    public NfManager inBox(String bigContentTitle, List<String> contents) {
        Notification.InboxStyle style = new Notification.InboxStyle();
        style.setBigContentTitle(bigContentTitle);
        for (String content : contents) {
            style.addLine(content);
        }
        builder.setStyle(style);
        return this;
    }



    public void build(){
        //防止不设置smallIcon崩溃，在此处设置默认资源
        if(smallIconRes == 0){
            builder.setSmallIcon(R.mipmap.ic_launcher_round);
        }
        manager.notify(id, builder.build());
    }

    public NotificationManager getManager(){
        return manager;
    }

    public Notification.Builder getBuilder(){
        return builder;
    }
}
