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
package sample.propositional;

/**
 * @author Mange
 */
public class CheckConclusion {
    public static void main(String[] args) {
        se.metricspace.logic.propositional.Context context = new se.metricspace.logic.propositional.Context();
        java.util.Set<se.metricspace.logic.propositional.Sentence> premisses = new java.util.HashSet<>();
//        premisses.add(new se.metricspace.logic.propositional.Implication(context.checkoutVariable("P", "Some description"), context.checkoutVariable("Q", "Some other description")));
        premisses.add(new se.metricspace.logic.propositional.Implication(se.metricspace.logic.propositional.Constant.TRUE, se.metricspace.logic.propositional.Constant.FALSE));
//        premisses.add(context.checkoutVariable("P", "Some description"));
        se.metricspace.logic.propositional.Sentence conclusion = context.checkoutVariable("Q");
        System.out.println("Checking: "+context.isValid(premisses, conclusion));
    }
}
