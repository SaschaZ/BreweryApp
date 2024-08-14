package de.saschazieger.breweryapp.data

import de.saschazieger.breweryapp.data.dto.Brewery
import io.ktor.client.*
import io.ktor.client.engine.okhttp.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule

object ClientProvider {

    val newClient: HttpClient get() = HttpClient(OkHttp) {
        engine {
            config {
                followSslRedirects(true)
                followRedirects(true)
                retryOnConnectionFailure(true)
            }
        }
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
            })
        }
    }
}