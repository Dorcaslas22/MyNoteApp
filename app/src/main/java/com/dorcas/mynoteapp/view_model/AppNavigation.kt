package com.dorcas.mynoteapp.view_model

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dorcas.mynoteapp.screens.AddNoteScreen
import com.dorcas.mynoteapp.screens.NoteDetailsScreen
import com.dorcas.mynoteapp.screens.NoteListScreen


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AppNavigation(){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.NoteListRoute
    ){
        composable(Routes.NoteListRoute){
            NoteListScreen(navController)
        }
        composable(Routes.AddNoteRoute){
            AddNoteScreen(navController)
        }
        composable("note-details/{noteId}"){
            NoteDetailsScreen(
                navController = navController,
                noteId = it.arguments!!.getString("noteId")!!
            )
        }

    }
}


object Routes{
    val NoteListRoute = "note-list"
    val AddNoteRoute = "add-note"
    fun NoteDetails(noteId: String): String{
        return "note-details/$noteId"
    }
}