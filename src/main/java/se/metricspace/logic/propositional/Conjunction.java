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
 * @author mange
 */
public class Conjunction implements BinaryConnective {
    private final Sentence itsFirstExpression;
    private final Sentence itsSecondExpression;

    private Conjunction() {
        itsFirstExpression = null;
        itsSecondExpression = null;
    }

    public Conjunction(Sentence first, Sentence second) {
        itsFirstExpression = first;
        itsSecondExpression = second;
    }

    public Conjunction(Conjunction someConjunction) {
        itsFirstExpression = (null!=someConjunction) ? someConjunction.itsFirstExpression:null;
        itsSecondExpression = (null!=someConjunction) ? someConjunction.itsSecondExpression:null;
    }

    @Override
    public boolean equals(Object someObject) {
        boolean eq = false;
        if(null!=someObject && someObject instanceof Conjunction) {
            Conjunction x = (Conjunction)someObject;
            eq = itsFirstExpression.equals(x.itsFirstExpression) && itsSecondExpression.equals(x.itsSecondExpression);
        }
        return eq;
    }

    @Override
    public boolean evaluate(Structure someStructure) {
        return itsFirstExpression.evaluate(someStructure) && itsSecondExpression.evaluate(someStructure);
    }

    @Override
    public Sentence getFirstExpression() {
        return itsFirstExpression;
    }

    @Override
    public Sentence getSecondExpression() {
        return itsSecondExpression;
    }

    @Override
    public boolean isAssociative() {
        return true;
    }

    @Override
    public boolean isCommutative() {
        return true;
    }
}
