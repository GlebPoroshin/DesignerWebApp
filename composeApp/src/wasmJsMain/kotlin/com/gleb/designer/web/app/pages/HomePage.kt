package com.gleb.designer.web.app.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.UriHandler
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gleb.designer.web.app.components.TextButton
import com.gleb.designer.web.app.theme.ThemeColors
import designerwebsite.composeapp.generated.resources.Res
import designerwebsite.composeapp.generated.resources.emoji
import designerwebsite.composeapp.generated.resources.home_page_background
import org.jetbrains.compose.resources.painterResource

@Composable
fun HomePage(
    isBlackTheme: Boolean,
    themeColors: ThemeColors,
    uriHandler: UriHandler
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Transparent)
    ) {
        if (isBlackTheme) {
            Image(
                painter = painterResource(Res.drawable.home_page_background),
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
                modifier = Modifier.fillMaxWidth().align(Alignment.Center)
            )
        }
        Column(
            modifier = Modifier.fillMaxWidth().padding(125.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(Res.drawable.emoji),
                contentDescription = null,
                modifier = Modifier.size(240.dp).clip(CircleShape)
            )
            Text(
                text = "Lidia Suzdaltseva",
                style = TextStyle(
                    fontSize = 64.sp,
                    fontWeight = FontWeight.Bold,
                    color = themeColors.thirdColor
                )
            )
            Spacer(Modifier.height(16.dp))
            Text(
                text = "Graphic Designer",
                style = TextStyle(
                    fontSize = 24.sp,
                    fontWeight = FontWeight.SemiBold,
                    brush = themeColors.blueToWhiteGradient
                )
            )
            Spacer(Modifier.height(8.dp))
            Text(
                text = "As a passionate data scientist, with expertise in machine learning, AI, and data analytics...",
                style = TextStyle(
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Medium,
                    color = themeColors.thirdColor
                )
            )
            Spacer(Modifier.height(40.dp))
            TextButton(
                modifier = Modifier.width(180.dp),
                text = "Contact Me",
                textColor = themeColors.onMainColor,
                borderColor = themeColors.thirdColor,
                shape = RoundedCornerShape(72.dp),
                onClick = { uriHandler.openUri("https://t.me/zipzen") }
            )
        }
    }
}