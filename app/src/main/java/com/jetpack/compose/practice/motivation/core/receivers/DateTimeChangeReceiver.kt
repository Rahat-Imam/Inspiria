package com.jetpack.compose.practice.motivation.core.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class DateTimeChangeReceiver(private val onDateTimeChange: () -> Unit) : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        Log.d("RAHAT", "onReceive")
        onDateTimeChange()
    }
}