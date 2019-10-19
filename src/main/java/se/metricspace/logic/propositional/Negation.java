/*
 * Copyright (c) 2019, Mange
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
public class Negation implements Sentence {
    private final Sentence itsSentence;

    private Negation() {
        itsSentence=null;
    }

    public Negation(Sentence someExpression) {
        itsSentence = someExpression;
    }

    public Negation(Negation someNegation) {
        itsSentence = (null!=someNegation) ? someNegation.itsSentence : null;
    }

    @Override
    public boolean equals(Object someObject) {
        boolean eq = false;
        if(null!=someObject && someObject instanceof Negation) {
            Negation x = (Negation)someObject;
            eq = itsSentence.equals(x.itsSentence);
        }
        return eq;
    }

    @Override
    public boolean evaluate(Structure someStructure) {
        return !itsSentence.evaluate(someStructure);
    }

    public Sentence getSentence() {
        return itsSentence;
    }
}
