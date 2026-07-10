package br.com.vitorcarvalho.api_cursos.modules.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.vitorcarvalho.api_cursos.modules.entities.CursoEntity;

public interface CursoRepository extends JpaRepository<CursoEntity, UUID>{
    
    
}
