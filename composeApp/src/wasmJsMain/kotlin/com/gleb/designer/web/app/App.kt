package com.gleb.designer.web.app

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.extensions.compose.stack.animation.fade
import com.gleb.designer.web.app.components.Header
import com.gleb.designer.web.app.components.SpacerBetweenPages
import com.gleb.designer.web.app.pages.AboutMe
import com.gleb.designer.web.app.pages.HomePage
import com.gleb.designer.web.app.pages.ProjectsPage
import com.gleb.designer.web.app.theme.DarkThemeColors
import com.gleb.designer.web.app.theme.LightThemeColors
import com.gleb.designer.web.app.theme.engStrings
import com.gleb.designer.web.app.theme.rusStrings
import kotlinx.coroutines.launch

@Composable
fun App(
    isSystemThemeDark: Boolean,
    clientHeight: Int,
    clientWidth: Int
) {
    var isEnglish by remember { mutableStateOf(true) }
    var strings by remember { mutableStateOf(if (isEnglish) engStrings else rusStrings) }
//    var isBlackTheme by remember { mutableStateOf(isSystemThemeDark) }
    var isBlackTheme by remember { mutableStateOf(false) }
    var themeColors by remember {
        mutableStateOf(
            if (isSystemThemeDark) DarkThemeColors else LightThemeColors
        )
    }

    themeColors = if (isBlackTheme) DarkThemeColors else LightThemeColors
    strings = if (isEnglish) engStrings else rusStrings

    val listState = rememberLazyListState()
    val scope = rememberCoroutineScope()
    val uriHandler = LocalUriHandler.current

    val contentsNamesList = listOf(
        strings.homeTab,
        strings.aboutTab,
        strings.skillsTab,
        strings.projectsTab,
        strings.contactsTab
    )
    val currentPage = 0

    LazyColumn(
        state = listState,
        modifier = Modifier
            .fillMaxSize()
            .background(themeColors.mainColor)
            .padding(start = 120.dp, end = 120.dp, top = 48.dp),
    ) {
        item(key = "Home") {
            Header(
                isEnglish = isEnglish,
                onLanguageChange = { isEnglish = !isEnglish },
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
                strings = strings,
                isBlackTheme = isBlackTheme,
                themeColors = themeColors,
                uriHandler = uriHandler
            )
            SpacerBetweenPages()

        }
        item(key = "AboutMe") {
            AboutMe(
                strings = strings,
                themeColors = themeColors,
                clientWidth = clientWidth
            )
            SpacerBetweenPages()
        }
//            item { }
        item(key = "Projects") {
            ProjectsPage(
                themeColors = themeColors
            )
            SpacerBetweenPages()
        }
    }
}
