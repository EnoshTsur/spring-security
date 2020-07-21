package com.enosh.security.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.security.Principal;

import static com.enosh.security.utils.ControllerUtils.nameFromPrincipal;
import static com.enosh.security.utils.ControllerUtils.withHtml;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/me")
    public String companyDetails(Principal principal) {
        return nameFromPrincipal
                .andThen(withHtml("h1"))
                .apply(principal);
    }


}
