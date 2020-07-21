package com.enosh.security.controllers;

import com.enosh.security.utils.ControllerUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Optional;

import static com.enosh.security.utils.ControllerUtils.*;

@RestController
@RequestMapping("/company")
public class CompanyController {


    @GetMapping("/me")
    public String companyDetails(Principal principal) {
        System.out.println(principal);
        return nameFromPrincipal
                .andThen(withHtml("h1"))
                .apply(principal);
    }
}
