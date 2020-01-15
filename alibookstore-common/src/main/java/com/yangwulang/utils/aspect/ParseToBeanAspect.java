package com.yangwulang.utils.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author yangwulang
 */
@Aspect
@Component
public class ParseToBeanAspect {
    private final Logger LOGGER = LoggerFactory.getLogger(ParseToBeanAspect.class);

}
