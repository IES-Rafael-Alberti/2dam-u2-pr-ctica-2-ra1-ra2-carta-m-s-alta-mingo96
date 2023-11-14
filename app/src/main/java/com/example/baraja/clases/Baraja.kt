package com.example.baraja.clases

import android.util.Range

class Baraja {

    companion object {


        val listaCartas = ArrayList<Carta>()

        var cartaActual=Carta()

        fun crearBaraja(primerNumero: Int) {
            listaCartas.clear()
            var contador = primerNumero
            for (palo in Palo.values())
                for ((indice, nombre) in Nombre.values().withIndex()) {
                    listaCartas.add(
                        Carta(
                            nombre,
                            palo,
                            indice + 1,
                            if (nombre == Nombre.AS) 11 else indice + 1,
                            contador
                        )
                    )
                    contador++
                }
            dameCarta()
        }

        fun barajar() {
            listaCartas.shuffle()
        }

        fun dameCarta(): Carta {
            val carta = listaCartas.last()
            listaCartas.removeLast()
            cartaActual = carta
            return carta
        }
    }
}