package de.saschazieger.breweryapp.app.ui.brewery_list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import de.saschazieger.breweryapp.app.theme.BreweryAppTheme
import de.saschazieger.breweryapp.app.ui.common.LoadingIndicator
import de.saschazieger.breweryapp.domain.entities.Brewery

@Composable
fun BreweryListScreen(
    breweryListViewModel: BreweryListViewModel,
    modifier: Modifier = Modifier,
    onBreweryClicked: (Brewery) -> Unit
) {
    BreweryAppTheme {
        Surface(
            modifier.fillMaxSize()
        ) {
            val breweries = breweryListViewModel.breweries.collectAsState(emptyList())

            if (breweries.value.isEmpty()) {
                Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    LoadingIndicator()
                }
            } else {
                LazyColumn(
                    Modifier.fillMaxSize()
                ) {
                    items(breweries.value) { brewery ->
                        BreweryCard(
                            brewery,
                            Modifier.clickable {
                                onBreweryClicked(brewery)
                            }
                        )
                    }
                }
            }
        }
    }
}

