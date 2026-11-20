/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejecucion;
import java.util.ArrayList;
import logica.Catalogo;
import logica.GestorClientes;
import logica.GestorVentas;
import modelo.Clientes;
import modelo.DetalleVenta;
import modelo.PagoEfectivo;
import modelo.PagoTargeta;
import modelo.Pagos;
import modelo.Productos;
import modelo.Ventas;
import modelo.Frutas;
import modelo.Verduras;
import modelo.Granos;
import org.beryx.textio.TextIO;
import org.beryx.textio.TextIoFactory;
import org.beryx.textio.TextTerminal;

/**
 *
 * @author User
 */
public class Consola {

    private final TextIO textIO;
    private final TextTerminal<?> terminal;
    private final Catalogo catalogo;
    private final GestorClientes gestorClientes;
    private final GestorVentas gestorVentas;

    public Consola() {
        this.textIO = TextIoFactory.getTextIO();
        this.terminal = textIO.getTextTerminal();
        this.catalogo = new Catalogo(new ArrayList<>());
        this.gestorClientes = new GestorClientes(new ArrayList<>());
        this.gestorVentas = new GestorVentas(new ArrayList<>());
    }

    public static void main(String[] args) {
        Consola consola = new Consola();
        consola.mostrarMenu();
    }

    public void mostrarMenu() {
        int opcion;
        do {
            terminal.println("\n=== SISTEMA POS FRUVER ===");
            terminal.println("1. Registrar cliente");
            terminal.println("2. Buscar cliente por documento");
            terminal.println("3. Añadir producto al catálogo");
            terminal.println("4. Listar productos con bajo stock");
            terminal.println("5. Registrar venta");
            terminal.println("6. Generar reporte de ventas");
            terminal.println("7. Listar catálogo completo");
            terminal.println("0. Salir");

            opcion = textIO.newIntInputReader().read("Seleccione una opción");

            switch (opcion) {
                case 1 -> registrarClienteMenu();
                case 2 -> buscarClienteMenu();
                case 3 -> añadirProductoMenu();
                case 4 -> listarBajoStockMenu();
                case 5 -> registrarVentaMenu();
                case 6 -> terminal.println(gestorVentas.generarReportesVentas());
                case 7 -> listarCatalogoMenu();
                case 0 -> terminal.println("Saliendo del sistema...");
                default -> terminal.println("Opción no válida.");
            }
        } while (opcion != 0);
    }

    private void registrarClienteMenu() {
        String nombre = textIO.newStringInputReader().read("Nombre del cliente");
        String cedula = textIO.newStringInputReader().read("Cédula");
        String telefono = textIO.newStringInputReader().read("Teléfono");

        Clientes nuevoCliente = new Clientes(nombre, cedula, telefono);
        gestorClientes.registrarCliente(nuevoCliente);
        terminal.println("Cliente registrado con éxito.");
    }

    private void buscarClienteMenu() {
        String cedula = textIO.newStringInputReader().read("Cédula a buscar");
        Clientes encontrado = gestorClientes.buscarPorDocumento(cedula);

        if (encontrado != null) {
            terminal.println("Cliente encontrado: " + encontrado.getNombre()
                    + " | Cédula: " + encontrado.getCedula()
                    + " | Teléfono: " + encontrado.getTelefono());
        } else {
            terminal.println("No se encontró ningún cliente con esa cédula.");
        }
    }

    private void añadirProductoMenu() {
        int idProducto = textIO.newIntInputReader().read("ID del producto");
        String nombre = textIO.newStringInputReader().read("Nombre del producto");
        int categoria = textIO.newIntInputReader()
                .withPossibleValues(1, 2, 3)
                .read("Categoría (1 = Frutas, 2 = Verduras, 3 = Granos)");
        int stock = textIO.newIntInputReader().read("Stock inicial");
        double precio = textIO.newDoubleInputReader().read("Precio unitario");

        Productos nuevoProducto = switch (categoria) {
            case 1 -> new Frutas("Fruta", nombre, stock, idProducto, precio);
            case 2 -> new Verduras("Verdura", nombre, stock, idProducto, precio);
            default -> new Granos("Grano", nombre, stock, idProducto, precio);
        };

        catalogo.añadirProducto(nuevoProducto);
        terminal.println("Producto añadido al catálogo.");
    }

    private void listarBajoStockMenu() {
        int stockMinimo = textIO.newIntInputReader().read("Stock mínimo de referencia");
        ArrayList<Productos> bajos = catalogo.listarBajoStock(stockMinimo);

        if (bajos.isEmpty()) {
            terminal.println("No hay productos por debajo de ese nivel de stock.");
        } else {
            terminal.println("--- Productos con bajo stock ---");
            for (Productos p : bajos) {
                terminal.println("- ID: " + p.getId()
                        + " | " + p.getNombre()
                        + " | Stock: " + p.getStock());
            }
        }
    }
    
    private void listarCatalogoMenu() {
        ArrayList<Productos> lista = catalogo.obtenerProductos();

        if (lista == null || lista.isEmpty()) {
            terminal.println("El catálogo está vacío.");
        } else {
            terminal.println("\n--- CATÁLOGO DE PRODUCTOS ---");
            for (Productos p : lista) {
                terminal.println("- ID: " + p.getId()
                        + " | " + p.getNombre()
                        + " (" + p.getTipo() + ")"
                        + " | Precio: $" + p.getPrecio()
                        + " | Stock: " + p.getStock());
            }
        }
    }

    private void registrarVentaMenu() {
        int idVenta = textIO.newIntInputReader().read("ID de la venta");
        String cedulaCliente = textIO.newStringInputReader().read("Cédula del cliente");
        Clientes cliente = gestorClientes.buscarPorDocumento(cedulaCliente);

        if (cliente == null) {
            terminal.println("Cliente no encontrado. Regístrelo primero o verifique la cédula.");
            return;
        }

        ArrayList<DetalleVenta> items = new ArrayList<>();

        boolean agregarOtro = true;
        while (agregarOtro) {
            int idProd = textIO.newIntInputReader().read("ID del producto");
            Productos producto = catalogo.buscarPorId(idProd);

            if (producto != null) {
                int cantidad = textIO.newIntInputReader().read("Cantidad");

                if (cantidad <= 0) {
                    terminal.println("La cantidad debe ser mayor que 0.");
                } else if (cantidad > producto.getStock()) {
                    terminal.println("Stock insuficiente. Stock actual: " + producto.getStock());
                } else {
                    double precioCalculado = producto.calcularPrecioVenta(cantidad);
                    DetalleVenta detalle = new DetalleVenta(producto, cantidad, precioCalculado, 0.19);
                    items.add(detalle);

                    int nuevoStock = producto.getStock() - cantidad;
                    producto.actualizarStock(nuevoStock);

                    terminal.println("Producto agregado al detalle. Stock restante: " + producto.getStock());
                }
            } else {
                terminal.println("Producto no encontrado en el catálogo.");
            }

            agregarOtro = textIO.newBooleanInputReader()
                    .withTrueInput("s")
                    .withFalseInput("n")
                    .read("¿Agregar otro producto? (s/n)");
        }

        if (items.isEmpty()) {
            terminal.println("La venta no tiene productos. Operación cancelada.");
            return;
        }

        double totalConIva = 0.0;
        for (DetalleVenta d : items) {
            totalConIva += d.calcularTotalConIva();
        }

        int metodo = textIO.newIntInputReader()
                .withPossibleValues(1, 2)
                .read("Método de pago (1 = Efectivo, 2 = Tarjeta)");
        boolean aprobado = textIO.newBooleanInputReader()
                .withTrueInput("s")
                .withFalseInput("n")
                .read("¿Pago aprobado? (s/n)");

        Pagos pago = (metodo == 2)
                ? new PagoTargeta(idVenta, totalConIva, aprobado)
                : new PagoEfectivo(idVenta, totalConIva, aprobado);

        Ventas venta = new Ventas(idVenta, cliente, items, pago);
        gestorVentas.registrarVentas(venta);

        terminal.println("Venta registrada | Recibo #" + venta.getNumeroRecibo()
                + " | Método: " + pago.obtenerMetodoPago()
                + " | Total con IVA: $" + totalConIva);
    }
}
