package gql.tables;

import static org.junit.Assert.assertEquals;

public interface BindingTableComparator {
    default void checkIfBindingTablesAreEqual(BindingTable expectedResult, BindingTable actualResult) {
        if (expectedResult.hasDuplicates() != actualResult.hasDuplicates()) {
            System.err.println("Expected " + (expectedResult.hasDuplicates() ? "": "no ") + "duplicates, but actual has opposite.");
        }

        if (!expectedResult.equals(actualResult)) {
            assertEquals(expectedResult, actualResult);
            System.err.println("Expected:");
            System.err.println("Has duplicates: " + expectedResult.hasDuplicates());
            expectedResult.printToConsole();
            System.err.println("Actual:");
            System.err.println("Has duplicates: " + actualResult.hasDuplicates());
            actualResult.printToConsole();
        }

    }
}
