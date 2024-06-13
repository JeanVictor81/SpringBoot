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
@Table(name = Janta.TABLE_NAME)

public class Janta{
    public static final String TABLE_NAME  = "Janta";

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name= "id", unique = true)
    private Integer id;

    @ManyToOne
    @JoinColumn(name= "dieta_id", nullable= false, updatable= false)
    private Dieta dieta;

    @Column(name = "alimentos", length = 500, nullable = false)
    private String alimentos;

    @Column(name = "calorias", nullable = false)
    private Integer calorias;

    public Janta() {
    }

    public Janta(Integer id, Dieta dieta, String alimentos, Integer calorias) {
        this.id = id;
        this.dieta = dieta;
        this.alimentos = alimentos;
        this.calorias = calorias;
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

    public Dieta getDieta() {
        return dieta;
    }

    public void setDieta(Dieta dieta) {
        this.dieta = dieta;
    }

    public String getAlimentos() {
        return alimentos;
    }

    public void setAlimentos(String alimentos) {
        this.alimentos = alimentos;
    }

    public Integer getCalorias() {
        return calorias;
    }

    public void setCalorias(Integer calorias) {
        this.calorias = calorias;
    }

    @Override
    public boolean equals(Object obj) {
        if( obj == this)
        return true;
        
        if ( obj == null) 
        return false;

        if (! (obj instanceof Janta))
            return false;
        
        Janta other = (Janta) obj;
        if (this.id != null)
            return false;
        else if (!this.id.equals(other.id)) {
            return false;
        }
        return Objects.equals(this.id, other.id) && Objects.equals(this.dieta, other.dieta);
    }

    @Override
    public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime  * result + ((this.id == null) ? 0 : this.id.hashCode());
            return result;
    }


}