# SWS Ontology Builder

Java program that extracts text from a PDF with [Apache Tika](https://tika.apache.org/) and writes an OWL ontology in Turtle with [Apache Jena](https://jena.apache.org/).

After cloning, Maven downloads Tika and Jena from Maven Central. You do **not** need local copies of those source trees, a JDK installer, or a Maven cache.

## Requirements

- **JDK 21** or later ([Eclipse Temurin](https://adoptium.net/) or [Microsoft Build of OpenJDK](https://learn.microsoft.com/en-us/java/openjdk/download))
- **Apache Maven 3.9+** ([download](https://maven.apache.org/download.cgi))

Confirm:

```bash
java -version
mvn -version
```

## Clone and run

```bash
git clone https://github.com/n30032771-wq/SWS.git
cd SWS
cd "New folder/ontology-builder"
mvn compile exec:java
```

The program reads `documents/clique.pdf` and writes `output/clique.ttl`.

## Project layout

```
pom.xml
src/main/java/com/example/CreateOntology.java
documents/clique.pdf
output/clique.ttl
```
