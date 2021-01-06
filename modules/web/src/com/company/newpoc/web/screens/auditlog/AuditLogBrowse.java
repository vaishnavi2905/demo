package com.company.newpoc.web.screens.auditlog;

import com.haulmont.cuba.gui.screen.*;
import com.company.newpoc.entity.AuditLog;

@UiController("newpoc_AuditLog.browse")
@UiDescriptor("audit-log-browse.xml")
@LookupComponent("auditLogsTable")
@LoadDataBeforeShow
public class AuditLogBrowse extends StandardLookup<AuditLog> {
}