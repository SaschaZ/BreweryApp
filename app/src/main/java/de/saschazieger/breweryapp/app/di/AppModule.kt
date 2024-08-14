package de.saschazieger.breweryapp.app.di

import de.saschazieger.breweryapp.app.ui.brewery_details.BreweryDetailsViewModel
import de.saschazieger.breweryapp.app.ui.brewery_list.BreweryListViewModel
import org.koin.dsl.module

val appModule = module {

    single { BreweryListViewModel(get()) }
    single { BreweryDetailsViewModel(get()) }
}