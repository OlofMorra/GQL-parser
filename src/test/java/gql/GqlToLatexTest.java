package gql;

import exceptions.InvalidEdgeFormatException;
import exceptions.InvalidNodeFormatException;
import gql.expressions.values.Value;
import gql.graphs.WorkingGraph;
import gql.tables.BindingTable;
import gql.tables.Record;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.FileNotFoundException;

import static org.junit.Assert.assertEquals;

public class GqlToLatexTest {
    private final String queryTestsFolder = "src/test/resources/queries/gql/tests";

    /**
     * Make sure that no exceptions are thrown and caught during evaluation.
     */
    @Rule
    public ExpectedException exception = ExpectedException.none();

    /**
     * Make sure that all ambient queries (without FROM clause) are tested on the synthetic graph.
     * That way testing stays stable.
     */
    @Before
    public void setWorkingGraph() {
        try {
            WorkingGraph graph = WorkingGraph.getInstance();
            graph.setToTestDirectory();
            graph.setLocalGraph("syntheticGraph");
        } catch (FileNotFoundException | InvalidNodeFormatException | InvalidEdgeFormatException exception) {
            exception.printStackTrace();
        }
    }

    /**
     * Comparison operators
     */
    @Test
    public void testEqualsOperator() {
        String expectedResult = "\\begin{align*}\n" +
                "    G &= syntheticGraph \\\\\n" +
                "    \\chi_{1} &= (x, \\emptyset, \\emptyset) \\\\\n" +
                "    \\pi_{1} &= \\chi_{1} \\\\\n" +
                "    \\rel{1} &= \\rel{W} \\\\\n" +
                "    \\Bar{\\pi} &= (\\pi_{1}) \\\\\n" +
                "    \\rel &= (\\rel{1}) \\\\\n" +
                "    T &= \\{()\\} \\\\\n" +
                "    M_{1} &= \\sem{\\mathblue{MATCH } \\Bar{\\pi}}(T) = \\biguplus_{u \\in T} \\{u \\times u' \\mid u' \\in \\textsf{match}(\\Bar{\\pi}, G, u, \\rel{})\\} \\\\\n" +
                "    M_{2} &= \\sem{\\mathblue{WHERE } \\texttt{x.age = 25}}(M_{1}) = \\{u \\in M_{1} \\mid \\semex{x.age = 25} = \\mathblue{true}\\} \\\\\n" +
                "    Q_1 &= \\sem{\\mathblue{RETURN ALL } *}(M_{2}) = M_{2} \\\\\n" +
                "\\end{align*}";

        GqlFileQueryEvaluator queryEvaluator = new GqlFileQueryEvaluator(queryTestsFolder + "/comparison_operators/equals_op.gql");

        assertEquals("expected:\n" + expectedResult + "\nactual: \n" + queryEvaluator.getLatexResult(),
                expectedResult, queryEvaluator.getLatexResult());
    }

    /**
     * Conjunctions
     */
    @Test
    public void testExceptAll() {
        String expectedResult = "\\begin{align*}\n" +
                "    G &= g3 \\\\\n" +
                "    \\chi_{1} &= (x, \\emptyset, \\emptyset) \\\\\n" +
                "    \\pi_{1} &= \\chi_{1} \\\\\n" +
                "    \\rel{1} &= \\rel{W} \\\\\n" +
                "    \\Bar{\\pi} &= (\\pi_{1}) \\\\\n" +
                "    \\rel &= (\\rel{1}) \\\\\n" +
                "    T &= \\{()\\} \\\\\n" +
                "    M_{1} &= \\sem{\\mathblue{MATCH } \\Bar{\\pi}}(T) = \\biguplus_{u \\in T} \\{u \\times u' \\mid u' \\in \\textsf{match}(\\Bar{\\pi}, G, u, \\rel{})\\} \\\\\n" +
                "    Q_1 &= \\sem{\\mathblue{RETURN ALL } x}(M_{1}) = \\biguplus_{u \\in M_{1}} \\{(x: \\semex{x})\\} \\\\\n" +
                "    G &= g3 \\\\\n" +
                "    \\chi_{2} &= (x, \\{\\{Professor\\}\\}, \\emptyset) \\\\\n" +
                "    \\pi_{2} &= \\chi_{2} \\\\\n" +
                "    \\rel{2} &= \\rel{W} \\\\\n" +
                "    \\Bar{\\pi} &= (\\pi_{2}) \\\\\n" +
                "    \\rel &= (\\rel{2}) \\\\\n" +
                "    T &= \\{()\\} \\\\\n" +
                "    M_{1} &= \\sem{\\mathblue{MATCH } \\Bar{\\pi}}(T) = \\biguplus_{u \\in T} \\{u \\times u' \\mid u' \\in \\textsf{match}(\\Bar{\\pi}, G, u, \\rel{})\\} \\\\\n" +
                "    Q_2 &= \\sem{\\mathblue{RETURN ALL } *}(M_{1}) = M_{1} \\\\\n" +
                "    Q_{1, 2} &= \\sem{Q_{1} \\mathblue{ EXCEPT ALL }Q_2}(T) = Q_{1} - Q_2 \\\\\n" +
                "\\end{align*}";

        GqlFileQueryEvaluator queryEvaluator = new GqlFileQueryEvaluator(queryTestsFolder + "/conjunctions/except_all.gql");

        assertEquals("expected:\n" + expectedResult + "\nactual: \n" + queryEvaluator.getLatexResult(),
                expectedResult, queryEvaluator.getLatexResult());
    }

    /**
     * Complex
     */
    @Test
    public void testLargeAlgebra() {
        String expectedResult = "\\begin{align*}\n" +
                "    G &= g \\\\\n" +
                "    \\chi_{1} &= (x, \\{\\{test\\}\\}, \\{(normal: \"test\"), (test: 1)\\}) \\\\\n" +
                "    \\pi_{1} &= \\chi_{1} \\\\\n" +
                "    \\rel{1} &= \\rel{S} \\\\\n" +
                "    \\Bar{\\pi} &= (\\pi_{1}) \\\\\n" +
                "    \\rel &= (\\rel{1}) \\\\\n" +
                "    T &= \\{()\\} \\\\\n" +
                "    M_{1} &= \\sem{\\mathblue{MATCH } \\Bar{\\pi}}(T) = \\biguplus_{u \\in T} \\{u \\times u' \\mid u' \\in \\textsf{match}(\\Bar{\\pi}, G, u, \\rel{})\\} \\\\\n" +
                "    M_{2} &= \\sem{\\mathblue{WHERE } \\texttt{x = 1}}(M_{1}) = \\{u \\in M_{1} \\mid \\semex{x = 1} = \\mathblue{true}\\} \\\\\n" +
                "    M_{3} &= \\sem{\\mathblue{MANDATORY MATCH } \\Bar{\\pi}\\mathblue{ WHERE } \\texttt{x = 1}}(M_{2})=  \\\\\n" +
                "     & \\begin{cases}\n" +
                "        \\sem{\\mathblue{MATCH } \\Bar{\\pi}\\mathblue{ WHERE } \\texttt{x = 1}}(M_{2}) & \\text{if } \\sem{\\mathblue{MATCH } \\Bar{\\pi}\\mathblue{ WHERE } \\texttt{x = 1}}(M_{2}) \\neq \\emptyset \\\\\n" +
                "        \\text{Not valid} & \\text{otherwise}\n" +
                "    \\end{cases} \\\\\n" +
                "    G &= g \\\\\n" +
                "    \\chi_{2} &= (y, \\{\\{test, \\%\\}\\}, \\emptyset) \\\\\n" +
                "    \\rho_{1} &= (-, e, \\emptyset, \\emptyset, (1, 1)) \\\\\n" +
                "    \\chi_{3} &= (z, \\emptyset, \\emptyset) \\\\\n" +
                "    \\pi_{2} &= \\chi_{2} \\rho_{1}\\chi_{3} \\\\\n" +
                "    \\rel{2} &= \\rel{T} \\\\\n" +
                "    \\Bar{\\pi} &= (\\pi_{2}) \\\\\n" +
                "    \\rel &= (\\rel{2}) \\\\\n" +
                "    M_{4} &= \\sem{\\mathblue{MATCH } \\Bar{\\pi}}(M_{3}) = \\biguplus_{u \\in M_{3}} \\{u \\times u' \\mid u' \\in \\textsf{match}(\\Bar{\\pi}, G, u, \\rel{})\\} \\\\\n" +
                "    M_{5} &= \\sem{\\mathblue{WHERE } \\texttt{y = 1\\mathblue{ OR }y = 1}}(M_{4}) = \\{u \\in M_{4} \\mid \\semex{y = 1\\mathblue{ OR }y = 1} = \\mathblue{true}\\} \\\\\n" +
                "    M_{6} &= \\sem{\\mathblue{OPTIONAL MATCH } \\Bar{\\pi}\\mathblue{ WHERE } \\texttt{y = 1\\mathblue{ OR }y = 1}}(M_{5})=  \\\\\n" +
                "     & \\begin{cases}\n" +
                "        \\sem{\\mathblue{MATCH } \\Bar{\\pi}\\mathblue{ WHERE } \\texttt{y = 1\\mathblue{ OR }y = 1}}(M_{5}) & \\text{if } \\sem{\\mathblue{MATCH } \\Bar{\\pi}\\mathblue{ WHERE } \\texttt{y = 1\\mathblue{ OR }y = 1}}(M_{5}) \\neq \\emptyset \\\\\n" +
                "        \\underset{u \\in T}{\\biguplus} (u, (\\textsf{free}(u, \\Bar{\\pi}): \\mathblue{null})) & \\text{otherwise}\n" +
                "    \\end{cases} \\\\\n" +
                "    Q_1 &= \\sem{\\mathblue{RETURN ALL } x, y}(M_{6}) = \\biguplus_{u \\in M_{6}} \\{(x: \\semex{x}, y: \\semex{y})\\} \\\\\n" +
                "    \\chi_{4} &= (x, \\emptyset, \\emptyset) \\\\\n" +
                "    \\pi_{3} &= \\chi_{4} \\\\\n" +
                "    \\rel{3} &= \\rel{W} \\\\\n" +
                "    \\chi_{5} &= (y, \\emptyset, \\emptyset) \\\\\n" +
                "    \\pi_{4} &= \\chi_{5} \\\\\n" +
                "    \\rel{4} &= \\rel{W} \\\\\n" +
                "    \\Bar{\\pi} &= (\\pi_{3}, \\pi_{4}) \\\\\n" +
                "    \\rel &= (\\rel{3}, \\rel{4}) \\\\\n" +
                "    T &= \\{()\\} \\\\\n" +
                "    M_{1} &= \\sem{\\mathblue{MATCH } \\Bar{\\pi}}(T) = \\biguplus_{u \\in T} \\{u \\times u' \\mid u' \\in \\textsf{match}(\\Bar{\\pi}, G, u, \\rel{})\\} \\\\\n" +
                "    Q_2 &= \\sem{\\mathblue{RETURN ALL } *}(M_{1}) = M_{1} \\\\\n" +
                "    Q_{1, 2} &= \\sem{Q_{1} \\mathblue{ UNION ALL }Q_2}(T) = Q_{1} \\biguplus Q_2 \\\\\n" +
                "\\end{align*}";

        GqlFileQueryEvaluator queryEvaluator = new GqlFileQueryEvaluator(queryTestsFolder + "/complex/large_algebra.gql");

        assertEquals("expected:\n" + expectedResult + "\nactual: \n" + queryEvaluator.getLatexResult(),
                expectedResult, queryEvaluator.getLatexResult());
    }
}
