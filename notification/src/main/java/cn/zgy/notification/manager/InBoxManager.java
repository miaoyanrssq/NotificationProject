package cn.zgy.notification.manager;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.annotation.DrawableRes;
import android.support.v4.app.NotificationCompat;
import cn.zgy.notification.NotificationUtils;
import cn.zgy.notification.model.NfStyle;

import java.util.List;

public class InBoxManager extends NfManager{
    public InBoxManager(Context context, NotificationManager manager, NotificationCompat.Builder builder, int style) {
        super(context, manager, builder, style);
    }
    public InBoxManager title(String title){
        builder.setContentTitle(title);
        return this;
    }

    public InBoxManager content(String content){
        builder.setContentText(content);
        return this;
    }

    public InBoxManager largeIcon(Bitmap bitmap){
        builder.setLargeIcon(bitmap);
        return this;
    }
    public InBoxManager largeIcon(@DrawableRes int resource){
        builder.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), resource));
        return this;
    }

    public InBoxManager smallIcon(@DrawableRes int resource){
        builder.setSmallIcon(resource);
        return this;
    }

    public InBoxManager intentUrl(String url, int requestCode){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        PendingIntent pendingIntent = PendingIntent.getActivity(context, requestCode, intent, 0);
        builder.setContentIntent(pendingIntent);
        return this;
    }

    public InBoxManager defaults(int defaults){
        builder.setDefaults(defaults);
        return this;
    }

    public InBoxManager defaultsAll(){
        builder.setDefaults(NotificationCompat.DEFAULT_ALL);
        return this;
    }

    public InBoxManager autoCancel(boolean auto){
        builder.setAutoCancel(auto);
        return this;
    }

    public InBoxManager inBox(String bigContentTitle, List<String> contents){
        if(style == NfStyle.INBOX.getCode()) {
            android.support.v4.app.NotificationCompat.InboxStyle style = new android.support.v4.app.NotificationCompat.InboxStyle();
            style.setBigContentTitle(bigContentTitle);
            for (String content : contents) {
                style.addLine(content);
            }
            builder.setStyle(style);
        }
        return this;
    }
}
