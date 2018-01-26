package io.jenkins.plugins.analysis.warnings;

import edu.hm.hafner.analysis.IssueParser;
import edu.hm.hafner.analysis.parser.ErlcParser;
import io.jenkins.plugins.analysis.core.model.DefaultLabelProvider;
import io.jenkins.plugins.analysis.core.model.StaticAnalysisLabelProvider;
import io.jenkins.plugins.analysis.core.model.StaticAnalysisTool;

import hudson.Extension;

/**
 * Provides a parser and customized messages for the ERL Compiler.
 *
 * @author Ullrich Hafner
 */
@Extension
public class Erlc extends StaticAnalysisTool {
    static final String ID = "erlc";
    private static final String PARSER_NAME = Messages.Warnings_Erlang_ParserName();

    @Override
    public IssueParser createParser() {
        return new ErlcParser();
    }

    @Override
    public StaticAnalysisLabelProvider getLabelProvider() {
        return new DefaultLabelProvider(ID, PARSER_NAME);
    }
}
