package com.company.newpoc.web.screens.employee;

import com.company.newpoc.entity.AuditLog;
import com.company.newpoc.service.AuditLogService;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.screen.*;
import com.company.newpoc.entity.Employee;

import javax.inject.Inject;
import java.time.LocalDate;

@UiController("newpoc_Employee.edit")
@UiDescriptor("employee-edit.xml")
@EditedEntityContainer("employeeDc")
@LoadDataBeforeShow
public class EmployeeEdit extends StandardEditor<Employee> {
    @Inject
    public AuditLogService auditLogService;

    @Subscribe("windowCommitAndClose")
    public void onDeleteBtnClick(Button.ClickEvent event) {
        auditLogService.createLog();

    }
}