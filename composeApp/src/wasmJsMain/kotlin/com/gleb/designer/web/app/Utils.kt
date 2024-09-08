package com.gleb.designer.web.app

import kotlinx.browser.document
import org.w3c.dom.HTMLAnchorElement

fun downloadResume(fileName: String) {
    val link = document.createElement("a") as HTMLAnchorElement
    link.href = "https://raw.githubusercontent.com/GlebPoroshin/DesignerWebApp/main/CV.pdf"
    link.download = fileName
    document.body?.appendChild(link)
    link.click()
    document.body?.removeChild(link)
}
