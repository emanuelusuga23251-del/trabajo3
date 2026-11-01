package com.trabajo3.repositories;

import com.trabajo3.modelo.Categoria;
import com.trabajo3.modelo.EnumJuego;
import com.trabajo3.modelo.Juego;
import com.trabajo3.modelo.SerieVideoJuegos;
import org.springframework.stereotype.Repository;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.function.Function;

import java.util.*;


@Repository
public class JuegoRepository {

    private Stack<Juego> pilaJuegos = new Stack<>();
    private SerieVideoJuegos serie;
    private Function<Juego, Integer> sumaConteo =
            j -> j.getConteo().stream().mapToInt(Integer::intValue).sum();

    public JuegoRepository() {
        // 5 juegos con los MISMOS enums (ACCION y BASICO)
        Juego j1 = new Juego("GTA 5 ", 2013, EnumJuego.ACCION, Categoria.BASICO);
        Juego j2 = new Juego("Doom", 1993, EnumJuego.ACCION, Categoria.BASICO);
        Juego j3 = new Juego("call of Duty", 2009, EnumJuego.ACCION, Categoria.BASICO);
        Juego j4 = new Juego("God of war", 2007, EnumJuego.ACCION, Categoria.BASICO);
        Juego j5 = new Juego("Devil May Cray 3", 2018, EnumJuego.ACCION, Categoria.BASICO);

        // Datos en el Stack conteo de cada juego
        j1.agregarConteo(10); j1.agregarConteo(20);
        j2.agregarConteo(5);
        j3.agregarConteo(30); j3.agregarConteo(15); j3.agregarConteo(8);
        j4.agregarConteo(12);
        j5.agregarConteo(40); j5.agregarConteo(25);

        // Stack con los 5 objetos
        pilaJuegos.push(j1);
        pilaJuegos.push(j2);
        pilaJuegos.push(j3);
        pilaJuegos.push(j4);
        pilaJuegos.push(j5);

        // Objeto de la serie, con los mismos enums
        serie = new SerieVideoJuegos("Mi Serie", "Estudio X", EnumJuego.ACCION, Categoria.BASICO);

        // Agregar los 5 juegos al Deque usando su método
        serie.agregarJuego(j1);
        serie.agregarJuego(j2);
        serie.agregarJuego(j3);
        serie.agregarJuego(j4);
        serie.agregarJuego(j5);
    }

    public List<String> filtrarPorTipo(EnumJuego tipoBuscado) {
        Deque<Juego> dequeJuegos = new ArrayDeque<>(pilaJuegos);

        List<String> salida = new ArrayList<>();
        dequeJuegos.stream()
                .filter(j -> j.getTipo() == tipoBuscado)
                .forEach(j -> {
                    System.out.println(j.descripcion());
                    salida.add(j.descripcion());
                });
        return salida;
    }

    // Punto 4: ejecutar la función con apply
    public List<String> totalesPorJuego() {
        List<String> salida = new ArrayList<>();
        for (Juego j : pilaJuegos) {
            int total = sumaConteo.apply(j);
            String linea = j.getNombre() + " -> Total horas jugadas: " + total;
            System.out.println(linea);
            salida.add(linea);
        }
        return salida;
    }

    // Lo necesitaremos en el Punto 5
    public Function<Juego, Integer> getSumaConteo() {
        return sumaConteo;
    }



    public Stack<Juego> getPilaJuegos() { return pilaJuegos; }
    public SerieVideoJuegos getSerie() { return serie; }

    public List<String> recorrerPila() {
        List<String> salida = new ArrayList<>();
        ListIterator<Juego> it = pilaJuegos.listIterator();
        while (it.hasNext()) {
            Juego j = it.next();
            System.out.println(j.descripcion());
            salida.add(j.descripcion());
        }
        return salida;
    }

    // Punto 2b: recorrer el Deque de la serie con Iterator
    public List<String> recorrerSerie() {
        List<String> salida = new ArrayList<>();
        salida.add(serie.descripcion());
        Iterator<Juego> it = serie.getJuegos().iterator();
        while (it.hasNext()) {
            Juego j = it.next();
            System.out.println(j.descripcion());
            salida.add(j.descripcion());
        }
        return salida;
    }
    // Punto 5: llamar verTotales desde un objeto ya creado
    public String totalDeUnJuego() {
        Juego elegido = pilaJuegos.get(0); // por ejemplo, GTA 5
        return elegido.verTotales(sumaConteo);
    }
}
