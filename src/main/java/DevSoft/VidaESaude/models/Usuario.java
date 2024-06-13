package DevSoft.VidaESaude.models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = Usuario.TABLE_NAME)
public class Usuario {
    
    public interface CreateUsuario {}

    public interface UpdateUsuario {}

    public static final String TABLE_NAME = "usuario";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Integer id;

    @Column(name = "nome", length = 100, nullable = false, unique = true)
    @NotNull (groups = CreateUsuario.class)
    @NotEmpty (groups = CreateUsuario.class)
    @Size(groups = CreateUsuario.class, min = 2, max=100)
    private String nome;

    @Column(name = "username", length = 50, nullable = false, unique = true)
    @NotNull (groups = CreateUsuario.class)
    @NotEmpty (groups = CreateUsuario.class)
    @Size(groups = CreateUsuario.class, min = 2, max=100)
    private String username;

    @JsonProperty(access = Access.WRITE_ONLY)
    @Column(name = "senha", columnDefinition = "TEXT", nullable = false)
    @NotNull (groups = {CreateUsuario.class, UpdateUsuario.class})
    @NotEmpty (groups = {CreateUsuario.class, UpdateUsuario.class})
    @Size( groups = {CreateUsuario.class, UpdateUsuario.class}, min = 2, max=100)
	private String senha;
    
    @Column (name = "email", length = 250, nullable = false)
    @NotNull (groups = CreateUsuario.class)
    @NotEmpty (groups = CreateUsuario.class)
	private String email;

    @Column(name = "Peso", nullable = false)
    @NotNull (groups = CreateUsuario.class)
    @NotEmpty (groups = CreateUsuario.class)
    private BigDecimal peso;

    @Column(name = "Altura", nullable = false)
    @NotNull (groups = CreateUsuario.class)
    @NotEmpty (groups = CreateUsuario.class)
    private Integer altura;

    @Column(name = "idade", nullable = false)
    @NotNull (groups = CreateUsuario.class)
    @NotEmpty (groups = CreateUsuario.class)
	private Integer idade;

    @Column(name = "Objetivo", length = 100, nullable = false)
    @NotNull (groups = CreateUsuario.class)
    @NotEmpty (groups = CreateUsuario.class)
	private String objetivo;

    @Column(name = "Sexo", length = 20, nullable = false)
    @NotNull (groups = CreateUsuario.class)
    @NotEmpty (groups = CreateUsuario.class)
	private String sexo;

    @OneToMany(mappedBy= "usuario")
    private List<Dieta> dietas = new ArrayList<Dieta>();


    public Usuario() {
    }


    public Usuario(Integer id, String nome, String username, String senha, String email, BigDecimal peso, Integer altura, Integer idade, String objetivo, String sexo) {
        this.id = id;
        this.nome = nome;
        this.username = username;
        this.senha = senha;
        this.email = email;
        this.peso = peso;
        this.altura = altura;
        this.idade = idade;
        this.objetivo = objetivo;
        this.sexo = sexo;
    }


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigDecimal getPeso() {
        return this.peso;
    }

    public void setPeso(BigDecimal peso) {
        this.peso = peso;
    }

    public Integer getAltura() {
        return this.altura;
    }

    public void setAltura(Integer altura) {
        this.altura = altura;
    }

    public Integer getIdade() {
        return this.idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getObjetivo() {
        return this.objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public String getSexo() {
        return this.sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public List<Dieta> getDietas() {
        return dietas;
    }

    public void setDietas(List<Dieta> dietas) {
        this.dietas = dietas;
    }


    @Override
    public boolean equals(Object obj) {
        if( obj == this)
        return true;
        
        if ( obj == null) 
        return false;

        if (! (obj instanceof Usuario))
            return false;
        
        Usuario other =  (Usuario) obj;
        if (this.id != null)
            return false;
        else if (!this.id.equals(other.id)) {
            return false;
        }
        return Objects.equals(this.id, other.id) && Objects.equals(this.username, other.username) && Objects.equals(this.senha, other.senha);
    }

    @Override
    public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime  * result + ((this.id == null) ? 0 : this.id.hashCode());
            return result;
    }

}

