package com.manasmalla.yojana.ui.reusable

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.manasmalla.yojana.ui.theme.Orange


@Composable
fun YojanaThemedButton(modifier: Modifier = Modifier, text: String, icon: ImageVector, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Orange),
        contentPadding =
        PaddingValues(horizontal = 36.dp, vertical = 16.dp),
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.titleLarge,
            color = Color.White
        )
        Spacer(modifier = Modifier.weight(1f))
        Icon(imageVector = icon, contentDescription = null)
    }
}