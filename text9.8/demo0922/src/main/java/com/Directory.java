package com;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 王金飞 on 2016/10/8.
 */
public class Directory extends FileSystemElement{
    private final List<FileSystemElement> elements = new ArrayList<>();

    public Directory(String path) {
        super(path);
    }

    public List<FileSystemElement> listElements(){
        return elements;
    }
}