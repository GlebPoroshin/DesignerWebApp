package com.gleb.designer.web.app.theme

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White

data class ThemeColors(
    val mainColor: Color,
    val onMainColor: Color,
    val secondColor: Color,
    val thirdColor: Color,
    val blueColor: Color,
    val blueToWhiteGradient: Brush
)

val DarkThemeColors = ThemeColors(
    mainColor = Color(0xFF1A1A1A),
    onMainColor = Color(0xFFE1E1E1),
    secondColor = White,
    thirdColor = Color(0xFFE1E1E1),
    blueColor = Color(0xFF4FC3F7),
    blueToWhiteGradient = Brush.horizontalGradient(listOf(Color(0xFF4FC3F7), White))
)

val LightThemeColors = ThemeColors(
    mainColor = Color(0xFFE0E8F6),
    onMainColor = Color(0xFF050505),
    secondColor = Black,
    thirdColor = Color(0xFF484E53),
    blueColor = Color(0xFF4FC3F7),
    blueToWhiteGradient = Brush.horizontalGradient(listOf(Color(0xFF4FC3F7), Color(0xFF484E53)))
)