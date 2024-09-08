package com.gleb.designer.web.app.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gleb.designer.web.app.components.ProjectCard
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

    Column {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .background(Color.Transparent),
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
                        onClick = { selectedTag = tag }
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
                projectsList.filter { it.fullTag.contains(selectedTag) }.forEach { project ->
                    ProjectCard(
                        modifier = Modifier.fillMaxWidth(0.3f),
                        image = painterResource(project.image),
                        title = project.title,
                        description = project.description,
                        themeColors = themeColors,
                        onClick = {}
                    )
                }
            }
            Spacer(modifier = Modifier.height(108.dp))
            if (selectedTag.isNotEmpty()) {
                SecondaryTextButton(
                    text = "View All",
                    modifier = Modifier.fillMaxWidth(0.2f),
                    themeColors = themeColors,
                    isSelected = false,
                    shape = RoundedCornerShape(50.dp),
                    onClick = { selectedTag = "" }
                )
            }
        }
    }
}
