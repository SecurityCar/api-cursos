package br.com.vitorcarvalho.api_cursos.modules.controllers;

import br.com.vitorcarvalho.api_cursos.modules.repositories.CursoRepository;
import br.com.vitorcarvalho.api_cursos.modules.useCases.CursoUseCase;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RestController;

import br.com.vitorcarvalho.api_cursos.modules.entities.CursoEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping
    public ResponseEntity<List<CursoEntity>> listByFilter(@RequestParam(required = false) String name,
        @RequestParam(required = false) String category){
        List<CursoEntity> cursos = cursoUseCase.findByFilter(name, category);
        return ResponseEntity.ok().body(cursos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CursoEntity> update(@PathVariable UUID id, @RequestBody CursoEntity cursoEntity){
        CursoEntity cursoAtualizado = this.cursoUseCase.update(id, cursoEntity);
        return ResponseEntity.ok(cursoAtualizado);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id){
        cursoUseCase.delete(id);
    }
}
