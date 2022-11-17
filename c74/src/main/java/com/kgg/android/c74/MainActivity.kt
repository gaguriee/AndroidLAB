package com.kgg.android.c74

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.graphics.Color
import android.media.AudioAttributes
import android.media.Ringtone
import android.media.RingtoneManager
import android.net.Uri
import android.os.Build
import android.os.Build.VERSION_CODES.P
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.app.NotificationCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            val builder : NotificationCompat.Builder

            // 오레오 버전 이상이라면 채널을 만들기 위한 정보 설정
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                val channelId = "one-channel"
                val channelName = "My One Channel"

                //channel을 만든 다음 빌더를 만들어줘야하는데, 채널에 대한 정보를 먼저 줌
                val channel = NotificationChannel(
                    channelId,
                    channelName,
                    NotificationManager.IMPORTANCE_HIGH
                )

                //notification 채널에 주는 정보
                channel.description = "My Channel One Description" //환결성정에 주는 설명
                channel.setShowBadge(true) //notification 정보가 badge 아이콘에 출력되게 할건지
                val uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
                //알림음 play
                val audio = AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .setUsage(AudioAttributes.USAGE_ALARM)
                    .build()

                channel.setSound(uri, audio) // 알림음 설정
                channel.enableLights(true) //notification이 뜰 때 빛이 깜빡거리게끔
                channel.lightColor = Color.RED
                channel.enableVibration(true)
                channel.vibrationPattern = longArrayOf(100, 200, 100, 200)

                // 채널 정보 notification manager에 등록

                manager.createNotificationChannel(channel)

                // 채널 가지고 빌더 만들기

                builder = NotificationCompat.Builder(this, channelId)
        }else {
            //채널 개념 없을 때

            builder = NotificationCompat.Builder(this)
            }

            builder.setSmallIcon(android.R.drawable.ic_notification_overlay)
            builder.setWhen(System.currentTimeMillis())
            builder.setContentTitle("TItle")
            builder.setContentText("message")

            // 띄우기

            manager.notify(1, builder.build())
        }
    }
}