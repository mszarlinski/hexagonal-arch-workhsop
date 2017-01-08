package com.github.mszarlinski.hexagonal.offer;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author mszarlinski on 2017-01-08.
 */
@Entity
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private boolean cancelled = false;

    public Long getId() {
        return id;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    /**
     * NOTE: Domain specific operations instead of setters.
     */
    public Offer cancelled() {
        cancelled = true;
        return this;
    }
}
