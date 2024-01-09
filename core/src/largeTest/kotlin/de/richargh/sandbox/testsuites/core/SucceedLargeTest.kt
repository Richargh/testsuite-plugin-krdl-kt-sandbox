package de.richargh.sandbox.testsuites.core

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test

class SucceedLargeTest {

    @Tag(willSucceed)
    @Test
    fun `tests that a succeeding large test is counted`() {
        // arrange, tests if main and testShared can be linked
        val domainObject: DomainObject = DomainObjectBuilder().build()

        // act
        val actual = domainObject.sayHello()

        // assert
        assertThat(actual).isEqualTo("Hello World")
    }

}