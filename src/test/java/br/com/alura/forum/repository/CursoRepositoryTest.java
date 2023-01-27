package br.com.alura.forum.repository;

import br.com.alura.forum.modelo.Curso;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
class CursoRepositoryTest {

    @Autowired
    private CursoRepository repository;

    @Test
    public void shouldGetACursoFoundByNome() {
        String nomeCurso = "HTML 5";
        Curso curso = repository.findByNome(nomeCurso);

        assertNotNull(curso);
        assertEquals(nomeCurso, curso.getNome());
    }

    @Test
    public void shouldNotFindACourseByNameWithAnUnregisteredName() {
        String nomeCurso = "Curso inexistente";
        Curso curso = repository.findByNome(nomeCurso);

        assertNull(curso);
    }


}