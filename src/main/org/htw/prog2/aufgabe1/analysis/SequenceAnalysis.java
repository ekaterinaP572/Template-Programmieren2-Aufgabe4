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
        FullLengthSequenceAnalysis drugName = new FullLengthSequenceAnalysis(reference,sequence,mutation);
        double min = 0.0;
        String drug = "";
        for (int i = 0; i < drugName.getResistances().size() ; i++) {
            if (getResistances().get(mutation.getDrugs().get(i))!=0 && getResistances().get(mutation.getDrugs().get(i)) > min) {
                min = getResistances().get(mutation.getDrugs().get(i));
                drug = mutation.getDrugs().get(i);

            }
        }
        return drug;
    }

    public String getDrugDescriptions() {
        String drug = getBestDrug();


        return "The best drug for this patient is "+ drug +" with the lowest resistance";
    }
}
