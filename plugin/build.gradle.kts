plugins {
    `java-gradle-plugin`
}

group = "repro"
version = "0.0.1"

gradlePlugin {
    // Define the plugin
    plugins {
        create("reproPlugin") {
            id = "repro.repro-plugin"
            implementationClass = "repro.ReproPlugin"
        }
    }
}
