import gql.tables.BindingTable;

import java.io.File;
import java.io.FileNotFoundException;
import org.antlr.v4.runtime.TokenSource;

public class GqlApp
{
    public static void main(String[] args) throws Exception {
        String testQueryFolder = "/src/test/resources/queries/";

        try {
            String queryFilePath = getFilePath(args, testQueryFolder);
            executeQuery(queryFilePath);
        } catch (IllegalArgumentException exception) {
            System.err.println(exception.toString());
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    private static String getFilePath(String[] args, String testQueryFolder)
            throws IllegalArgumentException, FileNotFoundException {
        checkForSingleInputArgument(args, testQueryFolder);

        // TODO: implement -q flag for query

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

    private static void executeQuery(String queryFilePath) {
        GqlQueryEvaluator gqlQueryEvaluator = new GqlQueryEvaluator(queryFilePath);

        BindingTable result = gqlQueryEvaluator.getEvaluationResult();
        result.printToConsole();
    }
}
