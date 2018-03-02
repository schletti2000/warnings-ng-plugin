package io.jenkins.plugins.analysis.warnings;

import javax.annotation.Nonnull;

import org.kohsuke.stapler.DataBoundConstructor;

import edu.hm.hafner.analysis.parser.NagFortranParser;
import io.jenkins.plugins.analysis.core.model.StaticAnalysisTool;

import hudson.Extension;

/**
 * Provides a parser and customized messages for the NagFortran Compiler.
 *
 * @author Joscha Behrmann
 */
public class NagFortran extends StaticAnalysisTool {
    static final String ID = "nag-fortran";

    /** Creates a new instance of {@link NagFortran}. */
    @DataBoundConstructor
    public NagFortran() {
        // empty constructor required for stapler
    }

    @Override
    public NagFortranParser createParser() {
        return new NagFortranParser();
    }

    /** Descriptor for this static analysis tool. */
    @Extension
    public static class Descriptor extends StaticAnalysisToolDescriptor {
        public Descriptor() {
            super(ID);
        }

        @Nonnull
        @Override
        public String getDisplayName() {
            return Messages.Warnings_NagFortran_ParserName();
        }
    }
}