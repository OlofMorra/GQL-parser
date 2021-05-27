package json;

import com.fasterxml.jackson.core.io.JsonEOFException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import exceptions.InvalidEdgeFormatException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.util.ArrayList;

public class EdgeParser {
    ObjectMapper objectMapper;
    File fileToParse;

    public EdgeParser(String filePath) throws FileNotFoundException {
        objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
        fileToParse = new File(filePath);

        if (!fileToParse.exists()) {
            throw new FileNotFoundException("There is no file with filepath " + filePath);
        }
    }

    public ArrayList<JsonEdge> getEdges() throws InvalidEdgeFormatException {
        JsonEdgeList edgeList = null;

        try {
            edgeList = objectMapper.readValue(fileToParse, JsonEdgeList.class);
        } catch (JsonMappingException exception) {
            System.err.println("edge.json is not formatted correctly at " + fileToParse.getAbsolutePath() + ".");
            System.err.println(exception.getMessage());
            throw new InvalidEdgeFormatException(exception.getMessage());
        } catch (JsonEOFException exception) {
            System.err.println("edge.json is not formatted correctly at " + fileToParse.getAbsolutePath() + ".");
            System.err.println(exception.getMessage());
            throw new InvalidEdgeFormatException(exception.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }

        assert edgeList != null;
        return edgeList.edges;
    }
}
