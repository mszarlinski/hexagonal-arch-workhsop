package com.github.mszarlinski.hexagonal

import com.github.mszarlinski.hexagonal.domain.mail.MailServiceClient
import com.github.mszarlinski.hexagonal.domain.offer.Offer
import com.github.mszarlinski.hexagonal.domain.offer.OfferRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
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
    private WebApplicationContext wac

    @Autowired
    private OfferRepository offerRepository

    @Autowired
    private MailServiceClient mailServiceClient

    @Value('${administrator.email}')
    private String administratorEmail

    private MockMvc mockMvc

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
            Offer cancelledOffer = offerRepository.findById(offer.id).get()
            cancelledOffer.cancelled
    }

    private Offer saveOffer() {
        offerRepository.save(new Offer())
    }

    /**
     * Send request to external Mail Service.
     */
    def "Should notify administrator about offer cancellation"() {
        given:
            Offer offer = saveOffer()
        when:
            mockMvc.perform(delete("/offers/{id}", offer.id))
        then:
            1 * mailServiceClient.sendMail("Offer ${offer.id} has been removed", administratorEmail)
    }

    /**
     * Fetch data from external Customers Service.
     */
    def "Should notify customers subscribed on offer"() {

    }
}
