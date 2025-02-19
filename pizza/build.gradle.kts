plugins {
    alias(libs.plugins.ktor)
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kotlin.serialization)
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
    implementation(libs.ktor.server.status.pages.jvm)
    implementation(libs.ktor.server.content.negotiation.jvm)
    implementation(libs.ktor.serialization.kotlinx.json)

    implementation(libs.koin.core)
    implementation(libs.koin.ktor)
    implementation(libs.koin.logger.slf4j)

    implementation(libs.kotlin.exposed.core)
    implementation(libs.kotlin.exposed.jdbc)
    implementation(libs.kotlin.exposed.dao)

    implementation(project(":fast-pizza-common"))

    implementation(libs.logback)
    implementation(libs.postgresql)
    implementation(libs.jakarta.validation.api)
    implementation(libs.hibernate.validator.engine)

    testImplementation(libs.mockk)
    testImplementation(libs.ktor.server.test.host.jvm)
    testRuntimeOnly(libs.junit.platform.launcher)
}

tasks.withType<Test> {
    useJUnitPlatform()
}
