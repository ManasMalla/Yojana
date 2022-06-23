package com.manasmalla.yojana.data.onboarding

interface OnBoardingRepositoryInterface {

    /**
     * Get Onboarding screen data.
     */

    fun getOnBoardingData(): List<OnboardingUiState>

}

class OnBoardingRepository : OnBoardingRepositoryInterface {

    override fun getOnBoardingData(): List<OnboardingUiState> {
        return onboardingData
    }

}