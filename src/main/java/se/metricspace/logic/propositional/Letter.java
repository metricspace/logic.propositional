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
public class Letter implements Sentence, Comparable<Letter> {
    private final String itsDescription;
    private final String itsName;

    private Letter() {
        itsDescription = null;
        itsName = null;
    }

    Letter(String theName, String theDescription) {
        itsDescription = (null!=theDescription && theDescription.trim().length()>0) ? theDescription.trim() : null;
        itsName = (null!=theName && theName.trim().length()>0) ? theName.trim() : null;
    }

    private Letter(Letter someLetter) {
        itsDescription = (null!=someLetter) ? someLetter.itsDescription : null;
        itsName = (null!=someLetter) ? someLetter.itsName : null;
    }

    @Override
    public int compareTo(Letter someLetter) {
        return itsName.compareTo(someLetter.itsName);
    }

    @Override
    public boolean equals(Object someObject) {
        boolean eq = false;
        if(null!=someObject && someObject instanceof Letter) {
            Letter someVariable = (Letter) someObject;
            eq = itsName.equals(someVariable.itsName);
        }
        return eq;
    }

    @Override
    public boolean evaluate(Structure someStructure) {
        return someStructure.getValue(itsName);
    }

    public String getDescription() {
        return itsDescription;
    }

    public String getName() {
        return itsName;
    }

    @Override
    public int hashCode() {
        return itsName.hashCode();
    }

    @Override
    public String toString() {
        return itsName;
    }
}
