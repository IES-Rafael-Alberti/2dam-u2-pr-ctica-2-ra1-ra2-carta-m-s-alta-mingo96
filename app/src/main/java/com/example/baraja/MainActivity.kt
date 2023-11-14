package com.example.baraja

import android.os.Bundle
import android.widget.ImageView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.baraja.clases.Baraja
import com.example.baraja.ui.theme.BarajaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Baraja.crearBaraja(R.drawable.c01)
        Baraja.barajar()
        setContent {
            BarajaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    pantallaBase()
                }
            }
        }
    }
}

@Composable
fun pantallaBase(){
    val contexto = LocalContext.current

    val cartaActual by rememberSaveable {
        mutableStateOf(Baraja.dameCarta())
    }

    Column {
        Image(painter = painterResource(id = R.drawable.c53), contentDescription = "carta del reves")
    }

}