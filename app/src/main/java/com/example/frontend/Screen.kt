package com.example.frontend

sealed class Screen (val route: String){
    data object Home : Screen("home")
    data object Grid: Screen("grid")
    data object About: Screen("about")
    data object DetailList: Screen("detailList")
}