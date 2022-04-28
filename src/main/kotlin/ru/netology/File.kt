package ru.netology

data class File(
    val id: Int,
    val ownerId: Int,
    val title: String,
    val size: Int,
    val ext: String,
    val url: String,
    val date: Int,
    val typeFile: Int,
    val preview: PreviewFile?,
){
    data class PreviewFile(
        var photo: Photo?,
        var graffiti: Graffiti,
        var audioMessage: AudioMessage?,
    )

    data class Photo(
        var sizes: ArrayList<PhotoSize>?,
    )

    data class Graffiti(
        var src: String,
        var width: Int,
        var height: Int,
    )

    data class AudioMessage(
        var duration: Int,
        var waveform: ArrayList<Int>,
        var linkOgg: String?,
        var linkMp3: String?,
    )
}
