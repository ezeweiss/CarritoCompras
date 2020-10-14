package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class TestCarrito {

	@Test
	public void testQueVerifiqueQueSeAgregoUnProductoAlCarrito() {
		Producto miProducto = new Producto("Carne",300.0, 123);
		Producto miProducto2 = new Producto("Carne",300.0, 123);
		CarritoCompras miCarrito = new CarritoCompras();
		
		miCarrito.agregarProductos(miProducto);
		
		assertTrue(miCarrito.getListaCarrito().contains(miProducto));	
	}

	
	@Test
	public void testQueBusqueUnProductoPorCodigo() {
		Producto miProducto = new Producto("Espinaca",100.0, 123);
		Producto miProducto2 = new Producto ("Carbon", 200.0, 222);
		CarritoCompras miCarrito = new CarritoCompras();
	
		miCarrito.agregarProductos(miProducto);
		miCarrito.agregarProductos(miProducto2);
		
		Integer codigo = 123;
		Producto productoBuscado = miCarrito.buscarProductosPorCodigo(codigo);
		assertEquals(codigo, productoBuscado.getCodigo());
		
	}
	
	@Test
	public void testQueMuestreLaLista() {
		Producto miProducto = new Producto("Espinaca",100.0, 123);
		Producto miProducto2 = new Producto ("Carbon", 200.0, 222);
		Producto miProducto3 = new Producto("Espinaca",100.0, 123);
		Producto miProducto4 = new Producto("Espinaca",100.0, 123);
		CarritoCompras miCarrito = new CarritoCompras();
		
		miCarrito.agregarProductos(miProducto);
		miCarrito.agregarProductos(miProducto2);
		miCarrito.agregarProductos(miProducto3);
		miCarrito.agregarProductos(miProducto4);
		
		ArrayList<Producto> listaProducto = miCarrito.getListaCarrito();
		
		for(Producto producto : listaProducto) {
			System.out.println(producto);
		}
	}
	
	@Test 
	public void testQueApliqueDescuentoAProductosIguales() {
		Producto miProducto = new Producto("Espinaca",300.0, 123);
		Producto miProducto2 = new Producto ("Carbon", 200.0, 222);
		Producto miProducto3 = new Producto("Espinaca",300.0, 123);
		Producto miProducto4 = new Producto("Espinaca",300.0, 123);
		Producto miProducto5 = new Producto("Espinaca", 300.0,123);
		CarritoCompras miCarrito = new CarritoCompras();
		
		miCarrito.agregarProductos(miProducto);
		miCarrito.agregarProductos(miProducto2);
		miCarrito.agregarProductos(miProducto3);
		miCarrito.agregarProductos(miProducto4);
		miCarrito.agregarProductos(miProducto5);
		
		Double valorEsperado = 880.0;
		Double valorObtenido = miCarrito.aplicarDescuento(123);
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void testQueCuenteProductosIguales() {
		Producto miProducto = new Producto("Espinaca",100.0, 123);
		Producto miProducto2 = new Producto ("Espinaca", 100.0, 123);
		Producto miProducto3 = new Producto("Pollo", 300.0, 444);
		CarritoCompras miCarrito = new CarritoCompras();
		Caja miCaja = new Caja(miCarrito);
		
		miCarrito.agregarProductos(miProducto);
		miCarrito.agregarProductos(miProducto2);
		miCarrito.agregarProductos(miProducto3);
		
		Integer valorEsperado = 2;
		Integer valorObtenido = miCaja.productosIguales(123);
		assertEquals(valorEsperado,valorObtenido);
	}
	
	@Test
	public void testQueCuenteLaCantidadDeProductosQueHayEnElCarrito() {
		Producto miProducto = new Producto("Espinaca",100.0, 123);
		Producto miProducto2 = new Producto ("Espinaca", 100.0, 123);
		Producto miProducto3 = new Producto("Pollo", 300.0, 444);
		Producto miProducto4 = new Producto("Yerba", 150.0,555);
		CarritoCompras miCarrito = new CarritoCompras();
		
		miCarrito.agregarProductos(miProducto);
		miCarrito.agregarProductos(miProducto2);
		miCarrito.agregarProductos(miProducto3);
		miCarrito.agregarProductos(miProducto4);
		
		Integer valorEsperado = 4;
		Integer valorObtenido = miCarrito.obtenerCantidadProductoEnElCarrito();
		assertEquals(valorEsperado, valorObtenido);
	}
}
