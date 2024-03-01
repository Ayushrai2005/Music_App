package com.ayush.musicapp

import androidx.annotation.DrawableRes

sealed class Screen(val title : String , val route : String){

    // All Screen title are mentioned here

    sealed class DrawerScreen(val dTitle : String , val dRoute : String , @DrawableRes val icon : Int)
        : Screen(dTitle ,dRoute){

            object Account : DrawerScreen(
                "Account",
                "account",
                R.drawable.ic_account
            )
        object subscription : DrawerScreen(
            "Subscription",
            "subscription",
            R.drawable.ic_subscribe
        )

        object AddAccount : DrawerScreen(
            "Add Account",
            "add_account",
            R.drawable.baseline_person_add_alt_1_24
        )
        }
}

val screensInDrawer = listOf(
    Screen.DrawerScreen.Account,
    Screen.DrawerScreen.AddAccount,
    Screen.DrawerScreen.subscription
)