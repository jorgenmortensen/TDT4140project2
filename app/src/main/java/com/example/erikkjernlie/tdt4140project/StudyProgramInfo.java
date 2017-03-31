package com.example.erikkjernlie.tdt4140project;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;

/**
 * Created by jonas on 22.03.2017.
 */

public class StudyProgramInfo {

    private String info;
    private Double grade;
    private boolean isGirlPoints;
    private double girlPercentage;
    private String studentUnion;
    private ArrayList<String> specializations;
    private String studyEnvironment;

    public StudyProgramInfo(String info, Double grade,
                            boolean isGirlPoints, double girlPercentage, String studentUnion,
                            ArrayList<String> specializations,
                            String studyEnvironment) {
        this.info = info;
        this.grade = grade;
        this.isGirlPoints = isGirlPoints;
        this.girlPercentage = girlPercentage;
        this.studentUnion = studentUnion;
        this.specializations = specializations;
        this.studyEnvironment = studyEnvironment;
    }

    public String getInfo() {
        return info;
    }

    @Override
    public String toString() {
        return "StudyProgramInfo{" +
                "info='" + info + '\'' +
                ", grade=" + grade +
                ", isGirlPoints=" + isGirlPoints +
                ", girPercentage=" + girlPercentage +
                ", studentUnion='" + studentUnion + '\'' +
                ", specializations=" + specializations +
                ", studyEnvironment='" + studyEnvironment + '\'' +
                '}';
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }


    public boolean isGirlPoints() {
        return isGirlPoints;
    }

    public void setGirlPoints(boolean girlPoints) {
        isGirlPoints = girlPoints;
    }

    public double getGirlPercentage() {
        return girlPercentage;
    }

    public void setGirlPercentage(double girPercentage) {
        this.girlPercentage = girPercentage;
    }

    public String getStudentUnion() {
        return studentUnion;
    }

    public void setStudentUnion(String studentUnion) {
        this.studentUnion = studentUnion;
    }

    public ArrayList<String> getSpecializations() {
        return specializations;
    }

    public void setSpecializations(ArrayList<String> specializations) {
        this.specializations = specializations;
    }

    public String getStudyEnvironment() {
        return studyEnvironment;
    }

    public void setStudyEnvironment(String studyEnvironment) {
        this.studyEnvironment = studyEnvironment;
    }
}