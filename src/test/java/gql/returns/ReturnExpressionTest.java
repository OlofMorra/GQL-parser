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

package gql.returns;

import exceptions.SemanticErrorException;
import gql.enums.BooleanComparator;
import gql.enums.ValueComparator;
import gql.expressions.filters.BooleanExpressionComparison;
import gql.expressions.filters.NegatedExpression;
import gql.expressions.filters.ValueComparison;
import gql.expressions.references.NameExpression;
import gql.expressions.references.PropertyReference;
import gql.expressions.values.FixedPointNumber;
import gql.expressions.values.GqlString;
import gql.expressions.values.TruthValue;
import org.junit.Test;

public class ReturnExpressionTest {

    @Test(expected = SemanticErrorException.class)
    public void testPropertyReferenceWithoutAlias() {
        new ReturnExpression(new PropertyReference("x", "not"));
    }

    @Test(expected = SemanticErrorException.class)
    public void testNegatedExpressionWithoutAlias() {
        new ReturnExpression(new NegatedExpression(new TruthValue(true)));
    }

    @Test(expected = SemanticErrorException.class)
    public void testValueWithoutAlias() {
        new ReturnExpression(new FixedPointNumber("3"));
    }

    @Test(expected = SemanticErrorException.class)
    public void testBooleanExpressionComparisonWithoutAlias() {
        new ReturnExpression(new BooleanExpressionComparison(new TruthValue(true), BooleanComparator.OR, new TruthValue(true)));
    }

    @Test(expected = SemanticErrorException.class)
    public void testValueComparisonWithoutAlias() {
        new ReturnExpression(new ValueComparison(new GqlString("test"), ValueComparator.EQ, new GqlString("test")));
    }

    @Test
    public void testNameExpressionWithoutAlias() {
        new ReturnExpression(new NameExpression("x"));
    }
}