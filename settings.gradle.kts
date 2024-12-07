rootProject.name = "fast-pizza"

include("order-service")

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            file("../gradle/libs.versions.toml")
        }
    }
}
