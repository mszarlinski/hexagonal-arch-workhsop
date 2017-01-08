package com.github.mszarlinski.hexagonal.application.offercancellation;

import com.github.mszarlinski.hexagonal.infrastructure.ddd.ApplicationService;
import com.github.mszarlinski.hexagonal.offer.Offer;
import com.github.mszarlinski.hexagonal.offer.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author mszarlinski on 2017-01-08.
 */
@ApplicationService
public class OfferCancellationHandler {

    private final OfferRepository offerRepository;

    @Autowired
    OfferCancellationHandler(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    public Offer cancelOffer(final Long offerId) {
        return offerRepository.findById(offerId)
                .map(Offer::cancelled)
                .orElseThrow(() -> new IllegalArgumentException("Offer not found for id: " + offerId));
    }
}
