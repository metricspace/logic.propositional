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
public class DisjunctionTest {
    @Test
    public void checkTruthTableFF() {
        Structure structure = new Structure(null);
        Disjunction disjunction = new Disjunction(Constant.FALSE, Constant.FALSE);
        assertEquals(false, disjunction.evaluate(structure));
    }

    @Test
    public void checkTruthTableFT() {
        Structure structure = new Structure(null);
        Disjunction disjunction = new Disjunction(Constant.FALSE, Constant.TRUE);
        assertEquals(true, disjunction.evaluate(structure));
    }

    @Test
    public void checkTruthTableTF() {
        Structure structure = new Structure(null);
        Disjunction disjunction = new Disjunction(Constant.TRUE, Constant.FALSE);
        assertEquals(true, disjunction.evaluate(structure));
    }

    @Test
    public void checkTruthTableTT() {
        Structure structure = new Structure(null);
        Disjunction disjunction = new Disjunction(Constant.TRUE, Constant.TRUE);
        assertEquals(true, disjunction.evaluate(structure));
    }
}
