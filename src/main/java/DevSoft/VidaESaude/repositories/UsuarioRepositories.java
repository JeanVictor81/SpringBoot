package DevSoft.VidaESaude.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import DevSoft.VidaESaude.models.Usuario;

@Repository
public interface  UsuarioRepositories extends  JpaRepository<Usuario, Integer> {
    
}
