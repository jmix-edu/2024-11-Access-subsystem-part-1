package com.company.jmixpm.view.project;

import com.company.jmixpm.view.main.MainView;
import com.company.jmixpm.entity.Project;
import com.company.jmixpm.entity.User;
import com.vaadin.flow.router.Route;
import io.jmix.core.security.CurrentAuthentication;
import io.jmix.core.usersubstitution.CurrentUserSubstitution;
import io.jmix.flowui.view.*;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value = "projects/:id", layout = MainView.class)
@ViewController("Project.detail")
@ViewDescriptor("project-detail-view.xml")
@EditedEntityContainer("projectDc")
public class ProjectDetailView extends StandardDetailView<Project> {
    @Autowired
    private CurrentAuthentication currentAuthentication;
    @Autowired
    private CurrentUserSubstitution currentUserSubstitution;

    @Subscribe
    public void onInitEntity(InitEntityEvent<Project> event) {
        User user = (User) currentUserSubstitution.getEffectiveUser();
//        User user = (User) currentAuthentication.getUser();

        event.getEntity().setManager(user);
    }
}