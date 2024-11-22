package com.example.git.ui.profile.component.card.Component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage

@Composable
fun CardHeader(
    userAvatarUrl: String = "",
    username: String = "",
    createdAt: String = "",
    modifier: Modifier = Modifier,
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(20.dp),
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .padding(20.dp)
    ) {

        AsyncImage(
            model = userAvatarUrl,
            contentDescription = "Git Logo",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(100.dp)
                .clip(MaterialTheme.shapes.extraLarge)
        )

        Column(
            verticalArrangement = Arrangement.Center
        ) {

            HeaderText(
                text = username,
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onBackground,
            )

            HeaderText(
                text = "@$username",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onPrimary,
            )

            HeaderText(
                text = "Created at: $createdAt"
                , style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.onBackground,
            )
        }
    }
}

@Composable
fun HeaderText(
    text: String ,
    style: TextStyle ,
    color: Color ,
    modifier: Modifier = Modifier ,
) {
    Text(
        text = text,
        style = style,
        maxLines = 1,
        color = color,
        modifier = modifier
            .padding(bottom = 5.dp)
    )
}