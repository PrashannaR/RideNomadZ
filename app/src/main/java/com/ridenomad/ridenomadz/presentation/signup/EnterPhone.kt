package com.ridenomad.ridenomadz.presentation.signup

import android.app.Activity
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.google.firestore.v1.TransactionOptions.ReadOnly
import com.ridenomad.ridenomadz.R
import com.ridenomad.ridenomadz.common.CommonDialog
import com.ridenomad.ridenomadz.common.ResultState
import com.ridenomad.ridenomadz.common.showMsg
import com.ridenomad.ridenomadz.presentation.navigation.Screens
import com.ridenomad.ridenomadz.presentation.viewmodel.AuthViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun EnterPhone(
    activity: Activity,
    viewModel: AuthViewModel = hiltViewModel(),
    navController: NavController
) {
    var mobile by remember { mutableStateOf("") }
    var otp by remember { mutableStateOf("") }
    val scope = rememberCoroutineScope()
    var isDialog by remember{ mutableStateOf(false) }

    if(isDialog)
        CommonDialog()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(modifier = Modifier.padding(top = 1.dp, bottom = 30.dp)) {
                Text(text = "Enter Phone Number For", fontSize = 25.sp, fontWeight = FontWeight.Bold)
                Text(text = "Verification", fontSize = 25.sp, fontWeight = FontWeight.Bold)
            }
            Spacer(modifier = Modifier.height(20.dp))
            
            Row() {
                TextField(value = +91, onValueChange = "+91"=it)
                OutlinedTextField(value = mobile, onValueChange = {
                    mobile = it
                }, modifier = Modifier.fillMaxWidth())
            }
            

            Spacer(modifier = Modifier.height(20.dp))

            Button(onClick = {
                scope.launch(Dispatchers.Main){
                    viewModel.createUserWithPhone(
                        mobile,
                        activity
                    ).collect{
                        when(it){
                            is ResultState.Success->{
                                isDialog = false
                                navController.navigate(Screens.EnterOTP.route)
                                activity.showMsg(it.data)
                            }
                            is ResultState.Failure->{
                                isDialog = false
                                activity.showMsg(it.msg.toString())
                            }
                            ResultState.Loading->{
                                isDialog = true
                            }
                        }
                    }
                }
            }) {
                Text(text = "Submit")
            }
            Spacer(modifier = Modifier.height(20.dp))
            Text(text = "Enter Otp")
            Spacer(modifier = Modifier.height(20.dp))
            OtpView(otpText = otp){
                otp = it
            }
            Spacer(modifier = Modifier.height(20.dp))
            Button(onClick = {
                scope.launch(Dispatchers.Main){
                    viewModel.signInWithCredential(
                        otp
                    ).collect{
                        when(it){
                            is ResultState.Success->{
                                isDialog = false
                                activity.showMsg(it.data)
                            }
                            is ResultState.Failure->{
                                isDialog = false
                                activity.showMsg(it.msg.toString())
                            }
                            ResultState.Loading->{
                                isDialog = true
                            }
                        }
                    }
                }
            }) {
                Text(text = "Verify")
            }
        }
    }

}

