package de.saschazieger.breweryapp.data.repository

import de.saschazieger.breweryapp.data.ClientProvider
import de.saschazieger.breweryapp.data.dto.toEntity
import de.saschazieger.breweryapp.data.dto.Brewery
import de.saschazieger.breweryapp.domain.repositories.OpenBreweryDbRepository
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class OpenBreweryDbRepositoryImpl(): OpenBreweryDbRepository {

    private val client = ClientProvider.newClient

    override fun getBrewery(id: String) = flow {
        emit(
            client.get("https://api.openbrewerydb.org/v1/breweries/$id")
                .body<Brewery>()
                .toEntity()
        )
    }

    override fun getBreweries() = flow {
        emit(
            client.get("https://api.openbrewerydb.org/v1/breweries?per_page=200")
            .body<List<Brewery>>()
            .map { it.toEntity() }
        )
    }
}