override fun onBind(intent: Intent?): IBinder? = null

fun playTrack(track: AudioFile) {
    mediaPlayer.reset()
    mediaPlayer.setDataSource(track.path)
    mediaPlayer.prepare()
    mediaPlayer.start()
    currentTrack = track
}

fun pause() = mediaPlayer.pause()
fun resume() = mediaPlayer.start()

fun playNext() {
    currentIndex = (currentIndex + 1) % trackList.size
    playTrack(trackList[currentIndex])
}

override fun onCreate() {
    super.onCreate()
    mediaPlayer = MediaPlayer()
}

override fun onDestroy() {
    mediaPlayer.release()
    super.onDestroy()
}
