package de.saschazieger.breweryapp.app.ui.brewery_details

import androidx.lifecycle.ViewModel
import de.saschazieger.breweryapp.domain.repositories.OpenBreweryDbRepository
import de.saschazieger.breweryapp.domain.usecases.GetSingleBreweryUseCase
import kotlinx.coroutines.flow.first

class BreweryDetailsViewModel(
    private val getSingleBreweryUseCase: GetSingleBreweryUseCase
) : ViewModel() {

    fun getBrewery(id: String) = getSingleBreweryUseCase.execute(id)
}