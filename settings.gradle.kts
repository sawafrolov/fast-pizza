rootProject.name = "fast-pizza"

include("fast-pizza-api")
include("fast-pizza-common")

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            file("../gradle/libs.versions.toml")
        }
    }
}
