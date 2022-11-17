package com.kgg.android.c72
import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.Binder
import android.os.IBinder

class MyService : Service() {

    inner class MyBinder: Binder() { // 외부로 전달되는 객체
        var player = MediaPlayer()
        fun startMusic() {
            try {
                if(player != null && player.isPlaying) {
                    player.stop()
                    player.release()
                }
                player = MediaPlayer.create(applicationContext, R.raw.music)
                player.start()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        fun stopMusic() {
            if(player != null && player.isPlaying) {
                player.stop()
            }
        }
    }
    override fun onBind(intent: Intent): IBinder {
        return MyBinder()
    }
}