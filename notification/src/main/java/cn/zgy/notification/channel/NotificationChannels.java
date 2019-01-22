package cn.zgy.notification.channel;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import cn.zgy.notification.R;

import java.util.Arrays;

public class NotificationChannels {

    public final static String HIGH = "high";
    public final static String IMPORTANCE = "importance";
    public final static String DEFAULT = "default";
    public final static String LOW = "low";
    public final static String MEDIA = "media";

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static void createAllNotificationChannels(Context context){
        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        createAllNotificationChannels(context, manager);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static void createAllNotificationChannels(Context context, NotificationManager manager) {
        if (manager.getNotificationChannels() != null && manager.getNotificationChannels().size() != 0) {
            NotificationChannel mediaChannel = new NotificationChannel(
                    MEDIA,
                    context.getString(R.string.channel_media),
                    NotificationManager.IMPORTANCE_DEFAULT);
            mediaChannel.setSound(null, null);
            mediaChannel.setVibrationPattern(null);


            manager.createNotificationChannels(Arrays.asList(
                    new NotificationChannel(HIGH,
                            context.getString(R.string.channel_high),
                            NotificationManager.IMPORTANCE_HIGH),
                    new NotificationChannel(
                            IMPORTANCE,
                            context.getString(R.string.channel_importance),
                            NotificationManager.IMPORTANCE_DEFAULT),
                    new NotificationChannel(
                            DEFAULT,
                            context.getString(R.string.channel_default),
                            NotificationManager.IMPORTANCE_LOW),
                    new NotificationChannel(
                            LOW,
                            context.getString(R.string.channel_low),
                            NotificationManager.IMPORTANCE_MIN),
                    //custom notification channel
                    mediaChannel
            ));
        }


    }
}
