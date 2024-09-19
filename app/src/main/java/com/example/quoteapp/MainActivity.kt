package com.example.quoteapp

import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.quoteapp.ui.theme.QuoteAppTheme
import androidx.compose.runtime.*
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QuoteAppTheme {
                Surface (
                    modifier = Modifier.fillMaxSize(),
                    color = androidx.compose.ui.graphics.Color.Magenta
                ){
                    Column (
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment  = Alignment.CenterHorizontally
                    ) {
                        QuoteApp()
                    }
                }
            }
        }
    }
}

@Composable
fun QuoteApp(){

    val quotes = listOf(
        "You are the best!",
        "You miss 100 percent of the shots that you don't take!",
        "I have failed over and over again in my life and that is why I succeed!",
        "It always seems impossible until it's done!",
        "Quality is not an act, it is a habit.",
        "If you're going through hell, keep going!",
        "If you dream it, you can do it!",
        "You will never win if you never begin",
        "Remember that diamonds are formed under pressure.",
        "If you can change your mind, you can change your life.",
        "Never take anything for granted. Always cherish the time you have on this Earth."
    )

    var currentQuote by remember { mutableStateOf(quotes.random()) }
    Text(
        text = currentQuote,
        style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold, color = androidx.compose.ui.graphics.Color.Cyan),
        modifier = Modifier.padding(16.dp)
    )
    Button(
        onClick = { currentQuote = quotes.random() },
    ) {
        Text("Change Quote")
    }
}