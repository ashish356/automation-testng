package org.ashish.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserServiceRequestUsingBuilder {

    @JsonProperty("name")
    private String name;

    @JsonProperty("job")
    private String job;


    public static class Builder
    {
        private String name;
        private String job;
        public Builder setName(String name) {
            this.name = name;
            return this;
        }
        public Builder setJob(String job) {
            this.job = job;
            return this;
        }

        public UserServiceRequestUsingBuilder build()
        {
            UserServiceRequestUsingBuilder userServiceRequestUsingBuilder=new UserServiceRequestUsingBuilder();
            userServiceRequestUsingBuilder.name=this.name;
            userServiceRequestUsingBuilder.job=this.job;
            return userServiceRequestUsingBuilder;
        }


    }
}
