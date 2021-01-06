package com.company.newpoc.service;

import com.company.newpoc.entity.Employee;
import com.haulmont.cuba.core.Persistence;
import com.haulmont.cuba.core.global.DataManager;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.persistence.NoResultException;
import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

@Service(ReadFileService.NAME)
public class ReadFileServiceBean implements ReadFileService {
    @Inject
    private DataManager dataManager;
    @Inject
    private Persistence persistence;

    @Transactional(noRollbackFor = NoResultException.class)
    @Override
    public void readFile(File fileId, String fileName) throws Exception {
        FileInputStream file = new FileInputStream(fileId);
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheetAt(0);
        System.out.println("Yash");

        int name=0,id=0;
        Iterator<Row> itr = sheet.iterator();
        while(itr.hasNext()){
            Row row = itr.next();
            Iterator<Cell> citr = row.cellIterator();
            Employee class1 = new Employee();
            String temp2="";
            double temp1=0;
            while (citr.hasNext()){
                Cell cell = citr.next();
                if(cell.getCellType().equals("String")){
                    if(cell.getStringCellValue().equalsIgnoreCase("id")){
                        id=cell.getColumnIndex();

                    }
                    else if(cell.getStringCellValue().equalsIgnoreCase("name")) {
                        name = cell.getColumnIndex();

                    }
                }

                else if(cell.getColumnIndex()==0){
                    temp1=cell.getNumericCellValue();

                }
                else if(cell.getColumnIndex()==1){
                    temp2=cell.getStringCellValue();

                }

            }
            class1.setEmployeeId(1);
            class1.setEmployeeName(temp2);
            persistence.getEntityManager().persist(class1);
        }
    }
}