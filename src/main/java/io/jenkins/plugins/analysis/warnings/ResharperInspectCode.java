package io.jenkins.plugins.analysis.warnings;

import javax.annotation.Nonnull;

import org.kohsuke.stapler.DataBoundConstructor;

import io.jenkins.plugins.analysis.core.model.StaticAnalysisTool;

import hudson.Extension;

import edu.hm.hafner.analysis.parser.violations.ResharperInspectCodeAdapter;

/**
 * Provides a parser and customized messages for Resharper Inspections.
 *
 * @author Ullrich Hafner
 */
public class ResharperInspectCode extends StaticAnalysisTool {
    static final String ID = "resharper";

    /** Creates a new instance of {@link ResharperInspectCode}. */
    @DataBoundConstructor
    public ResharperInspectCode() {
        // empty constructor required for stapler
    }

    @Override
    public ResharperInspectCodeAdapter createParser() {
        return new ResharperInspectCodeAdapter();
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
            return Messages.Warnings_ReshaperInspectCode_ParserName();
        }
    }
}