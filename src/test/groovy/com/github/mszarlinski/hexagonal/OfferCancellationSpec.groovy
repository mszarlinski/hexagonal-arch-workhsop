package com.github.mszarlinski.hexagonal

import com.github.mszarlinski.hexagonal.offer.Offer
import com.github.mszarlinski.hexagonal.offer.OfferRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.servlet.MockMvc
import org.springframework.web.context.WebApplicationContext
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup

@SpringBootTest
@ActiveProfiles('test')
class OfferCancellationSpec extends Specification {

    @Autowired
    WebApplicationContext wac

    @Autowired
    OfferRepository offerRepository

    MockMvc mockMvc

    def setup() {
        mockMvc = webAppContextSetup(wac).build()
    }

    /**
     * Interaction with database.
     */
    def "Should mark offer as canceled"() {
        given:
            Offer offer = saveOffer()
        when:
            mockMvc.perform(delete("/offers/{id}", offer.id))
        then:
            Offer deletedOffer = offerRepository.findById(offer.id).get()
            deletedOffer.cancelled
    }

    private Offer saveOffer() {
        offerRepository.save(new Offer())
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
