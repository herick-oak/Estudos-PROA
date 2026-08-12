package com.example.myapplication

import android.media.MediaPlayer
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

@Composable
fun TelaInicial(modifier: Modifier = Modifier) {
    // 1. Obter o contexto atual
    val context = LocalContext.current
    
    // 2. Inicializar o MediaPlayer (usando remember para não recriar a cada recomposição)
    val mediaPlayer = remember { 
        MediaPlayer.create(context, R.raw.sons_ratinho) 
    }

    // Limpeza do MediaPlayer quando o componente é removido da tela
    DisposableEffect(Unit) {
        onDispose {
            mediaPlayer?.release()
        }
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 48.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(64.dp))

        // Header Button
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp),
            shape = RoundedCornerShape(24.dp),
            color = Color(0xFF006386)
        ) {
            Box(contentAlignment = Alignment.Center) {
                Text(
                    text = stringResource(id = R.string.slop_sounds),
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
            }
        }

        Spacer(modifier = Modifier.height(48.dp))

        // Main Image with Shadow
        Surface(
            modifier = Modifier
                .size(280.dp)
                .shadow(
                    elevation = 32.dp,
                    shape = RoundedCornerShape(32.dp),
                    clip = false
                ),
            shape = RoundedCornerShape(32.dp),
            color = Color.LightGray
        ) {
            Image(
                painter = painterResource(id = R.drawable.rectangle_2__1_),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }

        Spacer(modifier = Modifier.height(48.dp))

        // Title Text
        Text(
            text = stringResource(id = R.string.title_text),
            color = Color.Black,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            lineHeight = 30.sp
        )

        Spacer(modifier = Modifier.height(64.dp))

        // Play Button
        Button(
            onClick = { 
                // 3. Lógica para tocar o som
                mediaPlayer?.let {
                    if (it.isPlaying) {
                        it.pause()
                        it.seekTo(0)
                    }
                    it.start()
                }
            },
            modifier = Modifier
                .width(220.dp)
                .height(84.dp),
            shape = RoundedCornerShape(24.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF006386),
                contentColor = Color.White
            )
        ) {
            Text(
                text = stringResource(id = R.string.play_button_text),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                lineHeight = 18.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TelaInicialPreview() {
    MyApplicationTheme {
        TelaInicial()
    }
}
