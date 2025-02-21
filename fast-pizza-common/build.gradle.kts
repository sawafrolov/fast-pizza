plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.openapi.generator)
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.kotlin.exposed.core)
    implementation(libs.kotlin.exposed.dao)
    implementation(libs.kotlin.exposed.java.time)
    implementation(libs.ktor.serialization.jackson)

    implementation(libs.logback)
    implementation(libs.jakarta.validation.api)
    implementation(libs.hibernate.validator.engine)
    kapt(libs.hibernate.validator.annotation.processor)

    testImplementation(libs.ktor.server.test.host.jvm)
    testRuntimeOnly(libs.junit.platform.launcher)
}

openApiGenerate {
    val commonPackage = "com.github.sawafrolov.fastpizza.common"
    val specLocation = "$rootDir/openapi.yaml".replace("\\", "/")
    val outputLocation = "$buildDir/generated"
    generatorName.set("kotlin")
    packageName.set(commonPackage)
    apiPackage.set("$commonPackage.api")
    modelPackage.set("$commonPackage.dto")
    invokerPackage.set("$commonPackage.invoker")
    inputSpec.set(specLocation)
    outputDir.set(outputLocation)

    configOptions.set(
        mapOf(
            "dateLibrary" to "string",
            "enumPropertyNaming" to "UPPERCASE",
            "serializationLibrary" to "jackson",
            "collectionType" to "list"
        )
    )
}

tasks {
    compileKotlin {
        dependsOn(openApiGenerate)
    }
    test {
        useJUnitPlatform()
    }
}
