package com.ridenomad.ridenomadz.presentation.signup

import android.app.Activity
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
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
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Column(modifier = Modifier.padding(top = 1.dp, bottom = 4.dp)) {
                Text(text = "Enter Phone Number For", fontSize = 25.sp, fontWeight = FontWeight.Bold)
                Text(text = "Verification", fontSize = 25.sp, fontWeight = FontWeight.Bold)
            }

            Spacer(modifier = Modifier.height(20.dp))

            Row(modifier = Modifier.padding(3.dp)) {
                Row(
                    modifier = Modifier
                        .border(
                            border = BorderStroke(width = 1.dp, Color.DarkGray),
                            shape = RoundedCornerShape(4.dp)
                        )
                        .weight(0.25f)
                        .padding(top = 1.dp, end = 1.dp)
                        .height(55.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly
                ){
                    Image(painter = painterResource(id = R.drawable.ic_india), contentDescription = " none",
                    modifier = Modifier.padding(1.dp))
                    Text(text ="+91")
                }

                Spacer(modifier = Modifier.height(40.dp))

                OutlinedTextField(value = mobile, onValueChange = {
                    mobile = it
                }, modifier = Modifier.padding(start = 6.dp))

            }

               /* OutlinedTextField(value = mobile, onValueChange = {
                    mobile = it
                }, modifier = Modifier.fillMaxWidth())*/



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
            },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = colorResource(id = R.color.primary),
                    contentColor = MaterialTheme.colors.primary
                ),
                shape = RoundedCornerShape(6.dp), modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp)
            ) {
                Text(
                    "Get OTP",
                    fontSize = 17.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(80.dp))

            Row(modifier = Modifier.fillMaxWidth(),Arrangement.Center) {
                Text(text = "Enter OTP", fontSize = 25.sp, fontWeight = FontWeight.Bold)
            }

            Spacer(modifier = Modifier.height(20.dp))
            Row(modifier = Modifier.fillMaxWidth(),Arrangement.Center) {
                OtpView(otpText = otp){
                    otp = it
                }
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
            },colors = ButtonDefaults.buttonColors(
                backgroundColor = colorResource(id = R.color.primary),
                contentColor = MaterialTheme.colors.primary
            ),
                shape = RoundedCornerShape(6.dp), modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp)
            ) {
                Text(
                    "Verify",
                    fontSize = 17.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }

}

