package com.ridenomad.ridenomadz.data.Auth

import android.app.Activity
import com.ridenomad.ridenomadz.common.ResultState
import kotlinx.coroutines.flow.Flow

interface AuthRepository{
    fun createUserWithPhone(
        phone:String,
        activity: Activity
    ) : Flow<ResultState<String>>

    fun signWithCredential(
        otp:String,
    ): Flow<ResultState<String>>

}