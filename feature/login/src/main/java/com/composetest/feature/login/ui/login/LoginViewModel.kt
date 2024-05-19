package com.composetest.feature.login.ui.login

import com.composetest.core.utility.providers.BuildConfigProvider
import com.composetest.core.ui.domain.bases.BaseViewModel
import com.composetest.core.ui.domain.enums.AppTheme
import com.composetest.core.ui.providers.AppThemeProvider
import com.composetest.feature.login.domain.models.LoginModel
import com.composetest.feature.login.domain.usecases.LoginUseCase
import com.composetest.core.router.navigation.home.HomeDestination
import com.composetest.core.router.navigation.home.navtypes.InnerHome
import com.composetest.core.router.providers.NavigationProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
internal class LoginViewModel @Inject constructor(
    private val appThemeProvider: AppThemeProvider,
    private val navigationProvider: NavigationProvider,
    private val buildConfigProvider: BuildConfigProvider,
    private val loginUseCase: LoginUseCase
) : BaseViewModel<LoginEvent, LoginState>(LoginState()) {

    private var loginModel: LoginModel = LoginModel()
    private val currentAppTheme get() = appThemeProvider.currentAppTheme

    init {
        initState()
    }

    override fun handleEvent(event: LoginEvent) = when (event) {
        is LoginEvent.SetCustomTheme -> setCustomTheme(event)
        is LoginEvent.CheckShowInvalidEmailMsg -> showInvalidEmailMsg()
        is LoginEvent.Login -> login()
        is LoginEvent.WriteData -> writeData(event)
    }

    private fun showInvalidEmailMsg() {
        if (loginModel.emailIsEmpty) {
            updateState { it.setInvalidEmail(!loginModel.emailIsValid) }
        }
    }

    private fun login() {
        lazyFlowTask(
            flowTask = loginUseCase.login(loginModel),
            onSuccessTask = ::processLoginResponse,
            onErrorTask = ::errorLogin
        )
    }

    private fun writeData(action: LoginEvent.WriteData) {
        when {
            action.email != null -> {
                loginModel = loginModel.copy(email = action.email)
                if (stateValue.invalidEmail) {
                    updateState { it.setInvalidEmail(false) }
                }
            }
            action.password != null -> {
                loginModel = loginModel.copy(password = action.password)
            }
        }
        loginButtonManager()
    }

    private fun loginButtonManager() {
        updateState { it.setEnableLoginButton(loginModel.loginAlready || buildConfigProvider.get.isDebug) }
    }

    private fun initState() {
        updateState {
            it.initState(
                versionName = buildConfigProvider.get.versionNameForView,
                enableLoginButton = buildConfigProvider.get.isDebug
            )
        }
    }

    private fun setCustomTheme(event: LoginEvent.SetCustomTheme) {
        appThemeProvider.setCustomTheme(
            if (event.enterScreen && currentAppTheme.theme != AppTheme.DARK) {
                AppTheme.DARK
            } else {
                null
            }
        )
        updateState { it.setAppTheme(currentAppTheme) }
    }

    private fun processLoginResponse(success: Boolean) {
        if (success) {
            navigationProvider.navigate(HomeDestination("teste", InnerHome("te", "23232")))
        }
    }

    private fun errorLogin(error: Throwable) {
        updateState { it.setError() }
    }
}