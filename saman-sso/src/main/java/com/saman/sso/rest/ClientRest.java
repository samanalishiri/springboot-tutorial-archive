package com.saman.sso.rest;

import com.saman.sso.rest.model.ClientDetailModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientRest {

    @PostMapping(value = {"client/save"})
    public ResponseEntity<Object> save(ClientDetailModel model){
        return null;
    }
}
