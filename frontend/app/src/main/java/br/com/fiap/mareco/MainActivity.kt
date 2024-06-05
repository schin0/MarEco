package br.com.fiap.mareco

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.fiap.mareco.screens.DetalhesEventoScreen
import br.com.fiap.mareco.screens.EventosScreen
import br.com.fiap.mareco.screens.HomeScreen
import br.com.fiap.mareco.screens.LoginScreen
import br.com.fiap.mareco.screens.RegistroScreen
import br.com.fiap.mareco.screens.registros.EmpresaScreen
import br.com.fiap.mareco.screens.registros.OrganizadorScreen
import br.com.fiap.mareco.screens.registros.VoluntarioScreen
import br.com.fiap.mareco.ui.theme.MarEcoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MarEcoTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize(),
                    color = colorResource(id = R.color.branco)
                ) {
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = "login",
                        modifier = Modifier
                            .background(colorResource(id = R.color.branco))
                    ) {
                        composable("login") {
                            LoginScreen(navController)
                        }

                        composable("registro") {
                            RegistroScreen(navController)
                        }

                        composable("registro/voluntario") {
                            VoluntarioScreen(navController)
                        }

                        composable("registro/organizador") {
                            OrganizadorScreen()
                        }

                        composable("registro/empresa") {
                            EmpresaScreen()
                        }

                        composable("home") {
                            HomeScreen(navController)
                        }

                        composable("eventos") {
                            EventosScreen(navController)
                        }

                        composable("detalhesEvento/{eventoId}") {
                            val eventoId = it.arguments?.getString("eventoId")
                            eventoId?.toInt()
                                ?.let { it1 -> DetalhesEventoScreen(navController, it1) }
                        }
                    }
                }
            }
        }
    }
}
