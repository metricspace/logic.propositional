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
public class StructureIterator implements java.util.Iterator<Structure> {
    private final Context itsContext;
    private int itsIndex = 0;
    private int itsLimit = 0;
    private java.util.List<String> itsNames = null;

    private StructureIterator() {
        itsContext = null;
    }

    StructureIterator(Context someContext) {
        itsContext = someContext;
        if(null!=itsContext) {
            itsNames = itsContext.getNames();
            itsLimit = (itsContext.getNames().size()>0)?1:0;
            for(String name:itsNames) {
                itsLimit *= 2;
            }
        }
    }

    @Override
    public boolean hasNext() {
        return itsIndex<itsLimit;
    }

    @Override
    public Structure next() {
        if (!hasNext()) {
            throw new java.util.NoSuchElementException();
        }
        java.util.Map<String, Boolean> values = new java.util.HashMap<>();
        int tmp = itsIndex;
        for(int index=0; index<itsNames.size(); index++) {
            Boolean b = (1==tmp%2);
            values.put(itsNames.get(index), b);
            tmp /=2;
        }
        itsIndex++;
        return new Structure(values);
    }
}
