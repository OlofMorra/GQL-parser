package json.gremlin;

import com.fasterxml.jackson.core.io.JsonEOFException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import exceptions.InvalidNodeFormatException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class NodeParser {
    ObjectMapper objectMapper;
    File fileToParse;

    public NodeParser(String filePath) throws FileNotFoundException {
        fileToParse = new File(filePath);

        if (!fileToParse.exists()) {
            throw new FileNotFoundException("There is no file with filepath " + filePath);
        }

        objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
    }

    public ArrayList<JsonNode> getNodes() throws InvalidNodeFormatException {
        JsonNodeList nodeList = null;

        try {
            nodeList = objectMapper.readValue(fileToParse, JsonNodeList.class);
        } catch (JsonMappingException exception) {
            System.err.println("node.json is not formatted correctly at " + fileToParse.getAbsolutePath() + ".");
            System.err.println(exception.getMessage());
            throw new InvalidNodeFormatException(exception.getMessage());
        } catch (JsonEOFException exception) {
            System.err.println("node.json is not formatted correctly at " + fileToParse.getAbsolutePath() + ".");
            System.err.println(exception.getMessage());
            throw new InvalidNodeFormatException(exception.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }

        assert nodeList != null;
        return nodeList.nodes;
    }
}
