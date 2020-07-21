package com.enosh.security.utils;

import java.security.Principal;
import java.util.Optional;
import java.util.function.Function;

public interface ControllerUtils {

    Function<Principal, String> nameFromPrincipal = principal ->
            Optional.ofNullable(principal)
                    .map(Principal::getName)
                    .orElse("Guest");

    static <T> Function<T, String> withHtml(String element) {
        return any ->  String.format("<%s>%s</%s>", element, any, element);
    }
}
