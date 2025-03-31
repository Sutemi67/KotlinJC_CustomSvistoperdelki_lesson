package acr.appcradle.kotlinjc_customsvistoperdelki_lesson.progress_animation_screen

import acr.appcradle.kotlinjc_customsvistoperdelki_lesson.app_util.converterFloatToDp
import acr.appcradle.kotlinjc_customsvistoperdelki_lesson.app_util.converterIntToDp
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

private const val PERCENTAGE_PADDING_OF_INNER_CIRCLE = 0.15f
private const val PERCENTAGE_PADDING_OF_OUTER_CIRCLE = 0.35f
private const val ROTATION_OFFSET_OF_INNER_CIRCLE = 135f
private const val ROTATION_OFFSET_OF_OUTER_CIRCLE = 240f

@Composable
fun RotatingCircles(
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.primary,
    strokeWidthInDp: Int = 1
) {
    val infiniteTransition = rememberInfiniteTransition(label = "infinite transition")
    val rotation = infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1000)
        ),
        label = "rotation animation"
    )
    var width by remember { mutableIntStateOf(0) }
    val strokeWidth = converterIntToDp(strokeWidthInDp)
    Box(
        modifier = modifier
            .size(60.dp)
            .onSizeChanged {
                width = it.width
            },
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(
            modifier = modifier
                .fillMaxSize()
                .graphicsLayer {
                    rotationZ = rotation.value
                },
            color = color,
            strokeWidth = strokeWidth
        )
        CircularProgressIndicator(
            modifier = modifier
                .fillMaxSize()
                .padding(converterFloatToDp(width * PERCENTAGE_PADDING_OF_INNER_CIRCLE))
                .graphicsLayer {
                    rotationZ = rotation.value + ROTATION_OFFSET_OF_INNER_CIRCLE
                },
            color = color,
            strokeWidth = strokeWidth
        )

        CircularProgressIndicator(
            modifier = modifier
                .fillMaxSize()
                .padding(converterFloatToDp(width * PERCENTAGE_PADDING_OF_OUTER_CIRCLE))
                .graphicsLayer {
                    rotationZ = rotation.value + ROTATION_OFFSET_OF_OUTER_CIRCLE
                },
            color = color,
            strokeWidth = strokeWidth
        )
    }
}

@Preview
@Composable
fun RotatingCirclesPreview() {
    RotatingCircles()
}