package com.manasmalla.yojana.ui.onboarding

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.manasmalla.yojana.R
import com.manasmalla.yojana.data.onboarding.OnBoardingRepository
import com.manasmalla.yojana.data.onboarding.OnboardingUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class OnBoardingViewModel(private val onBoardingRepository: OnBoardingRepository) : ViewModel() {

    val onboardingData: List<OnboardingUiState> = onBoardingRepository.getOnBoardingData()

    fun moveToIndexedOnBoardingScreen(index: Int, onFinished: () -> Unit) {

        if (index < onboardingData.size && index > -1) {
            //We're in bounds
            _uiState.update {
                onboardingData.get(index)
            }
        } else {
            //We're out of bounds
            if (index >= onboardingData.size) {
                //We've reached the end
                Log.d("Progress", "Onboarding finished")
                onFinished()
            } else {
                //User trying to navigate back out of bounds
            }
        }

    }

    fun updateUiState(){
        val initUiState = onboardingData.first()
        _uiState.update {
            initUiState
        }
    }

    fun updateOnBoardingProgressIndex(){
        _onboardingProgressIndex.update {
            it + 1
        }
    }

    /**
     *  UI state exposed to the UI
     */

    private val _uiState = MutableStateFlow(
        OnboardingUiState(
            index = 0,
            "Loading",
            "Please wait as we fetch in the data!",
            R.drawable.yojana_logo
        )
    )
    val uiState: StateFlow<OnboardingUiState> = _uiState.asStateFlow()

    val _onboardingProgressIndex = MutableStateFlow(0)
    val onboardingProgressIndex = _onboardingProgressIndex.asStateFlow()

    companion object {
        fun provideFactory(
            interestsRepository: OnBoardingRepository,
        ): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return OnBoardingViewModel(interestsRepository) as T
            }
        }
    }

}