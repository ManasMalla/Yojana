package com.manasmalla.yojana.data.onboarding

import androidx.annotation.DrawableRes

data class OnboardingUiState(val index: Int, val title: String, val description: String, @DrawableRes val image: Int)
