# split_SWS

Split ZIP of the full SWS workspace. Keep every `SWS.z*` volume next to `SWS.zip`.

The zip volumes are too large to store in git. After cloning this repo, download them from the [split-sws release](https://github.com/n30032771-wq/SWS/releases/tag/split-sws):

```bash
gh release download split-sws --repo n30032771-wq/SWS --dir split_SWS
```

Or download the assets from that release page into this folder.

Extract with [7-Zip](https://www.7-zip.org/):

```powershell
& "C:\Program Files\7-Zip\7z.exe" x SWS.zip
```
