package com.example.git.ui.profile.component


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage



@Composable
fun Header(
    isDarkTheme: Boolean = false ,
    onToggleTheme: () -> Unit = {} ,
    modifier: Modifier = Modifier
) {

    Row(
        horizontalArrangement = Arrangement.SpaceBetween ,
        verticalAlignment = Alignment.CenterVertically ,
        modifier = modifier.fillMaxWidth()
    )
    {
        AsyncImage(
            model = "https://cdn-icons-png.flaticon.com/512/25/25231.png" ,
            contentDescription = "Git Logo" ,
            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onBackground),
            modifier = Modifier.size(60.dp)
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp) ,
            verticalAlignment = Alignment.CenterVertically ,
        ) {
            Text(
                text = if (isDarkTheme) "Light Mode" else "Dark Mode" ,
                style = MaterialTheme.typography.bodyLarge ,
                color = MaterialTheme.colorScheme.onBackground
            )
            AsyncImage(
                model = if (isDarkTheme) "https://cdn-icons-png.flaticon.com/512/1164/1164954.png" else "https://cdn-icons-png.flaticon.com/512/1164/1164953.png" ,
                contentDescription = "Dark Mode Icon" ,
                modifier = Modifier
                    .size(24.dp)
                    .clickable {
                        onToggleTheme()
                    }
            )

        }

    }
}

@Preview
@Composable
fun HeaderPreview() {
    Box(
        Modifier
            .fillMaxSize()
            .background(Color.White)) {
        Header()
    }
}