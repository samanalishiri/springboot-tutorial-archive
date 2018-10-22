package com.saman.sso.controller;

import org.springframework.web.bind.annotation.GetMapping;

public interface BaseController {
    @GetMapping("client/register/view.page")
    String view();
}
