package ExamAppService;

import Data_Obj.Question;
import Globe_Data.Exam_Obj;
import Utils.File_InUtils;
import Utils.File_OutUtils;
import Utils.Scanner_Utils;

import java.util.Scanner;

public class ExamAppRealization {


    public void addQuestion()
        {
           Question q = createQuestion(Scanner_Utils.console);
            Exam_Obj.examData.add(q);

        }//add question method
        public void deleteQuestion()
        {
            System.out.print("Enter ID of question to Delete from DataBase: ");
            int id = Scanner_Utils.console.nextInt();
            Scanner_Utils.console.nextLine();//to eliminate NextInt() -> nextLine() input bugs.
            if(getQ(id)!=null)
            {
                Exam_Obj.examData.remove(getQ(id));
            }
            else
            {
                System.out.println("Question was not found. Check ID or contact admin.");
            }

        }// delete question using Question ID.

    public Question createQuestion(Scanner console)
    {
        Question q = new Question();
        q.setQuestion(Scanner_Utils.requireString("Enter your question: "));
        q.setOpt_A(Scanner_Utils.requireString("A- option: "));
        q.setOpt_B(Scanner_Utils.requireString("B- option: "));
        q.setOpt_C(Scanner_Utils.requireString("C- option: "));
        q.setOpt_D(Scanner_Utils.requireString("D- option: "));
        setCorrectOption(q);
        return q;
    }

    public void setCorrectOption(Question q)
    {
        while(true)
        {
            String correct =Scanner_Utils.requireString("Set correct option (A, B, C, D)").toUpperCase();
            if (correct.equalsIgnoreCase("A")
               || correct.equalsIgnoreCase("B")
               || correct.equalsIgnoreCase("C")
               || correct.equalsIgnoreCase("D"))
            {
                q.setCorrect(correct);
                break;
            }
            else
            {
                System.err.println("Invalid option selected");
            }
        }
    }

    public void saveQuestions_DB()
    {
        File_OutUtils fileOutUtils = new File_OutUtils();
        fileOutUtils.writeToFile();

    }

    public void loadQuestions_DB()
    {
        File_InUtils fileInUtils = new File_InUtils();
        fileInUtils.readFromFile();

    }

    public Question getQ( int id)
    {
        Question que=null;
        for(Question q: Exam_Obj.examData.getQuestionsList())
        {
            if(id==q.getId())
            {
                que=q;
                break;
            }
        }
        return que;
    }


    public void printExam_DB()
    {
        for(Question q : Exam_Obj.examData.getQuestionsList())
        {
            System.out.println(q.getId() + ") " + q.getQuestion());
        }

    }//prints question with Id number



}
