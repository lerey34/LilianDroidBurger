package fr.isen.rey.liliandroidburger.screens

import android.app.TimePickerDialog
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import fr.isen.rey.liliandroidburger.R
import fr.isen.rey.liliandroidburger.UserPreferences
import fr.isen.rey.liliandroidburger.logic.ConfirmerScreen
import fr.isen.rey.liliandroidburger.ui.theme.Dark
import fr.isen.rey.liliandroidburger.ui.theme.Gold
import fr.isen.rey.liliandroidburger.ui.theme.Light
import kotlinx.coroutines.launch
import java.util.*

@Composable
fun CommandeScreen(navController: NavController){
    val context = LocalContext.current

    val scope = rememberCoroutineScope()

    val dataStore = UserPreferences(context)

    var userName by rememberSaveable { mutableStateOf("") }
    var userPrenom by rememberSaveable { mutableStateOf("") }
    val address = remember { mutableStateOf("") }
    val phone = remember { mutableStateOf("") }
    val mTime = remember { mutableStateOf("") }

    var choice by remember {
        mutableStateOf("")
    }

    var expend by remember {
        mutableStateOf(false)
    }

    val list = listOf("Burger du chef", "Cheese Burger", "Burger Montagnard", "Burger Italien", "Burger Veterarien")

    val icon = if (expend)
        Icons.Filled.KeyboardArrowUp
    else
        Icons.Filled.KeyboardArrowDown

    val source = remember {
        MutableInteractionSource()
    }
    if (source.collectIsPressedAsState().value) {
        expend = !expend
    }

    val mCalendar = Calendar.getInstance()
    val mHour = mCalendar[Calendar.HOUR_OF_DAY]
    val mMinute = mCalendar[Calendar.MINUTE]

    val mTimePickerDialog = TimePickerDialog(
        context,
        {_, mHour : Int, mMinute: Int ->
            mTime.value = "$mHour:$mMinute"
        }, mHour, mMinute, true
    )

    val sourceTime = remember {
        MutableInteractionSource()
    }
    if (sourceTime.collectIsPressedAsState().value) {
        mTimePickerDialog.show()
    }

    Box(modifier = Modifier
        .fillMaxSize(),

    ) {
        Card(
            elevation = 4.dp,
            modifier = Modifier.fillMaxSize()
        ) {
            Image(painter = painterResource(id = R.drawable.ic_wave2), contentDescription = "waves", alignment = Alignment.BottomCenter)
            Image(painter = painterResource(id = R.drawable.ic_wave), contentDescription = "waves", alignment = Alignment.BottomCenter)

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
                    .padding(bottom = 20.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                    ) {
                    Image(painter = painterResource(id = R.drawable.burgerpng), contentDescription = "burger icon", Modifier.size(100.dp, 100.dp))
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Row() {
                            Text(text = "Lil", color = Dark, fontSize = 30.sp)
                            Text(text = "ian", color = Gold, fontSize = 30.sp)
                        }
                        Row() {
                            Text(text = "Droid", color = Dark, fontSize = 30.sp)
                            Text(text = "Burger", color = Gold, fontSize = 30.sp)
                        }

                    }
                }
    //            val userName2 = dataStore.getuserName.collectAsState("")
    //            userName = userName2.value!!
                OutlinedTextField(
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Gold,
                        focusedLabelColor = Dark
                    ),
                    value = userName,
                    onValueChange = { userName = it },
                    placeholder = { Text(text = "Nom") },
                    label = { Text(text = "Nom") },
                    leadingIcon = { Icon(painter = painterResource(id = R.drawable.name), contentDescription = "Nom") },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Next
                    ),
                    modifier = Modifier.width(300.dp)
                )
    //            val userPrenom2 = dataStore.getuserPrenom.collectAsState("")
    //            if (userPrenom2.value!! != "")
    //                userPrenom = userPrenom2.value!!
    //            else
    //                userPrenom = ""
                OutlinedTextField(
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Gold,
                        focusedLabelColor = Dark
                    ),
                    value = userPrenom,
                    onValueChange = { userPrenom = it },
                    placeholder = { Text(text = "Prenom") },
                    label = { Text(text = "Prenom") },
                    leadingIcon = { Icon(painter = painterResource(id = R.drawable.prenom), contentDescription = "Prenom") },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Next
                    ),
                    modifier = Modifier.width(300.dp)
                )

                OutlinedTextField(
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Gold,
                        focusedLabelColor = Dark
                    ),
                    value = address.value,
                    onValueChange = { address.value = it },
                    placeholder = { Text(text = "Addresse") },
                    label = { Text(text = "Addresse") },
                    leadingIcon = { Icon(painter = painterResource(id = R.drawable.adress), contentDescription = "Adresse") },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Next
                    ),
                    modifier = Modifier.width(300.dp)
                )

                OutlinedTextField(
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Gold,
                        focusedLabelColor = Dark
                    ),
                    value = phone.value,
                    onValueChange = { phone.value = it },
                    placeholder = { Text(text = "Phone number") },
                    label = { Text(text = "Phone number") },
                    leadingIcon = {
                        Icon(painter = painterResource(id = R.drawable.phone), contentDescription = "Phone")
                    },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Phone,
                        imeAction = ImeAction.Next
                    ),
                    modifier = Modifier.width(300.dp)
                )

                Column {
                    OutlinedTextField(
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Gold,
                            focusedLabelColor = Dark
                        ),
                        value = choice,
                        onValueChange = { choice = it },
                        placeholder = { Text(text = "Burger") },
                        label = { Text(text = "Burger") },
                        leadingIcon = { Icon(painter = painterResource(id = R.drawable.burgericon), contentDescription = "Burger") },
                        trailingIcon = {
                            Icon(icon, contentDescription = "Choice burger", Modifier.clickable { expend = !expend })
                        },
                        readOnly = true,
                        interactionSource = source,
                        modifier = Modifier.width(300.dp)
                    )
                    DropdownMenu(expanded = expend,
                        onDismissRequest = { expend = false}
                    ) {
                        list.forEach { label ->
                            DropdownMenuItem(onClick = {
                                choice = label
                                expend = false
                            }) {
                                Text(text = label)
                            }
                        }
                    }
                }

                OutlinedTextField(
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Gold,
                        focusedLabelColor = Dark
                    ),
                    value = mTime.value,
                    onValueChange = { mTime.value = it },
                    placeholder = { Text(text = "Time") },
                    label = { Text(text = "Time") },
                    leadingIcon = { Icon(painter = painterResource(id = R.drawable.time), contentDescription = "Time") },
                    readOnly = true,
                    interactionSource = sourceTime,
                    modifier = Modifier.width(300.dp)
                )
                Button(
                    onClick = {
                        scope.launch {
                            dataStore.saveUserName(userName)
                            dataStore.saveUserPrenom(userPrenom)
                        }
                        if (userName == ""){
                            Toast.makeText(context, "Remplir le champ \"nom\"", Toast.LENGTH_SHORT).show()
                        } else if (userPrenom == ""){
                            Toast.makeText(context, "Remplir le champ \"preom\"", Toast.LENGTH_SHORT).show()
                        } else if (address.value == ""){
                            Toast.makeText(context, "Remplir le champ \"addresse\"", Toast.LENGTH_SHORT).show()
                        } else if (phone.value == ""){
                            Toast.makeText(context, "Remplir le champ \"phone number\"", Toast.LENGTH_SHORT).show()
                        }
                        else if (choice == ""){
                            Toast.makeText(context, "Remplir le champ \"burger\"", Toast.LENGTH_SHORT).show()
                        }
                        else if (mTime.value == ""){
                            Toast.makeText(context, "Remplir le champ \"time\"", Toast.LENGTH_SHORT).show()
                        } else {
                            ConfirmerScreen(address, phone, choice, mTime.value)
                            navController.navigate("confirmScreen")
                        }
                    },
                    Modifier
                        .width(300.dp)
                        .height(100.dp)
                        .padding(top = 20.dp)
                ) {
                    Text(text = "Commander")
                }
            }
        }
    }
}