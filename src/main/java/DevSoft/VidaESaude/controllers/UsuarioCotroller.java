package DevSoft.VidaESaude.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import DevSoft.VidaESaude.models.Usuario;
import DevSoft.VidaESaude.service.UsuarioService;


@RestController

@RequestMapping("/usuario")
@Validated

public class UsuarioCotroller {
    
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable Integer id){
        Usuario obj = this.usuarioService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

}
