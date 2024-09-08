package com.gleb.designer.web.app.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gleb.designer.web.app.theme.ThemeColors
import designerwebsite.composeapp.generated.resources.Res
import designerwebsite.composeapp.generated.resources.theme_button_light
import designerwebsite.composeapp.generated.resources.theme_button_night
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.painterResource

@Composable
fun Header(
    contentsNamesList: List<String>,
    listState: LazyListState,
    scope: CoroutineScope,
    clientHeight: Int,
    isBlackTheme: Boolean,
    onThemeChange: () -> Unit,
    currentPage: Int,
    themeColors: ThemeColors
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Suzdaltseva",
            style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight(600),
                color = themeColors.secondColor
            ),
        )
        Spacer(Modifier.weight(1f))
        contentsNamesList.forEachIndexed { index, page ->
            Text(
                text = page,
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight(500),
                    color = if (index == currentPage) themeColors.blueColor else themeColors.onMainColor
                ),
                modifier = Modifier.clickable {
                    scope.launch {
                        listState.animateScrollToItem(index, clientHeight)
                    }
                }
            )
            if (index != contentsNamesList.lastIndex) Spacer(Modifier.width(48.dp))
        }
        Spacer(Modifier.weight(1f))
        Image(
            painter = painterResource(if (isBlackTheme) Res.drawable.theme_button_light else Res.drawable.theme_button_night),
            contentDescription = null,
            modifier = Modifier
                .requiredSize(32.dp)
                .clickable { onThemeChange() }
        )
    }
}