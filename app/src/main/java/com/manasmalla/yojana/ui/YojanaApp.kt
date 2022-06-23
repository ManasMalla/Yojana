package com.manasmalla.yojana.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.manasmalla.yojana.YojanaApplication
import com.manasmalla.yojana.ui.theme.YojanaTheme

@Composable
fun YojanaApp(yojanaApplication: YojanaApplication) {

    YojanaTheme { darkIcons ->

        var systemUIController = rememberSystemUiController()
        val navController = rememberNavController()

        SideEffect {
            systemUIController.setSystemBarsColor(Color.Transparent, darkIcons = !darkIcons)
        }

        YojanaNavGraph(
            navController,
            userPreferencesRepository = yojanaApplication.appContainer.userPreferencesRepository,
            onBoardingRepository = yojanaApplication.appContainer.onBoardingRepository
        )

    }

}