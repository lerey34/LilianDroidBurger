package fr.isen.rey.liliandroidburger.logic

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import fr.isen.rey.liliandroidburger.R
import fr.isen.rey.liliandroidburger.UserPreferences
import fr.isen.rey.liliandroidburger.ui.theme.Dark
import fr.isen.rey.liliandroidburger.ui.theme.GoldBlur
import fr.isen.rey.liliandroidburger.ui.theme.Light
import fr.isen.rey.liliandroidburger.ui.theme.Shaddow

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
        .fillMaxSize()
    ) {
        Card(
            elevation = 4.dp,
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_wave2),
                contentDescription = "waves",
                alignment = Alignment.BottomCenter
            )
            Image(
                painter = painterResource(id = R.drawable.ic_wave),
                contentDescription = "waves",
                alignment = Alignment.BottomCenter
            )

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 50.dp, end = 50.dp, top = 10.dp)
                        .background(Shaddow, RoundedCornerShape(10.dp))
                        .padding(bottom = 5.dp, end = 5.dp)
                        .background(GoldBlur, RoundedCornerShape(10.dp))
                        .padding(horizontal = 10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    val userName = dataStore.getuserName.collectAsState(initial = "")
                    Text(
                        text = userName.value!!,
                        fontSize = 20.sp,
                        color = Dark,
                        modifier = Modifier
                            .width(200.dp)
                            .heightIn(min = 30.dp, max = 80.dp)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.name_conf),
                        contentDescription = "name",
                        Modifier.size(50.dp, 50.dp)
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 50.dp, end = 50.dp, top = 10.dp)
                        .background(Shaddow, RoundedCornerShape(10.dp))
                        .padding(bottom = 5.dp, end = 5.dp)
                        .background(GoldBlur, RoundedCornerShape(10.dp))
                        .padding(horizontal = 10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    val userPrenom = dataStore.getuserPrenom.collectAsState(initial = "")
                    Text(
                        text = userPrenom.value!!,
                        fontSize = 20.sp,
                        color = Dark,
                        modifier = Modifier
                            .width(200.dp)
                            .heightIn(min = 30.dp, max = 80.dp)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.prenom_conf),
                        contentDescription = "prenom",
                        Modifier.size(50.dp, 50.dp)
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 50.dp, end = 50.dp, top = 10.dp)
                        .background(Shaddow, RoundedCornerShape(10.dp))
                        .padding(bottom = 5.dp, end = 5.dp)
                        .background(GoldBlur, RoundedCornerShape(10.dp))
                        .padding(horizontal = 10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = address,
                        fontSize = 20.sp,
                        color = Dark,
                        modifier = Modifier
                            .width(200.dp)
                            .heightIn(min = 30.dp, max = 80.dp)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.adress_conf),
                        contentDescription = "address",
                        Modifier.size(50.dp, 50.dp)
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 50.dp, end = 50.dp, top = 10.dp)
                        .background(Shaddow, RoundedCornerShape(10.dp))
                        .padding(bottom = 5.dp, end = 5.dp)
                        .background(GoldBlur, RoundedCornerShape(10.dp))
                        .padding(horizontal = 10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = phone,
                        fontSize = 20.sp,
                        color = Dark,
                        modifier = Modifier
                            .width(200.dp)
                            .heightIn(min = 30.dp, max = 80.dp)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.phone_conf),
                        contentDescription = "phone",
                        Modifier.size(50.dp, 50.dp)
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 50.dp, end = 50.dp, top = 10.dp)
                        .background(Shaddow, RoundedCornerShape(10.dp))
                        .padding(bottom = 5.dp, end = 5.dp)
                        .background(GoldBlur, RoundedCornerShape(10.dp))
                        .padding(horizontal = 10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = burger,
                        fontSize = 20.sp,
                        color = Dark,
                        modifier = Modifier
                            .width(200.dp)
                            .heightIn(min = 30.dp, max = 80.dp)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.burgerpng_conf),
                        contentDescription = "burger",
                        Modifier.size(50.dp, 50.dp)
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 50.dp, end = 50.dp, top = 10.dp, bottom = 10.dp)
                        .background(Shaddow, RoundedCornerShape(10.dp))
                        .padding(bottom = 5.dp, end = 5.dp)
                        .background(GoldBlur, RoundedCornerShape(10.dp))
                        .padding(horizontal = 10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = time,
                        fontSize = 20.sp,
                        color = Dark,
                        modifier = Modifier
                            .width(200.dp)
                            .heightIn(min = 30.dp, max = 80.dp)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.time_conf),
                        contentDescription = "clock",
                        Modifier.size(50.dp, 50.dp)
                    )
                }
                val intent = Intent(Intent.ACTION_SENDTO).apply {
                    setData(Uri.parse("mailto:marc.mollinari@gmail.com"))
                    putExtra(Intent.EXTRA_EMAIL, "marc.mollinari@gmail.com")
                    putExtra(Intent.EXTRA_SUBJECT, "Confirmation commande")
                    putExtra(Intent.EXTRA_TEXT, "Votre commande a bien ??t?? enregistr??e")
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
                    Text(text = "Confirmation par email", color = Dark)
                }
            }
        }
    }
}
