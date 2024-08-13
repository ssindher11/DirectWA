package com.ssindher.directwa.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.ssindher.directwa.data.Country
import com.ssindher.directwa.ui.theme.DirectWATheme
import com.ssindher.directwa.utils.ifTrue

@Composable
fun CountryListItem(
    country: Country,
    isSelected: Boolean,
    modifier: Modifier = Modifier,
    onClick: (Country) -> Unit,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 4.dp)
            .clip(RoundedCornerShape(4.dp))
            .clickable { onClick(country) }
            .ifTrue(isSelected) {
                Modifier
                    .background(MaterialTheme.colorScheme.secondary)
                    .padding(vertical = 4.dp)
            }
            .padding(horizontal = 8.dp, vertical = 4.dp)
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data("https://flagcdn.com/w80/${country.code.lowercase()}.png")
                .crossfade(true)
                .build(),
            contentDescription = "Flag",
            modifier = Modifier.size(24.dp)
        )
        Text(
            text = country.name,
            color = if (isSelected) MaterialTheme.colorScheme.onSecondary else MaterialTheme.colorScheme.onSurface,
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 16.dp),
        )
        Text(
            text = country.dialCode,
            color = if (isSelected) MaterialTheme.colorScheme.onSecondary else MaterialTheme.colorScheme.onSurface,
        )
    }
}

@Preview
@Composable
private fun CountryListItemPreview() {
    DirectWATheme {
        Surface {
            Column {
                CountryListItem(
                    Country("India", "IN", "+91"),
                    isSelected = false,
                ) {}
                CountryListItem(
                    Country("United States of America", "US", "+1"),
                    isSelected = true,
                ) {}
            }
        }
    }
}