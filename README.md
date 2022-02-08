# Tag Util

This utility parses filenames in the formats:

- Artist - Title.xxx

Or

- /Artist/Title.xxx

And writes the information in the tag files, removing all other tags.

Also, renames the files with the Artist - Title.xxx format.

To run in multiple files use:

```
$ find . -iname \*.mp3 -exec java -jar tagutil.jar "{}" \;
```
