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

@Entity(name="producto")
public class Producto implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** Primary key. */
    protected static final String PK = "idproducto";


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false, precision=10)
    private int idproducto;
    @Column(name="Imagen", nullable=false, length=50)
    private String imagen;
    @Column(name="Nombre", nullable=false, length=20)
    private String nombre;
    @Column(name="Modeloproducto", nullable=false, length=15)
    private String modeloproducto;
    @Column(name="Descripcion", nullable=false, length=200)
    private String descripcion;
    @Column(name="Color", nullable=false, length=20)
    private String color;
    @Column(name="Talla", nullable=false, length=10)
    private String talla;
    @Column(name="Cantidad", nullable=false, precision=10)
    private int cantidad;
    @Column(name="Precio", nullable=false, precision=10)
    private int precio;
    @OneToMany(mappedBy="producto")
    private Set<Detalleventa> detalleventa;
    @ManyToOne(optional=false)
    @JoinColumn(name="idcategoria", nullable=false)
    private Categoria categoria;

    /** Default constructor. */
    public Producto() {
        super();
    }

    /**
     * Access method for idproducto.
     *
     * @return the current value of idproducto
     */
    public int getIdproducto() {
        return idproducto;
    }

    /**
     * Setter method for idproducto.
     *
     * @param aIdproducto the new value for idproducto
     */
    public void setIdproducto(int aIdproducto) {
        idproducto = aIdproducto;
    }

    /**
     * Access method for imagen.
     *
     * @return the current value of imagen
     */
    public String getImagen() {
        return imagen;
    }

    /**
     * Setter method for imagen.
     *
     * @param aImagen the new value for imagen
     */
    public void setImagen(String aImagen) {
        imagen = aImagen;
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
     * Access method for modeloproducto.
     *
     * @return the current value of modeloproducto
     */
    public String getModeloproducto() {
        return modeloproducto;
    }

    /**
     * Setter method for modeloproducto.
     *
     * @param aModeloproducto the new value for modeloproducto
     */
    public void setModeloproducto(String aModeloproducto) {
        modeloproducto = aModeloproducto;
    }

    /**
     * Access method for descripcion.
     *
     * @return the current value of descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Setter method for descripcion.
     *
     * @param aDescripcion the new value for descripcion
     */
    public void setDescripcion(String aDescripcion) {
        descripcion = aDescripcion;
    }

    /**
     * Access method for color.
     *
     * @return the current value of color
     */
    public String getColor() {
        return color;
    }

    /**
     * Setter method for color.
     *
     * @param aColor the new value for color
     */
    public void setColor(String aColor) {
        color = aColor;
    }

    /**
     * Access method for talla.
     *
     * @return the current value of talla
     */
    public String getTalla() {
        return talla;
    }

    /**
     * Setter method for talla.
     *
     * @param aTalla the new value for talla
     */
    public void setTalla(String aTalla) {
        talla = aTalla;
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
     * Access method for categoria.
     *
     * @return the current value of categoria
     */
    public Categoria getCategoria() {
        return categoria;
    }

    /**
     * Setter method for categoria.
     *
     * @param aCategoria the new value for categoria
     */
    public void setCategoria(Categoria aCategoria) {
        categoria = aCategoria;
    }

    /**
     * Compares the key for this instance with another Producto.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Producto and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Producto)) {
            return false;
        }
        Producto that = (Producto) other;
        if (this.getIdproducto() != that.getIdproducto()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Producto.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Producto)) return false;
        return this.equalKeys(other) && ((Producto)other).equalKeys(this);
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
        i = getIdproducto();
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
        StringBuffer sb = new StringBuffer("[Producto |");
        sb.append(" idproducto=").append(getIdproducto());
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
        ret.put("idproducto", Integer.valueOf(getIdproducto()));
        return ret;
    }

}
