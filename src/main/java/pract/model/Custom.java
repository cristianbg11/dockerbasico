package pract.model;

import org.apache.commons.codec.binary.Base64;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class Custom implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;
    @Column(name = "cedula", unique = true, nullable = false)
    @NotEmpty(message = "Cedula no puede estar vacia.")
    private String cedula;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Photo foto;

    public Custom() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public Photo getFoto() {
        return foto;
    }

    public void setFoto(Photo foto) {
        this.foto = foto;
    }

    @Transient
    public String representacionFoto() {
        byte[] imgBytesAsBase64 = Base64.encodeBase64(foto.getData());
        String imgDataAsBase64 = new String(imgBytesAsBase64);

        return "data:image/png;base64," + imgDataAsBase64;
    }
}
