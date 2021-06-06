// Generated with g9.

package com.proyectoc4.modelo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="detalleventa")
public class Detalleventa implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** Primary key. */
    protected static final String PK = "iddetalleventa";


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false, precision=10)
    private int iddetalleventa;
    @Column(name="Fecha")
    private LocalDateTime fecha;
    @Column(name="Precio", nullable=false, precision=10)
    private int precio;
    @Column(name="Cantidad", nullable=false, precision=10)
    private int cantidad;
    @Column(name="Subtotal", nullable=false, precision=10)
    private int subtotal;
    @ManyToOne(optional=false)
    @JoinColumn(name="idproducto", nullable=false)
    private Producto producto;
    @ManyToOne(optional=false)
    @JoinColumn(name="idventa", nullable=false)
    private Venta venta;

    /** Default constructor. */
    public Detalleventa() {
        super();
    }

    /**
     * Access method for iddetalleventa.
     *
     * @return the current value of iddetalleventa
     */
    public int getIddetalleventa() {
        return iddetalleventa;
    }

    /**
     * Setter method for iddetalleventa.
     *
     * @param aIddetalleventa the new value for iddetalleventa
     */
    public void setIddetalleventa(int aIddetalleventa) {
        iddetalleventa = aIddetalleventa;
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
     * Access method for precio.
     *
     * @return the current value of precio
     */
    public int getPrecio() {
        return precio;
    }

    /**
     * Setter method for precio.
     *
     * @param aPrecio the new value for precio
     */
    public void setPrecio(int aPrecio) {
        precio = aPrecio;
    }

    /**
     * Access method for cantidad.
     *
     * @return the current value of cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * Setter method for cantidad.
     *
     * @param aCantidad the new value for cantidad
     */
    public void setCantidad(int aCantidad) {
        cantidad = aCantidad;
    }

    /**
     * Access method for subtotal.
     *
     * @return the current value of subtotal
     */
    public int getSubtotal() {
        return subtotal;
    }

    /**
     * Setter method for subtotal.
     *
     * @param aSubtotal the new value for subtotal
     */
    public void setSubtotal(int aSubtotal) {
        subtotal = aSubtotal;
    }

    /**
     * Access method for producto.
     *
     * @return the current value of producto
     */
    public Producto getProducto() {
        return producto;
    }

    /**
     * Setter method for producto.
     *
     * @param aProducto the new value for producto
     */
    public void setProducto(Producto aProducto) {
        producto = aProducto;
    }

    /**
     * Access method for venta.
     *
     * @return the current value of venta
     */
    public Venta getVenta() {
        return venta;
    }

    /**
     * Setter method for venta.
     *
     * @param aVenta the new value for venta
     */
    public void setVenta(Venta aVenta) {
        venta = aVenta;
    }

    /**
     * Compares the key for this instance with another Detalleventa.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Detalleventa and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Detalleventa)) {
            return false;
        }
        Detalleventa that = (Detalleventa) other;
        if (this.getIddetalleventa() != that.getIddetalleventa()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Detalleventa.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Detalleventa)) return false;
        return this.equalKeys(other) && ((Detalleventa)other).equalKeys(this);
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
        i = getIddetalleventa();
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
        StringBuffer sb = new StringBuffer("[Detalleventa |");
        sb.append(" iddetalleventa=").append(getIddetalleventa());
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
        ret.put("iddetalleventa", Integer.valueOf(getIddetalleventa()));
        return ret;
    }

}
