pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}

rootProject.name = "board"
include("data-domain")
include("data-value-object")
include("data-transfer-object")
include("exposed-entity")
include("exposed-table")
include("exposed-table-extension")
include("exposed-transaction-extension")
include("jpa-converter-extension")
include("kotlin-crypto-extension")
include("kotlin-format-extension")
include("kotlin-protocol-extension")
include("ktor-launcher")
include("ktor-plugin-extension")
include("ktor-routing")
include("ktor-routing-extension")
include("ktor-service")
include("spring-controller")
include("spring-controller-extension")
include("spring-entity")
include("spring-launcher")
include("spring-repository")
include("spring-repository-extension")
include("spring-service")
include("exposed-table-extension")
include("exposed-transaction-extension")
include("jpa-converter-extension")
include("kotlin-crypto-extension")
include("kotlin-format-extension")
include("kotlin-protocol-extension")
include("ktor-plugin-extension")
include("ktor-routing-extension")
include("spring-controller-extension")
include("spring-repository-extension")
include("spring-protocol-extension")
