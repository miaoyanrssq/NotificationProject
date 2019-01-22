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

public class NormalManager extends NfManager {
    public NormalManager(Context context, NotificationManager manager, Notification.Builder builder, int style) {
        super(context, manager, builder, style);
    }

    public NormalManager title(String title){
        builder.setContentTitle(title);
        return this;
    }

    public NormalManager content(String content){
        builder.setContentText(content);
        return this;
    }

    public NormalManager largeIcon(Bitmap bitmap){
        builder.setLargeIcon(bitmap);
        return this;
    }
    public NormalManager largeIcon(@DrawableRes int resource){
        builder.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), resource));
        return this;
    }

    public NormalManager smallIcon(@DrawableRes int resource){
        builder.setSmallIcon(resource);
        return this;
    }

    public NormalManager intentUrl(String url, int requestCode){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        PendingIntent pendingIntent = PendingIntent.getActivity(context, requestCode, intent, 0);
        builder.setContentIntent(pendingIntent);
        return this;
    }

    public NormalManager defaults(int defaults){
        builder.setDefaults(defaults);
        return this;
    }

    public NormalManager defaultsAll(){
        builder.setDefaults(NotificationCompat.DEFAULT_ALL);
        return this;
    }

    public NormalManager autoCancel(boolean auto){
        builder.setAutoCancel(auto);
        return this;
    }

    public NormalManager when(long time){
        builder.setWhen(time);
        return this;
    }
}
