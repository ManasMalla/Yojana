package com.manasmalla.yojana.ui.reusable

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.manasmalla.yojana.R
import com.manasmalla.yojana.ui.theme.YojanaTheme


@Composable
fun YojanaAppLogo(modifier:Modifier = Modifier){
    Image(painterResource(id = R.drawable.yojana_logo), contentDescription = "Yojana • Plan your future", modifier = modifier)
}

@Preview
@Composable
fun YojanaAppLogoPreview(){
    YojanaTheme {
        YojanaAppLogo()
    }
}
