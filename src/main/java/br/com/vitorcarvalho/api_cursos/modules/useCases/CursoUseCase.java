package br.com.vitorcarvalho.api_cursos.modules.useCases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vitorcarvalho.api_cursos.modules.entities.CursoEntity;
import br.com.vitorcarvalho.api_cursos.modules.repositories.CursoRepository;

@Service
public class CursoUseCase {
    @Autowired
    private CursoRepository cursoRepository;

    public List<CursoEntity> findAll(){
        return this.cursoRepository.findAll();
    }

    public List<CursoEntity> findByFilter(String name, String category){
        if(name != null){
            return this.cursoRepository.findByName(name);
        }

        if(category != null){
            return this.cursoRepository.findByCategory(category);
        }

        return this.cursoRepository.findAll();
    }
}
