package com.trabajo3.modelo;

import java.util.ArrayDeque;
import java.util.Deque;

public class SerieVideoJuegos {
    private String nombre;
    private String desarrolladora;
    private EnumJuego tipo;
    private Categoria categoria;
    private Deque<Juego> juegos = new ArrayDeque<>();

    public SerieVideoJuegos() {
    }

    public SerieVideoJuegos(String nombre, String desarrolladora, EnumJuego tipo, Categoria categoria) {
        this.nombre = nombre;
        this.desarrolladora = desarrolladora;
        this.tipo = tipo;
        this.categoria = categoria;
    }

    // Método para agregar Juegos al Deque
    public void agregarJuego(Juego juego) {
        juegos.add(juego);
    }

    // Sets
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setDesarrolladora(String desarrolladora) { this.desarrolladora = desarrolladora; }
    public void setTipo(EnumJuego tipo) { this.tipo = tipo; }
    public void setCategoria(Categoria categoria) { this.categoria = categoria; }
    public void setJuegos(Deque<Juego> juegos) { this.juegos = juegos; }

    // Gets
    public String getNombre() { return nombre; }
    public String getDesarrolladora() { return desarrolladora; }
    public EnumJuego getTipo() { return tipo; }
    public Categoria getCategoria() { return categoria; }
    public Deque<Juego> getJuegos() { return juegos; }

    public String descripcion() {
        return "Serie: " + nombre
                + " | Desarrolladora: " + desarrolladora
                + " | Tipo: " + tipo
                + " | Categoría: " + categoria;
    }
}
