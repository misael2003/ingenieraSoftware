package mx.unam.fesAragon.celulares.CELULAR.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="celular")
public class Celular {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int clave;

    @Column(name="modelo",nullable = false,length = 80)
    @NotBlank(message = "No se permiten espacios en blancos")
    private String modelo;

    @Column(name="marca",nullable = true,length = 80)
    private String marca;

    @Column(name="precio",nullable = true)
    private float precio;

    // constructores

    public Celular(){}
    public Celular(int clave, String modelo, String marca, float precio) {
        this.clave = clave;
        this.modelo = modelo;
        this.marca = marca;
        this.precio = precio;
    }

    // getters and setters

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
}
