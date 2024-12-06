/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.unirpharmaflow.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Representa un distribuidor en el sistema. Incluye el nombre del distribuidor
 * y su dirección.
 *
 * Uso de Lombok para reducir el código manual.
 *
 * @author Angelo
 */
@Data // Genera automáticamente getters, setters, toString(), equals() y hashCode() para los campos definidos.
@NoArgsConstructor // Genera automáticamente un constructor vacío (sin argumentos).
@AllArgsConstructor // Genera automáticamente un constructor que inicializa todos los campos definidos.
public class Distribuidor {

    private String nombre;
    // Almacena el nombre del distribuidor (por ejemplo, "Cofarma").

    private String direccion;
    // Almacena la dirección del distribuidor (por ejemplo, "Calle Principal 123").
}
