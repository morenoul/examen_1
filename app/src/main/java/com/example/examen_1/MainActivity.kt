package com.example.examen_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.examen_1.modelo.Animal
import com.example.examen_1.modelo.TipoAnimal
import com.example.examen_1.proveedor.ProveedorAnimal
import com.example.examen_1.proveedor.ProveedorButtonBar
import com.example.examen_1.proveedor.ProveedorTipoAnimal
import com.example.examen_1.ui.theme.Examen_1Theme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Examen_1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.secondary
                ) {
                    Column(modifier = Modifier.fillMaxSize()) {

                        Spacer(modifier = Modifier.height(8.dp))
                        AnimalList()
                        Spacer(modifier = Modifier.height(8.dp))
                        TipoAnimalList()
                        Spacer(modifier = Modifier.height(8.dp))
                        NavegadorBar()

                    }
                }
            }
        }
    }

    // lista de categorias
    @Composable
    fun AnimalList(modifier: Modifier = Modifier) {
        Column(modifier = modifier) {
            Text(
                text = "Animales marinos".uppercase(),
                style = MaterialTheme.typography.titleLarge,
                modifier = modifier.padding(8.dp)
            )
            LazyRow(modifier = Modifier.padding(8.dp)) {
                items(ProveedorAnimal.listaAnimales.size) {
                    Animal(animal = ProveedorAnimal.listaAnimales[it])
                }
            }
        }
    }

    @Composable
    fun Animal(modifier: Modifier = Modifier, animal: Animal) {
        Column(
            modifier = modifier.padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // imagen
            Image(
                painter = painterResource(
                    id = animal.image,
                ), contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = modifier
                    .size(88.dp)
                    .clip(CircleShape)
            )
            // descripcion
            Text(
                text = animal.title,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.paddingFromBaseline(top = 24.dp, bottom = 8.dp)
            )
        }
    }

    // lista de colecciones
    @Composable
    fun TipoAnimalList(modifier: Modifier = Modifier) {
        Column(modifier = modifier) {
            Text(
                text = "Especies marinas".uppercase(),
                style = MaterialTheme.typography.titleLarge,
                modifier = modifier.padding(8.dp)
            )

            LazyHorizontalGrid(
                rows = GridCells.Fixed(2),
                contentPadding = PaddingValues(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = modifier.height(120.dp)
            ) {
                items(ProveedorTipoAnimal.types.size) {
                    TipoAnimalItemContainer(tipoanimal = ProveedorTipoAnimal.types[it])
                }
            }
        }

    }

    @Composable
    fun TipoAnimalItemContainer(modifier: Modifier = Modifier, tipoanimal: TipoAnimal) {
        Surface(modifier = modifier, shape = MaterialTheme.shapes.small) {

            Row(modifier = modifier.width(192.dp), verticalAlignment = Alignment.CenterVertically) {
                // imagen
                Image(
                    painter = painterResource(
                        id = tipoanimal.image,
                    ), contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = modifier
                        .size(56.dp)
                )
                // descripcion
                Text(
                    text = tipoanimal.tipo,
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier
                        .paddingFromBaseline(top = 24.dp, bottom = 8.dp)
                        .padding(8.dp)
                )
            }
        }
    }

    // Navigation bar Bottom
    @Composable
    fun BottomNavigation(modifier: Modifier = Modifier) {
        var selectedItem by remember { mutableStateOf(0) }
        val items = ProveedorButtonBar.icons

        Row(
            modifier = modifier,
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.Center
        ) {
            NavigationBar {
                items.forEachIndexed { index, item ->
                    NavigationBarItem(
                        icon = {
                            item.icon?.let {
                                Icon(
                                    imageVector = it,
                                    contentDescription = null,
                                    tint = if (selectedItem == index) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onBackground
                                )
                            }
                        },
                        label = {
                            Text(
                                text = item.title,
                                style = MaterialTheme.typography.titleMedium,
                                color = if (selectedItem == index) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onBackground
                            )
                        },
                        selected = selectedItem == index,
                        onClick = {
                            selectedItem = index
                        }
                    )
                }
            }
        }

    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun NavegadorBar() {
        Examen_1Theme {
            Scaffold(
                bottomBar = { BottomNavigation() }
            ) { padding ->
                HomeScreen(Modifier.padding(padding))
            }
        }
    }

    @Composable
    fun HomeScreen(padding: Modifier) {
        Surface(color = MaterialTheme.colorScheme.secondary, modifier = Modifier.fillMaxSize()) {
            Column(verticalArrangement = Arrangement.Bottom, horizontalAlignment = Alignment.End) {
            }
        }
    }

    @Preview(showBackground = false)
    @Composable
    fun DefaultPreview() {
        Examen_1Theme {
        }
    }
}