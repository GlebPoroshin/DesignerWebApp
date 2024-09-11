package com.gleb.designer.web.app.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gleb.designer.web.app.components.ProjectCard
import com.gleb.designer.web.app.components.ProjectModel
import com.gleb.designer.web.app.components.SecondaryTextButton
import com.gleb.designer.web.app.theme.ThemeColors
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ProjectsPage(
    themeColors: ThemeColors,
    modifier: Modifier = Modifier
) {
    val tags = listOf(
        "Adobe",
        "Figma",
        "3D",
    )

    var selectedTag: String by remember { mutableStateOf("Adobe") }
    var filteredProjects: List<ProjectModel> by remember {
        mutableStateOf(projectsList.filter { it.fullTag.contains(selectedTag) })
    }
    var projectsCount: Int by remember { mutableStateOf(3) }

    Column {
        Column(
            modifier = modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Projects",
                style = TextStyle(
                    fontSize = 48.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = themeColors.secondColor
                ),
            )
            Text(
                text = "Some of my Work",
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
                tags.forEach { tag ->
                    SecondaryTextButton(
                        modifier = Modifier.width(140.dp),
                        text = tag,
                        themeColors = themeColors,
                        isSelected = selectedTag == tag,
                        shape = RoundedCornerShape(50.dp),
                        onClick = {
                            selectedTag = tag
                            projectsCount = 3
                        }
                    )
                }
            }
            Spacer(Modifier.height(104.dp))
            FlowRow(
                modifier = Modifier.fillMaxWidth(),
                maxItemsInEachRow = 3,
                horizontalArrangement = Arrangement.spacedBy(40.dp, Alignment.CenterHorizontally),
                verticalArrangement = Arrangement.spacedBy(80.dp, Alignment.CenterVertically)
            ) {
                filteredProjects = projectsList.filter { it.fullTag.contains(selectedTag) }
                filteredProjects.take(projectsCount).forEach { project ->
                    Image(
                        painter = painterResource(project.image),
                        contentDescription = null,
                        contentScale = ContentScale.FillWidth,
                        modifier = Modifier.widthIn(max = 326.dp).weight(1f)
                    )
                }
            }
            Spacer(modifier = Modifier.height(108.dp))

            SecondaryTextButton(
                text = if (projectsCount <= 3) "View All" else "Hide all",
                modifier = Modifier.fillMaxWidth(0.2f),
                themeColors = themeColors,
                isSelected = false,
                shape = RoundedCornerShape(50.dp),
                onClick = {
                    projectsCount = if (projectsCount <= 3) filteredProjects.size
                    else 3
                }
            )
        }
    }
}
