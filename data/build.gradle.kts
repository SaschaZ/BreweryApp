
plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("plugin.serialization")
    kotlin("kapt")
}

android {
    namespace = "de.saschazieger.breweryapp.data"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}

kotlin {
    jvmToolchain(17)
}

dependencies {

    implementation(project(":domain"))

    // Kotlin
    implementation(kotlin("stdlib"))

    // Coroutines
    implementation(libs.cooroutines)

    // Ktor
    implementation(libs.ktor.core)
    implementation(libs.ktor.okhttp)
    implementation(libs.ktor.serialization)
    implementation(libs.ktor.contentNegotiation)
    implementation(libs.ktor.json)

    // Kotlinx serialization
    implementation(libs.kotlin.serialization)
    implementation(libs.kotlin.serialization.json)


    // Test
    testImplementation(libs.junit)
}