package de.saschazieger.breweryapp.domain.usecases

import de.saschazieger.breweryapp.domain.repositories.OpenBreweryDbRepository

class GetSingleBreweryUseCase(
    private val repository: OpenBreweryDbRepository
) {

    fun execute(id: String) = repository.getBrewery(id)
}