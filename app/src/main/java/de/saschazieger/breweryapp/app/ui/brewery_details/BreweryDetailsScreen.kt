package de.saschazieger.breweryapp.app.ui.brewery_details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import de.saschazieger.breweryapp.app.theme.Typography
import de.saschazieger.breweryapp.domain.entities.Brewery

@Composable
fun BreweryDetailsScreen(
    brewery: Brewery,
    modifier: Modifier = Modifier
) {
    Column(
        modifier.padding(12.dp)
    ) {
        Text(
            brewery.name,
            style = Typography.titleLarge,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 12.dp)
        )

        Text("Type: " + brewery.breweryType.name.lowercase())
        Text("Country: " + brewery.country)
        Text("State: " + brewery.state)
        Text("State Province: " + brewery.stateProvince)
        Text("City: " + brewery.city)
        Text("Postal Code: " + brewery.postCode)
        Text("Address(es):")
        Column(Modifier.padding(start = 8.dp)) {
            brewery.address.forEach { address ->
                Text(address)
            }
        }
        brewery.phone?.let { Text("Phone: $it") }
        brewery.websiteUrl?.let { Text("Website: $it") }
        Text("Long: ${brewery.coordinates.first}")
        Text("Lat: ${brewery.coordinates.second}")
    }
}