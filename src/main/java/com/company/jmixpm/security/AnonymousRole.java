package com.company.jmixpm.security;

import com.company.jmixpm.entity.Task;
import com.company.jmixpm.entity.User;
import com.company.jmixpm.entity.dashboard.DashboardProject;
import io.jmix.security.model.EntityAttributePolicyAction;
import io.jmix.security.model.EntityPolicyAction;
import io.jmix.security.role.annotation.EntityAttributePolicy;
import io.jmix.security.role.annotation.EntityPolicy;
import io.jmix.security.role.annotation.ResourceRole;
import io.jmix.securityflowui.role.annotation.MenuPolicy;
import io.jmix.securityflowui.role.annotation.ViewPolicy;

@ResourceRole(name = "AnonymousRole", code = AnonymousRole.CODE, scope = "UI")
public interface AnonymousRole {
    String CODE = "anonymous-role";

    @MenuPolicy(menuIds = "Task_.list")
    @ViewPolicy(viewIds = {"Task_.list", "ProjectsDashboardView"})
    void screens();

    @EntityAttributePolicy(entityClass = Task.class, attributes = "*", action = EntityAttributePolicyAction.VIEW)
    @EntityPolicy(entityClass = Task.class, actions = EntityPolicyAction.READ)
    void task();

    @EntityPolicy(entityClass = User.class, actions = EntityPolicyAction.READ)
    void user();

    @EntityAttributePolicy(entityClass = DashboardProject.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = DashboardProject.class, actions = EntityPolicyAction.ALL)
    void dashboardProject();
}