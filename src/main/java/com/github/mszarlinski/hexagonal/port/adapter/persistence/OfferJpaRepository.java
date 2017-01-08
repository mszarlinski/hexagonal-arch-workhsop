package com.github.mszarlinski.hexagonal.port.adapter.persistence;

import com.github.mszarlinski.hexagonal.domain.offer.Offer;
import com.github.mszarlinski.hexagonal.domain.offer.OfferRepository;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author mszarlinski on 2017-01-08.
 */
interface OfferJpaRepository extends OfferRepository, JpaRepository<Offer, Long> {
}
