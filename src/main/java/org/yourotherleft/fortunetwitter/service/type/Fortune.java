package org.yourotherleft.fortunetwitter.service.type;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Fortune {

    private final String text;

}
