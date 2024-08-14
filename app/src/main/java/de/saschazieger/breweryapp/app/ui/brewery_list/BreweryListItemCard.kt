package de.saschazieger.breweryapp.app.ui.brewery_list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import de.saschazieger.breweryapp.domain.entities.Brewery
import java.util.Locale

@Composable
fun BreweryCard(
    brewery: Brewery,
    modifier: Modifier = Modifier
) {
    Card(modifier
        .padding(12.dp)
        .fillMaxWidth()
    ) {
        Column {
            Text(brewery.name)
            Text(brewery.city + " - " + brewery.country)
            Text(brewery.breweryType.name.lowercase(Locale.ROOT))
        }
    }
}