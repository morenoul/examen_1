package com.example.examen_1.proveedor

import com.example.examen_1.R
import com.example.examen_1.modelo.TipoAnimal

class ProveedorTipoAnimal {
    companion object{
        var types = listOf<TipoAnimal>(
            TipoAnimal("Algas", R.drawable.algas),
            TipoAnimal("Cnidarios", R.drawable.cnidarios),
            TipoAnimal("Moluscos", R.drawable.moluscos),
            TipoAnimal("Cefalopodos", R.drawable.cefalopodos),
        )

    }
}