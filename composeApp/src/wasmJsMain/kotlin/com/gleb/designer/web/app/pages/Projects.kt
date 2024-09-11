package com.gleb.designer.web.app.pages

import androidx.compose.ui.unit.dp
import com.gleb.designer.web.app.components.ProjectModel
import com.seiko.imageloader.rememberImagePainter
import designerwebsite.composeapp.generated.resources.Res
import designerwebsite.composeapp.generated.resources._3d_1
import designerwebsite.composeapp.generated.resources._3d_2
import designerwebsite.composeapp.generated.resources._3d_3
import designerwebsite.composeapp.generated.resources._3d_4
import designerwebsite.composeapp.generated.resources._3d_5
import designerwebsite.composeapp.generated.resources._3d_6
import designerwebsite.composeapp.generated.resources.adobe_1
import designerwebsite.composeapp.generated.resources.adobe_10
import designerwebsite.composeapp.generated.resources.adobe_11
import designerwebsite.composeapp.generated.resources.adobe_12
import designerwebsite.composeapp.generated.resources.adobe_13
import designerwebsite.composeapp.generated.resources.adobe_14
import designerwebsite.composeapp.generated.resources.adobe_15
import designerwebsite.composeapp.generated.resources.adobe_16
import designerwebsite.composeapp.generated.resources.adobe_17
import designerwebsite.composeapp.generated.resources.adobe_18
import designerwebsite.composeapp.generated.resources.adobe_2
import designerwebsite.composeapp.generated.resources.adobe_3
import designerwebsite.composeapp.generated.resources.adobe_4
import designerwebsite.composeapp.generated.resources.adobe_5
import designerwebsite.composeapp.generated.resources.adobe_6
import designerwebsite.composeapp.generated.resources.adobe_7
import designerwebsite.composeapp.generated.resources.adobe_8
import designerwebsite.composeapp.generated.resources.adobe_9

val projectsList = listOf(
    ProjectModel(
        imageUrl = "https://raw.githubusercontent.com/GlebPoroshin/DesignerWebApp/main/composeApp/src/commonMain/composeResources/drawable/adobe_1.png",
        fullTag = "Adobe"
    ),
    ProjectModel(
        imageUrl = "https://raw.githubusercontent.com/GlebPoroshin/DesignerWebApp/main/composeApp/src/commonMain/composeResources/drawable/adobe_2.png",        fullTag = "Adobe"
    ),
    ProjectModel(
        imageUrl = "https://raw.githubusercontent.com/GlebPoroshin/DesignerWebApp/main/composeApp/src/commonMain/composeResources/drawable/adobe_3.png",        fullTag = "Adobe"
    ),
    ProjectModel(
        imageUrl = "https://raw.githubusercontent.com/GlebPoroshin/DesignerWebApp/main/composeApp/src/commonMain/composeResources/drawable/adobe_4.png",        fullTag = "Adobe"
    ),
    ProjectModel(
        imageUrl = "https://raw.githubusercontent.com/GlebPoroshin/DesignerWebApp/main/composeApp/src/commonMain/composeResources/drawable/adobe_5.png",        fullTag = "Adobe"
    ),
    ProjectModel(
        imageUrl = "https://raw.githubusercontent.com/GlebPoroshin/DesignerWebApp/main/composeApp/src/commonMain/composeResources/drawable/adobe_6.png",        fullTag = "Adobe"
    ),
    ProjectModel(
        imageUrl = "https://raw.githubusercontent.com/GlebPoroshin/DesignerWebApp/main/composeApp/src/commonMain/composeResources/drawable/adobe_7.png",        fullTag = "Adobe"
    ),
    ProjectModel(
        imageUrl = "https://raw.githubusercontent.com/GlebPoroshin/DesignerWebApp/main/composeApp/src/commonMain/composeResources/drawable/adobe_8.png",        fullTag = "Adobe"
    ),
    ProjectModel(
        imageUrl = "https://raw.githubusercontent.com/GlebPoroshin/DesignerWebApp/main/composeApp/src/commonMain/composeResources/drawable/adobe_9.png",        fullTag = "Adobe"
    ),
    ProjectModel(
        imageUrl = "https://raw.githubusercontent.com/GlebPoroshin/DesignerWebApp/main/composeApp/src/commonMain/composeResources/drawable/adobe_10.png",        fullTag = "Adobe"
    ),
    ProjectModel(
        imageUrl = "https://raw.githubusercontent.com/GlebPoroshin/DesignerWebApp/main/composeApp/src/commonMain/composeResources/drawable/adobe_11.png",        fullTag = "Adobe"
    ),
    ProjectModel(
        imageUrl = "https://raw.githubusercontent.com/GlebPoroshin/DesignerWebApp/main/composeApp/src/commonMain/composeResources/drawable/adobe_12.png",        fullTag = "Adobe"
    ),
    ProjectModel(
        imageUrl = "https://raw.githubusercontent.com/GlebPoroshin/DesignerWebApp/main/composeApp/src/commonMain/composeResources/drawable/adobe_13.png",        fullTag = "Adobe"
    ),
    ProjectModel(
        imageUrl = "https://raw.githubusercontent.com/GlebPoroshin/DesignerWebApp/main/composeApp/src/commonMain/composeResources/drawable/adobe_14.png",        fullTag = "Adobe"
    ),
    ProjectModel(
        imageUrl = "https://raw.githubusercontent.com/GlebPoroshin/DesignerWebApp/main/composeApp/src/commonMain/composeResources/drawable/adobe_15.png",        fullTag = "Adobe"
    ),
    ProjectModel(
        imageUrl = "https://raw.githubusercontent.com/GlebPoroshin/DesignerWebApp/main/composeApp/src/commonMain/composeResources/drawable/adobe_16.png",        fullTag = "Adobe"
    ),
    ProjectModel(
        imageUrl = "https://raw.githubusercontent.com/GlebPoroshin/DesignerWebApp/main/composeApp/src/commonMain/composeResources/drawable/adobe_17.png",        fullTag = "Adobe"
    ),
    ProjectModel(
        imageUrl = "https://raw.githubusercontent.com/GlebPoroshin/DesignerWebApp/main/composeApp/src/commonMain/composeResources/drawable/adobe_18.png",        fullTag = "Adobe"
    ),


    ProjectModel(
        maxWidth = 465.dp,
        imageUrl = "https://raw.githubusercontent.com/GlebPoroshin/DesignerWebApp/main/composeApp/src/commonMain/composeResources/drawable/3d_1.png",
        fullTag = "3D #1"
    ),
    ProjectModel(
        maxWidth = 465.dp,
        imageUrl = "https://raw.githubusercontent.com/GlebPoroshin/DesignerWebApp/main/composeApp/src/commonMain/composeResources/drawable/3d_2.png",
        fullTag = "3D #2"
    ),
    ProjectModel(
        maxWidth = 465.dp,
        imageUrl = "https://raw.githubusercontent.com/GlebPoroshin/DesignerWebApp/main/composeApp/src/commonMain/composeResources/drawable/3d_3.png",
        fullTag = "3D #3"
    ),
    ProjectModel(
        maxWidth = 465.dp,
        imageUrl = "https://raw.githubusercontent.com/GlebPoroshin/DesignerWebApp/main/composeApp/src/commonMain/composeResources/drawable/3d_4.png",
        fullTag = "3D #4"
    ),
    ProjectModel(
        maxWidth = 1028.dp,
        imageUrl = "https://raw.githubusercontent.com/GlebPoroshin/DesignerWebApp/main/composeApp/src/commonMain/composeResources/drawable/3d_5.png",
        fullTag = "3D #5"
    ),
    ProjectModel(
        maxWidth = 1028.dp,
        imageUrl = "https://raw.githubusercontent.com/GlebPoroshin/DesignerWebApp/main/composeApp/src/commonMain/composeResources/drawable/3d_6.png",
        fullTag = "3D #6"
    ),
)
