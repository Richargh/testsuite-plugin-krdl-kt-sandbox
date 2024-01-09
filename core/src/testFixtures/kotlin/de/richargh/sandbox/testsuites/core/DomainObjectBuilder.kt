package de.richargh.sandbox.testsuites.core

class DomainObjectBuilder {

    private var word: String = "World"

    fun build() = DomainObject(word)

    fun withWord(word: String) = apply { this.word = word }
}