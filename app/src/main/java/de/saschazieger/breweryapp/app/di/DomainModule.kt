package de.saschazieger.breweryapp.app.di

import de.saschazieger.breweryapp.domain.usecases.GetBreweriesUseCase
import de.saschazieger.breweryapp.domain.usecases.GetSingleBreweryUseCase
import org.koin.dsl.module

val domainModule = module {

    single { GetSingleBreweryUseCase(get()) }
    single { GetBreweriesUseCase(get()) }
}