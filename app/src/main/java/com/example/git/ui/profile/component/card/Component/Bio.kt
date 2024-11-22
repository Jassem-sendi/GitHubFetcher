package com.example.git.ui.profile.component.card.Component


import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

@Composable
fun CardBio(
    bio: String? = null ,
    modifier: Modifier = Modifier
) {

    Text(
        text = bio ?: "No bio available",
        style = MaterialTheme.typography.titleMedium,
        maxLines = 2,
        color = MaterialTheme.colorScheme.onBackground,
        overflow = TextOverflow.Ellipsis,
        textAlign = TextAlign.Center,
        modifier = modifier
            .fillMaxWidth()
            .padding(20.dp)
    )
}