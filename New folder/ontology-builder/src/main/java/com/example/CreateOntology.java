package com.example;

import org.apache.tika.io.TikaInputStream;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.metadata.TikaCoreProperties;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.sax.BodyContentHandler;
import org.apache.jena.ontapi.OntModelFactory;
import org.apache.jena.ontapi.OntSpecification;
import org.apache.jena.ontapi.model.OntClass;
import org.apache.jena.ontapi.model.OntModel;
import org.apache.jena.ontapi.model.OntObjectProperty;
import org.apache.jena.riot.Lang;
import org.apache.jena.riot.RDFDataMgr;
import org.apache.jena.vocabulary.RDFS;

import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class CreateOntology {

    public static void main(String[] args) throws Exception {

        Path document =
                Path.of("documents/clique.pdf");

        Metadata metadata = new Metadata();

        String text;

        try (TikaInputStream stream =
                     TikaInputStream.get(document, metadata)) {

            AutoDetectParser parser =
                    new AutoDetectParser();

            BodyContentHandler handler =
                    new BodyContentHandler(-1);

            ParseContext context =
                    new ParseContext();

            parser.parse(
                    stream,
                    handler,
                    metadata,
                    context
            );

            text = handler.toString();
        }

        System.out.println("TITLE:");
        System.out.println(
                metadata.get(TikaCoreProperties.TITLE)
        );

        System.out.println("\nTEXT:");
        System.out.println(text);

        String NS =
        "http://example.org/ontology#";

        OntModel model =
                OntModelFactory.createModel(
                        OntSpecification.OWL2_DL_MEM
                );

        model.setNsPrefix("ex", NS);

        OntClass.Named topic =
        model.createOntClass(
                NS + "Topic"
        );

        OntClass.Named artificialIntelligence =
                model.createOntClass(
                        NS + "ArtificialIntelligence"
                );

        OntClass.Named machineLearning =
                model.createOntClass(
                        NS + "MachineLearning"
                );

        OntClass.Named deepLearning =
                model.createOntClass(
                        NS + "DeepLearning"
                );

        OntClass.Named neuralNetwork =
                model.createOntClass(
                        NS + "NeuralNetwork"
                );

        OntClass.Named cnn =
                model.createOntClass(
                        NS + "ConvolutionalNeuralNetwork"
                );

        OntClass.Named imageRecognition =
                model.createOntClass(
                        NS + "ImageRecognition"
                );
        artificialIntelligence.addSuperClass(topic);

        machineLearning.addSuperClass(
                artificialIntelligence
        );

        deepLearning.addSuperClass(
                machineLearning
        );

        neuralNetwork.addSuperClass(
                deepLearning
        );

        cnn.addSuperClass(
                neuralNetwork
        );

        OntObjectProperty.Named usedFor =
        model.createObjectProperty(
                NS + "usedFor"
        );

        usedFor.addDomain(cnn);
        usedFor.addRange(imageRecognition);

        Path outputDir = Path.of("output");
        Files.createDirectories(outputDir);

        try (FileOutputStream out =
                new FileOutputStream(
                        outputDir.resolve("clique.ttl").toFile()
                )) {

                RDFDataMgr.write(
                        out,
                        model,
                        Lang.TURTLE
                );
        }

        System.out.println(
                "\nOntology created:"
        );

        System.out.println(
                "output/clique.ttl"
        );

    }
}
