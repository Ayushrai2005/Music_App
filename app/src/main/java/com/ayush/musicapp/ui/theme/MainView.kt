package com.ayush.musicapp.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ScaffoldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.ayush.musicapp.Screen
import com.ayush.musicapp.Screen.DrawerScreen.Account.title
import com.ayush.musicapp.screensInDrawer
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun MainView(){

    val scaffoldState : ScaffoldState = rememberScaffoldState()
    val scope : CoroutineScope = rememberCoroutineScope()


    //Use to find out on which "view" we currently are
    val controller : NavController = rememberNavController()
    val  newBackStackEntry  by controller.currentBackStackEntryAsState()
    val currentRoute = newBackStackEntry?.destination?.route

    val title = remember {
        // TODO change that to currentScreen.title
        mutableStateOf("")
    }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Home")},
                navigationIcon = { IconButton(onClick = {
                    //Open a Drawer
                    scope.launch {
                        scaffoldState.drawerState.open()
                    }

                }) {
                    Icon(imageVector = Icons.Default.AccountCircle, contentDescription = "OpenMenu " )
                }}
            )
        },scaffoldState = scaffoldState,
        drawerContent = {
                LazyColumn(Modifier.padding(8.dp)){
                    items(screensInDrawer){
                        item ->
                        DrawerItem(selected = currentRoute == item.dRoute  , item = item) {
                            scope.launch {
                                scaffoldState.drawerState.close()
                            }
                            if(item.dRoute == "add_account"){
                                //Open dialog
                            }else{
                                controller.navigate(item.dRoute)
                                title.value = item.dTitle
                            }

                        }
                    }

                }
        }

    ) {
        Text(text = "Home" , modifier = Modifier.padding(it))
        
    }
}

@Composable
fun DrawerItem(
    selected : Boolean,
    item: Screen.DrawerScreen,
    onDrawerItemClicked:() -> Unit
){
    val background = if(selected) Color.DarkGray else Color.White

    Row(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 16.dp)
            .background(background)
            .clickable {
                onDrawerItemClicked()
            }
    ){
        androidx.compose.material.Icon(
            painter = painterResource(id = item.icon),
            contentDescription = item.dTitle,
            Modifier.padding(end = 8.dp , top = 4.dp)
        )
        Text(text = item.dTitle, style = MaterialTheme.typography.titleMedium)

    }

}