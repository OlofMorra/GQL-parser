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
import gql.expressions.Expression;

public abstract class Value extends Expression {
    /**
     * Use this method for the equals operator in GQL, use the equals method
     * of Java to compare if two objects are equal.
     *
     * @param valueToCompareTo  A Value to compare this to
     * @return A GQL truth value (FALSE, TRUE or UNKNOWN)
     */
    public abstract TruthValue isEqualTo(Value valueToCompareTo);
    public abstract TruthValue isSmallerThan(Value valueToCompareTo);

    // Base on defined implementation of isEqualTo and isSmallerThan of Value type
    public TruthValue isSmallerOrEqualThan(Value valueToCompareTo) {
        if (isEqualTo(valueToCompareTo).equals(new TruthValue(true)) ||
            isSmallerThan(valueToCompareTo).equals(new TruthValue(true))) {
            return new TruthValue(true);
        }

        return isSmallerThan(valueToCompareTo);
    }

    public TruthValue isLargerThan(Value valueToCompareTo) {
        return isSmallerOrEqualThan(valueToCompareTo).getNegation();
    }

    public TruthValue isLargerOrEqualThan(Value valueToCompareTo) {
        return isSmallerThan(valueToCompareTo).getNegation();
    }

    /**
     * Returns the length of string that will be printed.
     * @return
     */
    public int length() {
        return this.toString().length();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Value) {
            try {
                return isEqualTo((Value) obj).isTrue();
            } catch (SemanticErrorException exception) {
                return false;
            }
        }

        return false;
    }

    @Override
    public String toLatex() {
        return toString();
    }
}
