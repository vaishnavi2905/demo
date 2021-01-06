package com.company.newpoc.web.screens.employee;

import com.company.newpoc.service.AuditLogService;
import com.company.newpoc.service.ReadFileService;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.components.FileUploadField;
import com.haulmont.cuba.gui.screen.*;
import com.company.newpoc.entity.Employee;
import com.haulmont.cuba.gui.upload.FileUploadingAPI;

import javax.inject.Inject;
import java.io.File;

@UiController("newpoc_Employee.browse")
@UiDescriptor("employee-browse.xml")
@LookupComponent("employeesTable")
@LoadDataBeforeShow
public class EmployeeBrowse extends StandardLookup<Employee> {
    @Inject
    private FileUploadField upload;
    @Inject
    private FileUploadingAPI fileUploadingAPI;
    @Inject
    private ReadFileService readFileService;
    @Inject
    private AuditLogService auditLogService;

    @Subscribe("upload")
    public void uploadFile(FileUploadField.FileUploadSucceedEvent event) throws Exception {
        File file=fileUploadingAPI.getFile(upload.getFileId());
        String filename=upload.getFileName();
        readFileService.readFile(file,filename);
    }

    @Subscribe("removeBtn")
    public void onDeleteBtnClick(Button.ClickEvent event) {
        auditLogService.deleteLog();
    }
}