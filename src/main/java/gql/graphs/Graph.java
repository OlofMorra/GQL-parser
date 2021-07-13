package gql.graphs;

import exceptions.InvalidEdgeFormatException;
import exceptions.InvalidNodeFormatException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public abstract class Graph {
    protected String currentGraphName;
    protected static boolean isTest;
    private final String TEST_DIRECTORY = "/src/test/resources/database/";
    private final String MAIN_DIRECTORY = "/src/main/resources/database/";

    public abstract void setRemoteGraph();
    protected abstract void setEmptyGraph();
    protected abstract void initializeNodes(String graphName) throws FileNotFoundException, InvalidNodeFormatException;
    protected abstract void intializeEdges(String graphName) throws FileNotFoundException, InvalidEdgeFormatException;

    public void setLocalGraph(String graphName) throws IllegalArgumentException, FileNotFoundException, InvalidNodeFormatException, InvalidEdgeFormatException {
        if (graphNotExists(graphName)) {
            throw new IllegalArgumentException("There is no graph directory \"" + graphName + "\".");
        } else if (graphNotComplete(graphName)) {
            throw new FileNotFoundException("Directory database/" + graphName + " needs to have a node.json and edgePattern.json file.");
        } else if (graphName.equals(currentGraphName)) {
            return;
        }

        setEmptyGraph();

        initializeNodes(graphName);
        intializeEdges(graphName);

        currentGraphName = graphName;
    }

    protected boolean graphNotExists(String graphName) {
        ArrayList<String> graphDirectories = getAvailableGraphNames();

        return !graphDirectories.contains(graphName);
    }

    protected boolean graphNotComplete(String graphName) {
        File graphDirectory = getGraphDirectory(graphName);
        ArrayList<String> graphFileNames = new ArrayList<>(Arrays.asList(graphDirectory.list()));

        return !(graphFileNames.contains("nodes.json") && graphFileNames.contains("edges.json"));
    }

    public void setToTestDirectory() {
        isTest = true;
    }

    public void setToMainDirectory() {
        isTest = false;
    }

    protected String getFirstGraphName() {
        ArrayList<String> graphDirectories = getAvailableGraphNames();
        Collections.sort(graphDirectories);

        return graphDirectories.get(0);
    }

    protected ArrayList<String> getAvailableGraphNames() throws NullPointerException, IllegalStateException {
        File databaseDirectory = getDatabaseDirectory();

        String[] graphs = databaseDirectory.list(getDirectoryFilter());

        if (graphs == null) {
            throw new NullPointerException("Incorrect database directory.");
        } else if (graphs.length == 0) {
            throw new IllegalStateException("Database folder does not contain any graphs.");
        }

        return new ArrayList<>(Arrays.asList(graphs));
    }

    protected File getGraphDirectory(String graphName) {
        return new File(getDatabaseDirectory() + "/" + graphName);
    }

    private File getDatabaseDirectory() {
        return new File(System.getProperty("user.dir")
                + ((isTest) ? TEST_DIRECTORY : MAIN_DIRECTORY));
    }

    private FilenameFilter getDirectoryFilter() {
        return (file, filename) -> {
            // For some reason it outputs that .DS_Store is a directory
            if (filename.equals(".DS_Store")) {
                return false;
            }

            return file.isDirectory();
        };
    }

    public void printGraphName() {
        System.out.println("The current working graph is " + currentGraphName);
    }
}
