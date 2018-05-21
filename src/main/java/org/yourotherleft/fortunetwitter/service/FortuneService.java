package org.yourotherleft.fortunetwitter.service;

import org.yourotherleft.fortunetwitter.service.type.Fortune;

public interface FortuneService {

    /**
     * Fetches a {@link Fortune}.
     *
     * @return a {@link Fortune}.
     */
    Fortune getFortune();

}
