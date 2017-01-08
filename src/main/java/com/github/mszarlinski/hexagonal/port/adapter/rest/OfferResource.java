package com.github.mszarlinski.hexagonal.port.adapter.rest;

import com.github.mszarlinski.hexagonal.application.offercancellation.OfferCancellationHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mszarlinski on 2017-01-08.
 */
@RestController
@RequestMapping("/offers")
class OfferResource {

    private final OfferCancellationHandler offerCancellationHandler;

    @Autowired
    OfferResource(OfferCancellationHandler offerCancellationHandler) {
        this.offerCancellationHandler = offerCancellationHandler;
    }

    @DeleteMapping("/{offerId}")
    void cancelOffer(@PathVariable final Long offerId) {
        offerCancellationHandler.cancelOffer(offerId);
    }
}
