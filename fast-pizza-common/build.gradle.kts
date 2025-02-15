plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.kotlin.serialization)
}

repositories {
    mavenCentral()
}

dependencies {

    implementation(libs.kotlin.exposed.core)
    implementation(libs.kotlin.exposed.dao)
    implementation(libs.kotlin.exposed.java.time)
    implementation(libs.ktor.serialization.kotlinx.json)

    implementation(libs.logback)
    implementation(libs.jakarta.validation.api)
    implementation(libs.hibernate.validator.engine)
    kapt(libs.hibernate.validator.annotation.processor)

    testImplementation(libs.ktor.server.test.host.jvm)
    testRuntimeOnly(libs.junit.platform.launcher)
}

tasks.withType<Test> {
    useJUnitPlatform()
}
