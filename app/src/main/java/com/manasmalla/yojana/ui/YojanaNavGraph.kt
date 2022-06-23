package com.manasmalla.yojana.ui

import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.manasmalla.yojana.data.UserPreferencesRepository
import com.manasmalla.yojana.data.onboarding.OnBoardingRepository
import com.manasmalla.yojana.ui.onboarding.OnBoardingScreen
import com.manasmalla.yojana.ui.onboarding.OnBoardingViewModel
import kotlinx.coroutines.delay

/**
 * Destinations used in the [JetnewsApp].
 */
object YojanaDestinations {
    const val SPLASH_ROUTE = "splash"
    const val ONBOARDING_ROUTE = "onboarding"
    const val LOGIN_ROUTE = "login"
    const val HOME_ROUTE = "home"
}

@Composable
fun YojanaNavGraph(
    navController: NavHostController,
    userPreferencesRepository: UserPreferencesRepository,
    onBoardingRepository: OnBoardingRepository
) {

    val onBoardingViewModel : OnBoardingViewModel = viewModel(factory = OnBoardingViewModel.provideFactory(onBoardingRepository))

    NavHost(navController = navController, startDestination = YojanaDestinations.SPLASH_ROUTE){
        composable(YojanaDestinations.SPLASH_ROUTE){
            val shouldShowOnBoardingScreen by userPreferencesRepository.isOnboardingScreenShown.collectAsState(
                initial = false
            )
            LaunchedEffect(key1 = true){
                delay(2000)
                onBoardingViewModel.updateUiState()
                navController.navigate(YojanaDestinations.ONBOARDING_ROUTE)
                //navController.navigate(if(shouldShowOnBoardingScreen) YojanaDestinations.ONBOARDING_ROUTE else YojanaDestinations.HOME_ROUTE)
            }
            SplashScreen()
        }
        composable(YojanaDestinations.ONBOARDING_ROUTE){
            val uiState by onBoardingViewModel.uiState.collectAsState()
            OnBoardingScreen(onboardingUiState = uiState, length = onBoardingViewModel.onboardingData.size, onNextButton = {
                onBoardingViewModel.updateOnBoardingProgressIndex()
                onBoardingViewModel.moveToIndexedOnBoardingScreen(index = onBoardingViewModel.onboardingProgressIndex.value){
                    navController.navigate(YojanaDestinations.LOGIN_ROUTE)
                }
            }, onSkip = {
                navController.navigate(YojanaDestinations.LOGIN_ROUTE)
            })
        }
        composable(YojanaDestinations.LOGIN_ROUTE){
            LoginScreen()
        }
    }

}