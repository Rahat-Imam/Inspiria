package com.jetpack.compose.practice.motivation.core.extension

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.View
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.core.content.ContextCompat.startActivity

fun read(link:String, context: Context){
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
    startActivity(context, intent, null)
}