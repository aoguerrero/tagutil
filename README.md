# Tag Util

This utility parses filenames in the formats:

- Artist - Title.xxx

Or

- /Artist/Title.xxx

And writes the information in the tag files, removing all other tags (including album art, track number, genre, etc.)

The fields in the tags are saved as:

```
Title -> Title
Artist -> Artist
Artist -> Album
```

Also, renames the files with the Artist - Title.xxx format.

Characters different from a-zA-Z0-9 or space will be removed (including special characters and accents).

To run in multiple files use:

```
$ find . -iname \*.mp3 -exec java -jar tagutil.jar "{}" \;
```

Thested with mp3, ogg and m4a file extensions.
