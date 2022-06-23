package com.manasmalla.yojana.ui.onboarding

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.manasmalla.yojana.data.onboarding.*
import com.manasmalla.yojana.ui.reusable.YojanaThemedButton
import com.manasmalla.yojana.ui.theme.*

@Composable
fun OnBoardingScreen(
    onboardingUiState: OnboardingUiState,
    length: Int = 4,
    onNextButton: () -> Unit = {},
    onSkip: () -> Unit = {}
) {

    val isLastScreen by remember(onboardingUiState.index) {
        derivedStateOf {
            onboardingUiState.index == length - 1
        }
    }

    Crossfade(onboardingUiState) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(modifier = Modifier.padding(top = 8.dp)) {
                Spacer(modifier = Modifier.weight(1f))
                SkipButton(onSkip = onSkip)
            }
            Spacer(modifier = Modifier.weight(1f))
            Box(
                modifier = Modifier
                    .fillMaxHeight(0.45f)
                    .defaultMinSize(minHeight = 500.dp)
                    .padding(bottom = 24.dp), contentAlignment = Alignment.Center
            ) {
                Image(
                    painterResource(id = it.image),
                    contentDescription = null,
                    contentScale = ContentScale.FillWidth
                )
            }
            Text(
                text = it.title,
                style = MaterialTheme.typography.displayMedium,
                color = Orange, modifier = Modifier.padding(bottom = 16.dp)
            )
            Text(
                text = it.description,
                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Normal),
                textAlign = TextAlign.Justify
            )
            Spacer(modifier = Modifier.height(48.dp))
            Spacer(modifier = Modifier.weight(1f))
            OnBoardingProgressIndicator(index = it.index, length = length)
            Spacer(modifier = Modifier.height(48.dp))
            YojanaThemedButton(
                text = if (isLastScreen) "Get Started" else "Next",
                icon = Icons.Rounded.ArrowForward,
                onClick = onNextButton)
        }
    }
}


@Composable
fun OnBoardingProgressIndicator(
    modifier: Modifier = Modifier.size(16.dp),
    index: Int,
    length: Int
) {
    LazyRow(
        modifier = Modifier.fillMaxWidth(0.5f),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        items((0 until length).toList()) { drawingIndex ->
            Surface(
                modifier = modifier,
                shape = CircleShape,
                color = if (index < drawingIndex) Green40.copy(alpha = 0.5f) else Green70,
                content = {})
        }
    }
}

@Composable
fun SkipButton(onSkip: () -> Unit) {
    TextButton(onClick = onSkip) {
        Text(text = "Skip", style = MaterialTheme.typography.titleLarge, color = DeepBlue)
    }
}


@Preview(showBackground = true)
@Composable
fun OnBoardingScreen1Preview() {
    YojanaTheme {
        OnBoardingScreen(onboardingScreen1)
    }
}

@Preview(showBackground = true)
@Composable
fun OnBoardingScreen2Preview() {
    YojanaTheme {
        OnBoardingScreen(onboardingScreen2)
    }
}

@Preview(showBackground = true)
@Composable
fun OnBoardingScreen3Preview() {
    YojanaTheme {
        OnBoardingScreen(onboardingScreen3)
    }
}

@Preview(showBackground = true)
@Composable
fun OnBoardingScreen4Preview() {
    YojanaTheme {
        OnBoardingScreen(onboardingScreen4)
    }
}