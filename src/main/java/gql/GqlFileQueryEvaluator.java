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

package gql;

import antlr.GqlLexer;
import antlr.GqlParser;
import gql.tables.BindingTable;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;

import java.io.IOException;
import java.nio.file.NoSuchFileException;

public class GqlFileQueryEvaluator extends GqlQueryEvaluator {
    private String filePath;

    public GqlFileQueryEvaluator(String filePath) {
        this.filePath = filePath;
    }

    protected GqlLexer getLexer() {
        return new GqlLexer(getInputFromFile());
    }

    private CharStream getInputFromFile() {
        CharStream input = null;

        try {
            input = CharStreams.fromFileName(this.filePath);
        } catch (NoSuchFileException exception) {
            try {
                input = CharStreams.fromFileName(System.getProperty("user.dir") + this.filePath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return input;
    }
}
