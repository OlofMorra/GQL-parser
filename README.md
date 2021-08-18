# GQL parser
A GQL parser build with ANTLR v4.

---
## Executing queries
Open the project in your favorite IDE (I use IntelliJ) and make sure you have Maven installed.
Build the project from the command line by going to the [GQL-parser]() folder. Run `mvn clean install`. 
If test cases fail (I have seen some cross platform errors), you can try `mvn clean install -Dmaven.test.skip=true`.
Now there are two ways to execute the program, the first allows you to run queries from the 
[src/test/resources/queries](src/test/resources/queries) folder, the second allows you to type 
the query in your terminal (Mac) or Command Prompt (Windows).

* `mvn exec:java -Dexec.mainClass="GqlApp" -e -Dexec.args="/gql/tests/conjunctions/union_all.gql"` 
  * Executes the query found in the [union_all.gql](src/test/resources/queries/gql/test/conjunctions/union_all.gql)
    file
* `mvn exec:java -Dexec.mainClass="GqlApp" -e -Dexec.args="-q"`
  * Asks the user for a query and executes it when `execute` is entered. This process is continued until
    `Ctrl+c` is entered.
    
---
## Queries
In the folder [src/test/resources/queries/gql](src/test/resources/queries/gql) you can find example queries
from the report and test queries which show the syntax of GQL in some detail.

---
## Data
Queries are executed on property graphs. In this project multiple property graphs are given via .json files. All graphs in
[src/main/resources/database](src/main/resources/database) come from my report and contain valid data.
All graphs in [src/test/resources/database](src/test/resources/database) contains test graphs which are not
valid, except for [syntheticGraph](src/test/resources/database/syntheticGraph). 

#### Valid graphs
* `g`
* `g1`
* `g2`
* `g3`
* `syntheticGraph` (test graph)

### Providing your own data
If you want to provide your own data to the parser, create a new folder in
[src/main/resources/database](src/main/resources/database) where the folder name will be the reference name of 
the graph. All graphs contain two files, one file called *nodes.json* containing nodes with labels and properties, 
and one file called *edges.json* containing edges with an id, start node, end node, labels, properties and flag
if they are directed. Graph [g3](src/main/resources/database/g3) is the most complete example of a valid graph.
Below I describe how certain data types are parsed and what rules you must follow to obtain a valid graph.

#### Data types
* Truth values (TRUE, FALSE, UNKNOWN, NULL) are parsed as a case insensitive string 
* Integers and decimals are parsed as their given input (a string containing a number is parsed as string)
* Floating points must be of the form `(-)?[1-9][0-9]*[eE][0-9]*` (again not in a string)
* Strings are parsed as strings in Java
* Identifiers must be strings starting with a letter from the alphabet

#### Rules
* Minimal node object
```json
"n": {
  "identity": "someIdentity"
}
```
* Nodes can have labels and/or properties
* Minimal edge object
```json
"e": {
  "identity": "someIdentity", 
  "start": "existingNodeIdentifier",
  "end": "existingNodeIdentifier"
}
```
* Edges can have labels and/or properties
* Edges can have a field *isDirected* which can be set to 0 (undirected) or 1 (directed),
  by default an edge is directed