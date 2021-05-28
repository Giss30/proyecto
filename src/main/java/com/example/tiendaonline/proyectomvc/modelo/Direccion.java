// Generated with g9.

package com.example.tiendaonline.proyectomvc.modelo;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="direccion")
public class Direccion implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** Primary key. */
    protected static final String PK = "iddireccion";


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false, precision=10)
    private int iddireccion;
    @Column(name="Calle", nullable=false, length=50)
    private String calle;
    @Column(name="Numext", precision=10)
    private int numext;
    @Column(name="Numint", precision=10)
    private int numint;
    @Column(name="Cp", nullable=false, length=5)
    private String cp;
    @Column(name="Colonia", nullable=false, length=30)
    private String colonia;
    @Column(name="Estado", nullable=false, length=30)
    private String estado;
    @Column(name="Municipio", nullable=false, length=30)
    private String municipio;
    @Column(name="Referencia", nullable=false, length=200)
    private String referencia;
    @ManyToOne(optional=false)
    @JoinColumn(name="idusuario", nullable=false)
    private Usuario usuario;

    /** Default constructor. */
    public Direccion() {
        super();
    }

    /**
     * Access method for iddireccion.
     *
     * @return the current value of iddireccion
     */
    public int getIddireccion() {
        return iddireccion;
    }

    /**
     * Setter method for iddireccion.
     *
     * @param aIddireccion the new value for iddireccion
     */
    public void setIddireccion(int aIddireccion) {
        iddireccion = aIddireccion;
    }

    /**
     * Access method for calle.
     *
     * @return the current value of calle
     */
    public String getCalle() {
        return calle;
    }

    /**
     * Setter method for calle.
     *
     * @param aCalle the new value for calle
     */
    public void setCalle(String aCalle) {
        calle = aCalle;
    }

    /**
     * Access method for numext.
     *
     * @return the current value of numext
     */
    public int getNumext() {
        return numext;
    }

    /**
     * Setter method for numext.
     *
     * @param aNumext the new value for numext
     */
    public void setNumext(int aNumext) {
        numext = aNumext;
    }

    /**
     * Access method for numint.
     *
     * @return the current value of numint
     */
    public int getNumint() {
        return numint;
    }

    /**
     * Setter method for numint.
     *
     * @param aNumint the new value for numint
     */
    public void setNumint(int aNumint) {
        numint = aNumint;
    }

    /**
     * Access method for cp.
     *
     * @return the current value of cp
     */
    public String getCp() {
        return cp;
    }

    /**
     * Setter method for cp.
     *
     * @param aCp the new value for cp
     */
    public void setCp(String aCp) {
        cp = aCp;
    }

    /**
     * Access method for colonia.
     *
     * @return the current value of colonia
     */
    public String getColonia() {
        return colonia;
    }

    /**
     * Setter method for colonia.
     *
     * @param aColonia the new value for colonia
     */
    public void setColonia(String aColonia) {
        colonia = aColonia;
    }

    /**
     * Access method for estado.
     *
     * @return the current value of estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Setter method for estado.
     *
     * @param aEstado the new value for estado
     */
    public void setEstado(String aEstado) {
        estado = aEstado;
    }

    /**
     * Access method for municipio.
     *
     * @return the current value of municipio
     */
    public String getMunicipio() {
        return municipio;
    }

    /**
     * Setter method for municipio.
     *
     * @param aMunicipio the new value for municipio
     */
    public void setMunicipio(String aMunicipio) {
        municipio = aMunicipio;
    }

    /**
     * Access method for referencia.
     *
     * @return the current value of referencia
     */
    public String getReferencia() {
        return referencia;
    }

    /**
     * Setter method for referencia.
     *
     * @param aReferencia the new value for referencia
     */
    public void setReferencia(String aReferencia) {
        referencia = aReferencia;
    }

    /**
     * Access method for usuario.
     *
     * @return the current value of usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * Setter method for usuario.
     *
     * @param aUsuario the new value for usuario
     */
    public void setUsuario(Usuario aUsuario) {
        usuario = aUsuario;
    }

    /**
     * Compares the key for this instance with another Direccion.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Direccion and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Direccion)) {
            return false;
        }
        Direccion that = (Direccion) other;
        if (this.getIddireccion() != that.getIddireccion()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Direccion.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Direccion)) return false;
        return this.equalKeys(other) && ((Direccion)other).equalKeys(this);
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
        i = getIddireccion();
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
        StringBuffer sb = new StringBuffer("[Direccion |");
        sb.append(" iddireccion=").append(getIddireccion());
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
        ret.put("iddireccion", Integer.valueOf(getIddireccion()));
        return ret;
    }

}
