package acr.appcradle.kotlinjc_customsvistoperdelki_lesson.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
)

private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40
)

data class ButtonColors(
    val primaryColors: ButtonStateColors,
    val warningColors: ButtonStateColors
)

data class ButtonStateColors(
    val background: Color,
    val textColor: Color
)

data class CustomColors(
    val button: ButtonColors
)

private val LightCustomColors = CustomColors(
    button = ButtonColors(
        primaryColors = ButtonStateColors(
            background = PrimaryButtonBackgroundLight,
            textColor = PrimaryButtonTextLightLight
        ),
        warningColors = ButtonStateColors(
            background = WarningButtonBackgroundLight,
            textColor = WarningButtonTextLightLight
        )
    )
)

private val DarkCustomColors = CustomColors(
    button = ButtonColors(
        primaryColors = ButtonStateColors(
            background = PrimaryButtonBackgroundDark,
            textColor = PrimaryButtonTextLightDark
        ),
        warningColors = ButtonStateColors(
            background = WarningButtonBackgroundDark,
            textColor = WarningButtonTextLightDark
        )
    )
)

val LocalCustomColors = staticCompositionLocalOf<CustomColors> {
    error("No CustomColors provided")
}

val LocalTypography = staticCompositionLocalOf<CustomTypography> {
    error("No Typography provided")
}


@Composable
fun KotlinJC_CustomSvistoperdelki_lessonTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val customColors = if (darkTheme) DarkCustomColors else LightCustomColors

    CompositionLocalProvider(
        LocalCustomColors provides customColors,
        LocalTypography provides Typography
    ) {

        MaterialTheme(
            colorScheme = colorScheme,
            content = content
        )
    }
}