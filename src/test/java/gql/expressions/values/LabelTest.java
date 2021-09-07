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

import org.junit.Test;

import static org.junit.Assert.*;

public class LabelTest {
    @Test
    public void testLabelEquality() {
        Label label1 = new Label("Test");
        Label label2 = new Label("Test");
        Label label3 = new Label("test");
        Label label4 = new Label("Tést");

        assertEquals(label1, label2);
        assertNotEquals(label1, label3);
        assertNotEquals(label1, label4);

        Label label5 = new Label("Test1");
        Label label6 = new Label("Test1");
        Label label7 = new Label("Test2");

        assertEquals(label5, label6);
        assertNotEquals(label6, label7);
    }

    @Test
    public void testAnyLabelEqualToWildcardLabel() {
        Label testLabel = new Label("Test");

        WildcardLabel wildcardLabel = new WildcardLabel();

        assertTrue(testLabel.equals(wildcardLabel));
    }
}