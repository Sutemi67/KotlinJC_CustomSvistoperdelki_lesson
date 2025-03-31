package acr.appcradle.kotlinjc_customsvistoperdelki_lesson.app_util

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp

@Composable
fun converterIntToDp(intValue: Int): Dp {
    return with(LocalDensity.current) {
        intValue.toDp()
    }
}

@Composable
fun converterFloatToDp(floatValue: Float): Dp {
    return with(LocalDensity.current) {
        floatValue.toDp()
    }
}