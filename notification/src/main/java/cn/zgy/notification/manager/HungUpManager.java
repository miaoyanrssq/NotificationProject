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
import android.support.annotation.DrawableRes;
import android.support.v4.app.NotificationCompat;

public class HungUpManager extends NfManager{
    public HungUpManager(Context context, NotificationManager manager, Notification.Builder builder, int style) {
        super(context, manager, builder, style);
    }

    public HungUpManager title(String title){
        builder.setContentTitle(title);
        return this;
    }

    public HungUpManager content(String content){
        builder.setContentText(content);
        return this;
    }

    public HungUpManager largeIcon(Bitmap bitmap){
        builder.setLargeIcon(bitmap);
        return this;
    }
    public HungUpManager largeIcon(@DrawableRes int resource){
        builder.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), resource));
        return this;
    }

    public HungUpManager smallIcon(@DrawableRes int resource){
        builder.setSmallIcon(resource);
        return this;
    }

    public HungUpManager intentUrl(String url, int requestCode){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        PendingIntent pendingIntent = PendingIntent.getActivity(context, requestCode, intent, 0);
        builder.setContentIntent(pendingIntent);
//        builder.setFullScreenIntent(pendingIntent, true);//横幅不会自动消失
        builder.setTicker("").setPriority(Notification.PRIORITY_HIGH);//横幅可以自动消失
        return this;
    }

    public HungUpManager defaults(int defaults){
        builder.setDefaults(defaults);
        return this;
    }

    public HungUpManager defaultsAll(){
        builder.setDefaults(NotificationCompat.DEFAULT_ALL);
        return this;
    }

    public HungUpManager autoCancel(boolean auto){
        builder.setAutoCancel(auto);
        return this;
    }

    public HungUpManager when(long time){
        builder.setWhen(time);
        return this;
    }
}
