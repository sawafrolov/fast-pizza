plugins {
    alias(libs.plugins.kotlin.jvm)
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
    implementation(libs.ktor.server.auth.jvm)
    implementation(libs.ktor.server.netty.jvm)
    implementation(libs.ktor.server.config.yaml.jvm)
    implementation(libs.ktor.server.resources.jvm)
    implementation(libs.ktor.server.host.common.jvm)
    implementation(libs.ktor.server.status.pages.jvm)
    implementation(libs.ktor.server.default.headers.jvm)
    implementation(libs.ktor.server.request.validation)
    implementation(libs.ktor.server.content.negotiation.jvm)
    implementation(libs.ktor.serialization.kotlinx.json)

    implementation(libs.ktor.server.openapi)
    implementation(libs.ktor.server.swagger.jvm)

    implementation(libs.koin.ktor)
    implementation(libs.koin.logger.slf4j)

    implementation(libs.logback)
    implementation(libs.postgresql)

    implementation(project(":fast-pizza-common"))

    testImplementation(libs.ktor.server.test.host.jvm)
    testImplementation(libs.kotlin.test.junit)
}

tasks.withType<Test> {
    useJUnitPlatform()
}
