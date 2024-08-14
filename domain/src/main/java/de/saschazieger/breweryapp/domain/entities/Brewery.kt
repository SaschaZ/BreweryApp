package de.saschazieger.breweryapp.domain.entities

data class Brewery(
    val id: String,
    val name: String,
    val breweryType: BreweryType,
    val country: String,
    val state: String,
    val stateProvince: String,
    val city: String,
    val postCode: String,
    val address: List<String>,
    val coordinates: Pair<Double?, Double?>,
    val phone: String?,
    val websiteUrl: String?
)

enum class BreweryType {
    MICRO,
    NANO,
    REGIONAL,
    BREWPUB,
    LARGE,
    PLANNING,
    BAR,
    CONTRACT,
    PROPRIETOR,
    CLOSED
}