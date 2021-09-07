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

import java.text.Collator;
import java.util.Locale;
import java.util.Objects;

public class GqlString extends Value {
    String gqlString;
    Collator collator = Collator.getInstance(Locale.getDefault());

    public GqlString(String gqlString) {
        this.gqlString = gqlString;
    }

    @Override
    public TruthValue isEqualTo(Value valueToCompareTo) {
        if (valueToCompareTo.equals(new TruthValue(null))) {
            return new TruthValue(null);
        } else if (valueToCompareTo instanceof GqlString) {
            return new TruthValue(collator.compare(gqlString, ((GqlString) valueToCompareTo).gqlString) == 0);
        } else if (valueToCompareTo instanceof GqlIdentifier) {
            return valueToCompareTo.isEqualTo(this);
        }

        throw new SemanticErrorException("Cannot compare type GqlString to type " + valueToCompareTo.getClass() + ".");
    }

    @Override
    public TruthValue isSmallerThan(Value valueToCompareTo) {
        if (valueToCompareTo.equals(new TruthValue(null))) {
            return new TruthValue(null);
        } else if (valueToCompareTo instanceof GqlString) {
            return new TruthValue(collator.compare(gqlString, ((GqlString) valueToCompareTo).gqlString) < 0);
        }

        throw new SemanticErrorException("Cannot compare type GqlString to type " + valueToCompareTo.getClass() + ".");
    }

    @Override
    public String toString() {
        return "\"" + gqlString + "\"";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        GqlString gqlString1 = (GqlString) o;
        return gqlString.equals(gqlString1.gqlString) && collator.equals(gqlString1.collator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gqlString, collator);
    }
}
