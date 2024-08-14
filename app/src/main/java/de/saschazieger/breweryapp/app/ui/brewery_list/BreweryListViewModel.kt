package de.saschazieger.breweryapp.app.ui.brewery_list

import androidx.lifecycle.ViewModel
import de.saschazieger.breweryapp.domain.usecases.GetBreweriesUseCase

class BreweryListViewModel(
    private val getBreweriesUseCase: GetBreweriesUseCase
) : ViewModel() {

    val breweries = getBreweriesUseCase.execute()
}