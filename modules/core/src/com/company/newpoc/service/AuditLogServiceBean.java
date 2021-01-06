package com.company.newpoc.service;

import com.company.newpoc.entity.AuditLog;
import com.haulmont.cuba.core.Persistence;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.time.LocalDate;

@Service(AuditLogService.NAME)
public class AuditLogServiceBean implements AuditLogService {
    @Inject
    private Persistence persistence;

    @Override
    public void createLog(){
        AuditLog log = new AuditLog();
        log.setDescription("Create");
        LocalDate date = LocalDate.now();
        log.setDate(date);
        persistence.getEntityManager().persist(log);
    }

    @Override
    public void deleteLog() {
        AuditLog log = new AuditLog();
        log.setDescription("Delete");
        LocalDate date = LocalDate.now();
        log.setDate(date);
        persistence.getEntityManager().persist(log);
    }
}