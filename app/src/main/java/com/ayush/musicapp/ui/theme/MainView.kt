package com.ayush.musicapp.ui.theme

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun MainView(){

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Home")},
                navigationIcon = { IconButton(onClick = {
                    //Open a Drawer

                }) {
                    Icon(imageVector = Icons.Default.AccountCircle, contentDescription = "OpenMenu " )
                }}
            )
        }
    ) {
        Text(text = "Home" , modifier = Modifier.padding(it))
        
    }
}