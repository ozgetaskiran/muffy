package services.impl;

import models.Course;
import services.DataService;

public class DefaultDataService implements DataService {

    @Override
    public void createCourse(String name, String code) {
        Course c = new Course(name, code);
    }
}
