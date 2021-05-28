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
import javax.persistence.OneToMany;

@Entity(name="rol")
public class Rol implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** Primary key. */
    protected static final String PK = "idrol";


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false, precision=10)
    private int idrol;
    @Column(name="Nombre", nullable=false, length=20)
    private String nombre;
    @OneToMany(mappedBy="rol")
    private Set<Usuario> usuario;

    /** Default constructor. */
    public Rol() {
        super();
    }

    /**
     * Access method for idrol.
     *
     * @return the current value of idrol
     */
    public int getIdrol() {
        return idrol;
    }

    /**
     * Setter method for idrol.
     *
     * @param aIdrol the new value for idrol
     */
    public void setIdrol(int aIdrol) {
        idrol = aIdrol;
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
     * Access method for usuario.
     *
     * @return the current value of usuario
     */
    public Set<Usuario> getUsuario() {
        return usuario;
    }

    /**
     * Setter method for usuario.
     *
     * @param aUsuario the new value for usuario
     */
    public void setUsuario(Set<Usuario> aUsuario) {
        usuario = aUsuario;
    }

    /**
     * Compares the key for this instance with another Rol.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Rol and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Rol)) {
            return false;
        }
        Rol that = (Rol) other;
        if (this.getIdrol() != that.getIdrol()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Rol.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Rol)) return false;
        return this.equalKeys(other) && ((Rol)other).equalKeys(this);
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
        i = getIdrol();
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
        StringBuffer sb = new StringBuffer("[Rol |");
        sb.append(" idrol=").append(getIdrol());
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
        ret.put("idrol", Integer.valueOf(getIdrol()));
        return ret;
    }

}
