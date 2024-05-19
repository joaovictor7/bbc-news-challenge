package com.composetest.core.designsystem.components.textfields

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.composetest.core.designsystem.components.textfields.utils.createIcon
import com.composetest.core.designsystem.components.textfields.utils.textFieldHelpedText
import com.composetest.core.designsystem.components.textfields.utils.trailingIcon
import com.composetest.core.designsystem.components.textfields.params.TextFieldTrailingIconParam
import com.composetest.core.designsystem.domain.emuns.TextFieldIcons
import com.composetest.core.utility.extensions.opacity

@Composable
fun OutlinedTextField(
    modifier: Modifier = Modifier,
    labelText: String,
    placeholderText: String? = null,
    supportingText: String? = null,
    trailingIconParam: TextFieldTrailingIconParam? = null,
    leadingIcon: TextFieldIcons? = null,
    singleLine: Boolean = true,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    keyboardInput: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Default,
    onFocusChanged: ((FocusState) -> Unit)? = null,
    onTextChanged: ((String) -> Unit)? = null
) {
    val textValue = rememberSaveable { mutableStateOf(String()) }
    val passwordHidden = rememberSaveable { mutableStateOf(true) }
    val password = keyboardInput == KeyboardType.Password
    OutlinedTextField(
        value = textValue.value,
        enabled = enabled,
        singleLine = singleLine,
        isError = trailingIconParam?.iconType == TextFieldIcons.ERROR,
        readOnly = readOnly,
        modifier = modifier.onFocusChanged {
            onFocusChanged?.invoke(it)
        },
        onValueChange = {
            textValue.value = it
            onTextChanged?.invoke(textValue.value)
        },
        label = {
            Text(text = labelText)
        },
        placeholder = textFieldHelpedText(placeholderText),
        supportingText = textFieldHelpedText(supportingText),
        leadingIcon = createIcon(leadingIcon?.iconId),
        trailingIcon = trailingIcon(trailingIconParam, textValue, password, passwordHidden),
        visualTransformation = if (password && passwordHidden.value)
            PasswordVisualTransformation() else VisualTransformation.None,
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardInput,
            imeAction = imeAction
        ),
        colors = OutlinedTextFieldDefaults.colors(
            disabledBorderColor = MaterialTheme.colorScheme.outline.opacity(0.12f)
        )
    )
}

@Composable
@Preview
private fun Preview() {
    com.composetest.core.ui.theme.ComposeTestTheme {
        OutlinedTextField(
            labelText = "Label",
            placeholderText = "Placeholder",
            keyboardInput = KeyboardType.Password
        ) { }
    }
}