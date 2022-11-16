package com.kgg.android.c68

import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val resultView = findViewById<TextView>(R.id.resultView)

        val button = findViewById<Button>(R.id.button)

        registerReceiver(null, IntentFilter(Intent.ACTION_BATTERY_CHANGED))!!.apply {
            var isChanging =  "Not Plugged"
            when(getIntExtra(BatteryManager.EXTRA_PLUGGED, -1)){
                BatteryManager.BATTERY_STATUS_CHARGING -> {
                    when(getIntExtra(BatteryManager.EXTRA_PLUGGED, -1)){
                        BatteryManager.BATTERY_PLUGGED_USB -> {
                            isChanging = "USB Plugged"
                        } // 저속 충전 상황
                        BatteryManager.BATTERY_PLUGGED_AC -> {
                            isChanging = "AC Plugged"
                        } // 고속 충전 상황
                    }
                }

            }

            // 현재 충전상태가 몇 %인지

            val level = getIntExtra(BatteryManager.EXTRA_LEVEL, -1)
            val scale = getIntExtra(BatteryManager.EXTRA_SCALE, -1)
            val batteryPct = level / scale.toFloat() * 100

            resultView.text = "$isChanging, $batteryPct %"

        }

        button.setOnClickListener {
            val intent = Intent(this, MyReceiver::class.java)
            sendBroadcast(intent)
        }
    }
}