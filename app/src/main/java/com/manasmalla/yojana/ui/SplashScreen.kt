package com.manasmalla.yojana.ui

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import com.manasmalla.yojana.R
import com.manasmalla.yojana.ui.reusable.YojanaAppLogo
import com.manasmalla.yojana.ui.theme.YojanaTheme

@Composable
fun CreditsCard() {
    Layout(modifier = Modifier.fillMaxWidth(), content = {
        Image(
            painterResource(R.drawable.credits_image),
            contentDescription = null,contentScale = ContentScale.FillHeight
        )
        Image(
            painterResource(id = R.drawable.credits_text), contentDescription = null,
            contentScale = ContentScale.FillWidth
        )
    }) { measurables, constraints ->

        Log.d("MAX_WIDTH", constraints.maxWidth.toString())
        val textMeasurable = measurables.last()
        val imageMeasurable = measurables.first()
        val textPlaceable = textMeasurable.measure(constraints.copy(maxWidth = (constraints.maxWidth * 0.66).toInt(), minWidth = 0))
        val imagePlaceable = imageMeasurable.measure(Constraints(maxHeight = textPlaceable.height))
        layout(constraints.maxWidth, textPlaceable.height){
            var margin = (constraints.maxWidth - (textPlaceable.width + imagePlaceable.width + 16))/2
            imagePlaceable.placeRelative(margin, 0)
            textPlaceable.placeRelative(36 + imagePlaceable.width + margin,0)
        }
    }
}

@Composable
fun SplashScreen(){
    Column(modifier = Modifier.padding(24.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.weight(1f))
        YojanaAppLogo(modifier = Modifier.fillMaxWidth(0.8f))
        Spacer(modifier = Modifier.weight(1f))
        CreditsCard()
    }
}

@Preview
@Composable
fun CreditsCardPreview(){
    YojanaTheme {
        CreditsCard()
    }
}

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    YojanaTheme {
        SplashScreen()
    }
}