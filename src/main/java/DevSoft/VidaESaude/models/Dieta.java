package DevSoft.VidaESaude.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = Dieta.TABLE_NAME)

public class Dieta{
    public static final String TABLE_NAME = "Dieta"; 

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name= "id", unique = true)
    private Integer id;

    @ManyToOne
    @JoinColumn(name= "usuario_id", nullable= false, updatable= false)
    private Usuario usuario;

    public Dieta() {
        
    }

    public Dieta(Integer id, Usuario usuario) {
        this.id = id;
        this.usuario = usuario;
    }

    public static String getTableName() {
        return TABLE_NAME;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    @Override
    public boolean equals(Object obj) {
        if( obj == this)
        return true;
        
        if ( obj == null) 
        return false;

        if (! (obj instanceof Dieta))
            return false;
        
        Dieta other =  (Dieta) obj;
        if (this.id != null)
            return false;
        else if (!this.id.equals(other.id)) {
            return false;
        }
        return Objects.equals(this.id, other.id) && Objects.equals(this.usuario, other.usuario);
    }

    @Override
    public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime  * result + ((this.id == null) ? 0 : this.id.hashCode());
            return result;
    }
    


}