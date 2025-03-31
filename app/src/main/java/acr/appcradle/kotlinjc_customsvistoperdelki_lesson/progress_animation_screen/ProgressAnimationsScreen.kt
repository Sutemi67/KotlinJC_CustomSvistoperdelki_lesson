package acr.appcradle.kotlinjc_customsvistoperdelki_lesson.progress_animation_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

@Serializable
object ProgressAnimationScreen

fun NavController.navigateToProgressIndicatorScreen() =
    navigate(route = ProgressAnimationScreen)

fun NavGraphBuilder.progressAnimationScreen() {
    composable<ProgressAnimationScreen> { ProgressAnimationScreen() }
}

@Composable
fun ProgressAnimationScreen(
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            ScalingCircle()
            RotatingCircles(modifier = Modifier.size(130.dp))
        }
    }
}

