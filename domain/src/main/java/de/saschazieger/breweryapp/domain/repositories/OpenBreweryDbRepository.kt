package de.saschazieger.breweryapp.domain.repositories

import de.saschazieger.breweryapp.domain.entities.Brewery
import kotlinx.coroutines.flow.Flow

interface OpenBreweryDbRepository {

    fun getBrewery(id: String): Flow<Brewery>
    fun getBreweries(): Flow<List<Brewery>>
}