package com.example.baraja

import android.os.Bundle
import android.widget.ImageView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.baraja.clases.Baraja
import com.example.baraja.clases.Carta
import com.example.baraja.ui.theme.BarajaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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

    var iniciado by rememberSaveable {
        mutableStateOf(true)
    }

    val contexto = LocalContext.current


    if(iniciado){
        Baraja.crearBaraja(R.drawable.c01)
        Baraja.barajar()
        iniciado = false
    }

    var dadaLaVuelta by rememberSaveable {
        mutableStateOf(false)
    }

    Column (
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Image(painter = painterResource(id = if (dadaLaVuelta) Baraja.cartaActual.idDrawable else R.drawable.c53), contentDescription = "carta",modifier=Modifier.fillMaxWidth())

        Row(Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly)
        {
            Button(onClick = { dadaLaVuelta= true }) {
                Text(text = "Dame carta")
            }

            Button(onClick = {
                Baraja.crearBaraja(R.drawable.c01)
                Baraja.barajar()
                dadaLaVuelta = false
            }) {
                Text(text = "reiniciar")
            }
        }
    }

}