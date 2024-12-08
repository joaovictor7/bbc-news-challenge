package com.bbcnewschallenge.core.security.utils

import android.content.Context
import androidx.biometric.BiometricPrompt
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import com.bbcnewschallenge.core.security.R

fun showBiometricPrompt(
    context: Context,
    onSuccess: () -> Unit,
    onError: (String) -> Unit
) {
    val fragmentActivity = context as? FragmentActivity ?: return
    val biometricPrompt = BiometricPrompt(
        fragmentActivity,
        ContextCompat.getMainExecutor(fragmentActivity),
        object : BiometricPrompt.AuthenticationCallback() {
            override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                super.onAuthenticationSucceeded(result)
                onSuccess()
            }

            override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
                super.onAuthenticationError(errorCode, errString)
                onError(errString.toString())
            }

            override fun onAuthenticationFailed() {
                super.onAuthenticationFailed()
                onError("Authentication failed")
            }
        }
    )
    val promptInfo = BiometricPrompt.PromptInfo.Builder()
        .setTitle(context.getString(R.string.biometric_prompt_title))
        .setSubtitle(context.getString(R.string.biometric_prompt_subtitle))
        .setNegativeButtonText(context.getString(R.string.biometric_prompt_cancel))
        .build()

    biometricPrompt.authenticate(promptInfo)
}