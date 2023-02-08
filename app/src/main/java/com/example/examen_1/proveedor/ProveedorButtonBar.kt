package com.example.examen_1.proveedor

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import com.example.examen_1.modelo.ButtonBar

class ProveedorButtonBar {
    companion object{
        val icons = listOf<ButtonBar>(
            ButtonBar(Icons.Filled.Favorite, "Like"),
            ButtonBar(Icons.Default.ArrowBack, "Atrás"),
        )
    }
}