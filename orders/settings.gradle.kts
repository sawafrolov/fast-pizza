rootProject.name = "order-service"

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            file("../gradle/libs.versions.toml")
        }
    }
}
