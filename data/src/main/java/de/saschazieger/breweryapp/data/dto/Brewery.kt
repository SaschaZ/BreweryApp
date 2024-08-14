package de.saschazieger.breweryapp.data.dto

import de.saschazieger.breweryapp.domain.entities.BreweryType
import io.ktor.util.toUpperCasePreservingASCIIRules
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import de.saschazieger.breweryapp.domain.entities.Brewery as BreweryEntity

@Serializable
data class Brewery(
    val id: String,
    val name: String,
    @SerialName("brewery_type")
    val breweryType: String,
    @SerialName("address_1")
    val address1: String? = null,
    @SerialName("address_2")
    val address2: String? = null,
    @SerialName("address_3")
    val address3: String? = null,
    val city: String,
    @SerialName("state_province")
    val stateProvince: String,
    @SerialName("postal_code")
    val postalCode: String,
    val country: String,
    val longitude: String? = null,
    val latitude: String? = null,
    val phone: String? = null,
    @SerialName("website_url")
    val websiteUrl: String? = null,
    val state: String
)

fun Brewery.toEntity() = BreweryEntity(
    id, name,
    BreweryType.valueOf(breweryType.toUpperCasePreservingASCIIRules()),
    country, state, stateProvince, city, postalCode,
    listOfNotNull(address1, address2, address3),
    longitude?.toDouble() to latitude?.toDouble(),
    phone, websiteUrl
)