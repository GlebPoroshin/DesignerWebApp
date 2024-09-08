package com.gleb.designer.web.app

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import kotlinx.browser.document
import kotlinx.browser.window

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    ComposeViewport(document.body!!) {
        var isDark by remember { mutableStateOf(getBrowserTheme()) }
        with(document.body!!) {
            App(
                isSystemThemeDark = isDark,
                clientHeight = clientHeight,
                clientWidth = clientWidth
            )
        }
        onThemeChange { isDark = it }
    }
}

fun getBrowserTheme(): Boolean {
    val mediaQuery = window.matchMedia("(prefers-color-scheme: dark)")
    return mediaQuery.matches
}

fun onThemeChange(callback: (Boolean) -> Unit) {
    val mediaQuery = window.matchMedia("(prefers-color-scheme: dark)")

    callback(mediaQuery.matches)

    mediaQuery.addEventListener("change") { _ ->
        val newTheme = mediaQuery.matches
        callback(newTheme)
    }
}
