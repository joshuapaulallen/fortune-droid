package org.yourotherleft.fortunetwitter.controller;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.yourotherleft.fortunetwitter.AbstractFortuneTwitterTest;
import org.yourotherleft.fortunetwitter.service.type.Fortune;

import static org.assertj.core.api.Assertions.assertThat;

public class FortuneRestControllerTest extends AbstractFortuneTwitterTest {

    @Autowired
    private FortuneRestController fortuneRestController;

    @Test
    public void testGet() {
        final Fortune fortune = fortuneRestController.getFortune();
        assertThat(fortune).isNotNull();
        assertThat(fortune.getText()).isNotBlank();
    }

}
