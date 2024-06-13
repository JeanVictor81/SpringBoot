package DevSoft.VidaESaude.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import DevSoft.VidaESaude.models.Dieta;


public interface DietaRepositories extends JpaRepository<Dieta, Integer> {
    
    List<Dieta> findByUsuario_Id(Integer id);
}
