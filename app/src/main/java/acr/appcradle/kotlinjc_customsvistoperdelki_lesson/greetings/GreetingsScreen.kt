package acr.appcradle.kotlinjc_customsvistoperdelki_lesson.greetings

import acr.appcradle.kotlinjc_customsvistoperdelki_lesson.app_util.components.AppButton
import acr.appcradle.kotlinjc_customsvistoperdelki_lesson.progress_animation_screen.navigateToProgressIndicatorScreen
import acr.appcradle.kotlinjc_customsvistoperdelki_lesson.ui.theme.Typography
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

@Serializable
object GreetingsScreen

fun NavGraphBuilder.greetingsScreen(navController: NavController) {
    composable<GreetingsScreen> { GreetingsScreen(navController) }
}

@Composable
fun GreetingsScreen(navController: NavController) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        AppButton(
            modifier = Modifier,
            onClick = { navController.navigateToProgressIndicatorScreen() },
            text = "Progress indicators",
            textStyle = Typography.body20SemiBold
        )
    }
}