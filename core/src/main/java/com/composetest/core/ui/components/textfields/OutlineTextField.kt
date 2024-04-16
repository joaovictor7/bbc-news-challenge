package com.composetest.core.ui.components.textfields

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.composetest.core.domain.enums.components.textfield.TextFieldIcons
import com.composetest.core.extensions.opacity
import com.composetest.core.ui.components.textfields.utils.createIcon
import com.composetest.core.ui.components.textfields.utils.textFieldHelpedText
import com.composetest.core.ui.components.textfields.utils.trailingIcon
import com.composetest.core.ui.components.textfields.params.TextFieldTrailingIconParam
import com.composetest.core.ui.theme.ComposeTestTheme

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
    onTextChanged: ((String) -> Unit)? = null
) {
    val textValue = rememberSaveable { mutableStateOf(String()) }
    OutlinedTextField(
        value = textValue.value,
        enabled = enabled,
        singleLine = singleLine,
        isError = trailingIconParam?.iconType == TextFieldIcons.ERROR,
        readOnly = readOnly,
        modifier = modifier,
        onValueChange = {
            textValue.value = it
            onTextChanged?.invoke(textValue.value)
        },
        label = {
            Text(text = labelText)
        },
        placeholder = textFieldHelpedText(placeholderText),
        supportingText = textFieldHelpedText(supportingText),
        leadingIcon = createIcon(leadingIcon),
        trailingIcon = trailingIcon(trailingIconParam, textValue),
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
    ComposeTestTheme {
        OutlinedTextField(
            labelText = "Label",
            placeholderText = "Placeholder"
        ) { }
    }
}