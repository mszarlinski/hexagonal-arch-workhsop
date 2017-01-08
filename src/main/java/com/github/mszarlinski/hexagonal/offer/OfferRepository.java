package com.github.mszarlinski.hexagonal.offer;

import java.util.Optional;

/**
 * NOTE: This repository is unaware of Spring Data JPA implementation.
 *
 * @author mszarlinski on 2017-01-08.
 */
public interface OfferRepository {

    Offer save(Offer offer);

    Optional<Offer> findById(long offerId);
}
