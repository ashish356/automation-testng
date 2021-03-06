package org.ashish.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserService {


    @JsonProperty("name")
    private String name;

    @JsonProperty("job")
    private String job;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
