package com.company.newpoc.service;

public interface AuditLogService {
    String NAME = "newpoc_AuditLogService";

    void createLog();

    void deleteLog();
}