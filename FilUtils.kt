object FileUtils {
fun loadAudioFiles(context: Context): List<AudioFile> {
val audioList = mutableListOf<AudioFile>()
val contentResolver = context.contentResolver
val uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI
val projection = arrayOf(
MediaStore.Audio.Media.TITLE,
MediaStore.Audio.Media.DATA,
MediaStore.Audio.Media.DURATION
)
val cursor = contentResolver.query(uri, projection, null, null, null)
cursor?.use {
val titleIdx = it.getColumnIndex(MediaStore.Audio.Media.TITLE)
val dataIdx = it.getColumnIndex(MediaStore.Audio.Media.DATA)
val durIdx = it.getColumnIndex(MediaStore.Audio.Media.DURATION)
while (it.moveToNext()) {
val title = it.getString(titleIdx)
val data = it.getString(dataIdx)
val duration = it.getLong(durIdx)
audioList.add(AudioFile(title, data, duration))
}
}
return audioList
}
}

