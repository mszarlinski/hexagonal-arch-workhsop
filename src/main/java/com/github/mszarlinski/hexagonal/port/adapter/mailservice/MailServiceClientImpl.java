package com.github.mszarlinski.hexagonal.port.adapter.mailservice;

import com.github.mszarlinski.hexagonal.domain.mail.MailServiceClient;
import org.springframework.stereotype.Component;

/**
 * @author mszarlinski on 2017-01-08.
 */
@Component
class MailServiceClientImpl implements MailServiceClient {

    @Override
    public void sendMail(final String content, final String receiver) {
        throw new UnsupportedOperationException("Should call Mail Service...");
    }
}
