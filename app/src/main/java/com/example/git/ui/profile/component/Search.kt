package com.example.git.ui.profile.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Search(
    username: String = "" ,
    onUsernameChange: (String) -> Unit = {} ,
    fetchUser: (String) -> Unit = {} ,

    modifier: Modifier = Modifier
) {

    TextField(
        value = username ,
        onValueChange = { onUsernameChange(it) } ,
        placeholder = { Text(text = "Search .. ") } ,
        shape = CircleShape ,
        leadingIcon = {
            Icon(
                imageVector = Icons.Filled.Search ,
                contentDescription = "Search Icon" ,
                tint = Color.Black ,
                modifier = Modifier.padding(16.dp)
            )
        } ,
        trailingIcon = {
            Button(onClick = {
                fetchUser(username)
            } , modifier = Modifier.padding(end = 16.dp)) {
                Text(text = "Search")
            }
        } ,
        textStyle = TextStyle(
            color = Color.Black ,
            fontSize = 15.sp ,
            fontFamily = FontFamily.SansSerif
        ) ,
        maxLines = 1 ,
        modifier = modifier
            .padding(all = 16.dp)
            .fillMaxWidth()
    )
}
