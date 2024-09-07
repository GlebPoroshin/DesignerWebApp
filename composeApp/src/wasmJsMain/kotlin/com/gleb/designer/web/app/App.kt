package com.gleb.designer.web.app

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import designerwebsite.composeapp.generated.resources.Res
import designerwebsite.composeapp.generated.resources.compose_multiplatform
import designerwebsite.composeapp.generated.resources.emoji
import designerwebsite.composeapp.generated.resources.home_page_background
import designerwebsite.composeapp.generated.resources.theme_button_light
import designerwebsite.composeapp.generated.resources.theme_button_night
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun App() {
    MainPage()
}

@Preview
@Composable
fun MainPage() {
    var mainColor by remember { mutableStateOf(Color(0xFF1A1A1A)) }
    var onMainColor by remember { mutableStateOf(Color(0xFFE1E1E1)) }
    var secondColor by remember { mutableStateOf(White) }
    var thirdColor by remember { mutableStateOf(Color(0xFFE1E1E1)) }
    val blueColor = Color(0xFF4FC3F7)
    var blueToWhiteGradient by remember {
        mutableStateOf(
            Brush.horizontalGradient(
                listOf(
                    blueColor,
                    White
                )
            )
        )
    }
    var isBlackTheme by remember { mutableStateOf(true) }

    val uriHandler = LocalUriHandler.current

    val listState = rememberLazyListState()

    var currentPage by remember { mutableStateOf("Home") }
    val contentsNamesList = listOf(
        "Home",
        "About",
        "Projects",
        "Skills",
        "Resume"
    )

    when (isBlackTheme) {

        true -> {
            mainColor = Color(0xFF1A1A1A)
            onMainColor = Color(0xFFE1E1E1)
            secondColor = White
            thirdColor = Color(0xFFE1E1E1)
            blueToWhiteGradient = Brush.horizontalGradient(
                listOf(
                    blueColor,
                    White
                )
            )
        }

        false -> {
            mainColor = Color(0xFFE0E8F6)
            onMainColor = Color(0xFF050505)
            secondColor = Black
            thirdColor = Color(0xFF484E53)
            blueToWhiteGradient = Brush.horizontalGradient(
                listOf(
                    blueColor,
                    Color(0xFF484E53)
                )
            )
        }
    }

    LaunchedEffect(currentPage) {
        contentsNamesList.indexOf(currentPage).let {
            if (it == 0) listState.scrollToItem(it)
            else listState.scrollToItem(it + 2)
        }

    }

    AnimatedVisibility(true) {
        LazyColumn(
            state = listState,
            modifier = Modifier
                .fillMaxSize()
                .background(mainColor)
                .padding(horizontal = 120.dp, vertical = 48.dp)
        ) {
            item {
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
                            color = secondColor
                        ),
                    )
                    Spacer(Modifier.weight(1f))
                    contentsNamesList.forEachIndexed { index, page ->
                        Text(
                            text = page,
                            style = TextStyle(
                                fontSize = 18.sp,
                                fontWeight = FontWeight(500),
                                color = if (page == currentPage) blueColor else onMainColor
                            ),
                            modifier = Modifier.clickable {
                                currentPage = page
                            }
                        )
                        if (index != contentsNamesList.lastIndex) Spacer(Modifier.width(48.dp))
                    }
                    Spacer(Modifier.weight(1f))
                    Image(
                        painter = painterResource(
                            if (isBlackTheme) Res.drawable.theme_button_light
                            else Res.drawable.theme_button_night
                        ),
                        contentDescription = null,
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier.requiredSize(32.dp)
                            .clickable { isBlackTheme = !isBlackTheme }
                    )
                }
                Spacer(Modifier.height(36.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            color = Color.Transparent,
                        )
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
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Bottom
                    ) {
                        Image(
                            painter = painterResource(Res.drawable.emoji),
                            contentDescription = null,
                            contentScale = ContentScale.FillBounds,
                            modifier = Modifier.size(240.dp)
                                .clip(CircleShape)
                        )
                        Text(
                            text = "Lidia Suzdaltseva",
                            style = TextStyle(
                                fontSize = 64.sp,
                                fontWeight = FontWeight.Bold,
                                color = thirdColor
                            ),
                        )
                        Spacer(Modifier.height(16.dp))
                        Text(
                            text = "Graphic Designer",
                            style = TextStyle(
                                fontSize = 24.sp,
                                fontWeight = FontWeight.SemiBold,
                                brush = blueToWhiteGradient
                            ),
                        )
                        Spacer(Modifier.height(8.dp))
                        Text(
                            text = "As a passionate data scientist, with expertise in machine learning, AI, and data analytics, I thrive on the challenges of exploring complex data landscapes and uncovering meaningful patterns that drive innovation",
                            style = TextStyle(
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Medium,
                                color = thirdColor
                            ),
                        )
                        Spacer(Modifier.height(40.dp))
                        TextButton(
                            modifier = Modifier.width(180.dp),
                            text = "Contact Me",
                            textColor = onMainColor,
                            borderColor = if (isBlackTheme) blueColor else thirdColor,
                            shape = RoundedCornerShape(72.dp),
                            onClick = { uriHandler.openUri("https://t.me/zipzen") },
                        )
                    }
                }
            }
            item {
                Box(modifier = Modifier.fillMaxSize()) {
                    Image(painter = painterResource(Res.drawable.compose_multiplatform), null)
                }
            }
        }
    }
}

@Composable
fun TextButton(
    text: String,
    shape: Shape,
    textColor: Color,
    borderColor: Color,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .background(
                color = Color.Transparent,
                shape = shape
            )
            .border(
                width = 1.dp,
                color = borderColor,
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
            color = textColor
        )
    }
}
