package cn.zgy.notificationproject

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.RemoteViews
import cn.zgy.notification.Notifications
import cn.zgy.notification.channel.NotificationChannels
import cn.zgy.notification.manager.NfManager
import cn.zgy.notification.module.Property
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        hello.setOnClickListener{

            hungUpDemo()
            downDemo()
            remoteDemo()
        }
    }

    private fun remoteDemo(){
        val remoteViews = RemoteViews(getPackageName(), cn.zgy.notification.R.layout.remoteview_main)
        val title = "Android Developer"
        val content = "developer.android.com"
        remoteViews.setTextViewText(R.id.tv_title, title)
        remoteViews.setTextViewText(R.id.tv_content, content)
        remoteViews.setImageViewResource(R.id.iv_image, R.drawable.mv)

        Notifications.init(this, 1).remoteView(remoteViews)
            .smallIcon(R.mipmap.ic_launcher_round)
            .autoCancel(true)
            .defaultsAll()
            .build()
    }

    private fun hungUpDemo() {



        Notifications.init(this, 2).hungUp()
            .title("hungup")
            .content("content")
            .smallIcon(R.mipmap.ic_launcher_round)
            .autoCancel(true)
            .defaultsAll()
            .build()
    }

    private fun downDemo() {
        var downM: NfManager = Notifications.init(this, 3).normal(Property.DEFAULT)
        downM.title("微信2")
            .content("下载中")
            .smallIcon(R.mipmap.ic_launcher_round)
            .largeIcon(R.mipmap.ic_launcher)
            .autoCancel(true)


        Thread(
            Runnable {
                var incr: Int
                incr = 0
                while (incr <= 100) {
                    downM.progress(100, incr, false)
                    downM.content("下载中  " + incr.toString() + "%")
                    downM.build()
                    try {
                        Thread.sleep((1 * 1000).toLong())
                    } catch (e: Throwable) {
                        e.printStackTrace()
                    }

                    incr += 5
                }
                downM.content("下载完成")
                    // 移除进度条
                    .progress(0, 0, false)
                downM.build()
            }
        ).start()
    }
}
