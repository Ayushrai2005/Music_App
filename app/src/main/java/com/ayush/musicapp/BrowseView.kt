package com.ayush.musicapp

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun Browse(){

    val categories = listOf("Hits" , "happy" , "Chill" , "Workout" , "Arijit's Special" , "KK's Special")

    LazyVerticalGrid(GridCells.Fixed(2) ) {
        items(categories){ cat ->
            BrowserItem(cat = cat , drawable = R.drawable.baseline_apps_24)
        }
    }
}