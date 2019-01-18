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

public class BigPictureManager extends NfManager{
    public BigPictureManager(Context context, NotificationManager manager, NotificationCompat.Builder builder, int style) {
        super(context, manager, builder, style);
    }

    public BigPictureManager title(String title){
        builder.setContentTitle(title);
        return this;
    }

    public BigPictureManager content(String content){
        builder.setContentText(content);
        return this;
    }

    public BigPictureManager largeIcon(Bitmap bitmap){
        builder.setLargeIcon(bitmap);
        return this;
    }
    public BigPictureManager largeIcon(@DrawableRes int resource){
        builder.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), resource));
        return this;
    }

    public BigPictureManager smallIcon(@DrawableRes int resource){
        builder.setSmallIcon(resource);
        return this;
    }

    public BigPictureManager intentUrl(String url, int requestCode){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        PendingIntent pendingIntent = PendingIntent.getActivity(context, requestCode, intent, 0);
        builder.setContentIntent(pendingIntent);
        return this;
    }

    public BigPictureManager defaults(int defaults){
        builder.setDefaults(defaults);
        return this;
    }

    public BigPictureManager defaultsAll(){
        builder.setDefaults(NotificationCompat.DEFAULT_ALL);
        return this;
    }

    public BigPictureManager autoCancel(boolean auto){
        builder.setAutoCancel(auto);
        return this;
    }

    public BigPictureManager bigPicture(Bitmap bitmap, String bigContentTitle, String summaryText){
        if(style == NfStyle.BIGPICTURE.getCode()) {
            android.support.v4.app.NotificationCompat.BigPictureStyle style = new android.support.v4.app.NotificationCompat.BigPictureStyle();
            style.setBigContentTitle(bigContentTitle);
            style.setSummaryText(summaryText);
            style.bigPicture(bitmap);
            builder.setStyle(style);
        }
        return this;
    }
}
