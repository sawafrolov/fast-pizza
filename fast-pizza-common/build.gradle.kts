plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kotlin.serialization)
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.kotlin.exposed.core)
    implementation(libs.kotlin.exposed.jdbc)
    implementation(libs.kotlin.exposed.dao)
    implementation(libs.kotlin.exposed.java.time)
    implementation(libs.ktor.serialization.kotlinx.json)
}
