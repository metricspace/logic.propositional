/*
 * Copyright (c) 2019, mange
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * * Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 * * Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */
package se.metricspace.logic.propositional;

/**
 * @author Mange
 */
public class Context implements Iterable<Structure> {
    private final java.util.SortedSet<String> itsVariableNames = new java.util.TreeSet<>();
    private final java.util.Map<String, Letter> itsVariables = new java.util.HashMap<>();

    public Context() {
    }

    public Letter checkoutVariable(String theName) {
        return checkoutVariable(theName, null);
    }

    public Letter checkoutVariable(String theName, String theDescription) {
        String someName = (null!=theName) ? theName.trim() : "";
        Letter variable = null;
        if(someName.length()>0) {
            variable = itsVariables.get(someName);
            if(null==variable) {
                variable = new Letter(someName, theDescription);
                itsVariables.put(someName, variable);
                itsVariableNames.add(someName);
            }
        }
        return variable;
    }

    java.util.List<String> getNames() {
        return (null!=itsVariableNames && itsVariableNames.size()>0) ? new java.util.ArrayList<>(itsVariableNames) : new java.util.ArrayList<>();
    }

    public Structure getStructureWithDefaults(boolean someDefaultValue) {
        java.util.Map<String, Boolean> values = new java.util.HashMap<>();
        itsVariables.keySet().forEach((String name) -> {
            values.put(name, someDefaultValue);
        });
        return new Structure(values);
    }

    public boolean isSentenceAContradiction(Sentence someSentence) {
        boolean contradiction = false;
        if(null!=someSentence) {
            StructureIterator iterator = iterator();
            if(iterator.hasNext()) {
                boolean c = true;
                while(iterator.hasNext() && c) {
                    Structure structure = iterator.next();
                    c = !someSentence.evaluate(structure);
                }
                contradiction = c;
            } else {
                Structure structure = new Structure(null);
                contradiction = !someSentence.evaluate(structure);
            }
        }
        return contradiction;
    }

    public boolean isSentenceATautology(Sentence someSentence) {
        boolean tautology = false;
        if(null!=someSentence) {
            StructureIterator iterator = iterator();
            if(iterator.hasNext()) {
                boolean c = true;
                while(iterator.hasNext() && c) {
                    Structure structure = iterator.next();
                    c = someSentence.evaluate(structure);
                }
                tautology = c;
            } else {
                Structure structure = new Structure(null);
                tautology = someSentence.evaluate(structure);
            }
        }
        return tautology;
    }

    public boolean isValid(java.util.Set<Sentence> thePremisses, Sentence theConclusion) {
        boolean valid = true;
        StructureIterator iterator = iterator();
        if(iterator.hasNext()) {
            while(iterator.hasNext() && valid) {
                Structure structure = iterator.next();
                boolean truePremisses=true;
                if(null!=thePremisses && thePremisses.size()>0) {
                    for(Sentence sentence: thePremisses) {
                        if(!sentence.evaluate(structure)) {
                            truePremisses=false;
                        }
                    }
                }
                if(truePremisses) {
                    valid = theConclusion.evaluate(structure);
                }
            }
        } else {
            Structure structure = new Structure(null);
            boolean truePremisses=true;
            if(null!=thePremisses && thePremisses.size()>0) {
                for(Sentence sentence: thePremisses) {
                    if(!sentence.evaluate(structure)) {
                        truePremisses=false;
                    }
                }
            }
            if(truePremisses) {
                valid = theConclusion.evaluate(structure);
            }
        }
        return valid;
    }

    @Override
    public StructureIterator iterator() {
        return new StructureIterator(this);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[ Context: ");
        int i=0;
        for(String name: itsVariableNames) {
            if(i>0) {
                builder.append(", ");
            }
            builder.append(name);
            i++;
        }
        builder.append(" ]");
        return builder.toString();
    }
}
