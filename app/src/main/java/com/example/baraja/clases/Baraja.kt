package com.example.baraja.clases

class Baraja {

    val listaCartas = ArrayList<Carta>()

    fun crearBaraja(){
        for ((indice,palo) in Palo.values().withIndex())
            for (nombre in Nombre.values())
                listaCartas.add(Carta(nombre,palo,indice,if(nombre==Nombre.AS) 11 else indice, 1))
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