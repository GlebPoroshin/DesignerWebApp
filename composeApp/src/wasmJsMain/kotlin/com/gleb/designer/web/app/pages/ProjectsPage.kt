package com.gleb.designer.web.app.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gleb.designer.web.app.components.ProjectModel
import com.gleb.designer.web.app.components.SecondaryTextButton
import com.gleb.designer.web.app.components.projectsList
import com.gleb.designer.web.app.theme.Strings
import com.gleb.designer.web.app.theme.ThemeColors
import com.seiko.imageloader.rememberImagePainter
import kotlin.math.min

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ProjectsPage(
    strings: Strings,
    themeColors: ThemeColors,
    modifier: Modifier = Modifier
) {
    val tags = mapOf(
        "Adobe" to 3,
        "Figma" to 2,
        "3D" to 2,
    )

    var selectedTag: String by remember { mutableStateOf("Adobe") }
    var filteredProjects: List<ProjectModel> by remember {
        mutableStateOf(projectsList.filter { it.fullTag.contains(selectedTag) })
    }
    var projectsCount: Int by remember { mutableStateOf(tags[selectedTag] ?: 3) }

    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = strings.projects,
            style = TextStyle(
                fontSize = 48.sp,
                fontWeight = FontWeight.ExtraBold,
                color = themeColors.secondColor
            ),
        )
        Text(
            text = strings.myWorks,
            style = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                brush = themeColors.blueToWhiteGradient
            )
        )
        Spacer(Modifier.height(104.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(
                56.dp,
                alignment = Alignment.CenterHorizontally
            )
        ) {
            tags.keys.forEach { tag ->
                SecondaryTextButton(
                    modifier = Modifier.width(140.dp),
                    text = tag,
                    themeColors = themeColors,
                    isSelected = selectedTag == tag,
                    shape = RoundedCornerShape(50.dp),
                    onClick = {
                        selectedTag = tag
                        projectsCount = tags[selectedTag] ?: 3
                    }
                )
            }
        }
        Spacer(Modifier.height(104.dp))
        FlowRow(
            modifier = Modifier.fillMaxWidth(),
            maxItemsInEachRow = tags[selectedTag] ?: 3,
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalArrangement = Arrangement.spacedBy(80.dp, Alignment.CenterVertically)
        ) {
            filteredProjects = projectsList.filter { it.fullTag.contains(selectedTag) }
            filteredProjects.take(projectsCount).forEach { project ->
                Image(
                    painter = rememberImagePainter(project.imageUrl),
                    alignment = Alignment.Center,
                    contentDescription = null,
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier.widthIn(max = project.maxWidth)
                )
            }
        }
        Spacer(modifier = Modifier.height(48.dp))
        SecondaryTextButton(
            text = if (projectsCount <= (tags[selectedTag] ?: 3)) strings.view else strings.hide,
            modifier = Modifier.fillMaxWidth(0.2f),
            themeColors = themeColors,
            isSelected = false,
            shape = RoundedCornerShape(50.dp),
            onClick = {
                projectsCount = if (projectsCount <= (tags[selectedTag] ?: 3)) filteredProjects.size
                else tags[selectedTag] ?: 3
            }
        )
    }
}
