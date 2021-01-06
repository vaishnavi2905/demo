package com.company.newpoc.service;

import java.io.File;

public interface ReadFileService {
    String NAME = "newpoc_ReadFileService";

    public void readFile(File file, String filename) throws Exception;
}