package com;

import java.util.List;

/**
 * Created by 王金飞 on 2016/10/8.
 */
public class File extends FileSystemElement{
    public File(String path) {
        super(path);
    }

    public List<FileSystemElement> listElements(){
        return null;
    }
}