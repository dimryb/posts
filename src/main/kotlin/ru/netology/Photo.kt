package ru.netology

data class Photo (
    val id: Int = 0,
    val albumId: Int = 0,
    val ownerId: Int = 0,
    val userId: Int? = null,
    val text: String = "",
    val date: Int = 0,
    val sizes: List<CopySize>? = null,
    val width: Int? = 0,
    val height: Int? = 0,
){
    data class CopySize (
        var type: String,
        var url: String,
        var width: Int,
        var height: Int,
    )
}

