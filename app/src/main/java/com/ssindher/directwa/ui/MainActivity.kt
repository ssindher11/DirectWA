package com.ssindher.directwa.ui

import android.content.ClipDescription.MIMETYPE_TEXT_PLAIN
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.content.pm.PackageManager.NameNotFoundException
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ContentPaste
import androidx.compose.material.icons.filled.Whatsapp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.PlainTooltip
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TooltipBox
import androidx.compose.material3.TooltipDefaults
import androidx.compose.material3.rememberTooltipState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.text.isDigitsOnly
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.ssindher.directwa.data.Country
import com.ssindher.directwa.data.CountryPreferencesManager
import com.ssindher.directwa.data.countriesList
import com.ssindher.directwa.ui.component.CountrySelectionSheet
import com.ssindher.directwa.ui.theme.DirectWATheme
import com.ssindher.directwa.ui.theme.WhatsAppColor
import com.ssindher.directwa.utils.Utils.extractPhoneNumber
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DirectWATheme {
                MainScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()
    val context = LocalContext.current
    val focusManager = LocalFocusManager.current

    var phoneNumber by remember { mutableStateOf("") }
    val isButtonEnabled by remember {
        derivedStateOf { phoneNumber.length == 10 }
    }
    val clipboard = remember {
        context.getSystemService(Context.CLIPBOARD_SERVICE) as android.content.ClipboardManager
    }

    val countryPreferencesManager = remember { CountryPreferencesManager(context) }
    val selectedCountryCode by
    countryPreferencesManager.selectedCountryCode.collectAsState(initial = "")
    val selectedCountry = remember(selectedCountryCode) {
        val country = countriesList.find { it.code == selectedCountryCode } ?: Country(
            name = "India",
            code = "IN",
            dialCode = "+91",
        )
        country
    }

    var showSheet by remember { mutableStateOf(false) }
    if (showSheet) {
        CountrySelectionSheet {
            showSheet = false
        }
    }

    val openWhatsapp = remember(selectedCountry) {
        {
            context.openWhatsApp(phoneNumber = phoneNumber, dialCode = selectedCountry.dialCode) {
                coroutineScope.launch {
                    snackbarHostState.showSnackbar(
                        message = "WhatsApp is not installed",
                        duration = SnackbarDuration.Short,
                    )
                }
            }
        }
    }

    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState) { data ->
                Snackbar(
                    containerColor = MaterialTheme.colorScheme.errorContainer,
                    contentColor = MaterialTheme.colorScheme.onErrorContainer,
                    snackbarData = data
                )
            }
        },
        modifier = Modifier.fillMaxSize(),
    ) { innerPadding ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
        ) {
            Text(
                text = "Enter phone number",
                style = MaterialTheme.typography.headlineMedium.copy(
                    color = MaterialTheme.colorScheme.secondary
                ),
            )

            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp),
            ) {
                OutlinedTextField(
                    value = phoneNumber,
                    onValueChange = {
                        if (it.isDigitsOnly() && it.length <= 10) {
                            phoneNumber = it
                        }
                    },
                    leadingIcon = {
                        Box(
                            modifier = Modifier
                                .clickable { showSheet = true }
                                .padding(8.dp),
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                AsyncImage(
                                    model = ImageRequest.Builder(LocalContext.current)
                                        .data("https://flagcdn.com/w80/${selectedCountryCode?.lowercase()}.png")
                                        .crossfade(true)
                                        .build(),
                                    contentDescription = "Flag",
                                    modifier = Modifier
                                        .padding(end = 8.dp)
                                        .size(24.dp),
                                )
                                Text(text = selectedCountry.dialCode)
                                Icon(
                                    imageVector = Icons.Default.ArrowDropDown,
                                    contentDescription = "Select country code",
                                )
                            }
                        }
                    },
                    trailingIcon = {
                        TooltipBox(
                            positionProvider = TooltipDefaults.rememberPlainTooltipPositionProvider(),
                            tooltip = {
                                PlainTooltip {
                                    Text(text = "Paste from clipboard")
                                }
                            },
                            state = rememberTooltipState()
                        ) {
                            IconButton(
                                onClick = {
                                    val clipboardContainsText = when {
                                        !clipboard.hasPrimaryClip() -> false

                                        clipboard.primaryClipDescription?.hasMimeType(
                                            MIMETYPE_TEXT_PLAIN
                                        ) != true -> false

                                        else -> true
                                    }
                                    val pasteData =
                                        clipboard.primaryClip?.getItemAt(0)?.text?.toString() ?: ""
                                    if (clipboardContainsText) {
                                        val (dialCode, phone) = extractPhoneNumber(pasteData)
                                        if (!phone.isNullOrBlank()) {
                                            phoneNumber = phone
                                            val country =
                                                countriesList.find { it.dialCode == "+$dialCode" }
                                            country?.let {
                                                coroutineScope.launch {
                                                    countryPreferencesManager.saveSelectedCountryCode(
                                                        country.code
                                                    )
                                                }
                                            }
                                        }
                                    }
                                },
                            ) {
                                Icon(
                                    imageVector = Icons.Default.ContentPaste,
                                    contentDescription = "Paste from clipboard"
                                )
                            }
                        }
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Phone,
                        imeAction = ImeAction.Go,
                    ),
                    keyboardActions = KeyboardActions(
                        onGo = {
                            openWhatsapp()
                            focusManager.clearFocus()
                        }
                    ),
                    maxLines = 1,
                    modifier = Modifier.fillMaxWidth(),
                )
            }

            Button(
                colors = ButtonDefaults.buttonColors()
                    .copy(containerColor = WhatsAppColor, contentColor = Color.White),
                modifier = Modifier
                    .padding(top = 16.dp)
                    .align(Alignment.CenterHorizontally),
                enabled = isButtonEnabled,
                onClick = {
                    openWhatsapp()
                    focusManager.clearFocus()
                },
            ) {
                Icon(
                    imageVector = Icons.Default.Whatsapp,
                    contentDescription = "WhatsApp icon",
                )
                Text(text = "Chat on WhatsApp", modifier = Modifier.padding(start = 4.dp))
            }
        }
    }
}

private fun Context.openWhatsApp(
    phoneNumber: String,
    dialCode: String,
    handleAppNotInstalled: () -> Unit
) {
    val pm: PackageManager = packageManager
    try {
        pm.getPackageInfo("com.whatsapp", PackageManager.GET_META_DATA)
        val intent = Intent(
            Intent.ACTION_VIEW,
            Uri.parse("https://wa.me/${dialCode.removePrefix("+")}$phoneNumber")
        )
        intent.setPackage("com.whatsapp")
        startActivity(intent)
    } catch (e: NameNotFoundException) {
        handleAppNotInstalled()
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    DirectWATheme {
        MainScreen()
    }
}