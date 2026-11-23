package com.permuta.djinlog.ui.component

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.permuta.djinlog.ui.page.DJinnDetailPage
import com.permuta.djinlog.ui.page.DJinnListPage
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable


//@Serializable
//object RutaDjinnLista {
//    fun serializer(): KSerializer<RutaDjinnLista>
//}
//
//@Serializable
//data class RutaDjinnDetalle(var id: Int) {
//    fun serializer(): KSerializer<RutaDjinnDetalle>
//}
//
//
//@Composable
//fun MyNav(nav: NavHostController) {
//
//
//    NavHost(
//        navController = nav,
//        startDestination = RutaDjinnLista
//    ) {
//
//        composable<RutaDjinnLista> {
//            DJinnListPage(onCardClick = { nav.navigate(RutaDjinnDetalle(it)) })
//        }
//
//        composable<RutaDjinnDetalle> {
//            backStackEntry ->
//            var id = backStackEntry.toRoute<RutaDjinnDetalle>().id
//            DJinnDetailPage(id = id, onGoBack = {
//                nav.popBackStack()
//            })
//        }
//    }
//
//
//}