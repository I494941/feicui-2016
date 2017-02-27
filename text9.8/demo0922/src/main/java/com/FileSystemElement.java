package com;

import java.util.List;

/**
 * Created by 王金飞 on 2016/10/8.
 */
public abstract class FileSystemElement {
    private String path;

    public FileSystemElement(String path){
        this.path = path;
    }

    public String getPath(){
        return path;
    }

    public abstract List<FileSystemElement> listElements();
}
