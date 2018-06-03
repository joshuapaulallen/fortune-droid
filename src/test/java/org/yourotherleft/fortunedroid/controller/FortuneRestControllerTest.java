package org.yourotherleft.fortunedroid.controller;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.yourotherleft.fortunedroid.AbstractFortuneDroidTest;
import org.yourotherleft.fortunedroid.service.type.Fortune;

import static org.assertj.core.api.Assertions.assertThat;

public class FortuneRestControllerTest extends AbstractFortuneDroidTest {

    @Autowired
    private FortuneRestController fortuneRestController;

    @Test
    public void testGet() {
        final Fortune fortune = fortuneRestController.getFortune();
        assertThat(fortune).isNotNull();
        assertThat(fortune.getText()).isNotBlank();
    }

}
