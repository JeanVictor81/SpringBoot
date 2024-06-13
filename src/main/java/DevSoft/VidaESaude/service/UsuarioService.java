package DevSoft.VidaESaude.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import DevSoft.VidaESaude.models.Usuario;
import DevSoft.VidaESaude.repositories.UsuarioRepositories;



@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepositories usuarioRepositories;

    public Usuario findById(Integer id){
        Optional<Usuario> usuario = this.usuarioRepositories.findById(id);
        return usuario.orElseThrow(() -> new RuntimeException(
            "Usuario nao encontrado"
        ));  
    }

    @Transactional
    public Usuario create(Usuario obj){
        obj.setId(null);
        obj = this.usuarioRepositories.save(obj);
        return obj;
    }

    @Transactional
    public Usuario update(Usuario obj){
        Usuario newObj = findById(obj.getId());
        newObj.setSenha(obj.getSenha());
        return this.usuarioRepositories.save(newObj);
    }

}
