package com.cuidar.api;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Clsse responsavel por informar qual container esta respondendo, retornando host e IP
 * (dentro da ideia de load balance com 1 + n containeres
 */
@RestController
public class HostCheckController {

    @GetMapping("/hostcheck")
    public String checkHost() throws UnknownHostException {
        return InetAddress.getLocalHost().getHostAddress()
                + " - " + InetAddress.getLocalHost().getHostName();
    }

}