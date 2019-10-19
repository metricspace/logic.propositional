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
public class ConstantTest {
    @Test
    public void checkEqFF() {
        assertEquals(true, Constant.FALSE.equals(Constant.FALSE));
    }

    @Test
    public void checkEqFT() {
        assertEquals(false, Constant.FALSE.equals(Constant.TRUE));
    }

    @Test
    public void checkEqTF() {
        assertEquals(false, Constant.TRUE.equals(Constant.FALSE));
    }

    @Test
    public void checkEqTT() {
        assertEquals(true, Constant.TRUE.equals(Constant.TRUE));
    }

    @Test
    public void checkFalsity() {
        assertEquals(false, Constant.FALSE.getValue());
    }

    @Test
    public void checkTrueness() {
        assertEquals(true, Constant.TRUE.getValue());
    }
}
