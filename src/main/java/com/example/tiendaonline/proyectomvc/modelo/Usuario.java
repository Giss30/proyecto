// Generated with g9.

package com.example.tiendaonline.proyectomvc.modelo;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name="usuario")
public class Usuario implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** Primary key. */
    protected static final String PK = "idusuario";


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false, precision=10)
    private int idusuario;
    @Column(name="Nombre", nullable=false, length=30)
    private String nombre;
    @Column(name="Apepat", nullable=false, length=30)
    private String apepat;
    @Column(name="Apemat", nullable=false, length=30)
    private String apemat;
    @Column(name="Telefono", nullable=false, length=10)
    private String telefono;
    @Column(name="Correo", nullable=false, length=50)
    private String correo;
    @Column(name="Contrasena", nullable=false, length=20)
    private byte[] contrasena;
    @OneToMany(mappedBy="usuario")
    private Set<Direccion> direccion;
    @ManyToOne(optional=false)
    @JoinColumn(name="idrol", nullable=false)
    private Rol rol;
    @OneToMany(mappedBy="usuario")
    private Set<Venta> venta;

    /** Default constructor. */
    public Usuario() {
        super();
    }

    /**
     * Access method for idusuario.
     *
     * @return the current value of idusuario
     */
    public int getIdusuario() {
        return idusuario;
    }

    /**
     * Setter method for idusuario.
     *
     * @param aIdusuario the new value for idusuario
     */
    public void setIdusuario(int aIdusuario) {
        idusuario = aIdusuario;
    }

    /**
     * Access method for nombre.
     *
     * @return the current value of nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Setter method for nombre.
     *
     * @param aNombre the new value for nombre
     */
    public void setNombre(String aNombre) {
        nombre = aNombre;
    }

    /**
     * Access method for apepat.
     *
     * @return the current value of apepat
     */
    public String getApepat() {
        return apepat;
    }

    /**
     * Setter method for apepat.
     *
     * @param aApepat the new value for apepat
     */
    public void setApepat(String aApepat) {
        apepat = aApepat;
    }

    /**
     * Access method for apemat.
     *
     * @return the current value of apemat
     */
    public String getApemat() {
        return apemat;
    }

    /**
     * Setter method for apemat.
     *
     * @param aApemat the new value for apemat
     */
    public void setApemat(String aApemat) {
        apemat = aApemat;
    }

    /**
     * Access method for telefono.
     *
     * @return the current value of telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Setter method for telefono.
     *
     * @param aTelefono the new value for telefono
     */
    public void setTelefono(String aTelefono) {
        telefono = aTelefono;
    }

    /**
     * Access method for correo.
     *
     * @return the current value of correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Setter method for correo.
     *
     * @param aCorreo the new value for correo
     */
    public void setCorreo(String aCorreo) {
        correo = aCorreo;
    }

    /**
     * Access method for contrasena.
     *
     * @return the current value of contrasena
     */
    public byte[] getContrasena() {
        return contrasena;
    }

    /**
     * Setter method for contrasena.
     *
     * @param aContrasena the new value for contrasena
     */
    public void setContrasena(byte[] aContrasena) {
        contrasena = aContrasena;
    }

    /**
     * Access method for direccion.
     *
     * @return the current value of direccion
     */
    public Set<Direccion> getDireccion() {
        return direccion;
    }

    /**
     * Setter method for direccion.
     *
     * @param aDireccion the new value for direccion
     */
    public void setDireccion(Set<Direccion> aDireccion) {
        direccion = aDireccion;
    }

    /**
     * Access method for rol.
     *
     * @return the current value of rol
     */
    public Rol getRol() {
        return rol;
    }

    /**
     * Setter method for rol.
     *
     * @param aRol the new value for rol
     */
    public void setRol(Rol aRol) {
        rol = aRol;
    }

    /**
     * Access method for venta.
     *
     * @return the current value of venta
     */
    public Set<Venta> getVenta() {
        return venta;
    }

    /**
     * Setter method for venta.
     *
     * @param aVenta the new value for venta
     */
    public void setVenta(Set<Venta> aVenta) {
        venta = aVenta;
    }

    /**
     * Compares the key for this instance with another Usuario.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Usuario and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Usuario)) {
            return false;
        }
        Usuario that = (Usuario) other;
        if (this.getIdusuario() != that.getIdusuario()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Usuario.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Usuario)) return false;
        return this.equalKeys(other) && ((Usuario)other).equalKeys(this);
    }

    /**
     * Returns a hash code for this instance.
     *
     * @return Hash code
     */
    @Override
    public int hashCode() {
        int i;
        int result = 17;
        i = getIdusuario();
        result = 37*result + i;
        return result;
    }

    /**
     * Returns a debug-friendly String representation of this instance.
     *
     * @return String representation of this instance
     */
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("[Usuario |");
        sb.append(" idusuario=").append(getIdusuario());
        sb.append("]");
        return sb.toString();
    }

    /**
     * Return all elements of the primary key.
     *
     * @return Map of key names to values
     */
    public Map<String, Object> getPrimaryKey() {
        Map<String, Object> ret = new LinkedHashMap<String, Object>(6);
        ret.put("idusuario", Integer.valueOf(getIdusuario()));
        return ret;
    }

}
