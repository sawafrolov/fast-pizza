plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kotlin.serialization)
}

repositories {
    mavenCentral()
}

dependencies {

    implementation(libs.ktor.server.core.jvm)
    implementation(libs.ktor.serialization.kotlinx.json)

    implementation(libs.kotlin.exposed.core)
    implementation(libs.kotlin.exposed.jdbc)
    implementation(libs.kotlin.exposed.dao)
    implementation(libs.kotlin.exposed.java.time)

    testImplementation(libs.ktor.server.test.host.jvm)
    testImplementation(libs.kotlin.test.junit)
}

tasks.withType<Test> {
    useJUnitPlatform()
}
