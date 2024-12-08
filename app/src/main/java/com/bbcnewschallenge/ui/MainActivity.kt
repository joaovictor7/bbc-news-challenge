package com.bbcnewschallenge.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.ComposeView
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.bbcnewschallenge.core.designsystem.theme.BbcNewsChallengeTheme
import com.bbcnewschallenge.core.router.destinations.home.HomeDestination
import com.bbcnewschallenge.core.ui.interfaces.Command
import com.bbcnewschallenge.feature.home.navigation.homeNavGraph
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import kotlin.reflect.KClass

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSplashScreen()
        uiStateObserver()
        setContentView(
            ComposeView(this).apply {
                setContent {
                    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
                    BbcNewsChallengeTheme(
                        dynamicColor = uiState.appTheme.dynamicColors,
                        theme = uiState.appTheme.theme
                    ) {
                        Navigation(
                            firstScreenDestination = HomeDestination::class,
                            onExecuteCommand = viewModel::executeCommand
                        )
                    }
                }
            }
        )
    }

    override fun onResume() {
        super.onResume()
        viewModel.executeCommand(MainCommand.FetchRemoteConfig)
    }

    private fun uiStateObserver() = lifecycleScope.launch {
        viewModel.uiState.flowWithLifecycle(lifecycle).collect { uiState ->
            setEdgeToEdge(uiState)
        }
    }

    private fun setSplashScreen() {
        installSplashScreen().setKeepOnScreenCondition {
            viewModel.uiState.value.showSplashScreen
        }
    }

    private fun setEdgeToEdge(uiState: MainUiState) {
        enableEdgeToEdge(uiState.statusBarStyle, uiState.navigationBarStyle)
    }
}

@Composable
private fun Navigation(
    firstScreenDestination: KClass<*>,
    onExecuteCommand: (Command<MainCommandReceiver>) -> Unit
) {
    val navController = rememberNavController()
    onExecuteCommand(MainCommand.SetNavigationGraph(navController))
    NavHost(
        navController = navController,
        startDestination = firstScreenDestination
    ) {
        homeNavGraph()
    }
}