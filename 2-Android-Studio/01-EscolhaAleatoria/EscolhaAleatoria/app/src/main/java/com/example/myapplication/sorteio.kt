package com.example.myapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

data class OpcaoSorteio(
    val nome: String,
    val imagemRes: Int // ID do recurso (R.drawable...)
)

val listaOpcoes = listOf(
    OpcaoSorteio("Preconceito", R.drawable.rectangle_4__10_),
    OpcaoSorteio("Machismo", R.drawable.rectangle_4__9_), // Troque pelos seus IDs reais
    OpcaoSorteio("Comida com banana", R.drawable.rectangle_4__8_),
    OpcaoSorteio("Jailson", R.drawable.rectangle_4__7_),
    OpcaoSorteio("Miojo doce", R.drawable.rectangle_4__6_), // Troque pelos seus IDs reais
    OpcaoSorteio("Coque Samurai", R.drawable.rectangle_4__3_),
    OpcaoSorteio("Lasanha de Berinjela", R.drawable.rectangle_4__2_),
    OpcaoSorteio("Palmerias", R.drawable.rectangle_4__1_), // Troque pelos seus IDs reais
    OpcaoSorteio("Studio Ghibli", R.drawable.rectangle_4)
)

@Composable
fun TelaSorteio(
    modifier: Modifier = Modifier,
    onBack: () -> Unit
) {
    var opcaoSelecionada by remember { mutableStateOf(listaOpcoes.random()) }

    Surface(
        modifier = modifier.fillMaxSize(),
        color = Color(0xFFFBFBFF) // Very light background
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Dark blue header bar
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(54.dp)
                    .background(Color(0xFF00668B))
            )

            Spacer(modifier = Modifier.height(110.dp))

            // Display Name
            Text(
                text = opcaoSelecionada.nome,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 32.sp,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(48.dp))

            // Large gray rounded card with nested image
            Box(
                modifier = Modifier
                    .size(312.dp)
                    .shadow(
                        elevation = 20.dp,
                        shape = RoundedCornerShape(48.dp),
                        clip = false,
                        ambientColor = Color.Black.copy(alpha = 0.2f),
                        spotColor = Color.Black.copy(alpha = 0.2f)
                    )
                    .clip(RoundedCornerShape(48.dp))
                    .background(Color(0xFFD9D9D9)),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = opcaoSelecionada.imagemRes),
                    contentDescription = null,
                    modifier = Modifier
                        .size(500.dp)
                        .clip(RoundedCornerShape(24.dp)),
                    contentScale = ContentScale.Crop
                )
            }

            Spacer(modifier = Modifier.height(130.dp))

            // "Sortear novamente" button
            Button(
                onClick = { opcaoSelecionada = listaOpcoes.random() },
                modifier = Modifier
                    .fillMaxWidth(0.65f)
                    .height(56.dp),
                shape = RoundedCornerShape(28.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF00668B)
                )
            ) {
                Text(
                    text = stringResource(R.string.btn_sortear_novamente),
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // "Tela Inicial" button
            Button(
                onClick = { onBack() },
                modifier = Modifier
                    .fillMaxWidth(0.65f)
                    .height(56.dp),
                shape = RoundedCornerShape(28.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF00668B)
                )
            ) {
                Text(
                    text = stringResource(R.string.btn_tela_inicial),
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun TelaSorteioPreview() {
    MyApplicationTheme {
        TelaSorteio(onBack = {})
    }
}
