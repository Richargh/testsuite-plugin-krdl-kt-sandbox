import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.9.21"
    `jvm-test-suite`
}

group = "de.richargh.sandbox.testsuite"

java {
    sourceCompatibility = JavaVersion.VERSION_17
}


allprojects {
    repositories {
        mavenCentral()
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
        }
    }
}

subprojects {

}

tasks.wrapper {
    gradleVersion = "8.4.0"
}
