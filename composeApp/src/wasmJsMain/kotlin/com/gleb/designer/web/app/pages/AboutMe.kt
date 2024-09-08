package com.gleb.designer.web.app.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.UriHandler
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gleb.designer.web.app.components.TextButton
import com.gleb.designer.web.app.theme.ThemeColors
import kotlinx.browser.document
import org.w3c.dom.HTMLAnchorElement

@Composable
fun AboutMe(
    isBlackTheme: Boolean,
    clientWidth: Int,
    themeColors: ThemeColors,
    uriHandler: UriHandler,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.Transparent)
            .padding(horizontal = (clientWidth/5).dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "About Me",
            style = TextStyle(
                fontSize = 48.sp,
                fontWeight = FontWeight.ExtraBold,
                color = themeColors.secondColor
            ),
        )
        Text(
            text = "Get to know me",
            style = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                brush = themeColors.blueToWhiteGradient
            )
        )
        Spacer(Modifier.height(40.dp))
        Text(
            text = "Hi there! I'm [Your Name], a data scientist specializing in data analytics, predictive modeling, natural language processing, machine learning, and AI chatbots. With a passion for unraveling insights from complex datasets, I'm dedicated to helping businesses make informed decisions and stay ahead in today's data-driven world.\n" +
                    "\n" +
                    "I bring a blend of technical expertise, hands-on experience, and a commitment to clear communication to every project. Whether it's uncovering hidden patterns, predicting future trends, or automating processes with AI, I'm here to help you harness the full potential of your data.\n" +
                    "\n" +
                    "Let's work together to transform your data into actionable insights that drive real results. Get in touch, and let's start unlocking the power of your data today!",
            style = TextStyle(
                fontSize = 17.sp,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Center,
                color = themeColors.thirdColor
            )
        )
        Spacer(Modifier.height(40.dp))

        TextButton(
            modifier = Modifier.width(180.dp),
            text = "Download Resume",
            textColor = themeColors.onMainColor,
            borderColor = themeColors.thirdColor,
            shape = RoundedCornerShape(72.dp),
            onClick = {
                downloadResume("CV.pdf")
            }
        )
    }
}

fun downloadResume(fileName: String) {
    val link = document.createElement("a") as HTMLAnchorElement
    link.href = fileName
    link.download = fileName
    document.body?.appendChild(link)
    link.click()
    document.body?.removeChild(link)
}
