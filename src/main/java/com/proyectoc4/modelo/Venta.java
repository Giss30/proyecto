// Generated with g9.

package com.proyectoc4.modelo;

import java.io.Serializable;
import java.time.LocalDateTime;
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

@Entity(name="venta")
public class Venta implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** Primary key. */
    protected static final String PK = "idventa";


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false, precision=10)
    private int idventa;
    @Column(name="Fecha")
    private LocalDateTime fecha;
    @Column(name="Cantidadproductos", nullable=false, precision=10)
    private int cantidadproductos;
    @Column(name="Total", nullable=false, precision=10)
    private int total;
    @OneToMany(mappedBy="venta")
    private Set<Detalleventa> detalleventa;
    @ManyToOne(optional=false)
    @JoinColumn(name="idusuario", nullable=false)
    private Usuario usuario;

    /** Default constructor. */
    public Venta() {
        super();
    }

    /**
     * Access method for idventa.
     *
     * @return the current value of idventa
     */
    public int getIdventa() {
        return idventa;
    }

    /**
     * Setter method for idventa.
     *
     * @param aIdventa the new value for idventa
     */
    public void setIdventa(int aIdventa) {
        idventa = aIdventa;
    }

    /**
     * Access method for fecha.
     *
     * @return the current value of fecha
     */
    public LocalDateTime getFecha() {
        return fecha;
    }

    /**
     * Setter method for fecha.
     *
     * @param aFecha the new value for fecha
     */
    public void setFecha(LocalDateTime aFecha) {
        fecha = aFecha;
    }

    /**
     * Access method for cantidadproductos.
     *
     * @return the current value of cantidadproductos
     */
    public int getCantidadproductos() {
        return cantidadproductos;
    }

    /**
     * Setter method for cantidadproductos.
     *
     * @param aCantidadproductos the new value for cantidadproductos
     */
    public void setCantidadproductos(int aCantidadproductos) {
        cantidadproductos = aCantidadproductos;
    }

    /**
     * Access method for total.
     *
     * @return the current value of total
     */
    public int getTotal() {
        return total;
    }

    /**
     * Setter method for total.
     *
     * @param aTotal the new value for total
     */
    public void setTotal(int aTotal) {
        total = aTotal;
    }

    /**
     * Access method for detalleventa.
     *
     * @return the current value of detalleventa
     */
    public Set<Detalleventa> getDetalleventa() {
        return detalleventa;
    }

    /**
     * Setter method for detalleventa.
     *
     * @param aDetalleventa the new value for detalleventa
     */
    public void setDetalleventa(Set<Detalleventa> aDetalleventa) {
        detalleventa = aDetalleventa;
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
     * Compares the key for this instance with another Venta.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Venta and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Venta)) {
            return false;
        }
        Venta that = (Venta) other;
        if (this.getIdventa() != that.getIdventa()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Venta.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Venta)) return false;
        return this.equalKeys(other) && ((Venta)other).equalKeys(this);
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
        i = getIdventa();
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
        StringBuffer sb = new StringBuffer("[Venta |");
        sb.append(" idventa=").append(getIdventa());
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
        ret.put("idventa", Integer.valueOf(getIdventa()));
        return ret;
    }

}
