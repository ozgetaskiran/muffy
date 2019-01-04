package models;

public class Course extends OEntity {

    public String code;

    public Course (String name, String code){
        super(name);
        this.code = code;
    }
}
