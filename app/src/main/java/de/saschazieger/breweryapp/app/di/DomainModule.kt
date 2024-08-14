package de.saschazieger.breweryapp.app.di

import de.saschazieger.breweryapp.domain.usecases.GetBreweriesUseCase
import org.koin.dsl.module

val domainModule = module {

    single { GetBreweriesUseCase(get()) }
}