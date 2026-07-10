package br.com.vitorcarvalho.api_cursos.modules.useCases;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vitorcarvalho.api_cursos.modules.entities.CursoEntity;
import br.com.vitorcarvalho.api_cursos.modules.exceptions.ResourceNotFoundException;
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

    public CursoEntity update(UUID id, CursoEntity cursoAtualizado){
        CursoEntity curso = cursoRepository.findById(id).orElseThrow(
            () -> new ResourceNotFoundException("Curso não encontrado. Verifique o ID.")
        );

        if(cursoAtualizado.getName() != null){
            curso.setName(cursoAtualizado.getName());
        }
        if(cursoAtualizado.getCategory() != null){
            curso.setCategory(cursoAtualizado.getCategory());
        }
        return cursoRepository.save(curso);
    }

    public void delete(UUID id){
        CursoEntity curso = this.cursoRepository.findById(id).orElseThrow(
            () -> new ResourceNotFoundException("Curso não encontrado. Verifique o ID")
        );

        cursoRepository.delete(curso);
    }

    public void patch(UUID id){
        CursoEntity curso = this.cursoRepository.findById(id).orElseThrow(
            () -> new ResourceNotFoundException("Curso não encontrado. Verifique o ID")
        );

        boolean status = curso.getActive();
        curso.setActive(!status);
        cursoRepository.save(curso);
    }
}
