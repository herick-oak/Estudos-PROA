package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                AppNavigation()
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "tela_inicial") {
        // Rota da Tela Inicial
        composable("tela_inicial") {
            MinhaTelaInicial(onNavigateToSorteio = {
                navController.navigate("tela_sorteio")
            })
        }

        // Rota da Tela de Sorteio
        composable("tela_sorteio") {
            TelaSorteio(onBack = {
                navController.popBackStack() // Volta para a tela anterior
            })
        }
    }
}
