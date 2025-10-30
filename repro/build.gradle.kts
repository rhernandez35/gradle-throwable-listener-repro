plugins {
    id("repro.repro-plugin")
}

tasks.register("error") {
    description = "Run with error type"
}

tasks.register("exception") {
    description = "Run with exception type"
}

configure<repro.ReproExtension> {
    errorType.set(provider {
        when {
            gradle.taskGraph.hasTask(":repro:error") -> "error"
            gradle.taskGraph.hasTask(":repro:exception") -> "exception"
            else -> "error" // default
        }
    })
}

