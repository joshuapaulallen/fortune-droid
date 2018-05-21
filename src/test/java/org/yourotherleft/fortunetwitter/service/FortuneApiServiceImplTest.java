package org.yourotherleft.fortunetwitter.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.yourotherleft.fortunetwitter.AbstractFortuneTwitterTest;
import org.yourotherleft.fortunetwitter.service.type.Fortune;

import static org.assertj.core.api.Assertions.assertThat;

public class FortuneApiServiceImplTest extends AbstractFortuneTwitterTest {

    @Autowired
    private FortuneService fortuneService;

    @Test
    public void test() {
        final Fortune fortune = fortuneService.getFortune();
        assertThat(fortune).isNotNull();
        assertThat(fortune.getText()).isNotBlank();
    }

}
