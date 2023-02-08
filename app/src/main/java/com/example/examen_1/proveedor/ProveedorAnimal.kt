package com.example.examen_1.proveedor

import com.example.examen_1.R
import com.example.examen_1.modelo.Animal

class ProveedorAnimal {
    companion object{
        val listaAnimales = listOf(
            Animal(R.drawable.pulpo, "Pulpo"),
            Animal(R.drawable.morena, "Morena"),
            Animal(R.drawable.sardo,"Sardo"),
            Animal(R.drawable.nudibranquio, "Nudibranquio"),
            Animal(R.drawable.medusa, "Medusa")
        )
    }
}