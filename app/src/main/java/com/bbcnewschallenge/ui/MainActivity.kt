package com.bbcnewschallenge.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.bbcnewschallenge.core.designsystem.components.alertdialogs.DefaultAlertDialog
import com.bbcnewschallenge.core.designsystem.theme.ComposeTestTheme
import com.bbcnewschallenge.core.router.destinations.home.HomeDestination
import com.bbcnewschallenge.core.ui.interfaces.Command
import com.bbcnewschallenge.feature.home.navigation.homeNavGraph
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import kotlin.reflect.KClass

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSplashScreen()
        setEdgeToEdge()
        setContent {
            val uiState by viewModel.uiState.collectAsStateWithLifecycle()
            ComposeTestTheme(
                dynamicColor = uiState.appTheme.dynamicColors,
                theme = uiState.appTheme.theme
            ) {
                uiState.defaultAlertDialogParam?.let {
                    DefaultAlertDialog(param = it)
                }
                Navigation(
                    firstScreenDestination = HomeDestination::class,
                    onExecuteCommand = viewModel::executeCommand
                )
            }
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.executeCommand(MainCommand.FetchRemoteConfig)
    }

    private fun setEdgeToEdge() = lifecycleScope.launch {
        viewModel.uiState.flowWithLifecycle(lifecycle).collect { uiState ->
            enableEdgeToEdge(uiState.statusBarStyle, uiState.navigationBarStyle)
        }
    }

    private fun setSplashScreen() {
        installSplashScreen().setKeepOnScreenCondition {
            viewModel.uiState.value.showSplashScreen
        }
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