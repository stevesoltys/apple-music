# Apple Music
[![Build Status](https://travis-ci.org/stevesoltys/apple-music.svg?branch=master)](https://travis-ci.org/github/stevesoltys/apple-music)

An [Apple Music API](https://developer.apple.com/documentation/applemusicapi/) wrapper.

## Installation
```groovy
repositories {
    jcenter()
    maven { url 'https://jitpack.io' }
}

dependencies {
    compile 'com.github.stevesoltys:apple-music:0.1.0'
}
```

## Usage
Create an `AppleMusic` instance with your credentials, and run an API query.

Here's an example:
```kotlin
val appleMusic = AppleMusic(
    teamId = "A93J3NMCK2",
    privateKey = Files.readAllBytes(Path.of("private.key")),
    keyId = "S019516J93",
    storefront = "us"
)

val searchResultArtist = appleMusic.search(
    "j cole", types = setOf(SearchResultType.ARTISTS)
).results?.artists?.data?.first()

val artistAlbums = appleMusic.getAllAlbumsByArtistId(searchResultArtist!!.id!!)

// ...
```

## License
This library is available as open source under the terms of the [MIT License](http://opensource.org/licenses/MIT).
