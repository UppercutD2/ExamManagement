package Data_Obj;

public class Question {


    private int id;
    private static int sequenceID;
    private String question;
    private String opt_A ;
    private String opt_B ;
    private String opt_C ;
    private String opt_D ;

    private String correct;

    public Question()
    {
        sequenceID++;
        id=sequenceID;
    }

    public int getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOpt_A() {
        return opt_A;
    }

    public void setOpt_A(String opt_A) {
        this.opt_A ="A) " +opt_A;
    }

    public String getOpt_B() {
        return opt_B;
    }

    public void setOpt_B(String opt_B) {
        this.opt_B ="B) " + opt_B;
    }

    public String getOpt_C() {
        return opt_C;
    }

    public void setOpt_C(String opt_C) {
        this.opt_C ="C) " + opt_C;
    }

    public String getOpt_D() {
        return opt_D;
    }

    public void setOpt_D(String opt_D) {
        this.opt_D ="D) " + opt_D;
    }

    public String getCorrect() {
        return correct;
    }

    public void setCorrect(String correct) {
                this.correct = correct;
    }



    public String examTestStr() {
        return  "---------------------------------------------------------\n" +
                "Question -"+ id +": " + question + "?\n" +
                "*********************************************************\n"+
                opt_A + '\n' +
                opt_B + '\n' +
                opt_C + '\n' +
                opt_D + '\n'+
                "---------------------------------------------------------";
    }
    @Override
    public String toString() {
        return "---------------------------------------------------------\n" +
                "Question -"+ id +": " + question + "?\n" +
                "*********************************************************\n"+
                opt_A + '\n' +
                opt_B + '\n' +
                opt_C + '\n' +
                opt_D + '\n'+
                "Correct option : " +correct +'\n'+
                "---------------------------------------------------------";
    }
    @Override
    public boolean equals( Object o)
    {
        if(this == o)
            return true;

        if(o==null || !(o instanceof Question))
            return false;

        Question q = (Question) o;
        boolean same = (q.question == this.question &&
                        q.correct == this.correct &&
                        q.opt_A == this.opt_A &&
                        q.opt_B == this.opt_B &&
                        q.opt_C == this.opt_C &&
                        q.opt_D == this.opt_D);
        return same;
    }

    @Override
    public int hashCode()
        {
            return 69 + (id) +(question==null? 0:question.hashCode());
        }

}
