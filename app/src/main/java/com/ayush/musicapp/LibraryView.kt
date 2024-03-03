package com.ayush.musicapp

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun Library(){

    LazyColumn {
        items(libraries){
            lib ->
            LibItem(lib = lib)
        }
    }

}

@Composable
fun LibItem(lib : Lib){
    Column {
        Row (modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp)
            .clickable {  },
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Row {
                Icon(painter = painterResource(id = lib.icon) ,
                    modifier = Modifier.padding(horizontal = 8.dp) , contentDescription = lib.name )
                   Text(text = lib.name)
            }
            Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = "Arrow right"  )

        }

        Divider(color = Color.Gray)

    }
}
