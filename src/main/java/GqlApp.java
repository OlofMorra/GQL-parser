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

import gql.GqlFileQueryEvaluator;
import gql.GqlQueryEvaluator;
import gql.GqlUserInputQueryEvaluator;
import gql.graphs.WorkingGraph;
import gql.tables.BindingTable;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class GqlApp
{
    private static boolean OUTPUT_ALGEBRA = false;

    public static void main(String[] args) throws Exception {
        try {
            String testQueryFolder = "/src/test/resources/queries/";

            OUTPUT_ALGEBRA = containsAlgebraOutputFlag(args);

            if (containsCustomInputFlag(args)) {
                handleUserInputQueries();
            } else {
                handleFileInputQuery(args, testQueryFolder);
            }
        } catch (IllegalStateException exception) {
            System.err.println(exception.getMessage());
        }
    }

    private static void handleUserInputQueries() {
        System.out.println("Exit the program by entering Ctrl+c.");

        while (true) {
            handleUserInputQuery();
        }
    }

    private static void handleUserInputQuery() {
        try {
            GqlQueryEvaluator gqlQueryEvaluator = getGqlUserInputQueryEvaluator();
            if (OUTPUT_ALGEBRA) handleOutputAlgebra(gqlQueryEvaluator);

            System.out.println("\nExecuting the query.");
            BindingTable result = gqlQueryEvaluator.getEvaluationResult();
            result.printToConsole();
        } catch (IllegalStateException exception) {
            System.err.println(exception.getMessage());
        }
    }

    private static void handleFileInputQuery(String[] args, String testQueryFolder) {
        try {
            GqlQueryEvaluator gqlQueryEvaluator = getGqlFileQueryEvaluator(args, testQueryFolder);
            if (OUTPUT_ALGEBRA) handleOutputAlgebra(gqlQueryEvaluator);

            System.out.println("\nExecuting the query.");
            BindingTable result = gqlQueryEvaluator.getEvaluationResult();
            result.printToConsole();
        } catch (IllegalStateException exception) {
            System.err.println(exception.getMessage());
        }
    }

    private static void handleOutputAlgebra(GqlQueryEvaluator gqlQueryEvaluator) {
        System.out.println("Algebra of given query, add it to the Latex file and compile with Latex compiler.");
        System.out.println(gqlQueryEvaluator.getLatexResult());
    }

    private static boolean containsCustomInputFlag(String[] args) {
        return Arrays.asList(args).contains("-q");
    }

    private static boolean containsAlgebraOutputFlag(String[] args) {
        return Arrays.asList(args).contains("-a");
    }

    private static GqlUserInputQueryEvaluator getGqlUserInputQueryEvaluator() {
        String inputQuery = getQueryFromUser();

        return new GqlUserInputQueryEvaluator(inputQuery);
    }

    private static String getQueryFromUser() {
        String query = "";

        System.out.println("");
        WorkingGraph.getInstance().printGraphName();
        System.out.println("Type in your query, it will be executed after typing execute on a new line and hitting enter");

        return getInputFromUser(query);
    }

    private static String getInputFromUser(String query) {
        Scanner scanner = new Scanner(System.in);

        String line;
        while (scanner.hasNextLine())
        {
            line = scanner.nextLine();

            if (isExecuteStatement(line.split("\\s"))) {
                scanner.reset();
                return query;
            } else {
                query = query.concat(line + "\n");
            }
        }

        return query;
    }

    private static boolean isExecuteStatement(String[] tokens) {
        return tokens.length > 0 && tokens[0].matches("(?i)execute");
    }

    private static GqlFileQueryEvaluator getGqlFileQueryEvaluator(String[] args, String testQueryFolder) {
        try {
            String queryFilePath = getFilePath(args, testQueryFolder);
            return new GqlFileQueryEvaluator(queryFilePath);
        } catch (IllegalArgumentException exception) {
            System.err.println(exception.toString());
        } catch (Throwable t) {
            t.printStackTrace();
        }

        throw new IllegalArgumentException("Query file cannot be found.");
    }

    private static String getFilePath(String[] args, String testQueryFolder)
            throws IllegalArgumentException, FileNotFoundException {
        checkIfFileExists(args[0], testQueryFolder);

        return testQueryFolder + args[0];
    }

    private static void checkIfFileExists(String arg, String testQueryFolder) throws FileNotFoundException {
        File file = new File(System.getProperty("user.dir") + testQueryFolder + arg);

        if (!file.exists()) {
            throw new FileNotFoundException("No file found with name \"" + arg + "\". Make sure the paths starts from " + testQueryFolder + ".");
        }
    }
}
