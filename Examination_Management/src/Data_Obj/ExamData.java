package Data_Obj;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ExamData implements Serializable {

    private int id;
    private static int sequenceID;

     private List<Question> questionsList;

     public ExamData ()
     {
         questionsList = new ArrayList<>();
         sequenceID++;
         id=sequenceID;
     }// Creates new ArrayList and Set Unique Id

    //////////////////////////////////////////////////////////////////

    public List<Question> getQuestionsList() {
        return questionsList;
    }

    public void setQuestionsList(List<Question> questionsList) {
        this.questionsList = questionsList;
    }

    public void add(Question q)
    {
        questionsList.add(q);
        System.out.println("Question has been added");
    }
    public int indexOf(Question q)
    {
       return  questionsList.indexOf(q);
    }
    public Question get( int index)
    {
        return questionsList.get(index);

    }

    public void remove(Question q)
    {
        questionsList.remove(q);
        System.out.println("Question has been deleted");

    }

    @Override
    public boolean equals( Object o)
    {
        if(this == o)
            return true;

        if(o==null || !(o instanceof ExamData))
            return false;

        ExamData q = (ExamData) o;
        boolean same = (q.questionsList == this.questionsList);
        return same;
    }

    @Override
    public int hashCode()
    {
        return 7 + (id) + (questionsList==null? 0 :questionsList.hashCode()) ;
    }
}
