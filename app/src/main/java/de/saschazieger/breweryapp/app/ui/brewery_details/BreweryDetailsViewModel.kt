package de.saschazieger.breweryapp.app.ui.brewery_details

import androidx.lifecycle.ViewModel
import de.saschazieger.breweryapp.domain.repositories.OpenBreweryDbRepository

class BreweryDetailsViewModel(
    private val repository: OpenBreweryDbRepository
) : ViewModel() {

    fun getBrewery(id: String) = repository.getBrewery(id)
}