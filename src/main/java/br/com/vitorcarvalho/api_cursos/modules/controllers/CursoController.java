package br.com.vitorcarvalho.api_cursos.modules.controllers;

import br.com.vitorcarvalho.api_cursos.modules.repositories.CursoRepository;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RestController;

import br.com.vitorcarvalho.api_cursos.modules.entities.CursoEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/cursos")
public class CursoController {
    
    private final CursoRepository cursoRepository;

    CursoController(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    @PostMapping("/")
    public CursoEntity create(@Valid @RequestBody CursoEntity cursoEntity) {
        return this.cursoRepository.save(cursoEntity);
    }
}
