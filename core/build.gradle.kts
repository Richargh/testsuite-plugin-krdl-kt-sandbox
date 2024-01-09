plugins {
    kotlin("jvm")

    `java-test-fixtures`

    id("test-suite-sandbox.conventions") // buildSrc plugin
}

dependencies {
    /** Project dependencies **/
    // none

    /** Language dependencies **/
    implementation(kotlin("stdlib-jdk8"))

    /** Main dependencies **/
    // none

    /** Test dependencies **/
    // none
}
