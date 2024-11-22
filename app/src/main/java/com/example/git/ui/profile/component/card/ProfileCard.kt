package com.example.git.ui.profile.component.card

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.git.data.GitHubUser
import com.example.git.domain.GithubUserModel
import com.example.git.ui.profile.component.card.Component.CardAbout
import com.example.git.ui.profile.component.card.Component.CardBio
import com.example.git.ui.profile.component.card.Component.CardHeader
import com.example.git.ui.profile.component.card.Component.CardInfo

@Composable
fun ProfileCard(
    user : GithubUserModel,
    modifier: Modifier = Modifier
) {
    Column (modifier = modifier
        .fillMaxWidth()
        .clip(MaterialTheme.shapes.medium)
        .background(MaterialTheme.colorScheme.primary)
        .padding(10.dp)
    ) {
        CardHeader(
            userAvatarUrl = user.avatarUrl,
            username = user.login,
            createdAt = user.createdAt
        )
        Spacer(Modifier.height(25.dp))
        CardBio(
            bio = user.bio
        )
        Spacer(Modifier.height(25.dp))
        CardInfo(
            followers = user.followers,
            following = user.following,
            repos = user.publicRepos
        )
        Spacer(Modifier.height(25.dp))
        CardAbout(
            location = user.location,
            blog = user.blog,
            company = user.company
        )
        Spacer(Modifier.height(25.dp))

    }
}