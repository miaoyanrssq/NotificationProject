package cn.zgy.notification.manager;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.annotation.DrawableRes;
import android.support.v4.app.NotificationCompat;
import cn.zgy.notification.model.NfStyle;

public class BigTextManager extends NfManager {
    public BigTextManager(Context context, NotificationManager manager, Notification.Builder builder, int style) {
        super(context, manager, builder, style);
    }

    public BigTextManager title(String title){
        builder.setContentTitle(title);
        return this;
    }

    public BigTextManager content(String content){
        builder.setContentText(content);
        return this;
    }

    public BigTextManager largeIcon(Bitmap bitmap){
        builder.setLargeIcon(bitmap);
        return this;
    }
    public BigTextManager largeIcon(@DrawableRes int resource){
        builder.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), resource));
        return this;
    }

    public BigTextManager smallIcon(@DrawableRes int resource){
        builder.setSmallIcon(resource);
        return this;
    }

    public BigTextManager intentUrl(String url, int requestCode){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        PendingIntent pendingIntent = PendingIntent.getActivity(context, requestCode, intent, 0);
        builder.setContentIntent(pendingIntent);
        return this;
    }

    public BigTextManager defaults(int defaults){
        builder.setDefaults(defaults);
        return this;
    }

    public BigTextManager defaultsAll(){
        builder.setDefaults(NotificationCompat.DEFAULT_ALL);
        return this;
    }

    public BigTextManager autoCancel(boolean auto){
        builder.setAutoCancel(auto);
        return this;
    }
    public BigTextManager when(long time){
        builder.setWhen(time);
        return this;
    }

    public BigTextManager bigText(String bigText, String bigContentTitle){
        if(style == NfStyle.BIGTEXT.getCode()) {
            Notification.BigTextStyle style = new Notification.BigTextStyle();
            //bigText 给样式设置大文本内容
            style.bigText(bigText);
            //setBigContentTitle 给样式设置大文本的标题
            style.setBigContentTitle(bigContentTitle);
            //setStyle 将样式添加到通知
            builder.setStyle(style);
        }
        return this;
    }
}
