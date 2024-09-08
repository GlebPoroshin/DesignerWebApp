package com.gleb.designer.web.app.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gleb.designer.web.app.theme.ThemeColors

@Composable
fun SecondaryTextButton (
    themeColors: ThemeColors,
    text: String,
    shape: Shape,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    isSelected: Boolean = false
) {
    Box(
        modifier = modifier
            .background(
                color = if (!isSelected) Color.Transparent else Color(0xFF484E53),
                shape = shape
            )
            .border(
                width = 1.dp,
                color = themeColors.fourthColor,
                shape = shape
            )
            .clickable { onClick() }
            .padding(vertical = 12.dp)
    ) {
        Text(
            modifier = Modifier.align(Alignment.Center),
            text = text,
            style = TextStyle(
                fontSize = 15.sp,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Center
            ),
            color =  if (isSelected) Color(0xffF5F5F5) else themeColors.fourthColor
        )
    }
}
