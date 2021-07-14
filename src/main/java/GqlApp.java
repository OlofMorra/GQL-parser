import exceptions.SemanticErrorException;
import exceptions.SyntaxErrorException;
import gql.GqlFileQueryEvaluator;
import gql.GqlQueryEvaluator;
import gql.GqlUserInputQueryEvaluator;
import gql.graphs.WorkingGraph;
import gql.tables.BindingTable;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GqlApp
{
    public static void main(String[] args) throws Exception {
        try {
            String testQueryFolder = "/src/test/resources/queries/";

            checkForSingleInputArgument(args, testQueryFolder);

            if (isInputFlag(args)) {
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

            BindingTable result = gqlQueryEvaluator.getEvaluationResult();
            result.printToConsole();
        } catch (IllegalStateException exception) {
            System.err.println(exception.getMessage());
        }
    }

    private static void handleFileInputQuery(String[] args, String testQueryFolder) {
        GqlQueryEvaluator gqlQueryEvaluator = getGqlFileQueryEvaluator(args, testQueryFolder);

        BindingTable result = gqlQueryEvaluator.getEvaluationResult();
        result.printToConsole();
    }

    private static boolean isInputFlag(String[] args) {
        return args[0].equals("-q");
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
                System.out.println("\nExecuting the query.");
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

    private static void checkForSingleInputArgument(String[] args, String testQueryFolder) throws IllegalArgumentException {
        if (args.length != 1) {
            throw new IllegalArgumentException("Usage: file path including file name from " +  testQueryFolder + " folder or the flag -q.");
        }
    }

    private static void checkIfFileExists(String arg, String testQueryFolder) throws FileNotFoundException {
        File file = new File(System.getProperty("user.dir") + testQueryFolder + arg);

        if (!file.exists()) {
            throw new FileNotFoundException("No file found with name \"" + arg + "\". Make sure the paths starts from " + testQueryFolder + ".");
        }
    }
}
