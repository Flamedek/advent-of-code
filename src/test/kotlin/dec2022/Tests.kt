package dec2022

import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test

internal object Tests {

    @BeforeAll
    @JvmStatic
    fun before() {
        println("\nAdvent Of Code 2022")
    }

    @Test
    fun day1() {
        Day1().run()
    }

    @Test
    fun day2() {
        Day2().run()
    }

    @AfterAll
    @JvmStatic
    fun after() {
        println("\n")
    }

}