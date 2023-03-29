package com.example.demo.chatGPTCodes;


import java.util.List;
import java.util.Properties;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;

	public class ClassifyWords {
	    public static void main(String[] args) {
	        // Set up Stanford CoreNLP pipeline
	        Properties props = new Properties();
	        props.setProperty("annotators", "tokenize, ssplit, pos");
	        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);

	        // Sample input sentence
	        String sentence = "The probability of happening that match is not much.";

	        // Create CoreNLP annotation object for the input sentence
	        Annotation annotation = new Annotation(sentence);

	        // Run the pipeline on the input sentence
	        pipeline.annotate(annotation);

	        // Get the list of CoreLabels for the input sentence
	        List<CoreLabel> tokens = annotation.get(CoreAnnotations.TokensAnnotation.class);

	        // Iterate through each token in the sentence and print its part of speech
	        for (CoreLabel token : tokens) {
	            String word = token.word();
	            String pos = token.get(CoreAnnotations.PartOfSpeechAnnotation.class);

	            // Print the word and its part of speech
	          //  System.out.println(word + " - " + pos);

	            // Classify the word based on its part of speech
	            if (pos.startsWith("NN")) {
	                System.out.println(word + " is a singular or mass noun.");
	            } else if (pos.startsWith("NNS")) {
	                System.out.println(word + " is a plural noun.");
	            } else if (pos.startsWith("NNP")) {
	                System.out.println(word + " is a singular proper noun.");
	            } else if (pos.startsWith("NNPS")) {
	                System.out.println(word + " is a plural proper noun.");
	            } else if (pos.startsWith("PRP")) {
	                System.out.println(word + " is a personal pronoun.");
	            } else if (pos.startsWith("PRP$")) {
	                System.out.println(word + " is a possessive pronoun.");
	            } else if (pos.startsWith("JJ")) {
	                System.out.println(word + " is an adjective.");
	            } else if (pos.startsWith("VB")) {
	                System.out.println(word + " is a verb.");
	            } else if (pos.startsWith("RB")) {
	                System.out.println(word + " is an adverb.");
	            } else if (pos.startsWith("IN")) {
	                System.out.println(word + " is a preposition or subordinating conjunction.");
	            } else if (pos.startsWith("CC")) {
	                System.out.println(word + " is a coordinating conjunction.");
	            } else if (pos.startsWith("DT")) {
	                System.out.println(word + " is a determiner.");
	            } else if (pos.startsWith("CD")) {
	                System.out.println(word + " is a cardinal number.");
	            } else if (pos.startsWith("MD")) {
	                System.out.println(word + " is a modal.");
	            } else if (pos.startsWith("UH")) {
	                System.out.println(word + " is an interjection.");
	            }
	            else if (pos.startsWith("N")) {
	                System.out.println(word + " is a noun.");
	            } else if (pos.startsWith("PR")) {
	                System.out.println(word + " is a pronoun.");
	            } else if (pos.startsWith("JJ")) {
	                System.out.println(word + " is an adjective.");
	            } else if (pos.startsWith("VB")) {
	                System.out.println(word + " is a verb.");
	            } else if (pos.startsWith("RB")) {
	                System.out.println(word + " is an adverb.");
	            } else if (pos.startsWith("DT")) {
	                System.out.println(word + " is a determiner.");
	            } else if (pos.startsWith("CC")) {
	                System.out.println(word + " is a conjunction.");
	            } else if (pos.startsWith("IN")) {
	                System.out.println(word + " is a preposition.");
	            } else if (pos.startsWith("MD")) {
	                System.out.println(word + " is a modal verb.");
	            } else if (pos.startsWith("RP")) {
	                System.out.println(word + " is an adverb particle.");
	            } else if (pos.startsWith("WP")) {
	                System.out.println(word + " is a wh-pronoun.");
	            } else if (pos.startsWith("UH")) {
	                System.out.println(word + " is an interjection.");
	            } else {
	                System.out.println("Cannot classify " + word + " with POS " + pos);
	            }
	        }
	    }
	}



