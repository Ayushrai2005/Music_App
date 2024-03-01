package com.ayush.musicapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp


@Composable
fun AccountView(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    )
    {

        Row (
            modifier = Modifier.fillMaxWidth() ,
            horizontalArrangement = Arrangement.SpaceBetween
        ){

            Row {
                Icon(imageVector = Icons.Default.AccountCircle,
                    contentDescription = "Account" ,
                    modifier = Modifier.padding(end = 8.dp)
                )
                Column {
                    Text(text = "Ayush Rai")
                    Text(text = "@Ayushrai")
                }
            }
            IconButton(onClick = { }) {
                Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight ,
                    contentDescription =  "Null")

            }

        }
        
            Spacer(modifier = Modifier.padding(8.dp))

        // Second Row For My Music
        Row (
            modifier = Modifier.fillMaxWidth() ,
        ){

            
                Icon( painter = painterResource(id = com.ayush.musicapp.R.drawable.baseline_music_video_24),
                    contentDescription = "Account" ,
                    modifier = Modifier.padding(end = 8.dp)
                )
                Text(text = "My Music")


        }

        Divider()
    }

}