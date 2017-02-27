package daily.pojo;

import java.util.Date;

/**
 * Created by 王金飞 on 2016/10/14.
 */
public class Daily {

    public Daily(int id,
                 String name,
                 Date create_date,
                 int create_id,
                 String should_finished_work,
                 String have_finished_work,
                 String unfinished_work_reason,
                 String question_and_answer,
                 String next_day_plain) {
        this.id = id;
        this.name = name;
        this.create_date = create_date;
        this.create_id = create_id;
        this.should_finished_work = should_finished_work;
        this.have_finished_work = have_finished_work;
        this.unfinished_work_reason = unfinished_work_reason;
        this.question_and_answer = question_and_answer;
        this.next_day_plain = next_day_plain;
    }

    private int id;

    private String name;

    private Date create_date;

    private int create_id;

    private String should_finished_work;

    private String have_finished_work;

    private String unfinished_work_reason;

    private String question_and_answer;

    private String next_day_plain;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public int getCreate_id() {
        return create_id;
    }

    public String getShould_finished_work() {
        return should_finished_work;
    }

    public String getHave_finished_work() {
        return have_finished_work;
    }

    public String getUnfinished_work_reason() {
        return unfinished_work_reason;
    }

    public String getQuestion_and_answer() {
        return question_and_answer;
    }

    public String getNext_day_plain() {
        return next_day_plain;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public void setCreate_id(int create_id) {
        this.create_id = create_id;
    }

    public void setShould_finished_work(String should_finished_work) {
        this.should_finished_work = should_finished_work;
    }

    public void setHave_finished_work(String have_finished_work) {
        this.have_finished_work = have_finished_work;
    }

    public void setUnfinished_work_reason(String unfinished_work_reason) {
        this.unfinished_work_reason = unfinished_work_reason;
    }

    public void setQuestion_and_answer(String question_and_answer) {
        this.question_and_answer = question_and_answer;
    }

    public void setNext_day_plain(String next_day_plain) {
        this.next_day_plain = next_day_plain;
    }
}
