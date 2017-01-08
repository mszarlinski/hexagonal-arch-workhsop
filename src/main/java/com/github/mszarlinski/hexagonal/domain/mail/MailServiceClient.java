package com.github.mszarlinski.hexagonal.domain.mail;

/**
 * @author mszarlinski on 2017-01-08.
 */
public interface MailServiceClient {

    void sendMail(String content, String receiver);
}
