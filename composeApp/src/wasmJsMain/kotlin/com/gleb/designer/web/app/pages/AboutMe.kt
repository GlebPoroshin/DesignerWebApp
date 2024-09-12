package com.gleb.designer.web.app.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidthIn
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
import com.gleb.designer.web.app.downloadResume
import com.gleb.designer.web.app.theme.Strings
import com.gleb.designer.web.app.theme.ThemeColors
import kotlinx.browser.document
import org.w3c.dom.HTMLAnchorElement

@Composable
fun AboutMe(
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
            text = strings.aboutMeTitle,
            style = TextStyle(
                fontSize = 48.sp,
                fontWeight = FontWeight.ExtraBold,
                color = themeColors.secondColor
            ),
        )
        Text(
            text = strings.getToKnowMe,
            style = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                brush = themeColors.blueToWhiteGradient
            )
        )
        Spacer(Modifier.height(40.dp))
        Text(
            modifier = Modifier.requiredWidthIn(max = (clientWidth / 2).dp),
            text = strings.aboutMe,
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
            text = strings.downLoadResume,
            textColor = themeColors.onMainColor,
            borderColor = themeColors.thirdColor,
            shape = RoundedCornerShape(72.dp),
            onClick = {
                downloadResume("CV.pdf")
            }
        )
    }
}
