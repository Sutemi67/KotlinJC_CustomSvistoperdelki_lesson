package acr.appcradle.kotlinjc_customsvistoperdelki_lesson.progress_animation_screen

import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp

@Composable
fun ScalingCircle(modifier: Modifier = Modifier, color: Color = Color.Red) {
    val infiniteTransition = rememberInfiniteTransition(label = "infinite transition")
    val progress = infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1000)
        ),
        label = "progress animation"
    )
    Box(
        modifier = modifier
            .size(60.dp)
            .graphicsLayer {
                scaleX = progress.value
                scaleY = progress.value
                alpha = 1f - progress.value
            }
            .border(width = 5.dp, color = color, shape = CircleShape)
    )
}