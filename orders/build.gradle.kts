plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.ktor)
}

application {
    mainClass = "io.ktor.server.netty.EngineMain"
}

repositories {
    mavenCentral()
}

dependencies {

    implementation(libs.ktor.server.core.jvm)
    implementation(libs.ktor.server.netty.jvm)
    implementation(libs.ktor.server.auth.jvm)
    implementation(libs.ktor.server.auth.jwt.jvm)
    implementation(libs.ktor.server.config.yaml.jvm)
    implementation(libs.ktor.server.status.pages.jvm)
    implementation(libs.ktor.server.content.negotiation.jvm)
    implementation(libs.ktor.serialization.kotlinx.json)

    implementation(libs.ktor.server.openapi)
    implementation(libs.ktor.server.swagger.jvm)

    implementation(libs.koin.core)
    implementation(libs.koin.ktor)
    implementation(libs.koin.logger.slf4j)

    implementation(libs.kotlin.exposed.core)
    implementation(libs.kotlin.exposed.jdbc)
    implementation(libs.kotlin.exposed.dao)

    implementation(project(":fast-pizza-common"))
    implementation(project(":fast-pizza-starter"))

    implementation(libs.logback)
    implementation(libs.postgresql)
    implementation(libs.jakarta.validation.api)
    implementation(libs.hibernate.validator.engine)
    kapt(libs.hibernate.validator.annotation.processor)

    testImplementation(libs.mockk)
    testImplementation(libs.kotlin.test.junit)
    testImplementation(libs.ktor.server.test.host.jvm)
}

tasks.withType<Test> {
    useJUnitPlatform()
}
