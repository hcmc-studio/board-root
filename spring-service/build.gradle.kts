plugins {
    kotlin("jvm") version "1.9.0"
    kotlin("plugin.spring") version "1.9.0"
    kotlin("plugin.jpa") version "1.9.0"
    kotlin("plugin.allopen") version "1.9.0"
    kotlin("plugin.noarg") version "1.9.0"
    id("org.springframework.boot") version "3.1.2"
    id("io.spring.dependency-management") version "1.1.2"
}

group = "studio.hcmc"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":kotlin-protocol-extension"))
    implementation(project(":data-domain"))
    implementation(project(":data-transfer-object"))
    implementation(project(":data-value-object"))
    implementation(project(":spring-entity"))
    implementation(project(":spring-repository"))
    implementation(project(":spring-repository-extension"))
    implementation(project(":spring-protocol-extension"))

    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
}

kotlin {
    jvmToolchain(17)
}