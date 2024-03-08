package com.sushil.redissession.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Optional;

@RestController
public class HomeController {

    private final String HOME_VIEW_COUNT = "HOME_VIEW_COUNT";

    @GetMapping("/")
    public String home(Principal principal, HttpSession session) {
        incrementCount(session, HOME_VIEW_COUNT);
        return "Hello, " + principal.getName();
    }

    private void incrementCount(HttpSession session, String attr) {
        var homeViewCount = getCount(session, attr);
        session.setAttribute(attr, homeViewCount+= 1);
    }

    private Integer getCount(HttpSession session, String attr) {
        return (Integer) Optional.ofNullable(session.getAttribute(attr))
                .orElse(0);
    }

    @GetMapping("/count")
    public String count(HttpSession session) {
        return "HOME_VIEW_COUNT: " + getCount(session, HOME_VIEW_COUNT);
    }

}
