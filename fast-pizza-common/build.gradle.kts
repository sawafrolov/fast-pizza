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
    implementation(libs.ktor.serialization.kotlinx.json)

    implementation(libs.logback)
    implementation(libs.jakarta.validation.api)
    implementation(libs.hibernate.validator.engine)
    kapt(libs.hibernate.validator.annotation.processor)

    testImplementation(libs.ktor.server.test.host.jvm)
    testRuntimeOnly(libs.junit.platform.launcher)
}

//openApiGenerate {
//    val commonPackage = "com.github.sawafrolov.fastpizza.common"
//    generatorName.set("kotlin")
//    packageName.set(commonPackage)
//    apiPackage.set("$commonPackage.api")
//    modelPackage.set("$commonPackage.dto")
//    invokerPackage.set("$commonPackage.invoker")
//    inputSpec.set("${rootDir}\\openapi.yaml")
//
//    globalProperties.apply {
//        put("models", "true")
//        put("modelDocs", "false")
//    }
//
//    configOptions.set(
//        mapOf(
//            "dateLibrary" to "string",
//            "enumPropertyNaming" to "UPPERCASE",
//            "serializationLibrary" to "jackson",
//            "collectionType" to "list"
//        )
//    )
//}
//
//tasks {
//    compileKotlin {
//        dependsOn(openApiGenerate)
//    }
//    test {
//        useJUnitPlatform()
//    }
//}
