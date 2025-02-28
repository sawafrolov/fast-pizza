plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.openapi.generator)
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.jackson.core)
    implementation(libs.jackson.databind)
    implementation(libs.jackson.annotations)
    implementation(libs.jackson.module.kotlin)

    implementation(libs.logback)
    implementation(libs.okhttp3)
}

openApiGenerate {
    val projectName = project.name.replace("-", "")
    modelPackage = "com.github.sawafrolov.fastpizza.$projectName.dto"
    inputSpec = "$projectDir/openapi.yaml".replace("\\", "/")
    outputDir = "$projectDir/src/main/kotlin".replace("\\", "/")

    generatorName = "kotlin"
    generateModelTests = false

    globalProperties.apply {
        put("models", "")
        put("modelDocs", "false")
        put("lang", "kotlin")
    }

    configOptions.set(
        mapOf(
            "dateLibrary" to "string",
            "enumPropertyNaming" to "UPPERCASE",
            "serializationLibrary" to "jackson",
            "collectionType" to "list"
        )
    )
}
