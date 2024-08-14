package de.saschazieger.breweryapp.app

import android.app.Application
import de.saschazieger.breweryapp.app.di.appModule
import de.saschazieger.breweryapp.app.di.dataModule
import de.saschazieger.breweryapp.app.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BreweryAppApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@BreweryAppApplication)
            modules(
                appModule,
                domainModule,
                dataModule
            )
        }
    }
}