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

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * @author Mange
 */
public class ContextTest {
    @Test
    public void checkoutVariableDiff() {
        Context context = new Context();
        Letter letter1 = context.checkoutVariable("Q");
        Letter letter2 = context.checkoutVariable("P");
        assert(letter1!=letter2);
        assert(!letter1.equals(letter2));
    }

    @Test
    public void checkoutVariableEquality() {
        Context context = new Context();
        Letter letter1 = context.checkoutVariable("Q");
        Letter letter2 = context.checkoutVariable("Q");
        assert(letter1==letter2);
        assert(letter1.equals(letter2));
    }

    @Test
    public void getNames() {
        Context context = new Context();
        context.checkoutVariable("R");
        context.checkoutVariable("P");
        context.checkoutVariable("Q");
        java.util.List<String> names = context.getNames();
        assert(names.get(0).equals("P"));
        assert(names.get(1).equals("Q"));
        assert(names.get(2).equals("R"));
    }

    @Test
    public void isSentenceAContradiction() {
        Context context = new Context();
        se.metricspace.logic.propositional.Sentence sentence1 = new se.metricspace.logic.propositional.Conjunction(context.checkoutVariable("Q"), se.metricspace.logic.propositional.Constant.FALSE);
        se.metricspace.logic.propositional.Sentence sentence2 = new se.metricspace.logic.propositional.Conjunction(context.checkoutVariable("P"), se.metricspace.logic.propositional.Constant.FALSE);
        se.metricspace.logic.propositional.Sentence sentence3 = new se.metricspace.logic.propositional.Disjunction(sentence1, sentence2);
        assert(context.isSentenceAContradiction(sentence3));
    }

    @Test
    public void isSentenceATautology() {
        Context context = new Context();
        se.metricspace.logic.propositional.Sentence sentence1 = new se.metricspace.logic.propositional.Disjunction(context.checkoutVariable("Q"), se.metricspace.logic.propositional.Constant.TRUE);
        se.metricspace.logic.propositional.Sentence sentence2 = new se.metricspace.logic.propositional.Disjunction(context.checkoutVariable("P"), se.metricspace.logic.propositional.Constant.TRUE);
        se.metricspace.logic.propositional.Sentence sentence3 = new se.metricspace.logic.propositional.Conjunction(sentence1, sentence2);
        assert(context.isSentenceATautology(sentence3));
    }
}
