package com.gleb.designer.web.app.components

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.DrawableResource

data class ProjectModel(
    val imageUrl: String,
    val maxWidth: Dp = 326.dp,
    val fullTag: String
)
