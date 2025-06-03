private val PERMISSIONS = arrayOf(
    Manifest.permission.READ_EXTERNAL_STORAGE
)

override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    
    if (!hasPermissions()) {
        ActivityCompat.requestPermissions(this, PERMISSIONS, 1)
    } else {
        initPlayer()
    }
}

private fun hasPermissions(): Boolean {
    return PERMISSIONS.all {
        ContextCompat.checkSelfPermission(this, it) == PackageManager.PERMISSION_GRANTED
    }
}

private fun initPlayer() {
    mediaPlayer = MediaPlayer()
    trackList = FileUtils.loadAudioFiles(this)

    adapter = MusicAdapter(trackList) { track ->
        playTrack(trackList.indexOf(track))
    }

    recyclerView.adapter = adapter
    recyclerView.layoutManager = LinearLayoutManager(this)

    playButton.setOnClickListener { mediaPlayer?.start() }
    pauseButton.setOnClickListener { mediaPlayer?.pause() }
    nextButton.setOnClickListener { playTrack((currentIndex + 1) % trackList.size) }
}

private fun playTrack(index: Int) {
    currentIndex = index
    val track = trackList[index]
    mediaPlayer?.reset()
    mediaPlayer?.setDataSource(track.path)
    mediaPlayer?.prepare()
    mediaPlayer?.start()
    currentTrackTextView.text = "Now Playing: ${track.title}"
}

override fun onDestroy() {
    mediaPlayer?.release()
    super.onDestroy()
}
