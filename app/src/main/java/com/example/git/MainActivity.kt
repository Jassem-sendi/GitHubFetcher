package com.example.git

import android.annotation.SuppressLint
import android.content.res.Resources.Theme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.git.di.AppModule
import com.example.git.ui.profile.ProfileScreen
import com.example.git.ui.profile.ProfileViewModel
import org.koin.androidx.compose.koinViewModel
import org.koin.core.context.startKoin
import org.koin.ksp.generated.module


class MainActivity : ComponentActivity() {
    @SuppressLint("RememberReturnType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startKoin {
            modules(AppModule().module)
        }
        enableEdgeToEdge()
        setContent {
            val profileViewModel: ProfileViewModel = koinViewModel()
            val state by profileViewModel.uiState.collectAsState()
            ProfileScreen(
                uiState = state
            )
        }
    }
}


