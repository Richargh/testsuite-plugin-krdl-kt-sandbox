plugins {
    java
}

tasks.withType<Test> {
    useJUnitPlatform {  }

    reports {
        junitXml.apply {
            isOutputPerTestCase = true // defaults to false
        }
    }

    testLogging {
        showExceptions = true
        showStandardStreams = true
        events("passed", "skipped", "failed")
    }
}

testing {
    suites {
        val test by getting(JvmTestSuite::class) {
            useJUnitJupiter("5.7.1")
            dependencies {
                implementation("org.assertj:assertj-core:3.25.1")
            }
        }

        val mediumTest by registering(JvmTestSuite::class) {
            dependencies {
                implementation(project())
                implementation(testFixtures(project()))
                implementation("org.assertj:assertj-core:3.25.1")
            }

            targets {
                all {
                    testTask.configure {
                        shouldRunAfter(test)
                    }
                }
            }
        }

        val largeTest by registering(JvmTestSuite::class) {
            dependencies {
                implementation(project())
                implementation(testFixtures(project()))
                implementation("org.assertj:assertj-core:3.25.1")
            }

            targets {
                all {
                    testTask.configure {
                        shouldRunAfter(test)
                    }
                }
            }
        }
    }
}

tasks.named("largeTest") {
    dependsOn(
        testing.suites.named("mediumTest"))
}

tasks.named("check") {
    dependsOn(
        testing.suites.named("mediumTest"),
        testing.suites.named("largeTest"))
}
