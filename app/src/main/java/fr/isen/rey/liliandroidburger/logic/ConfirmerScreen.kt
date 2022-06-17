package fr.isen.rey.liliandroidburger.logic

import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.*
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import fr.isen.rey.liliandroidburger.R
import fr.isen.rey.liliandroidburger.UserPreferences
import fr.isen.rey.liliandroidburger.ui.theme.*
import kotlinx.coroutines.launch

var address: String = ""
var phone: String = ""
var burger: String = ""
var time: String = ""

fun ConfirmerScreen(Addresse: MutableState<String>, Phone: MutableState<String>, Burger: String, Time: String){
    address = Addresse.value
    phone = Phone.value
    burger = Burger
    time = Time
}

@Composable
fun ViewInfo() {
    val context = LocalContext.current
    val dataStore = UserPreferences(context)
    Box(modifier = Modifier
        .background(Light)
        .fillMaxSize()) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ){
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Light)
                    .padding(start = 50.dp, end = 50.dp, top = 10.dp)
                    .background(Shaddow, RoundedCornerShape(10.dp))
                    .padding(bottom = 5.dp, end = 5.dp)
                    .background(GoldBlur, RoundedCornerShape(10.dp))
                    .padding(horizontal = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                val userName = dataStore.getuserName.collectAsState(initial = "")
                Text(text = userName.value!!, fontSize = 20.sp, color = Dark, modifier = Modifier.width(200.dp).heightIn(min = 30.dp, max = 80.dp))
                Image(painter = painterResource(id = R.drawable.name_conf), contentDescription = "name", Modifier.size(50.dp, 50.dp))
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Light)
                    .padding(start = 50.dp, end = 50.dp, top = 10.dp)
                    .background(Shaddow, RoundedCornerShape(10.dp))
                    .padding(bottom = 5.dp, end = 5.dp)
                    .background(GoldBlur, RoundedCornerShape(10.dp))
                    .padding(horizontal = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                val userPrenom = dataStore.getuserPrenom.collectAsState(initial = "")
                Text(text = userPrenom.value!!, fontSize = 20.sp, color = Dark, modifier = Modifier.width(200.dp).heightIn(min = 30.dp, max = 80.dp))
                Image(painter = painterResource(id = R.drawable.prenom_conf), contentDescription = "prenom", Modifier.size(50.dp, 50.dp))
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Light)
                    .padding(start = 50.dp, end = 50.dp, top = 10.dp)
                    .background(Shaddow, RoundedCornerShape(10.dp))
                    .padding(bottom = 5.dp, end = 5.dp)
                    .background(GoldBlur, RoundedCornerShape(10.dp))
                    .padding(horizontal = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                val userName = dataStore.getuserName.collectAsState(initial = "")
                Text(text = address, fontSize = 20.sp, color = Dark, modifier = Modifier.width(200.dp).heightIn(min = 30.dp, max = 80.dp))
                Image(painter = painterResource(id = R.drawable.adress_conf), contentDescription = "address", Modifier.size(50.dp, 50.dp))
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Light)
                    .padding(start = 50.dp, end = 50.dp, top = 10.dp)
                    .background(Shaddow, RoundedCornerShape(10.dp))
                    .padding(bottom = 5.dp, end = 5.dp)
                    .background(GoldBlur, RoundedCornerShape(10.dp))
                    .padding(horizontal = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                val userName = dataStore.getuserName.collectAsState(initial = "")
                Text(text = phone, fontSize = 20.sp, color = Dark, modifier = Modifier.width(200.dp).heightIn(min = 30.dp, max = 80.dp))
                Image(painter = painterResource(id = R.drawable.phone_conf), contentDescription = "phone", Modifier.size(50.dp, 50.dp))
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Light)
                    .padding(start = 50.dp, end = 50.dp, top = 10.dp)
                    .background(Shaddow, RoundedCornerShape(10.dp))
                    .padding(bottom = 5.dp, end = 5.dp)
                    .background(GoldBlur, RoundedCornerShape(10.dp))
                    .padding(horizontal = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                val userName = dataStore.getuserName.collectAsState(initial = "")
                Text(text = burger, fontSize = 20.sp, color = Dark, modifier = Modifier.width(200.dp).heightIn(min = 30.dp, max = 80.dp))
                Image(painter = painterResource(id = R.drawable.burgerpng_conf), contentDescription = "burger", Modifier.size(50.dp, 50.dp))
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Light)
                    .padding(start = 50.dp, end = 50.dp, top = 10.dp, bottom = 10.dp)
                    .background(Shaddow, RoundedCornerShape(10.dp))
                    .padding(bottom = 5.dp, end = 5.dp)
                    .background(GoldBlur, RoundedCornerShape(10.dp))
                    .padding(horizontal = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                val userName = dataStore.getuserName.collectAsState(initial = "")
                Text(text = time, fontSize = 20.sp, color = Dark, modifier = Modifier.width(200.dp).heightIn(min = 30.dp, max = 80.dp))
                Image(painter = painterResource(id = R.drawable.time_conf), contentDescription = "clock", Modifier.size(50.dp, 50.dp))
            }
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                setData(Uri.parse("mailto:nailil2503@gmail.com"))
                putExtra(Intent.EXTRA_EMAIL, "nailil2503@gmail.com")
                putExtra(Intent.EXTRA_SUBJECT, "Confirmation commande")
                putExtra(Intent.EXTRA_TEXT, "Votre commande a bien été enregistrée")
            }
            Button(
                onClick = {
                    startActivity(context, intent, null)
                },
                Modifier
                    .width(300.dp)
                    .height(100.dp)
                    .padding(top = 20.dp)
            ) {
                Text(text = "Confiramation par email")
            }
        }
    }
}

@Preview
@Composable
fun ComposablePreview() {
    ViewInfo()
}