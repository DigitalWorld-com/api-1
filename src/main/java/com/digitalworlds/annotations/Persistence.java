package com.digitalworlds.annotations;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface Persistence {

    // Spring Boot @Component annotation abstraction
    @AliasFor(annotation = Component.class) String value() default "";
}
