package com.example.frontend.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.frontend.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListScreen(navController: NavHostController) {
    Column {
        CenterAlignedTopAppBar(title = {
            Text("LIST SCREEN", fontWeight = FontWeight.Bold)
        })

        val lazyrowResources = listOf(
            R.drawable.image3,
            R.drawable.image7,
            R.drawable.image8,
            R.drawable.image19,
            R.drawable.image5,
            R.drawable.image17,
            R.drawable.image22,
            R.drawable.image9,
            R.drawable.image14,
            R.drawable.image1,
        )

        val lazycolumnResources = listOf(
            R.drawable.image21,
            R.drawable.image12,
            R.drawable.image13,
            R.drawable.image16,
            R.drawable.image18,
            R.drawable.image5,
            R.drawable.image7,
            R.drawable.image8,
            R.drawable.image20,
            R.drawable.image15,
        )

        Text(
            text = "Lazy Row",
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(8.dp)
        )

        // Lazy Row
        LazyRow {
            items(10) { index ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(8.dp)
                ) {
                    Image(
                        painter = painterResource(id = lazyrowResources[index]),
                        contentDescription = "Image $index",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(100.dp)
                            .clip(CircleShape)
                    )
                    Button(onClick = { navController.navigate("detail/$index/${lazyrowResources[index]}") }) {
                        Text("Post $index")
                    }
                }
            }
        }

        Text(
            text = "Lazy Column",
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(8.dp)
        )

        // Lazy Column
        LazyColumn {
            items(lazycolumnResources.size) { index ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    
                    Image(
                        painter = painterResource(id = lazycolumnResources[index]),
                        contentDescription = "Image $index",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(250.dp) // Square size
                            .clip(RoundedCornerShape(0.dp)) // Square shape
                            .padding(end = 6.dp)
                    )
                    Button(onClick = { navController.navigate("detail/$index/${lazycolumnResources[index]}") }) {
                        Text("Photo $index")
                    }
                }
            }
        }
    }
}
