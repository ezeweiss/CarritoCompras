package ar.edu.unlam.pb2;

import java.util.ArrayList;

public class Caja{
	
	private CarritoCompras carrito;
	private Integer contadorProductosIguales = 0;
	
	public Caja(CarritoCompras carrito) {
		this.carrito = carrito;
	}

	public Integer productosIguales(Integer codigo) {
		for(Producto producto : this.carrito.getListaCarrito()) {
			if(producto.getCodigo().equals(codigo)) {
				this.contadorProductosIguales = this.contadorProductosIguales + 1;
			}
		}
		return this.contadorProductosIguales;
	}

	public CarritoCompras getCarrito() {
		return carrito;
	}


	public void setCarrito(CarritoCompras carrito) {
		this.carrito = carrito;
	}

	public ArrayList<Producto> mostrarLista(){
		return this.getCarrito().getListaCarrito();
	}
}

