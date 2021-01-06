package com.company.newpoc.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Table(name = "NEWPOC_AUDIT_LOG")
@Entity(name = "newpoc_AuditLog")
@NamePattern("%s|description")
public class AuditLog extends StandardEntity {
    private static final long serialVersionUID = -3002097288830587079L;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "DATE_")
    private LocalDate date;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}