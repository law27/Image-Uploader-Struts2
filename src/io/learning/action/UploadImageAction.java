package io.learning.action;

import com.opensymphony.xwork2.ActionSupport;
import io.learning.utils.FileUtil;

import java.io.File;
import java.io.IOException;

public class UploadImageAction extends ActionSupport {


    private File imageFile;
    private String imageFileFileName;
    private String newName;

    public String getImageFileName() {
        return imageFileFileName;
    }

    public void setImageFileFileName(String imageFileName) {
        this.imageFileFileName = imageFileName;
    }

    public String execute() {
        try {
            System.out.println(imageFileFileName);
            newName = FileUtil.saveFile(imageFile);
        } catch (IOException exception) {
            exception.printStackTrace();
            return ERROR;
        }
        return SUCCESS;
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    public File getImageFile() {
        return imageFile;
    }

    public void setImageFile(File imageFile) {
        this.imageFile = imageFile;
    }
}
