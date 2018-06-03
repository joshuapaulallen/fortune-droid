package org.yourotherleft.fortunedroid.service;

import org.yourotherleft.fortunedroid.service.type.Fortune;

public interface FortuneService {

    /**
     * Fetches a {@link Fortune}.
     *
     * @return a {@link Fortune}.
     */
    Fortune getFortune();

}
