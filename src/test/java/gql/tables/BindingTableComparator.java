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

package gql.tables;

import static org.junit.Assert.assertEquals;

public interface BindingTableComparator {
    default void checkIfBindingTablesAreEqual(BindingTable expectedResult, BindingTable actualResult) {
        if (expectedResult.hasDuplicates() != actualResult.hasDuplicates()) {
            System.err.println("Expected " + (expectedResult.hasDuplicates() ? "": "no ") + "duplicates, but actual has opposite.");
        }

        if (!expectedResult.equals(actualResult)) {
            System.err.println("Expected:");
            System.err.println("Has duplicates: " + expectedResult.hasDuplicates());
            expectedResult.printToConsole();
            System.err.println("Actual:");
            System.err.println("Has duplicates: " + actualResult.hasDuplicates());
            actualResult.printToConsole();
            assertEquals(expectedResult, actualResult);
        }
    }
}
