package cn.zgy.notification;


import android.app.NotificationManager;
import android.content.Context;
import android.support.v4.app.NotificationCompat;
import cn.zgy.notification.manager.*;
import cn.zgy.notification.model.NfStyle;


public class NotificationUtils {

    private Context context;
    private NotificationManager manager;
    private NotificationCompat.Builder builder;

    public static NotificationUtils init(Context context, String channelId) {
        return new NotificationUtils(context.getApplicationContext(), channelId);
    }

    private NotificationUtils(Context context, String channelId) {
        this.context = context;
        manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        builder = new NotificationCompat.Builder(context, channelId);
    }


    public NormalManager normalStyle(){
        return new NormalManager(context, manager, builder, NfStyle.NRONAL.getCode());
    }

    public DownloadManager downloadStyle(NfStyle style){
        return new DownloadManager(context, manager, builder, style.getCode());
    }

    public BigTextManager bigTextStyle(){
        return new BigTextManager(context, manager, builder, NfStyle.BIGTEXT.getCode());
    }
    public BigPictureManager bigPictureStyle(){
        return new BigPictureManager(context, manager, builder, NfStyle.BIGPICTURE.getCode());
    }
    public InBoxManager inBoxStyle(){
        return new InBoxManager(context, manager, builder, NfStyle.INBOX.getCode());
    }
    public HungUpManager hungUpStyle(){
        return new HungUpManager(context, manager, builder, NfStyle.HUNGUP.getCode());
    }

    public RemoteViewManager remoteViewStyle(){
        return new RemoteViewManager(context, manager, builder, NfStyle.REMOTEVIEW.getCode());
    }




}
