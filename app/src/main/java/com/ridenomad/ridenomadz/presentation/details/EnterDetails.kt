package com.ridenomad.ridenomadz.presentation.details

import android.app.DatePickerDialog
import android.content.Context
import android.widget.DatePicker
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import androidx.navigation.NavController
import com.ridenomad.ridenomadz.R
import com.ridenomad.ridenomadz.presentation.navigation.Screens
//import com.ridenomad.ridenomadz.presentation.DestinationScreen
//import com.ridenomad.ridenomadz.presentation.navigateTo
import java.util.*


@Composable
fun app(context: Context, navController: NavController) {
    Column(
        Modifier.padding(start = 20.dp, end = 20.dp, top = 35.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        dropDownMenu()
        showDatePicker(context = context)
        submitButton(context, navController)
        text()
    }
}

@Composable
fun text() {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Text(
            text = "Please fill the details above",
            fontSize = 17.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(start = 10.dp, end = 10.dp, bottom = 100.dp)
        )
    }

}

@Composable
fun submitButton(context: Context, navController: NavController) {

    Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.padding(top = 32.dp)) {
        OutlinedButton(
            modifier = Modifier
                .width(134.dp)
                .height(47.dp),
            border = BorderStroke(
                2.dp,
                color = com.ridenomad.ridenomadz.presentation.theme.ui.Purple700
            ), shape = RoundedCornerShape(12.dp),
            onClick = {
                navController.navigate(Screens.VehicleList.route)
//                navigateTo(
//                    navController = navController,
//                    DestinationScreen.VehicleList
//                )
            }) {
            Text(text = "Submit", fontSize = 18.sp, color = Color(R.color.primary))
        }
    }
}

@Composable
fun showDatePicker(context: Context) {

    val year: Int
    val month: Int
    val day: Int

    val calendar = Calendar.getInstance()
    year = calendar.get(Calendar.YEAR)
    month = calendar.get(Calendar.MONTH)
    day = calendar.get(Calendar.DAY_OF_MONTH)
    calendar.time = Date()

    var fromdate = remember { mutableStateOf("") }
    var todate = remember { mutableStateOf("") }
    val fromDatePickerDialog = DatePickerDialog(
        context,
        { _: DatePicker, year: Int, month: Int, dayOfMonth: Int ->
            fromdate.value = "$dayOfMonth/$month/$year"
        }, year, month, day
    )
    val toDatePickerDialog = DatePickerDialog(
        context,
        { _: DatePicker, year: Int, month: Int, dayOfMonth: Int ->
            todate.value = "$dayOfMonth/$month/$year"
        }, year, month, day
    )

    var fromToggle = remember { mutableStateOf(false) }
    var toToggle = remember { mutableStateOf(false) }


    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier.padding(end = 0.dp)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth(0.75f)
                .border(
                    border = BorderStroke(width = 1.dp, Color.LightGray),
                    shape = RoundedCornerShape(8.dp)
                )
                .padding(top = 1.dp)
                .height(60.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            DateSelect(
                toToggle = fromToggle,
                todate = fromdate,
                toDatePickerDialog = fromDatePickerDialog,
                type = "To"
            )

            Text(text = " - ", textAlign = TextAlign.Center, fontSize = 20.sp)

            DateSelect(
                toToggle = toToggle,
                todate = todate,
                toDatePickerDialog = toDatePickerDialog,
                type = "From"
            )
        }

        Spacer(modifier = Modifier.fillMaxWidth(0.08f))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    border = BorderStroke(width = 1.dp, Color.LightGray),
                    shape = RoundedCornerShape(8.dp)
                )
                .padding(top = 1.dp)
                .height(60.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 3.dp), horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Guest",
                    fontSize = 15.sp,
                    color = Color.Gray,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 8.dp)
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    val guest = remember {
                        mutableStateOf(0)
                    }
                    Icon(
                        painter = painterResource(id = R.drawable.ic_minus),
                        contentDescription = "minus", modifier = Modifier
                            .width(14.dp)
                            .height(24.dp)
                            .clickable(
                                onClick = {
                                    guest.value = guest.value - 1;

                                }
                            )
                    )

                    Text(text = "${guest.value}", fontSize = 18.sp)

                    Icon(
                        painter = painterResource(id = R.drawable.ic_baseline_add_24),
                        contentDescription = "minus", modifier = Modifier.clickable(
                            onClick = {
                                guest.value = guest.value + 1;

                            }
                        )
                    )
                }
            }
        }
    }
}

@Composable
fun DateSelect(
    toToggle: MutableState<Boolean>,
    todate: MutableState<String>,
    toDatePickerDialog: DatePickerDialog,
    type: String
) {

    if (toToggle.value) {
        Column(
            verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.Start
        ) {
            if (toToggle.value) {
                Text(
                    text = type, fontSize = 15.sp, color = Color.Gray, modifier = Modifier
                        .padding(start = 5.dp, top = 3.dp, bottom = 0.5.dp)
                )

                Text(
                    text = if (toToggle.value) {
                        todate.value
                    } else {
                        ""
                    }, fontSize = 15.sp, modifier = Modifier
                        .clickable(
                            onClick = {
                                toDatePickerDialog.show()
                                toToggle.value = !toToggle.value
                            }
                        )
                        .padding(start = 5.dp, bottom = 3.dp))
            }
        }
    } else {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.clickable(
            onClick = {
                toDatePickerDialog.show()
                toToggle.value = !toToggle.value
            }
        )) {
            Text(
                text = type, fontSize = 20.sp, modifier = Modifier
                    .padding(3.dp), textAlign = TextAlign.Center
            )
            Icon(
                painter = painterResource(id = R.drawable.ic_calender),
                contentDescription = "Calender Icon"
            )
        }

    }
}

@Composable
fun dropDownMenu() {

    var expanded by remember { mutableStateOf(false) }
    val suggestions = listOf("Noida", "Bangalore", "delhi", "Jaipur")
    var selectedText by remember { mutableStateOf("") }

    var textfieldSize by remember { mutableStateOf(Size.Zero) }

    val icon = if (expanded)
        Icons.Filled.KeyboardArrowUp
    else
        Icons.Filled.KeyboardArrowDown

    Box(modifier = Modifier.background(colors.background)) {
        Column(
            Modifier
                .background(colors.background)
                .padding(bottom = 1.dp)
        )
        {
            OutlinedTextField(
                value = selectedText,
                onValueChange = { selectedText = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
                    .onGloballyPositioned { coordinates ->
                        textfieldSize = coordinates.size.toSize()
                    },
                label = { Text("Pickup Location") },
                trailingIcon = {
                    Icon(icon, "contentDescription",
                        Modifier.clickable { expanded = !expanded })
                }
            )
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = Modifier
                    .width(with(LocalDensity.current) { textfieldSize.width.toDp() })
            ) {
                suggestions.forEach { label ->
                    DropdownMenuItem(onClick = {
                        selectedText = label
                        expanded = false
                    }) {
                        Text(text = label)
                    }
                }
            }
        }
    }

}
