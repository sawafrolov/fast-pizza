rootProject.name = "fast-pizza"

include("orders")

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            file("../gradle/libs.versions.toml")
        }
    }
}
