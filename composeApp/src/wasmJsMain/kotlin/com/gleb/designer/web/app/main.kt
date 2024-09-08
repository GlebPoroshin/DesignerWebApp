package com.gleb.designer.web.app

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import kotlinx.browser.document

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    ComposeViewport(document.body!!) {
        with(document.body!!) {
            MainPage(
                clientHeight = clientHeight,
                clientWidth = clientWidth
            )
        }
    }
}
