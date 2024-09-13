package com.gleb.designer.web.app.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SkillChart(
    data: Float,
    brush: Brush,
    textColor: Color,
    skillName: String,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(50)
                )
                .height(24.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth(data)
                    .background(
                        brush = brush,
                        shape = RoundedCornerShape(50)
                    )
                    .height(24.dp)
            )
        }
        Spacer(modifier.width(24.dp))
        Text(
            text = skillName,
            color = textColor,
            fontSize = 24.sp,
            fontWeight = FontWeight(500)
        )
    }
}
