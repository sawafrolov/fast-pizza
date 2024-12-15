rootProject.name = "fast-pizza"

include("fast-pizza-common")
include("orders")

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            file("../gradle/libs.versions.toml")
        }
    }
}
