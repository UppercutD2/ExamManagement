package Utils;

import Globe_Data.Exam_Message_Links;
import Globe_Data.Exam_Obj;

import java.io.*;

public class File_OutUtils {

        {

        }



        public void writeToFile()
        {
                File file = getFile();
                try(FileOutputStream outputStream = new FileOutputStream(file);
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream))
                {
                        objectOutputStream.writeObject(Exam_Obj.examData);
                        objectOutputStream.flush();
                        System.out.println("Question DataBase saved");
                        System.out.println(file.getAbsolutePath());


                }catch(IOException ex)
                {
                        ex.printStackTrace();
                }
        }
        public File getFile()
        {
            Exam_Message_Links.Exam_Data_File_Path = Scanner_Utils.requireString("Please input Absolute Path for Question DB");
            String filename = Scanner_Utils.requireString("Please Advise File Name and Extension");
            Exam_Message_Links.Exam_Data_File_Path +="\\"+ filename;
            File file = new File(Exam_Message_Links.Exam_Data_File_Path);
             try{
                 if (!file.exists()) {
                     file.createNewFile();
                         System.out.println("New File has been created.");
                 }

             }catch(IOException ex)
             {

             }

                return file;
        }// gets or creates file


}
