package com.gleb.designer.web.app

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.unit.dp
import com.gleb.designer.web.app.components.Header
import com.gleb.designer.web.app.components.SpacerBetweenPages
import com.gleb.designer.web.app.pages.AboutMe
import com.gleb.designer.web.app.pages.ContactsPage
import com.gleb.designer.web.app.pages.HomePage
import com.gleb.designer.web.app.pages.ProjectsPage
import com.gleb.designer.web.app.pages.SkillsPage
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
    Box(modifier = Modifier.fillMaxSize()) {
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
            item(key = "Skills") {
                SkillsPage(
                    strings = strings,
                    themeColors = themeColors,
                    clientWidth = clientWidth
                )
                SpacerBetweenPages()
            }
            item(key = "Projects") {
                ProjectsPage(
                    strings = strings,
                    themeColors = themeColors
                )
                SpacerBetweenPages()
            }
            item {
                ContactsPage(
                    colors = themeColors,
                    strings = strings
                )
            }
        }
        if (listState.firstVisibleItemIndex != 0) {
            Row(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(48.dp)
            ) {
                IconButton(
                    modifier = Modifier
                        .border(
                            width = 1.dp,
                            color = themeColors.fourthColor,
                            shape = CircleShape
                        ),
                    onClick = {
                        scope.launch {
                            listState.animateScrollToItem(0)
                        }
                    }
                ) {
                    Icon(
                        imageVector = Icons.Filled.KeyboardArrowUp,
                        contentDescription = null,
                        tint = Color(0xFF484E53),
                        modifier = Modifier.size(36.dp)
                    )
                }
            }
        }
    }
}
