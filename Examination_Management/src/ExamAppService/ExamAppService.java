package ExamAppService;

import Data_Obj.Question;
import Globe_Data.Exam_Message_Links;
import Utils.Scanner_Utils;


public class ExamAppService {



//    Methods:
//    1)Start method to run this service
//            (inside method
//                -- password to modify and access to ExamData File
//                   1)show Questions - show only question and their index
//                    2) (search by index , search by keyword ) edit question using index of question, or using Key Word to search in Question.
//                    3) Edit question, options, correct
//                    4) Add question (Procedure)
//                    5)Delete question (Repeat password)
//                    6)Save all+
//                    7) Load file+
//                    8)  Cancel

    public void start(boolean isActive)
    {
        ExamAppRealization examAppRealization = new ExamAppRealization();

        while (isActive)
        {
            System.out.println(Exam_Message_Links.ExamDataBaseMenuStr);
            String option = Scanner_Utils.requireString("Choose your option: ");

            switch(option)
            {
                case "0":
                    isActive=false;
                    break;
                case "1":
                    examAppRealization.printExam_DB();
                    break;
                case "2":
                    System.out.println(
                     examAppRealization.getQ(Integer.parseInt(Scanner_Utils.requireString("Enter question ID"))).examTestStr()
                                        );
                    //I can write it in separate method, but why should I ?:-)
                    break;
                case "3":
                    examAppRealization.addQuestion();
                    break;
                case "4":
                    editQ_Menu(examAppRealization);
                    //Method to Edit question if that will be needed I don't Know.
                    break;
                case "5":
                    examAppRealization.deleteQuestion();
                    break;
                case "6":
                    examAppRealization.saveQuestions_DB();
                    break;
                case "7":
                    examAppRealization.loadQuestions_DB();
                    break;
                default:
                    System.err.println("Wrong operation selected");
            }
        }
    }

    public void editQ_Menu(ExamAppRealization examAppRealization)
    {
        Question q = examAppRealization.getQ(Integer.parseInt(Scanner_Utils.requireString("Enter ID of Quesiton to edit: ")));
            editQuestion(examAppRealization,q,true);
    }


    private void editQuestion(ExamAppRealization examAppRealization,Question q,boolean isActive)
    {
        while(isActive)
        {
            System.out.println(Exam_Message_Links.editQuestionStr);
            String option = Scanner_Utils.requireString("Choose option: ");

            switch (option)
            {
                case "0":
                    isActive = false;
                    break;
                case "1":
                    System.out.println("Current Question: " + q.getQuestion());
                    q.setQuestion(Scanner_Utils.requireString("New Question"));
                    break;
                case "2":
                    System.out.println("Currenct option - A" +q.getOpt_A());
                    q.setOpt_A(Scanner_Utils.requireString("A- option: "));//option A
                    break;
                case "3":
                    System.out.println("Currenct option - B" +q.getOpt_B());
                    q.setOpt_B(Scanner_Utils.requireString("B- option: "));//option B
                    break;
                case "4":
                    System.out.println("Currenct option - C" +q.getOpt_C());
                    q.setOpt_C(Scanner_Utils.requireString("C- option: "));//option C
                    break;
                case "5":
                    System.out.println("Currenct option - D" +q.getOpt_D());
                    q.setOpt_D(Scanner_Utils.requireString("D- option: "));//option D
                    break;
                case "6":
                    System.out.println("Current Correct Option "+q.getCorrect());
                    examAppRealization.setCorrectOption(q);//change correct option
                    break;
                default:
                    System.err.println("Wrong option selected");


            }


        }



    }


}

