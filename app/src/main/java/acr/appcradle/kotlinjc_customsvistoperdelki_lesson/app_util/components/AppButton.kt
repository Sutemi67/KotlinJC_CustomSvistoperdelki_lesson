package acr.appcradle.kotlinjc_customsvistoperdelki_lesson.app_util.components

import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle

@Composable
fun AppButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    text: String,
    textStyle: TextStyle
) {
    ElevatedButton(
        modifier = modifier,
        onClick = { onClick() }
    ) {
        Text(
            text = text,
            style = textStyle
        )
    }
}