rootProject.name = "fast-pizza"

include("fast-pizza-common")
include("fast-pizza-starter")
include("iam-proxy")
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
