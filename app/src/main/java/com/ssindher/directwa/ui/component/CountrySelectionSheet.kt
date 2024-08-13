package com.ssindher.directwa.ui.component

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ssindher.directwa.data.CountryPreferencesManager
import com.ssindher.directwa.data.countriesList
import com.ssindher.directwa.ui.theme.DirectWATheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CountrySelectionSheet(
    onDismiss: () -> Unit
) {
    val modalBottomSheetState = rememberModalBottomSheetState()

    ModalBottomSheet(
        onDismissRequest = onDismiss,
        sheetState = modalBottomSheetState,
        dragHandle = { BottomSheetDefaults.DragHandle() }
    ) {
        CountryList(
            modifier = Modifier.fillMaxSize(),
            onDismiss = onDismiss,
        )
    }
}

@Composable
fun CountryList(
    modifier: Modifier = Modifier,
    onDismiss: () -> Unit
) {
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()
    val focusManager = LocalFocusManager.current

    val countryPreferencesManager = remember { CountryPreferencesManager(context) }
    val selectedCountry = countryPreferencesManager.selectedCountryCode.collectAsState(initial = "")

    var query by rememberSaveable { mutableStateOf("") }

    val countries = remember(query) {
        if (query.isBlank()) countriesList
        else countriesList.filter {
            it.name.contains(query, ignoreCase = true) ||
                    it.code.contains(query, ignoreCase = true)
        }
    }

    LazyColumn(modifier = modifier) {
        item {
            OutlinedTextField(
                value = query,
                onValueChange = { query = it },
                label = { Text(text = "Search Country") },
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Search, contentDescription = "Search")
                },
                trailingIcon = {
                    if (query.isNotBlank()) {
                        IconButton(onClick = { query = "" }) {
                            Icon(imageVector = Icons.Default.Clear, contentDescription = "Clear")
                        }
                    }
                },
                maxLines = 1,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Done,
                    capitalization = KeyboardCapitalization.Words,
                ),
                keyboardActions = KeyboardActions(
                    onDone = { focusManager.clearFocus() }
                ),
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .padding(bottom = 24.dp)
                    .fillMaxWidth(),
            )
        }

        items(countries, key = { it.code }) { country ->
            CountryListItem(
                country = country,
                isSelected = country.code == selectedCountry.value,
            ) {
                coroutineScope.launch {
                    countryPreferencesManager.saveSelectedCountryCode(country.code)
                    onDismiss()
                }
            }
        }
    }
}

@Preview
@Composable
private fun CountryListPreview() {
    DirectWATheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            CountryList(modifier = Modifier.fillMaxSize(), onDismiss = {})
        }
    }
}