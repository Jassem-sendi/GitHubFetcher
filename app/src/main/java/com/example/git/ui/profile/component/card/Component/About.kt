package com.example.git.ui.profile.component.card.Component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun CardAbout(
    location: String? = null,
    blog: String? = null,
    company: String? = null,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(15.dp),
        modifier = modifier
    ) {
        AboutRow(text = location ?: "No location available", icon = Icons.Default.LocationOn)
        AboutRow(text = blog ?: "No blog available", icon = Icons.Default.LocationOn)
        AboutRow(text = company ?: "No company available", icon = Icons.Default.LocationOn)
    }
}

@Composable
fun AboutRow(text: String, icon: ImageVector, modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = androidx.compose.ui.Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        modifier = modifier.padding(start = 20.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = "$text Icon",
            tint = MaterialTheme.colorScheme.onPrimary
        )
        Text(
            text = text,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onPrimary
        )
    }
}