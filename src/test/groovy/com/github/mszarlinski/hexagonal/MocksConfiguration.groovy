package com.github.mszarlinski.hexagonal

import com.github.mszarlinski.hexagonal.domain.mail.MailServiceClient
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import spock.mock.DetachedMockFactory

/**
 * @author mszarlinski on 2017-01-08.
 */
@Profile('test')
@Configuration
class MocksConfiguration {

    private DetachedMockFactory factory = new DetachedMockFactory()

    @Bean
    MailServiceClient mailServiceClient() {
        return factory.Mock(name: 'mailServiceClient', MailServiceClient)
    }
}
