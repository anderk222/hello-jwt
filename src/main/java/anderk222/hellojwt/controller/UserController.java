package anderk222.hellojwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import anderk222.hellojwt.dto.Response;
import anderk222.hellojwt.service.UsuarioService;

@RestController
@CrossOrigin(allowedHeaders = { "Authorization" }, origins = "http:localhost:8000")
public class UserController {

    @Autowired
    UsuarioService service;

    @GetMapping("/validate")
    public Response validate() {

        return Response.ok();

    }

}
