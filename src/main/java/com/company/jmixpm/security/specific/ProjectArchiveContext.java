package com.company.jmixpm.security.specific;

import io.jmix.core.accesscontext.SpecificOperationAccessContext;

public class ProjectArchiveContext extends SpecificOperationAccessContext {

    public static final String NAME = "project.archive";

    public ProjectArchiveContext() {
        super(NAME);
    }
}
