# SWS

Public workspace for ontology builder notes, MathQuill equation demos, and related materials.

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
| `equation/` | MathQuill demo, help notes, and ontology-builder project |
| `equation/ontology-builder/` | Java program that reads a PDF with Tika and writes an OWL ontology |
| `equation/mathquill.github.com/` | MathQuill site/demo assets |
| `equation/help_math/` | Math editor screenshots |
| `equation/help_onto/` | Ontology/Torch notes |
| `New folder/jena-6.2.0/` | Apache Jena 6.2.0 source tree |

Local installs such as `jdk_21/`, `tika/`, and Maven `.m2` caches are not in git (too large). Install JDK 21+ and Maven separately; dependencies download from Maven Central.

## Run the ontology builder

Requirements: **JDK 21+** and **Apache Maven 3.9+**.

```bash
java -version
mvn -version
cd "equation/ontology-builder"
mvn compile exec:java
```

The program reads `documents/clique.pdf` and writes `output/clique.ttl`.
