package com.manasmalla.yojana.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.material.icons.rounded.CameraAlt
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.manasmalla.yojana.R
import com.manasmalla.yojana.ui.reusable.YojanaThemedButton
import com.manasmalla.yojana.ui.theme.*

@Composable
fun LoginScreen() {

    var name by rememberSaveable() {
        mutableStateOf("")
    }
    var emailAddress by rememberSaveable() {
        mutableStateOf("")
    }
    var password by rememberSaveable() {
        mutableStateOf("")
    }

    Column {
        Image(
            painterResource(id = R.drawable.be_organized),
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.FillWidth,
            contentDescription = "Be Organized. Start now!"
        )
        Column(
            modifier = Modifier
                .padding(horizontal = 32.dp)
                .padding(bottom = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
            ) {
                Text(
                    text = "Login",
                    style = MaterialTheme.typography.displaySmall,
                    color = Orange,
                    modifier = Modifier.padding(top = 28.dp)
                )

                TextField(
                    value = name,
                    onValueChange = {
                        name = it
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(70.dp)
                        .offset(y = 100.dp),
                    shape = RoundedCornerShape(25),
                    placeholder = {
                        Text(
                            text = "Name",
                            style = MaterialTheme.typography.headlineSmall,
                            color = LocalContentColor.current.copy(alpha = 0.6f)
                        )
                    },
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = LightGrey,
                        unfocusedIndicatorColor = Color.Transparent,
                        errorIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent
                    )
                )

                Surface(
                    modifier = Modifier
                        .size(144.dp)
                        .align(Alignment.CenterEnd)
                        .offset(y = -42.dp)
                        .clip(CircleShape)
                        .background(Green20)
                        .padding(48.dp),
                ) {
                    Icon(
                        imageVector = Icons.Rounded.CameraAlt,
                        modifier = Modifier
                            .background(Green20)
                            .size(48.dp),
                        contentDescription = "Add Profile Picture Button",
                        tint = Green40
                    )
                }
            }
            YojanaTextField(
                value = emailAddress,
                onValueChange = {
                    emailAddress = it
                },
                modifier = Modifier
                    .height(86.dp)
                    .padding(vertical = 8.dp),
                placeholder = "Email Address"
            )
            YojanaTextField(
                value = password,
                onValueChange = {
                    password = it
                },
                placeholder = "Password",
                modifier = Modifier
                    .height(86.dp)
                    .padding(vertical = 8.dp)
            )

            YojanaThemedButton(
                modifier = Modifier.padding(vertical = 24.dp),
                text = "Login",
                icon = Icons.Rounded.ArrowForward
            ) {
                //Login the user
            }
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "or, Connect with Social",
                color = IndianBlue,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
            Row(
                horizontalArrangement = Arrangement.spacedBy(32.dp),
                modifier = Modifier
                    .padding(top = 16.dp)
                    .height(52.dp)
            ) {

                SocialButton(provider = "Google", icon = R.drawable.google_logo, theme = Color.White, modifier = Modifier.padding(8.dp))
                SocialButton(provider = "Facebook", icon = R.drawable.facebook_logo, modifier = Modifier.padding(4.dp))
            }
        }

    }
}

@Composable
fun YojanaTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(25),
        placeholder = {
            Column(modifier = Modifier.fillMaxHeight(), verticalArrangement = Arrangement.Center) {

                Text(
                    text = placeholder,
                    style = MaterialTheme.typography.headlineSmall,
                    color = LocalContentColor.current.copy(alpha = 0.6f)
                )

            }
        },
        colors = TextFieldDefaults.textFieldColors(
            containerColor = LightGrey,
            unfocusedIndicatorColor = Color.Transparent,
            errorIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent
        )
    )
}

@Composable
fun RowScope.SocialButton(modifier : Modifier = Modifier,
    provider: String, @DrawableRes icon: Int, theme: Color = Color.Transparent
) {
    Surface(
        color = Blue, shape = RoundedCornerShape(25), modifier = Modifier
            .weight(1f)
            .fillMaxHeight()
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Surface(
                modifier = Modifier
                    .padding(8.dp)
                    .aspectRatio(1f),
                shape = RoundedCornerShape(18),
                color = theme
            ) {
                Image(
                    painterResource(id = icon),
                    contentDescription = "null",
                    contentScale = ContentScale.Fit,
                    modifier = modifier
                )
            }
            Text(
                text = provider,
                style = MaterialTheme.typography.titleLarge,
                color = Color.White,
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .padding(end = 8.dp),
                textAlign = TextAlign.Center
            )
        }

    }
}

@Preview
@Composable
fun LoginScreenPreview() {
    YojanaTheme {
        LoginScreen()
    }
}