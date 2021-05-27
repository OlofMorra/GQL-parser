import java.io.File;
import java.io.FileNotFoundException;

public class GqlApp
{
    public static void main(String[] args) throws Exception {
        String testQueryFolder = "src/test/resources/queries/";

        // Get query file from user
//        String queryFilePath = getFilePath(args, testQueryFolder);
//        executeQuery(queryFilePath);

        String[] queryFilePaths = new String[]{"src/test/resources/queries/gql/tests/comparison_operators/equals_op.gql",
                "src/test/resources/queries/gql/report/example_2.3_acyclic.gql",
                "src/test/resources/queries/gql/tests/syntax_errors/AND.gql"};

        for (String filePath: queryFilePaths) {
            System.out.println("");
            System.out.println("New query:");
            executeQuery(filePath);
        }
    }

    private static String getFilePath(String[] args, String testQueryFolder)
            throws IllegalArgumentException, FileNotFoundException {
        checkForSingleInputArgument(args, testQueryFolder);
        checkIfFileExists(args[0], testQueryFolder);

        return testQueryFolder + args[0];
    }

    private static void checkForSingleInputArgument(String[] args, String testQueryFolder) throws IllegalArgumentException {
        if (args.length != 1) {
            throw new IllegalArgumentException("Usage: file path including file name from " +  testQueryFolder + " folder.");
        }
    }

    private static void checkIfFileExists(String arg, String testQueryFolder) throws FileNotFoundException {
        File file = new File(System.getProperty("user.dir") + testQueryFolder + arg);

        if (!file.exists()) {
            throw new FileNotFoundException("No file found with name \"" + arg + "\". Make sure the paths starts from " + testQueryFolder + ".");
        }
    }

    private static void executeQuery(String queryFilePath) {
        GqlQueryEvaluator gqlQueryProcessor = new GqlQueryEvaluator(queryFilePath);
        gqlQueryProcessor.execute();
    }
}
