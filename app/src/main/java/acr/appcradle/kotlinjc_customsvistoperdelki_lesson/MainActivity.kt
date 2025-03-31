package acr.appcradle.kotlinjc_customsvistoperdelki_lesson

import acr.appcradle.kotlinjc_customsvistoperdelki_lesson.greetings.GreetingsScreen
import acr.appcradle.kotlinjc_customsvistoperdelki_lesson.greetings.greetingsScreen
import acr.appcradle.kotlinjc_customsvistoperdelki_lesson.progress_animation_screen.progressAnimationScreen
import acr.appcradle.kotlinjc_customsvistoperdelki_lesson.ui.theme.KotlinJC_CustomSvistoperdelki_lessonTheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KotlinJC_CustomSvistoperdelki_lessonTheme {
                val navController = rememberNavController()
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AppNavHost(
                        navController = navController,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = GreetingsScreen,
        modifier = modifier
    ) {
        greetingsScreen(navController)
        progressAnimationScreen()
    }
}
