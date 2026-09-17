package com.example.kotlingame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
    // Usamos Box como container principal para fixar elementos no topo, centro e rodapé
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp)
    ) {
        // --- 1. CONTEÚDO DO TOPO E MEIO ---
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Linha do Placar (SCORE na esquerda, LIVES na direita)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "SCORE: 0050",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    fontFamily = FontFamily.Monospace
                )
                Text(
                    text = "LIVES: 🚀🚀🚀",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    fontFamily = FontFamily.Monospace
                )
            }

            // Espaçamento e Linha de Inimigos/Vírus
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                GamesStatesPreviewContent()
                GamesStatesPreviewContent()
                GamesStatesPreviewContent()
                GamesStatesPreviewContent()
                GamesStatesPreviewContent()
            }
        }

        // --- 2. NAVE CENTRALIZADA ABAIXO DOS INIMIGOS ---
        Box(
            modifier = Modifier.align(Alignment.Center)
        ) {
            NaveStatesPreviewContent()
        }

        // --- 3. BOTÃO PRESS START NO RODAPÉ ---
        Text(
            text = "PRESS START",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            fontFamily = FontFamily.Monospace,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .align(Alignment.BottomCenter) // Fixa no rodapé
                .padding(bottom = 16.dp)       // Margem do fundo da tela
                .fillMaxWidth()               // Preenche a largura inteira
                .background(Color(0xFF333333)) // Fundo cinza como na foto
                .padding(vertical = 14.dp)     // Espessura do botão
        )
    }
}

@Composable
fun GamesStatesPreviewContent(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = R.drawable.virus1),
        contentDescription = null,
        modifier = modifier.size(48.dp) // Tamanho proporcional para caber 5 vírus na linha
    )
}

@Composable
fun NaveStatesPreviewContent(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = R.drawable.nave),
        contentDescription = null,
        modifier = modifier.size(64.dp)
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