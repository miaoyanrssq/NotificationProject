package cn.zgy.notification.channel;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import cn.zgy.notification.R;
import cn.zgy.notification.module.Property;

import java.util.Arrays;
/**
* 创建不同级别的Channel，api>= 26生效
* @author zhengy
* create at 2019/1/23 上午11:00
**/
public class NotificationChannels {


    @RequiresApi(api = Build.VERSION_CODES.O)
    public static void createAllNotificationChannels(Context context){
        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        createAllNotificationChannels(context, manager);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static void createAllNotificationChannels(Context context, NotificationManager manager) {
        if (manager.getNotificationChannels() != null && manager.getNotificationChannels().size() != 0) {
            NotificationChannel mediaChannel = new NotificationChannel(
                    Property.IMPORTANCE.getName(),
                    context.getString(R.string.channel_media),
                    NotificationManager.IMPORTANCE_DEFAULT);
            mediaChannel.setSound(null, null);
            mediaChannel.setVibrationPattern(null);


            manager.createNotificationChannels(Arrays.asList(
                    new NotificationChannel(Property.HIGH.getName(),
                            context.getString(R.string.channel_high),
                            NotificationManager.IMPORTANCE_HIGH),
                    new NotificationChannel(
                            Property.IMPORTANCE.getName(),
                            context.getString(R.string.channel_importance),
                            NotificationManager.IMPORTANCE_DEFAULT),
                    new NotificationChannel(
                            Property.DEFAULT.getName(),
                            context.getString(R.string.channel_default),
                            NotificationManager.IMPORTANCE_LOW),
                    new NotificationChannel(
                            Property.LOW.getName(),
                            context.getString(R.string.channel_low),
                            NotificationManager.IMPORTANCE_MIN),
                    //custom notification channel
                    mediaChannel
            ));
        }


    }
}
