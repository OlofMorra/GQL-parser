# GQL-parser
A GQL parser build with ANTLR v4.

---
## Installation Antlr v4
Go to https://www.antlr.org/ and follow the _Quick start_ instructions. You can
check if the installation works by entering the following two commands in your
terminal (Mac) or Command Prompt (Windows) and receiving similar output 
(probably, did not test with Windows):

* `antlr4`
    * ```shell
      ANTLR Parser Generator  Version 4.9
      -o ___              specify output directory where all output is generated
      -lib ___            specify location of grammars, tokens files
      -atn                generate rule augmented transition network diagrams
      -encoding ___       specify grammar file encoding; e.g., euc-jp
      -message-format ___ specify output style for messages in antlr, gnu, vs2005
      -long-messages      show exception details when available for errors and warnings
      -listener           generate parse tree listener (default)
      -no-listener        don't generate parse tree listener
      -visitor            generate parse tree visitor
      -no-visitor         don't generate parse tree visitor (default)
      -package ___        specify a package/namespace for the generated code
      -depend             generate file dependencies
      -D<option>=value    set/override a grammar-level option
      -Werror             treat warnings as errors
      -XdbgST             launch StringTemplate visualizer on generated code
      -XdbgSTWait         wait for STViz to close before continuing
      -Xforce-atn         use the ATN simulator for all predictions
      -Xlog               dump lots of logging info to antlr-timestamp.log
      -Xexact-output-dir  all output goes into -o dir regardless of paths/package```
* `grun`
    * ```shell
        java org.antlr.v4.gui.TestRig GrammarName startRuleName
        [-tokens] [-tree] [-gui] [-ps file.ps] [-encoding encodingname]
        [-trace] [-diagnostics] [-SLL]
        [input-filename(s)]
        Use startRuleName='tokens' if GrammarName is a lexer grammar.
        Omitting input-filename makes rig read from stdin.
        ```
      
Clearly, I use ANTLR v4.9. Additionally, above two commands are aliases, hence, for Mac 
users you have to add the last two lines of _Quick Start_ to your _~/.bash_profile_ which can 
be found in your _Users/[username]_ folder. Make sure to reload your terminal afterwards.

## Creating Java project
Go to your favorite IDE (I use IntelliJ) and open an existing project 
from the GQL-parser folder. Make sure that your buildpath includes 
[antlr-4.9-complete.jar](lib/antlr-4.9-complete.jar) and set the [lib](lib) 
folder as library folder for the project. You might need to add this jar as classpath
by executing the following shell command:

```shell
export CLASSPATH=path/to/lib/antlr-4.9-complete.jar
```

### Add ANTLR v4 grammar plugin to IDE (optional)
Go to your plugin library in your IDE and search for ANTLR (for IntelliJ, go to 
_IntelliJ IDEA -> Preferences... -> plugins_ and search for _ANTLR_). Install 
the plugin.  

## Testing the GQL grammar
In your shell, go to the folder [src](src). From there, type the following commands:

```shell
cd path/to/antlr
antlr4 GqlLexer.g4
antlr4 -visitor GqlParser.g4
javac Gql*.java
cd ../../../
grun src.antlr.Gql file queries/gql/snb/short_read_1.gql -gui &
```
Notice that after compiling we go up one directory. This is done as we want Gql to be available 
via the antlr package, i.e. in both [GqlParser.g4](src/antlr/GqlParser.g4) and 
[GqlLexer.g4](src/antlr/GqlLexer.g4) @header informs that they are within the package antlr. 
If you want to remove @header, you can run the following to obtain the same result:

```shell
cd antlr
antlr4 GqlLexer.g4
antlr4 -visitor GQL.g4
javac Gql*.java
grun Gql file queries/gql/snb/short_read_1.gql -gui &
```

---
## References
I followed Parser Generator Tutorial from Jackie Wang called
[EECS4302 ANTLR4 Parser Generator Tutorial](https://www.youtube.com/watch?v=6uF1Nxo2xjk)
(starts at the first video from this link). Additionally, I have consulted 
[the Definitive ANTLR 4 Reference](https://pragprog.com/titles/tpantlr2/the-definitive-antlr-4-reference/),
[ANTLR 4 GitHub](https://github.com/antlr/antlr4), and some [ANTLRv4 grammars](https://github.com/antlr/grammars-v4).