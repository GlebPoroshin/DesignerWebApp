package com.gleb.designer.web.app.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gleb.designer.web.app.components.SkillChart
import com.gleb.designer.web.app.theme.Strings
import com.gleb.designer.web.app.theme.ThemeColors

@Composable
fun SkillsPage(
    strings: Strings,
    clientWidth: Int,
    themeColors: ThemeColors,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = strings.mySkills,
            style = TextStyle(
                fontSize = 48.sp,
                fontWeight = FontWeight.ExtraBold,
                color = themeColors.secondColor
            ),
        )
        Text(
            text = strings.software,
            style = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                brush = themeColors.blueToWhiteGradient
            )
        )
        Spacer(Modifier.height(40.dp))
        Column(horizontalAlignment = Alignment.Start) {
            SkillChart(
                skillName = "Adobe Photoshop",
                data = 4 / 10f,
                brush = themeColors.blueToWhiteGradient,
                textColor = themeColors.fourthColor
            )
            Spacer(Modifier.height(20.dp))
            SkillChart(
                skillName = "Figma",
                data = 60 / 100f,
                brush = themeColors.blueToWhiteGradient,
                textColor = themeColors.fourthColor
            )
            Spacer(Modifier.height(20.dp))
            SkillChart(
                skillName = "Adobe Illustrator",
                data = 70 / 100f,
                brush = themeColors.blueToWhiteGradient,
                textColor = themeColors.fourthColor
            )
            Spacer(Modifier.height(20.dp))
            SkillChart(
                skillName = "Blender",
                data = 35 / 100f,
                brush = themeColors.blueToWhiteGradient,
                textColor = themeColors.fourthColor
            )
            Spacer(Modifier.height(20.dp))
            SkillChart(
                skillName = "SketchUp",
                data = 25 / 100f,
                brush = themeColors.blueToWhiteGradient,
                textColor = themeColors.fourthColor
            )
            Spacer(Modifier.height(20.dp))
            SkillChart(
                skillName = "AutoCAD",
                data = 3 / 10f,
                brush = themeColors.blueToWhiteGradient,
                textColor = themeColors.fourthColor
            )
            Spacer(Modifier.height(20.dp))
            SkillChart(
                skillName = "Adobe After Effects",
                data = 2 / 10f,
                brush = themeColors.blueToWhiteGradient,
                textColor = themeColors.fourthColor
            )
        }
    }
}