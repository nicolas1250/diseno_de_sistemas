package com.corhuila.ejercicio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins="http//localhost:4200")
@RestController
@RequestMapping("/api")
public class userController {
    @Autowired
    private UserService usuarioService;

    @GetMapping("/usuario")
    public List<Tarea> index() {
        return usuarioService.findall();
    }

    @GetMapping("/usuario/{id}")
    public Tarea show(@PathVariable Long id) {
        return usuarioService.findById(id);
    }

    @PostMapping("/usuario")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario create(@RequestBody Usuario usuario) {
        return usuarioService.save(usuario);
    }

    @PutMapping("/usuario/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Tarea update(@RequestBody Usuario usuario, @PathVariable Long id) {
        Tarea usuarioActual = usuarioService.findById(id);
        usuarioActual.setFullName(usuario.getFullName());
        usuarioActual.setEmail(usuario.getEmail());
        usuarioActual.setPassword(usuario.getPassword());
        return usuarioService.save(usuarioActual);
    }

    @DeleteMapping("/usuario/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        usuarioService.delete(id);
    }
}

