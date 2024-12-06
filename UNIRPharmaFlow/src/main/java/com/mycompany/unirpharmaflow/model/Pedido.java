/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.unirpharmaflow.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Representa un pedido de medicamento en el sistema. Incluye detalles sobre el
 * medicamento, el distribuidor y la sucursal.
 *
 * Uso de Lombok para generar código repetitivo de forma automática.
 *
 * @author Angelo
 */
@Data // Genera automáticamente los métodos getters, setters, toString(), equals() y hashCode() para todos los campos.
@NoArgsConstructor // Genera automáticamente un constructor vacío (sin argumentos).
@AllArgsConstructor // Genera automáticamente un constructor que inicializa todos los campos definidos en la clase.
public class Pedido {

    private String nombreMedicamento;
    // Almacena el nombre del medicamento, por ejemplo, "Amoxicilina".

    private String tipoMedicamento;
    // Almacena el tipo del medicamento, por ejemplo, "Antibiótico".

    private int cantidad;
    // Almacena la cantidad del medicamento que se requiere, por ejemplo, 10 unidades.

    private String distribuidor;
    // Almacena el nombre del distribuidor, por ejemplo, "Cofarma".

    private String sucursal;
    // Almacena la dirección o nombre de la sucursal a la que se entregará el medicamento, por ejemplo, "Calle de la Rosa n. 28".

    /**
     * Método que valida los datos del pedido. Verifica que todos los campos del
     * pedido tengan valores válidos.
     *
     * @return true si todos los datos del pedido son válidos, false en caso
     * contrario.
     */
    public boolean esValido() {
        // Validar que todos los campos no sean nulos ni vacíos, y que la cantidad sea mayor que 0.
        return nombreMedicamento != null && !nombreMedicamento.isEmpty()
                && tipoMedicamento != null && !tipoMedicamento.isEmpty()
                && cantidad > 0
                && distribuidor != null && !distribuidor.isEmpty()
                && sucursal != null && !sucursal.isEmpty();
    }
}
