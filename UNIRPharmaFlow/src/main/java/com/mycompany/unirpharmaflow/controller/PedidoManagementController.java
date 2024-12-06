/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.unirpharmaflow.controller;

import com.mycompany.unirpharmaflow.model.Distribuidor;
import com.mycompany.unirpharmaflow.model.Pedido;
import com.mycompany.unirpharmaflow.view.FormularioPedidoVista;

/**
 * Controlador principal para la gestión de pedidos. Realiza validaciones y
 * conecta datos entre la vista y los modelos.
 *
 * @author Angelo
 */
public class PedidoManagementController {

    // Referencia a la vista para interactuar con la interfaz del usuario.
    private final FormularioPedidoVista vista;

    /**
     * Constructor de la clase PedidoController.
     *
     * @param vista La vista con la que interactuará este controlador.
     */
    public PedidoManagementController(FormularioPedidoVista vista) {
        this.vista = vista; // Asigna la vista al controlador.
    }

    /**
     * Método principal para confirmar un pedido. Realiza validaciones,
     * construye el modelo Pedido y muestra el resumen.
     */
    public void ConfirmarPedido() {
        // Validaciones de entrada a través de un método auxiliar.
        if (!ValidarEntrada()) {
            return; // Si hay errores en las validaciones, detiene la ejecución.
        }

        // Recupera los datos necesarios de la vista tras las validaciones exitosas.
        String nombre = vista.GetNombreMedicamento(); // Obtiene el nombre del medicamento.
        String tipo = vista.GetTipoMedicamento();     // Obtiene el tipo del medicamento.
        int cantidad = Integer.parseInt(vista.GetCantidad()); // Convierte la cantidad a entero.
        Distribuidor distribuidor = vista.GetDistribuidorSeleccionado(); // Obtiene el distribuidor seleccionado.

        // Determina la sucursal utilizando un operador ternario.
        String sucursal = vista.IsSucursalPrincipalSeleccionada()
                ? "Para la farmacia situada en Calle de la Rosa n. 28"
                : "Para la farmacia situada en Calle Alcazabilla n. 3";

        // Crea una instancia del modelo Pedido con los datos proporcionados.
        Pedido pedido = new Pedido(nombre, tipo, cantidad, distribuidor.getNombre(), sucursal);

        // Muestra el resumen del pedido a través de la vista.
        vista.MostrarResumenPedido(pedido);
    }

    /**
     * Método auxiliar para validar los datos de entrada del pedido.
     *
     * @return true si todos los datos son válidos, false en caso contrario.
     */
    private boolean ValidarEntrada() {
        // Recupera los datos ingresados por el usuario desde la vista.
        String nombre = vista.GetNombreMedicamento();
        String tipo = vista.GetTipoMedicamento();
        String cantidadStr = vista.GetCantidad(); // La cantidad como cadena de texto.
        Distribuidor distribuidor = vista.GetDistribuidorSeleccionado(); // Distribuidor seleccionado.

        // Validación del nombre del medicamento.
        if (nombre == null || nombre.isBlank() || !nombre.matches("[a-zA-Z0-9áéíóúÁÉÍÓÚñÑ ]+")) {
            vista.MostrarError("El nombre del medicamento es inválido.");
            return false; // Detiene la validación si el nombre no es válido.
        }

        // Validación del tipo de medicamento.
        if (tipo == null || tipo.isBlank() || tipo.length() <= 1) {
            vista.MostrarError("Debe seleccionar un tipo de medicamento.");
            return false; // Detiene la validación si el tipo no es válido.
        }

        // Validación de la cantidad ingresada.
        if (cantidadStr == null || cantidadStr.isBlank()) {
            vista.MostrarError("La cantidad no puede estar vacía.");
            return false; // Detiene la validación si la cantidad está vacía.
        }

        try {
            // Intenta convertir la cantidad a un número entero.
            int cantidad = Integer.parseInt(cantidadStr);
            if (cantidad <= 0) {
                vista.MostrarError("La cantidad debe ser un número entero positivo.");
                return false; // Detiene la validación si la cantidad no es positiva.
            }
        } catch (NumberFormatException e) {
            // Captura errores si la cantidad no es un número válido.
            vista.MostrarError("La cantidad debe ser un número entero.");
            return false;
        }

        // Validación del distribuidor.
        if (distribuidor == null) {
            vista.MostrarError("Debe seleccionar un distribuidor.");
            return false; // Detiene la validación si no hay un distribuidor seleccionado.
        }

        // Validación de la sucursal seleccionada.
        if (!vista.IsSucursalPrincipalSeleccionada() && !vista.IsSucursalSecundariaSeleccionada()) {
            vista.MostrarError("Debe seleccionar al menos una sucursal.");
            return false; // Detiene la validación si no se selecciona ninguna sucursal.
        }

        return true; // Retorna true si todas las validaciones son exitosas.
    }
}
