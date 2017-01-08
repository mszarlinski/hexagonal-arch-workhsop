package com.github.mszarlinski.hexagonal.application.offercancellation;

import static java.lang.String.format;

import com.github.mszarlinski.hexagonal.domain.mail.MailServiceClient;
import com.github.mszarlinski.hexagonal.domain.offer.Offer;
import com.github.mszarlinski.hexagonal.domain.offer.OfferRepository;
import com.github.mszarlinski.hexagonal.infrastructure.ddd.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author mszarlinski on 2017-01-08.
 */
@ApplicationService
public class OfferCancellationHandler {

    private final OfferRepository offerRepository;

    private final MailServiceClient mailServiceClient;

    private final String administratorEmail;

    @Autowired
    OfferCancellationHandler(OfferRepository offerRepository,
                             MailServiceClient mailServiceClient,
                             @Value("${administrator.email}") String administratorEmail) {
        this.offerRepository = offerRepository;
        this.mailServiceClient = mailServiceClient;
        this.administratorEmail = administratorEmail;
    }

    public Offer cancelOffer(final Long offerId) {
        final Offer cancelledOffer = offerRepository.findById(offerId)
                .map(Offer::cancelled)
                .orElseThrow(() -> new IllegalArgumentException("Offer not found for id: " + offerId));

        mailServiceClient.sendMail(format("Offer %s has been cancelled", offerId), administratorEmail);

        return cancelledOffer;
    }
}
