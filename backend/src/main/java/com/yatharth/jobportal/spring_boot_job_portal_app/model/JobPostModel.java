package com.yatharth.jobportal.spring_boot_job_portal_app.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Arrays;

@Document(collection = "job_posts")
public class JobPostModel {
    @Id
    private String id;
    private String profile;
    private String desc;
    private int exp;
    private String[] techs;

    public JobPostModel() {
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public String[] getTechs() {
        return techs;
    }

    public void setTechs(String[] techs) {
        this.techs = techs;
    }

    @Override
    public String toString() {
        return "JobPostModel{" +
                "profile='" + profile + '\'' +
                ", desc='" + desc + '\'' +
                ", exp=" + exp +
                ", techs=" + Arrays.toString(techs) +
                '}';
    }
}
