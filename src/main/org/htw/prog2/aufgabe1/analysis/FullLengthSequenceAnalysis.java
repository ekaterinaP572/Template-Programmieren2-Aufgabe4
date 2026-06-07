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
    public void calculateResistances() {
        int counter = 0;

        for (int i = 0; i < mutation.getNumberOfMutations(); i++) {
            Mutation m = new Mutation(mutation.getMutations().get(i).getVariant(), mutation.getMutations().get(i).getResistances());
            String mySeq = m.getSequence(reference);
            if (sequence.containsSequence(mySeq)) {
                counter++;
                if (counter == 1) {
                    for (int i1 = 0; i1 < mutation.getDrugs().size(); i1++) {
                        addResistances.put(mutation.getDrugs().get(i1),
                                mutation.getMutations().get(i).getResistances().get(mutation.getDrugs().get(i1)));
                    }
                   // addResistances.putAll(mutation.getMutations().element().getResistances());
                } else {
                    for (int j = 0; j < addResistances.size(); j++) {
                        if (addResistances.get(mutation.getDrugs().get(j)) <
                                mutation.getMutations().get(i).getResistances().get(mutation.getDrugs().get(j))) {
                            addResistances.replace(mutation.getDrugs().get(j),
                                    mutation.getMutations().get(i).getResistances().get(mutation.getDrugs().get(j)));
                        }
                    }
                }
            }
            if(counter == 0) {
                {
                    for (int i1 = 0; i1 < mutation.getDrugs().size(); i1++) {
                        addResistances.put(mutation.getDrugs().get(i1), 0.0);
                    }
                }
            }
            }
    }
    public HashMap<String, Double> getResistances(){
        calculateResistances();


        return addResistances;
    }
    public String getBestDrug() {
        String drug = mutation.getDrugs().getFirst();
        double min = getResistances().get(mutation.getDrugs().getFirst());
        //calculateResistances();
        int counter = 0;
        for (int i = 0; i < getResistances().size(); i++) {
            if(getResistances().get(mutation.getDrugs().get(i)) == 0){
                counter++;
            }
        }
        if(counter == getResistances().size()){
            drug = "it seems like the resistance is not in the list.";
        }else{

        for (int i = 0; i < getResistances().size() ; i++) {
           // min = getResistances().get(mutation.getDrugs().get(i));

            if (getResistances().get(mutation.getDrugs().get(i))!=0 && getResistances().get(mutation.getDrugs().get(i)) < min) {
                min = getResistances().get(mutation.getDrugs().get(i));
                drug =  mutation.getDrugs().get(i);
                System.out.println( drug + " " +min);

            }
            }

        }
        return drug;
    }

    public String getDrugDescriptions() {
       // String drug = getBestDrug();


        return "The best drug for this patient is "+ getBestDrug() +" with the lowest resistance ";
    }

}
