plugins {
    alias(libs.plugins.kotlin.jvm)
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
    implementation(libs.jackson.core)
    implementation(libs.jackson.databind)
    implementation(libs.jackson.annotations)
    implementation(libs.jackson.module.kotlin)

    implementation(libs.logback)
    implementation(libs.okhttp3)
    testRuntimeOnly(libs.junit.platform.launcher)
}

openApiGenerate {
    val apiLocation = "com.github.sawafrolov.fastpizza.api.v1"
    val specLocation = "$rootDir/openapi.yaml".replace("\\", "/")
    val outputLocation = "${buildDir}/generated"
    inputSpec.set(specLocation)
    outputDir.set(outputLocation)
    generatorName.set("kotlin")
    packageName.set(apiLocation)
    apiPackage.set(apiLocation)
    modelPackage.set("$apiLocation.dto")
    invokerPackage.set("$apiLocation.invoker")
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
