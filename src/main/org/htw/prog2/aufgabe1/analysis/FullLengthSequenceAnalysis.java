package org.htw.prog2.aufgabe1.analysis;

import org.htw.prog2.aufgabe1.files.Mutation;
import org.htw.prog2.aufgabe1.files.MutationFile;
import org.htw.prog2.aufgabe1.files.SequenceFile;

import java.util.HashMap;
import java.util.HashSet;

public class FullLengthSequenceAnalysis extends SequenceAnalysis{
        HashMap<String,Double> addResistances = new HashMap<>();
    public FullLengthSequenceAnalysis(String reference, SequenceFile sequence, MutationFile mutation){
        super(reference, sequence, mutation);
    }
    public void calculateResistances(){
        if(sequence.containsSequence(reference)){
            for (int i = 0; i < mutation.getDrugs().size(); i++) {
                addResistances.put(mutation.getDrugs().get(i), 0.0);
            }

        }

        else {
            addResistances.putAll(mutation.getMutations().element().getResistances());
            if (sequence.containsSequence(reference)) {
                for (int i = 0; i < addResistances.size(); i++) {
                    if (addResistances.get(mutation.getDrugs().get(i))
                            <
                            mutation.getMutations().element().getResistances().get(mutation.getDrugs().get(i))) {
                        addResistances.put(mutation.getDrugs().get(i),
                                mutation.getMutations().element().getResistances().get(mutation.getDrugs().get(i)));
                    }
                }
            } else {
                for (int i = 0; i < mutation.getDrugs().size(); i++) {
                    addResistances.put(mutation.getDrugs().get(i), 0.0);
                }
            }


        }
    }
    public HashMap<String, Double> getResistances(){
        calculateResistances();


        return addResistances;
    }

}
