package com.example.baraja.clases

import android.util.Range

class Baraja {

    companion object{

        val listaCartas = ArrayList<Carta>()

        fun crearBaraja(primerNumero:Int){
            listaCartas.clear()
            var contador = primerNumero
            for ((indice,palo) in Palo.values().withIndex())
                for (nombre in Nombre.values()) {
                    listaCartas.add(
                        Carta(
                            nombre,
                            palo,
                            indice,
                            if (nombre == Nombre.AS) 11 else indice,
                            contador
                        )
                    )
                    contador++
                }
        }

        fun barajar(){
            listaCartas.shuffle()
        }

        fun dameCarta():Carta
        {
            val carta = listaCartas.last()
            listaCartas.remove(carta)
            return carta
        }
    }
}