rootProject.name = "fast-pizza"

include("fast-pizza-common")
include("customers")
include("orders")
include("pizza")

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            file("../gradle/libs.versions.toml")
        }
    }
}
