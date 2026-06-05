package org.htw.prog2.aufgabe1.analysis;

import org.htw.prog2.aufgabe1.files.MutationFile;
import org.htw.prog2.aufgabe1.files.Mutation;
import org.htw.prog2.aufgabe1.files.SequenceFile;

import java.util.HashMap;

public abstract class SequenceAnalysis {
    String reference;
    SequenceFile sequence;
    MutationFile mutation;
    //FullLengthSequenceAnalysis check = new FullLengthSequenceAnalysis(reference, sequence, mutation);

    public SequenceAnalysis(String reference, SequenceFile sequences, MutationFile mutations) {
   this.reference = reference;
   this.sequence = sequences;
   this.mutation = mutations;

    }

    public abstract void calculateResistances();

    public HashMap<String, Double> getResistances() {

        return null;
    }

    public String getBestDrug() {
        String drug = "";
        //check.calculateResistances();

        //for (int i = 0; i < check.getResistances().size(); i++) {
        //}

        return drug;
    }

    public String getDrugDescriptions() {
        //check.calculateResistances();
        return "";
    }
}
