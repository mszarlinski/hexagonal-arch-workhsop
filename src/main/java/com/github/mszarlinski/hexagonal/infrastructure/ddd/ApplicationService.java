package com.github.mszarlinski.hexagonal.infrastructure.ddd;

import org.springframework.stereotype.Component;
import javax.transaction.Transactional;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author mszarlinski on 2017-01-08.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Component
@Transactional
public @interface ApplicationService {
}
