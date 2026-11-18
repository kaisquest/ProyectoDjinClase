package com.permuta.djinlog.seeder

var listaDjin = listOf(
    DjinModel(
        id = 1,
        nombre = "Ignis",
        descripcion = "Este djin es raro, parece un charmander",
        tipo = TipoDjin.FIRE,
    ),
    DjinModel(
        id = 2,
        nombre = "Marid",
        descripcion = "Vive en los pozos y se enfada si le tiran monedas",
        tipo = TipoDjin.WATER,
    ),
    DjinModel(
        id = 3,
        nombre = "Golem",
        descripcion = "Lento y testarudo, duerme siglos enteros bajo una montaña",
        tipo = TipoDjin.EARTH,
    )
)

data class DjinModel(
    val id: Int,
    val nombre: String,
    val descripcion: String,
    val tipo: TipoDjin,
)

enum class TipoDjin {
    FIRE,
    WATER,
    AIR,
    EARTH

}


fun getDjinnFiltered(filter: String): List<DjinModel> {

    return listaDjin.filter { it.nombre.contains(filter) }

}

fun getDjinn(id: Int): DjinModel? {
    return listaDjin.find { it.id == id }


}