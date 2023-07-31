package studio.hcmc.board.env

internal fun clone(repository: String, destination: String) {
    val command = "bin/clone $repository $destination"
    println(command)

    val process = Runtime.getRuntime().exec(command)
    val reader = process.errorReader()
    while (true) {
        val line = reader.readLine() ?: break
        println(line)
    }

    process.waitFor()
    reader.close()
}

internal fun cloneAll() {
    val args = listOf(
        "board-data-domain" to "data-domain",
        "board-data-transfer-object" to "data-transfer-object",
        "board-data-value-object" to "data-value-object",
        "board-exposed-entity" to "exposed-entity",
        "board-exposed-table" to "exposed-table",
        "exposed-table-extension" to "exposed-table-extension",
        "exposed-transaction-extension" to "exposed-transaction-extension",
        "jpa-converter-extension" to "jpa-converter-extension",
        "kotlin-crypto-extension" to "kotlin-crypto-extensinon",
        "kotlin-format-extension" to "kotlin-format-extension",
        "kotlin-protocol-extension" to "kotlin-protocol-extension",
        "board-ktor-launcher" to "ktor-launcher",
        "ktor-plugin-extension" to "ktor-plugin-extension",
        "board-ktor-routing" to "ktor-routing",
        "ktor-routing-extension" to "ktor-routing-extension",
        "board-ktor-service" to "ktor-service",
        "board-spring-controller" to "spring-controller",
        "spring-controller-extension" to "spring-controller-extension",
        "board-spring-entity" to "spring-entity",
        "board-spring-launcher" to "spring-launcher",
        "board-spring-repository" to "spring-repository",
        "spring-repository-extension" to "spring-repository-extension"
    )
}

fun main() {
    clone("board-data-transfer-object", "data-transfer-object")
}

//#!/bin/zsh
//
// bin/clone board-data-domain data-domain
// bin/clone board-data-transfer-object data-transfer-object
// bin/clone board-data-value-object data-value-object
// bin/clone board-exposed-entity exposed-entity
// bin/clone board-exposed-table exposed-table
// bin/clone exposed-table-extension exposed-table-extension
// bin/clone exposed-transaction-extension exposed-transaction-extension
// bin/clone jpa-converter-extension jpa-converter-extension
// bin/clone kotlin-crypto-extension kotlin-crypto-extensinon
// bin/clone kotlin-format-extension kotlin-format-extension
// bin/clone kotlin-protocol-extension kotlin-protocol-extension
// bin/clone board-ktor-launcher ktor-launcher
// bin/clone ktor-plugin-extension ktor-plugin-extension
// bin/clone board-ktor-routing ktor-routing
// bin/clone ktor-routing-extension ktor-routing-extension
// bin/clone board-ktor-service ktor-service
// bin/clone board-spring-controller spring-controller
// bin/clone spring-controller-extension spring-controller-extension
// bin/clone board-spring-entity spring-entity
// bin/clone board-spring-launcher spring-launcher
// bin/clone board-spring-repository spring-repository
// bin/clone spring-repository-extension spring-repository-extension