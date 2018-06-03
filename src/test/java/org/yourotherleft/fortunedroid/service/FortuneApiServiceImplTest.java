package org.yourotherleft.fortunedroid.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.yourotherleft.fortunedroid.AbstractFortuneDroidTest;
import org.yourotherleft.fortunedroid.service.type.Fortune;

import static org.assertj.core.api.Assertions.assertThat;

public class FortuneApiServiceImplTest extends AbstractFortuneDroidTest {

    @Autowired
    @Qualifier("fortuneApi")
    private FortuneService fortuneService;

    @Test
    public void test() {
        final Fortune fortune = fortuneService.getFortune();
        assertThat(fortune).isNotNull();
        assertThat(fortune.getText()).isNotBlank();
    }

}
