plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.openapi.generator)
}

repositories {
    mavenCentral()
}

sourceSets {
    main {
        val srcDir = "${buildDir}/generated/src/main/kotlin"
        kotlin.srcDir(srcDir)
    }
}

dependencies {
    implementation(libs.kotlin.exposed.core)
    implementation(libs.kotlin.exposed.dao)
    implementation(libs.kotlin.exposed.java.time)
    implementation(libs.ktor.serialization.jackson)

    implementation(libs.logback)
    implementation(libs.okhttp3)

    testImplementation(libs.ktor.server.test.host.jvm)
    testRuntimeOnly(libs.junit.platform.launcher)
}

openApiGenerate {
    val commonPackage = "com.github.sawafrolov.fastpizza.common"
    val specLocation = "$rootDir/openapi.yaml".replace("\\", "/")
    val outputLocation = "${buildDir}/generated"
    inputSpec.set(specLocation)
    outputDir.set(outputLocation)
    generatorName.set("kotlin")
    packageName.set(commonPackage)
    apiPackage.set("$commonPackage.api.v1")
    modelPackage.set("$commonPackage.dto")
    invokerPackage.set("$commonPackage.invoker")
    generateModelTests.set(true)
    generateApiTests.set(true)

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
    test {
        useJUnitPlatform()
    }
}
