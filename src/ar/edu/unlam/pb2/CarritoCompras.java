package ar.edu.unlam.pb2;

import java.util.ArrayList;

public class CarritoCompras{
	
	private ArrayList<Producto> listaCarrito = new ArrayList<Producto>();
	private Integer contadorProductosIguales = 0;
	
	public Boolean agregarProductos(Producto producto) {
		return this.listaCarrito.add(producto);
	}
	
	
	public Producto buscarProductosPorCodigo(Integer codigo) {
		for(Producto producto : this.listaCarrito) {
			if(producto.getCodigo().equals(codigo)) {
				return producto;
			}
		}
		return null;
		
	}
	
	public Integer obtenerCantidadProductoEnElCarrito() {
		return this.listaCarrito.size();
	}
	
	public Double aplicarDescuento(Integer codigo) {
		Double descuento = 0.0;	
		Double acumulador = 0.0;
		
		for(Producto producto : this.listaCarrito) {
			if(producto.getCodigo().equals(codigo) ) {
				acumulador = acumulador + producto.getPrecio();
				 this.contadorProductosIguales  = this.contadorProductosIguales + 1;
			}	
			if(this.contadorProductosIguales.equals(3)) {
				descuento = acumulador - 20.0;
				return descuento;	
			}
		}
		return null;
	}

	public ArrayList<Producto> getListaCarrito() {
		return listaCarrito;
	}

	public void setListaCarrito(ArrayList<Producto> listaCarrito) {
		this.listaCarrito = listaCarrito;
	}


	
	
}
