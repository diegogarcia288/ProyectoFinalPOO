# Fruver TU FRUTA MADRE 
# BY: Diego García, Eduardo Carrera, Ana Tabares

*Nuestro negocio vende todo tipo de revueltos:*

• Verduras: Brocoli, Cebolla, Pimentón, Zanahoria, Pepino.

• Frutas: Manzana, Banano, Aguacate, Mandarina, Tomate.

• Granos: Arroz, Maíz, Lentejas, Caraotas, Trigo.

*Medios de Pago:*

• Transferencia
• Efectivo.

# CLASES, MÉTODOS, ATRIBUTOS, RELACIONES:

*Clases, atributos y métodos*

PRODUCTOS (Se asocia con Catalogos , Se asocia con DetalleVenta) :

• Atributos: Tipo de producto, nombre, stock, IdProducto, precio

• Métodos: actualizarPrecio(nuevoPrecio : double) , calcularPrecioVenta(cantidad : int) , actualizarStock(nuevoStock : int)

PERSONAS: 

• Atributos: Nombre, Cédula

VERDURAS -- (Hereda de productos)

• Métodos: Sobrescribe métodos de Productos

FRUTAS -- (Hereda de productos)

• Métodos: Sobrescribe métodos de Productos

GRANOS -- (Hereda de productos)

• Métodos: Sobrescribe métodos de Productos

CLIENTES -- (Hereda de personas , Se asocia con GestorClientes):

• Atributos: Teléfono

VENTAS (Relación de Composición con DetalleVenta y se asocia con GestorVentas):

• Atributos: idVenta, Cliente, numeroRecibo, contadorVentas, items, pago

DETALLEVENTA (Relación de Composición con Ventas):

• Atributos: producto, cantidad, total, iva.

• Métodos: calcularSubTotal() , calcularTotalConIva()

PAGOS (Se asocia con Ventas):

• Atributos: idPago, monto, estadoPago.

• Métodos: obtenerMetodoPago

PAGOEFECTIVO (Hereda de Pagos)

PAGOTARGETA (Hereda de Pagos)

GestorVentas

• Atributos: venta

• Métodos: registrarVentas(Ventas nuevaVenta) , generarReportesVentas()

GestorClientes

• Atributos: cliente

• Métodos: registrarCliente(Clientes nuevoCliente) , buscarPorDocumento(String Cedula)

Catalogo

• Atributos: producto

• Métodos: añadirProducto(Productos nuevoProducto) , buscarPorId(int idProducto) , listarBajoStock(int stockBajo) , obtenerProductos()

Console (depende de GestorVentas, GestorClientes, Catalogo) :

• Atributos: textIO

• Métodos:  main(args: String[]): void ,  mostrarMenu(): void ,  registrarClienteMenu(): void , buscarClienteMenu(): void , buscarClienteMenu(): void , buscarClienteMenu(): void , añadirProductoMenu(): void , listarBajoStockMenu(): void , registrarVentaMenu(): void , listarCatalogoMenu(): void

















