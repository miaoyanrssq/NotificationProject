package cn.zgy.notification;


import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import cn.zgy.notification.channel.NotificationChannels;
import cn.zgy.notification.manager.*;
import cn.zgy.notification.model.NfStyle;


public class Notifications {

    private Context context;
    private NotificationManager manager;
    private Notification.Builder builder;

    public static Notifications init(Context context) {
        return new Notifications(context.getApplicationContext());
    }


    private Notifications(Context context) {
        this.context = context;
        manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannels.createAllNotificationChannels(context, manager);
        }
    }

    private void setBuilder(Context context, String channelId) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            builder = new Notification.Builder(context, channelId);
        } else {
            builder = new Notification.Builder(context);
        }
    }


    public NormalManager normalStyle() {
        setBuilder(context, NotificationChannels.DEFAULT);
        return new NormalManager(context, manager, builder, NfStyle.NRONAL.getCode());
    }


    public DownloadManager downloadStyle(NfStyle style) {
        setBuilder(context, NotificationChannels.DEFAULT);
        return new DownloadManager(context, manager, builder, style.getCode());
    }

    public BigTextManager bigTextStyle() {
        setBuilder(context, NotificationChannels.DEFAULT);
        return new BigTextManager(context, manager, builder, NfStyle.BIGTEXT.getCode());
    }

    public BigPictureManager bigPictureStyle() {
        setBuilder(context, NotificationChannels.DEFAULT);
        return new BigPictureManager(context, manager, builder, NfStyle.BIGPICTURE.getCode());
    }

    public InBoxManager inBoxStyle() {
        setBuilder(context, NotificationChannels.DEFAULT);
        return new InBoxManager(context, manager, builder, NfStyle.INBOX.getCode());
    }

    public HungUpManager hungUpStyle() {
        setBuilder(context, NotificationChannels.HIGH);
        return new HungUpManager(context, manager, builder, NfStyle.HUNGUP.getCode());
    }

    public RemoteViewManager remoteViewStyle() {
        setBuilder(context, NotificationChannels.DEFAULT);
        return new RemoteViewManager(context, manager, builder, NfStyle.REMOTEVIEW.getCode());
    }



}
