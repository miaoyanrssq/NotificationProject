package cn.zgy.notification.manager;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.DrawableRes;
import android.support.v4.app.NotificationCompat;
import android.widget.RemoteViews;
import cn.zgy.notification.model.NfStyle;

public class RemoteViewManager extends NfManager {
    public RemoteViewManager(Context context, NotificationManager manager, NotificationCompat.Builder builder, int style) {
        super(context, manager, builder, style);
    }

    public RemoteViewManager smallIcon(@DrawableRes int resource){
        builder.setSmallIcon(resource);
        return this;
    }

    public RemoteViewManager intentUrl(String url, int requestCode){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        PendingIntent pendingIntent = PendingIntent.getActivity(context, requestCode, intent, 0);
        builder.setContentIntent(pendingIntent);
        return this;
    }

    public RemoteViewManager defaults(int defaults){
        builder.setDefaults(defaults);
        return this;
    }

    public RemoteViewManager defaultsAll(){
        builder.setDefaults(NotificationCompat.DEFAULT_ALL);
        return this;
    }

    public RemoteViewManager autoCancel(boolean auto){
        builder.setAutoCancel(auto);
        return this;
    }
    public RemoteViewManager remoteView(RemoteViews remoteViews){
        if(style == NfStyle.REMOTEVIEW.getCode()) {
            builder.setContent(remoteViews);
        }
        return this;
    }

}
