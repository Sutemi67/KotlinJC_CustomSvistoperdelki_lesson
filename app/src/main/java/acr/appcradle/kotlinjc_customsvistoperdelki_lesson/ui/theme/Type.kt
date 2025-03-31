package acr.appcradle.kotlinjc_customsvistoperdelki_lesson.ui.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.yapracticumsprint27.ui.theme.JuraFontFamily

val Typography = CustomTypography(
    h1 = TextStyle(
        fontFamily = JuraFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 30.sp,
        lineHeight = 36.sp,
        letterSpacing = 0.sp
    ),
    body20SemiBold = TextStyle(
        fontFamily = JuraFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),

)

data class CustomTypography(
    val h1: TextStyle,
    val body20SemiBold: TextStyle,
)