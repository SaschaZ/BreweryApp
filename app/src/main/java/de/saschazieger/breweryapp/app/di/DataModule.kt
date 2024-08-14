package de.saschazieger.breweryapp.app.di

import de.saschazieger.breweryapp.data.ClientProvider
import de.saschazieger.breweryapp.data.repository.OpenBreweryDbRepositoryImpl
import de.saschazieger.breweryapp.domain.repositories.OpenBreweryDbRepository
import org.koin.dsl.module

val dataModule = module {

    single<OpenBreweryDbRepository> { OpenBreweryDbRepositoryImpl() }
}