package DevSoft.VidaESaude.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import DevSoft.VidaESaude.models.Dieta;
import DevSoft.VidaESaude.repositories.DietaRepositories;

public class DietaService {
    
    @Autowired
    private DietaRepositories dietaRepositories;

    @Autowired
    private UsuarioService usuarioService;

    public Dieta findById(Integer id){
        Optional<Dieta> usuario = this.dietaRepositories.findById(id);
        return usuario.orElseThrow(() -> new RuntimeException(
            "Dieta nao encontrado"
        ));
    }

}
