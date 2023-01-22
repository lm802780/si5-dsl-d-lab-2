import React, { useState } from "react";
import { AntlrEditor } from "antlr-editor";
// import * as tools from "my-antlr-lib";
import {Tools} from "antlr-editor/model";
import {NotebookmlLexer} from "./antlr/grammar/NotebookmlLexer";
import {NotebookmlParser} from "./antlr/grammar/NotebookmlParser";

const Editor = ({}) => {
    const [script, setScript] = useState<string>("");
    const [errors, setErrors] = useState([]);
    const customTools: Tools = {
        Lexer: NotebookmlLexer,
        Parser: NotebookmlParser,
        // grammar: "",
        // id: "",
        // initialRule: ""
        // ...tools,
        // getSuggestionsFromRange: getSuggestions
    };
    return (
        <div>
            <AntlrEditor
                script={script}
                setScript={setScript}
                languageVersion="notebookML"
                setErrors={setErrors}
                variables={{}}
                variableURLs={[]}
                tools={customTools}
            />
            {errors.length > 0 && <div>{`Errors: ${errors.join(" - ")}`}</div>}
        </div>
    );
};

export default Editor;
