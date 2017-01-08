package com.github.mszarlinski.hexagonal

import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import spock.lang.Specification

@RunWith(SpringRunner.class)
@SpringBootTest
public class OfferCancellationSpec extends Specification {

    /**
     * Interaction with database.
     */
    def "Should mark offer as canceled"() {
    }

    /**
     * Send request to external Mail Service.
     */
    def "Should notify administrator about offer cancellation"() {

    }

    /**
     * Fetch data from external Customers Service.
     */
    def "Should notify customers subscribed on offer"() {

    }
}
