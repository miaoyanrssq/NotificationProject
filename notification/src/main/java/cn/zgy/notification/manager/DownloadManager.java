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

public class DownloadManager extends NfManager{
    public DownloadManager(Context context, NotificationManager manager, NotificationCompat.Builder builder, int style) {
        super(context, manager, builder, style);
    }

    public DownloadManager title(String title){
        builder.setContentTitle(title);
        return this;
    }

    public DownloadManager content(String content){
        builder.setContentText(content);
        return this;
    }

    public DownloadManager largeIcon(Bitmap bitmap){
        builder.setLargeIcon(bitmap);
        return this;
    }
    public DownloadManager largeIcon(@DrawableRes int resource){
        builder.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), resource));
        return this;
    }

    public DownloadManager smallIcon(@DrawableRes int resource){
        builder.setSmallIcon(resource);
        return this;
    }

    public DownloadManager intentUrl(String url, int requestCode){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        PendingIntent pendingIntent = PendingIntent.getActivity(context, requestCode, intent, 0);
        builder.setContentIntent(pendingIntent);
        return this;
    }

//    public DownloadManager defaults(int defaults){
//        builder.setDefaults(defaults);
//        return this;
//    }
//
//    public DownloadManager defaultsAll(){
//        builder.setDefaults(NotificationCompat.DEFAULT_ALL);
//        return this;
//    }

    public DownloadManager autoCancel(boolean auto){
        builder.setAutoCancel(auto);
        return this;
    }

    public DownloadManager progress(int max, int progress, boolean indeterminate){
        builder.setProgress(max, progress, false);
        return this;
    }
    public DownloadManager contentInfo(CharSequence info){
        builder.setContentInfo(info);
        return this;
    }
}
