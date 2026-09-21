# SWS

Public clone of **New folder** (ontology builder, Jena source, notes).

```bash
git clone https://github.com/n30032771-wq/SWS.git
cd SWS
```

If a large transfer is reset on your network, retry with HTTP/1.1:

```bash
git -c http.version=HTTP/1.1 clone https://github.com/n30032771-wq/SWS.git
```

## Layout

| Path | Contents |
| --- | --- |
| `New folder/ontology-builder/` | Java program that reads a PDF with Tika and writes an OWL ontology |
| `New folder/jena-6.2.0/` | Apache Jena 6.2.0 source tree |
| `New folder/help/` | Extra notes |
| `split_SWS/` | How to restore the split full-workspace archive |

The split ZIP volumes (`SWS.z01` … `SWS.zip`, about 4.4 GB) are too large for a GitHub git push (GitHub returned HTTP 500). They are attached to the [split-sws release](https://github.com/n30032771-wq/SWS/releases/tag/split-sws) on the same public repo.

## Restore the split archive

Download the release assets into `split_SWS/`, then with [7-Zip](https://www.7-zip.org/):

```powershell
cd split_SWS
& "C:\Program Files\7-Zip\7z.exe" x SWS.zip
```

## Run the ontology builder

Requirements: **JDK 21+** and **Apache Maven 3.9+**.

```bash
java -version
mvn -version
cd "New folder/ontology-builder"
mvn compile exec:java
```

The program reads `documents/clique.pdf` and writes `output/clique.ttl`. Maven downloads Tika and Jena libraries from Maven Central.
