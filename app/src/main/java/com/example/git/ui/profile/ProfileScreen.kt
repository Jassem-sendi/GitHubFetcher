package com.example.git.ui.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.git.ui.profile.component.Header
import com.example.git.ui.profile.component.Search
import com.example.git.ui.profile.component.card.ProfileCard
import com.example.git.ui.theme.GitTheme
import org.koin.androidx.compose.koinViewModel

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
    profileViewModel: ProfileViewModel = koinViewModel(),
    uiState: ProfileUiState,
) {
    GitTheme(darkTheme = uiState.isDarkTheme) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .safeDrawingPadding()
                .padding(20.dp)
        ) {
            Column(
                modifier = modifier
                    .verticalScroll(rememberScrollState())
            ) {
                Header(
                    isDarkTheme = uiState.isDarkTheme ,
                    onToggleTheme = { profileViewModel.toggleTheme() }
                )
                Spacer(modifier = Modifier.height(20.dp))
                Search(
                    username = uiState.username ,
                    onUsernameChange = { profileViewModel.setUsername(it) } ,
                    fetchUser = { profileViewModel.fetchUser(uiState.username)},

                )
                Spacer(modifier = Modifier.height(20.dp))
                if (uiState.loading) {
                   Box (
                          modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                   ) {
                       CircularProgressIndicator()
                   }
                }
                if (uiState.errorMessage != null) {
                    Text(
                        text = uiState.errorMessage,
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.error,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxSize()
                    )
                }
                if (uiState.user != null) {
                    ProfileCard( user = uiState.user)
                }
            }
        }

    }
}