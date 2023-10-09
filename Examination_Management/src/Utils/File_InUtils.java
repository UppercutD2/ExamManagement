package Utils;

import Data_Obj.ExamData;
import Globe_Data.Exam_Message_Links;
import Globe_Data.Exam_Obj;

import java.io.*;

public class File_InUtils {





    public void readFromFile()
    {
        try{
            File file = getFile();
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            Exam_Obj.examData = (ExamData)objectInputStream.readObject();
            fileInputStream.close();
            System.out.println("Question DataBase Loaded");

        }catch(IOException ex)
        {
            ex.printStackTrace();
        }
        catch(ClassNotFoundException exx)
        {
            exx.printStackTrace();
        }

    }



    public File getFile() throws FileNotFoundException
    {
        Exam_Message_Links.Exam_Data_File_Path = Scanner_Utils.requireString("Please input Absolute Path for Question DB");
        File file = new File(Scanner_Utils.requireString("Please Advise File Name and Extension"));
        if(!file.exists())
        {
            throw new FileNotFoundException("File not found");
        }
        else
        {
            return file;
        }
    }
}
