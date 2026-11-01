package com.trabajo3.modelo;

import java.util.Stack;
import java.util.function.Function;

public class Juego {
    private String nombre;
    private int año;
    private EnumJuego tipo;
    private Categoria categoria;
    private Stack<Integer> conteo = new Stack<>();

    public Juego() {
    }

    public Juego(String nombre, int año, EnumJuego tipo, Categoria categoria) {
        this.nombre = nombre;
        this.año = año;
        this.tipo = tipo;
        this.categoria = categoria;
    }

    // Método para agregar datos al Stack conteo (puntajes obtenidos)
    public void agregarConteo(int horas) {
        conteo.push(horas);
    }

    // Punto 5: recibe la función y muestra el total de horas jugadas de cada juego
    public String verTotales(Function<Juego, Integer> funcion) {
        int total = funcion.apply(this);
        String resultado = nombre + " -> Total horas jugadas: " + total;
        System.out.println(resultado);
        return resultado;
    }

    // Sets (uno por atributo)
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setAnio(int año) { this.año = año; }
    public void setTipo(EnumJuego tipo) { this.tipo = tipo; }
    public void setCategoria(Categoria categoria) { this.categoria = categoria; }
    public void setConteo(Stack<Integer> conteo) { this.conteo = conteo; }

    // Gets (los necesitarás para mostrar los datos en Thymeleaf)
    public String getNombre() { return nombre; }
    public int getAño() { return año; }
    public EnumJuego getTipo() { return tipo; }
    public Categoria getCategoria() { return categoria; }
    public Stack<Integer> getConteo() { return conteo; }

    public String descripcion() {
        return "Nombre: " + nombre
                + " | Año: " + año
                + " | Tipo: " + tipo
                + " | Categoría: " + categoria
                + " | Conteo: " + conteo;
    }
}


