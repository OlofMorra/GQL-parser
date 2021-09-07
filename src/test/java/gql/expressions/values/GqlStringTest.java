/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package gql.expressions.values;

import exceptions.SemanticErrorException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GqlStringTest {
    private final TruthValue TRUE = new TruthValue(true);
    private final TruthValue FALSE = new TruthValue(false);
    private final TruthValue UNKNOWN = new TruthValue(null);

    @Test
    public void testGqlStringEquals() {
        GqlString first = new GqlString("test");
        GqlString second = new GqlString("test");

        assertEquals(first.isEqualTo(second), TRUE);
    }

    @Test
    public void testGqlStringNotEquals() {
        GqlString first = new GqlString("definitely");
        GqlString second = new GqlString("not equal");

        assertEquals(first.isEqualTo(second), FALSE);
    }

    @Test
    public void testGqlStringNotEqualsOnCapitals() {
        GqlString first = new GqlString("test");
        GqlString second = new GqlString("Test");

        assertEquals(first.isEqualTo(second), FALSE);
    }

    @Test(expected = SemanticErrorException.class)
    public void testGqlStringToNumberComparison() {
        GqlString gqlString = new GqlString("test");
        FixedPointNumber fixedPointNumber = new FixedPointNumber("85");

        gqlString.isEqualTo(fixedPointNumber);
    }

    @Test(expected = SemanticErrorException.class)
    public void testGqlStringToTrueComparison() {
        GqlString gqlString = new GqlString("test");

        gqlString.isEqualTo(TRUE);
    }

    @Test(expected = SemanticErrorException.class)
    public void testGqlStringToFalseComparison() {
        GqlString gqlString = new GqlString("test");

        gqlString.isEqualTo(FALSE);
    }

    @Test
    public void testGqlStringToUnknownComparison() {
        GqlString gqlString = new GqlString("test");

        assertEquals(gqlString.isEqualTo(UNKNOWN), UNKNOWN);
    }

    // TODO: Do I want to add test cases for inequalities as they
    //  depend on the strength of the collator.
}