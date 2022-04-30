package ru.netology

data class File(
    val id: Int = 0,
    val ownerId: Int = 0,
    val title: String = "",
    val size: Int = 0,
    val ext: String = "",
    val url: String = "",
    val date: Int = 0,
    val typeFile: Int = 0,
    val preview: PreviewFile? = null,
){
    data class PreviewFile(
        var photo: Photo?,
        var graffiti: Graffiti,
        var audioMessage: AudioMessage?,
    )

    data class Photo(
        var sizes: List<PhotoSize>?,
    )

    data class Graffiti(
        var src: String,
        var width: Int,
        var height: Int,
    )

    data class AudioMessage(
        var duration: Int,
        var waveform: List<Int>,
        var linkOgg: String?,
        var linkMp3: String?,
    )
}
