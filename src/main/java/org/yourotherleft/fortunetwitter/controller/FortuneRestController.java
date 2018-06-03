package org.yourotherleft.fortunetwitter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.yourotherleft.fortunetwitter.service.FortuneService;
import org.yourotherleft.fortunetwitter.service.type.Fortune;

@RestController
@RequestMapping("/fortune")
public class FortuneRestController {

    private final FortuneService fortuneService;

    @Autowired
    public FortuneRestController(@Qualifier("fortuneShell") final FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Fortune getFortune() {
        return fortuneService.getFortune();
    }

}
