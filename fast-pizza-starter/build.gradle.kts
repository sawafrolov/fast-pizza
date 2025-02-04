plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.ktor)
}

repositories {
    mavenCentral()
}

dependencies {

    implementation(libs.ktor.server.core.jvm)
    implementation(libs.ktor.server.auth.jvm)
    implementation(libs.ktor.server.auth.jwt.jvm)
    implementation(libs.ktor.server.config.yaml.jvm)
    implementation(libs.ktor.server.status.pages.jvm)
    implementation(libs.ktor.server.content.negotiation.jvm)
    implementation(libs.ktor.serialization.kotlinx.json)

    implementation(libs.postgresql)
    implementation(libs.jakarta.validation.api)
    implementation(libs.hibernate.validator.engine)
}

tasks.withType<Test> {
    useJUnitPlatform()
}
