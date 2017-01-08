package com.github.mszarlinski.hexagonal.port.adapter.persistence;

import com.github.mszarlinski.hexagonal.offer.Offer;
import com.github.mszarlinski.hexagonal.offer.OfferRepository;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author mszarlinski on 2017-01-08.
 */
interface OfferJpaRepository extends OfferRepository, JpaRepository<Offer, Long> {
}
