# Music Tag Util

This utility parses filenames in the formats:

- Artist - Title.xxx

Or

- /Artist/Title.xxx

And writes the information inside the tag fields, **removing all other fields** (including album art, track number, genre, etc.)

The fields in the tags are saved as:

```
Title -> Title
Artist -> Artist
Artist -> Album
```

Also, renames the files with the Artist - Title.xxx format.

Characters different from a-zA-Z0-9 or space will be removed (including special characters and accents), the values are changed to capital case with the file extension in lower case, i.e:
```
the beatles - hey jude.MP3 -> The Beatles - Hey Jude.mp3

Hey Jude -> Title
The Beatles -> Artist
The Beatles -> Album
```


To run in multiple files use:

```
$ find . -iname \*.mp3 -exec java -jar tagutil.jar "{}" \;
```

Tested with mp3, ogg and m4a file extensions in Linux and Android (using termux), should run fine in Windows.

## Releases:

https://github.com/aoguerrero/tagutil/releases/download/v0.1/tagutil.jar

## Dependencies

This utility uses [Jaudiotagger](https://www.jthink.net/jaudiotagger/)



