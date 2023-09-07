package com.example.businesscard

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.businesscard.ui.theme.BusinessCardTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = Color(red = 155, green = 204, blue = 184)),
                    color = Color(red = 190, green = 233, blue = 193)
                ) {
                    ComposeCard()
                }
            }
        }
    }
}

@Composable
fun ComposeCard(modifier: Modifier = Modifier) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ){
        NamePart(name = "Full Name", description = "Android Developer")
        ContactPart(phone = "000 000 000", mail = "example@mail.com", social = "linkedin.com")
    }
}

@Composable
fun NamePart(name: String, description: String, modifier: Modifier = Modifier) {
    Row (
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .background(color = Color(red = 93, green = 176, blue = 141))
            .fillMaxWidth()
        ) {
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(bottom = 15.dp)
        ){
            Text(
                text = name,
                fontSize = 40.sp,
                modifier = Modifier.padding(10.dp),
                fontWeight = FontWeight.Bold
            )
            Text(
                text = description,
                fontSize = 25.sp,
                modifier = Modifier.padding(end = 10.dp, start = 10.dp)
            )
        }
        Image(
            painter = painterResource(id = R.drawable.android_logo),
            contentDescription = null,
            modifier = Modifier
                .padding(15.dp)
                .size(70.dp)
        )
    }
}
@Composable
fun ContactPart(phone: String, mail: String, social: String, modifier: Modifier = Modifier ){
    Row (
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(top = 50.dp, bottom = 20.dp, start = 10.dp, end = 10.dp)
    ){
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_phone_white_24dp),
                contentDescription = null,
                modifier = Modifier
                    .size(36. dp)
                    .padding(bottom = 10.dp)
            )
            Icon(
                painter = painterResource(id = R.drawable.baseline_email_white_24dp),
                contentDescription = null,
                modifier = Modifier
                    .size(36. dp)
                    .padding(bottom = 10.dp)
            )
            Icon(
                painter = painterResource(id = R.drawable.baseline_people_white_24dp),
                contentDescription = null,
                modifier = Modifier
                    .size(36. dp)
                    .padding(bottom = 10.dp)
            )
        }
        Column (
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.SpaceAround
        ) {
            Text(
                text = phone,
                fontSize = 20.sp,
                modifier = Modifier.padding(bottom = 9.dp)
            )
            Text(
                text = mail,
                fontSize = 20.sp,
                modifier = Modifier.padding(bottom = 9.dp)
            )
            Text(
                text = social,
                fontSize = 20.sp,
                modifier = Modifier.padding(bottom = 9.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        ComposeCard()
    }
}