package org.yourotherleft.fortunetwitter.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.yourotherleft.fortunetwitter.AbstractFortuneTwitterTest;
import org.yourotherleft.fortunetwitter.service.type.Fortune;

import static org.assertj.core.api.Assertions.assertThat;

public class FortuneShellServiceImplTest extends AbstractFortuneTwitterTest {

    @Autowired
    @Qualifier("fortuneShell")
    private FortuneService fortuneService;

    @Test
    public void test() {
        final Fortune fortune = fortuneService.getFortune();
        assertThat(fortune).isNotNull();
        assertThat(fortune.getText()).isNotBlank();
    }

}
