package com.proyectoc4.modelo;

public class Carrito {
	public int IdProducto;
	public String Nombre;
	public String Imagen;
	public int Precio;
	public int Cantidad;
	public int SubTotal;

	public int getIdProducto() {
		return IdProducto;
	}

	public void setIdProducto(int idProducto) {
		IdProducto = idProducto;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getImagen() {
		return Imagen;
	}

	public void setImagen(String imagen) {
		Imagen = imagen;
	}

	public int getPrecio() {
		return Precio;
	}

	public void setPrecio(int precio) {
		Precio = precio;
	}

	public int getCantidad() {
		return Cantidad;
	}

	public void setCantidad(int cantidad) {
		Cantidad = cantidad;
	}

	public int getSubTotal() {
		return Precio * Cantidad;
	}

}
