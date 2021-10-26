package com.example.intentservice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        btnStartService.setOnClickListener {
//            Intent(this,MyIntentService::class.java).also {
//                startService(it)
//                tvServiceInfo.text = "Service running"
//            }
//
//
//        }
//
//        btnStopService.setOnClickListener {
//            MyIntentService.stopService()
//            tvServiceInfo.text = "Service stopped"
//        }

        btnStartService.setOnClickListener {
            Intent(this, MyService::class.java).also {
                startService(it)
                tvServiceInfo.text = "Service running"
            }
        }
        btnStopService.setOnClickListener {
            Intent(this, MyService::class.java).also {
                stopService(it)
                tvServiceInfo.text = "Service stopped"
            }
        }
        btnSendData.setOnClickListener {
            Intent(this, MyService::class.java).also {
                val dataString = etData.text.toString()
                it.putExtra("EXTRA_DATA",dataString)
                startService(it)
            }
        }
    }
}
