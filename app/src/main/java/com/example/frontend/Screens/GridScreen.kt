package com.example.frontend.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.frontend.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GridScreen(navController: NavHostController) {
    Column {
        CenterAlignedTopAppBar(title = {
            Text("GRID SCREEN", fontWeight = FontWeight.Bold)
        })

        val imageResources = listOf(
            R.drawable.image4,
            R.drawable.image2,
            R.drawable.image5,
            R.drawable.image11,
            R.drawable.image12,
            R.drawable.image1,
            R.drawable.image3,
            R.drawable.image13,
            R.drawable.image7,
            R.drawable.image8,
        )
        LazyVerticalGrid(columns = GridCells.Fixed(2), modifier = Modifier.padding(8.dp)) {
            items(imageResources.size) { index ->
                Column(
                    modifier = Modifier
                        .padding(4.dp)
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = imageResources[index]),
                        contentDescription = "Image $index",
                        modifier = Modifier
                            .size(150.dp)
                            .padding(8.dp)
                    )
                    Button(onClick = { navController.navigate("detail/$index/${imageResources[index]}") }) {
                        Text("Photo $index")
                    }
                }
            }
        }
    }
}