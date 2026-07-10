package br.com.vitorcarvalho.api_cursos.modules.controllers;

import br.com.vitorcarvalho.api_cursos.modules.repositories.CursoRepository;
import br.com.vitorcarvalho.api_cursos.modules.useCases.CursoUseCase;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RestController;

import br.com.vitorcarvalho.api_cursos.modules.entities.CursoEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
@RequestMapping("/cursos")
public class CursoController {
    
    private final CursoRepository cursoRepository;
    private final CursoUseCase cursoUseCase;

    CursoController(CursoRepository cursoRepository, CursoUseCase cursoUseCase) {
        this.cursoRepository = cursoRepository;
        this.cursoUseCase = cursoUseCase;
    }

    @PostMapping("/")
    public CursoEntity create(@Valid @RequestBody CursoEntity cursoEntity) {
        return this.cursoRepository.save(cursoEntity);
    }

    @GetMapping("/")
    public ResponseEntity<List<CursoEntity>> findAll() {
        List<CursoEntity> cursos = cursoUseCase.findAll();
        return ResponseEntity.ok().body(cursos);
    }
}
