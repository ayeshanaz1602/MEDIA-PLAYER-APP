COMPANY: CODTECH IT SOLUTIONS

NAME: AYESHA NAZNEEN

INTERN ID :CT04DL1293

DOMAIN: ANDROID DEVELOPMENT

DURATION: 4 WEEKS

MENTOR: NEELA SANTOSH

Here is a 500-word README file for Task 2: Media Player App.

📱 Task 2: Media Player App – README

Overview
The Media Player App is a lightweight Android application built using Kotlin that allows users to play audio files from local device storage. The app supports essential playback controls such as play, pause, resume, and skip (next/previous), and displays metadata such as track title and duration. The project demonstrates effective use of Android’s MediaPlayer API and handles runtime permissions and file selection through the SAF (Storage Access Framework).

Features
* Browse and play audio files from internal storage
* Play, pause, resume, and skip tracks
* Displays song title and current playback time
* Seeks through the track with a SeekBar
* Background playback support
* Clean and responsive user interface

Technologies Used
* Kotlin
* Android SDK (API 21+)
* MediaPlayer class
* Storage Access Framework (SAF)
* RecyclerView for playlist (optional enhancement)
* ViewBinding

Project Structure
com.example.mediaplayerapp
├── ui
│   └── MainActivity.kt – main UI and logic controller
├── model
│   └── AudioFile.kt – data class representing an audio file
├── adapter
│   └── AudioAdapter.kt – adapter for displaying a playlist (optional)
├── utils
│   └── FileUtils.kt – utility functions to read and filter audio files
└── res
└── layout – activity\_main.xml, list\_item.xml
└── drawable – icons
└── values – strings, colors, styles

Getting Started

1. Clone the repository:
   git clone [https://github.com/yourusername/MediaPlayerApp.git](https://github.com/yourusername/MediaPlayerApp.git)
2. Open in Android Studio:
   * Open Android Studio → Open an existing project → Select this folder
3. Build & Run:
   * Run the project on an emulator or a real Android device running Android 5.0 (API 21) or above.
4. Grant permissions:
   * Allow the app to access device storage when prompted.

Permissions
The app requires the following permissions to function:
<uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />

For Android 10+:
* Uses Storage Access Framework to pick files dynamically via file picker intent.
Implementation Details

MediaPlayer:
* The core of the audio playback is handled via MediaPlayer.
* On selecting an audio file, the MediaPlayer is prepared and started.
* MediaPlayer is reset before loading a new track to avoid memory leaks.

SeekBar:
* A SeekBar tracks the current playback position.
* A Handler updates the SeekBar in real-time every 500ms.

File Access:
* The app uses Intent.ACTION\_OPEN\_DOCUMENT to browse audio files from storage.
* Only audio/\* MIME types are filtered in the file picker.

UI:
* The layout consists of a title TextView, SeekBar, and control buttons for play, pause, and skip.
* The buttons respond to onClickListeners and update the MediaPlayer state accordingly.

