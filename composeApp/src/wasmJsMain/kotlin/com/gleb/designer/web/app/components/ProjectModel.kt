package com.gleb.designer.web.app.components

import androidx.compose.ui.graphics.painter.Painter
import org.jetbrains.compose.resources.DrawableResource

data class ProjectModel(
    val image: DrawableResource,
    val title: String,
    val description: String,
    val fullTag: String
)
