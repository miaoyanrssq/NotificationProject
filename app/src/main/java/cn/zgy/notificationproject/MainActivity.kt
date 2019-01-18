package cn.zgy.notificationproject

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.RemoteViews
import cn.zgy.notification.NotificationUtils
import cn.zgy.notification.manager.DownloadManager
import cn.zgy.notification.model.NfStyle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        hello.setOnClickListener{

//            hungUpDemo()
//            downDemo()
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

        NotificationUtils.init(this, "channelId2").remoteViewStyle()
            .smallIcon(R.mipmap.ic_launcher_round)
            .remoteView(remoteViews)
            .autoCancel(true)
            .defaultsAll()
            .intentUrl("http://www.baidu.com", 0)
            .build()
    }

    private fun hungUpDemo() {

        var list = ArrayList<String>()
        list.add("hhhhhhhh")
        list.add("gggg")
        list.add("eeeeee")
        list.add("hhhhwwwwwhhhh")

        NotificationUtils.init(this, "channelId2").hungUpStyle()
            .title("hungup")
            .content("content")
            .smallIcon(R.mipmap.ic_launcher_round)
            .largeIcon(R.mipmap.ic_launcher)
            .autoCancel(true)
            .defaultsAll()
            .intentUrl("http://www.baidu.com", 0)
            .build()
    }

    private fun downDemo() {
        var downM: DownloadManager = NotificationUtils.init(this, "channelId2").downloadStyle(NfStyle.DOWNLOAD_2)
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
