package com.example.kotlingame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kotlingame.R
import com.example.kotlingame.ui.theme.KotlingameTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KotlingameTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    GamesStates(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun GamesStates(name: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Black),
    ) {
        Text(
            text = "LIVES: 1 2 3 4",
            fontSize = 15.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color(0xFF3DDC84),
            fontFamily = FontFamily.Serif,
            letterSpacing = 5.sp,
            modifier = Modifier.offset(x = 240.dp, y = 24.dp)
        )
        Text(
            text = "SCORE: 0050",
            fontSize = 15.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color(0xFF3DDC84),
            fontFamily = FontFamily.Serif,
            textAlign = TextAlign.Start,
            letterSpacing = 5.sp
        )
        Text(
            text = "Start",
            fontSize = 15.sp,
            fontWeight = FontWeight.SemiBold,
            color = (Color.White),
            fontFamily = FontFamily.Serif,
            modifier = modifier
                .padding(bottom = 32.dp)       // 2. Afasta da borda inferior da tela (margem externa)
                .background(Color.DarkGray)    // 3. Pinta o fundo do texto de cinza
                .padding(horizontal = 185.dp, vertical = 12.dp)


        )

        // Chamada da imagem inserida aqui para renderizar na tela
        Row() {
            GamesStatesPreviewContent()
            GamesStatesPreviewContent()
            GamesStatesPreviewContent()
            GamesStatesPreviewContent()

            NaveStatesPreviewContent()
        }
    }
}

@Composable
fun GamesStatesPreviewContent(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = R.drawable.virus1),
        contentDescription = null,
        modifier = modifier
            .size(76.dp)
            .offset(x = 50.dp, y = 24.dp)

    )
}

@Composable
fun NaveStatesPreviewContent(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = R.drawable.nave),
        contentDescription = null,
        modifier = modifier
//            .offset(x = 50.dp, y = 400.dp)
            .size(900.dp)
    )
}

// Preview para visualização no Android Studio
@Preview(showBackground = true)
@Composable
fun GamesStatesPreview() {
    KotlingameTheme {
        GamesStates(name = "Android")
    }
}

@Preview(showBackground = true)
@Composable
fun NaveStatesPreview() {
    KotlingameTheme {
        GamesStates(name = "Android")
    }
}