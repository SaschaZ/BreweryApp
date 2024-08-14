package de.saschazieger.breweryapp.domain.usecases

import de.saschazieger.breweryapp.domain.repositories.OpenBreweryDbRepository

class GetBreweriesUseCase(
    private val repository: OpenBreweryDbRepository
) {

    fun execute() = repository.getBreweries()
}