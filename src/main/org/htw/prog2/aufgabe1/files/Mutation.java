package org.htw.prog2.aufgabe1.files;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Mutation {
    String variant;
    HashMap<String, Double> resistances;

    public Mutation(String variant, HashMap<String, Double> resistances) {
        this.variant = variant;
        this.resistances = resistances;
    }

    public String getVariant() {
        return variant;
    }

    public HashMap<String, Double> getResistances() {
        return resistances;
    }

    public String getSequence(String reference) {
        String[] splitVatiant = variant.split(",");
        String[] splitRef = reference.split("");
        LinkedList<String> splitReference = new LinkedList<>(Arrays.asList(splitRef));
        for (int i = 0; i <splitVatiant.length; i++) {
            String key = splitVatiant[i].substring(0, splitVatiant[i].length()-1);
            String value = splitVatiant[i].substring(splitVatiant[i].length()-1);
            int key1 = Integer.parseInt(key);
            splitReference.set(key1-1, value);
        }
        StringBuilder build = new StringBuilder();
        for (int i = 0; i < splitReference.size(); i++) {
            build.append(splitReference.get(i));
        }

        return build.toString();
    }
}
