package com.gleb.designer.web.app

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gleb.designer.web.app.components.Header
import com.gleb.designer.web.app.components.SpacerBetweenPages
import com.gleb.designer.web.app.pages.AboutMe
import com.gleb.designer.web.app.pages.HomePage
import com.gleb.designer.web.app.pages.ProjectsPage
import com.gleb.designer.web.app.theme.DarkThemeColors
import com.gleb.designer.web.app.theme.LightThemeColors
import kotlinx.coroutines.launch

@Composable
fun MainPage(
    clientHeight: Int,
    clientWidth: Int
) {

    var isBlackTheme by remember { mutableStateOf(true) }
    isBlackTheme = false
    isBlackTheme = true

    val themeColors = if (isBlackTheme) DarkThemeColors else LightThemeColors

    val listState = rememberLazyListState()
    val scope = rememberCoroutineScope()
    val uriHandler = LocalUriHandler.current

    val contentsNamesList = listOf(
        "Home", "About", "Skills", "Projects", "Contacts"
    )
    val currentPage = 0

    LazyColumn(
        state = listState,
        modifier = Modifier
            .fillMaxSize()
            .background(themeColors.mainColor)
            .padding(start = 120.dp, end = 120.dp, top = 48.dp),
    ) {
        item {
            Header(
                contentsNamesList = contentsNamesList,
                onPageChange = { index ->
                    scope.launch {
                        listState.scrollToItem(index)
                    }
                },
                isBlackTheme = isBlackTheme,
                onThemeChange = { isBlackTheme = !isBlackTheme },
                currentPage = currentPage,
                themeColors = themeColors
            )
            Spacer(Modifier.height(36.dp))
            HomePage(
                isBlackTheme = isBlackTheme,
                themeColors = themeColors,
                uriHandler = uriHandler
            )
            SpacerBetweenPages()

        }
        item {
            AboutMe(
                themeColors = themeColors,
                clientWidth = clientWidth
            )
            SpacerBetweenPages()
        }
//            item { }
        item {
            ProjectsPage(
                themeColors = themeColors
            )
            SpacerBetweenPages()
        }
    }
}
