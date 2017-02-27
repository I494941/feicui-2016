package daily.pojo;

import java.util.Date;

/**
 * Created by 王金飞 on 2016/10/12.
 */
public class User {

    public User(String name, int sex, Date birthday, String passwd, int id) {
        this.name = name;
        this.sex = sex;
        this.birthday = birthday;
        this.passwd = passwd;
        this.id = id;
    }

    public User(String name, String passwd) {
        this.name = name;
        this.passwd = passwd;
    }

    public User(String name, int id) {
        this.name = name;
        this.id = id;
    }

    private String name;

    private int sex;

    private Date birthday;

    private String passwd;

    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + "'" +
                ", sex=" + sex +
                ", birthday=" + birthday +
                ", passwd='" + passwd + "'" +
                ", id=" + id +
                "}";
    }
}
