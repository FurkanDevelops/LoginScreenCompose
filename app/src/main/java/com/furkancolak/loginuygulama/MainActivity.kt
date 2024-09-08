package com.furkancolak.loginuygulama

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.furkancolak.loginuygulama.ui.theme.LoginUygulamaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LoginUygulamaTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    MainScreen()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(){
    Surface(color = MaterialTheme.colorScheme.primary){
        val tfKullaniciAdi = remember {
            mutableStateOf("")

        }
        val tfSifre = remember {
            mutableStateOf("")
        }
        Column(modifier = Modifier.fillMaxSize(1f)
        , verticalArrangement = Arrangement.SpaceEvenly
        , horizontalAlignment = Alignment.CenterHorizontally) {
            Image(painter = painterResource(id = R.drawable.logo), contentDescription = "logo")
            TextField(
                value = tfKullaniciAdi.value,
                onValueChange = {tfKullaniciAdi.value=it},
                label = { Text(text = "Kullanici Adi")}
                ,colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Red,
                    focusedIndicatorColor = Color.Red,
                )
            )

            TextField(value = tfSifre.value,
                onValueChange = {tfSifre.value=it},
                label = { Text(text = "Sifre")}
            ,colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.Red,
                focusedIndicatorColor = Color.Red,
            )
            )
            Button(onClick = { /*TODO*/ },
                modifier = Modifier.size(250.dp,50.dp),
                colors =ButtonDefaults.buttonColors(
                    contentColor = Color.Red,// arka plan rengi
                    containerColor = Color.White// yazı rengi
                )){
                Text(text = "Giris Yap")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LoginUygulamaTheme {
        MainScreen()
    }
}