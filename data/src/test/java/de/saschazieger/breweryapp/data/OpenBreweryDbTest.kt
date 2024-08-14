package de.saschazieger.breweryapp.data

import de.saschazieger.breweryapp.data.repository.OpenBreweryDbRepositoryImpl
import de.saschazieger.breweryapp.domain.repositories.OpenBreweryDbRepository
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class OpenBreweryDbTest {

    private val repository = OpenBreweryDbRepositoryImpl()

    @Test
    fun testSingleBrewery(): Unit = runBlocking {
        val brewery = repository.getBrewery("6d14b220-8926-4521-8d19-b98a2d6ec3db").first()
        assert(brewery.name == "10 Barrel Brewing Co")
        assert(brewery.address.first() == "62970 18th St")
    }

    @Test
    fun testListBreweries(): Unit = runBlocking {
        val breweries = repository.getBreweries().toList().first()
        assertTrue(breweries.isNotEmpty())
    }
}