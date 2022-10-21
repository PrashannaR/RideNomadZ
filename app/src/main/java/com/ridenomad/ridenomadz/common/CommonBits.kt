package com.ridenomad.ridenomadz.common

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

fun toaster(context: Context, msg : String){
    Toast.makeText(context,msg,Toast.LENGTH_SHORT).show()
}

