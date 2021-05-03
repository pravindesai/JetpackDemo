package com.example.jetpackdemo.listDataBinding;

public class Task {
    String desc;
    String status;
    boolean isCompleted;

    public Task() {
    }

    public Task(String desc, boolean isCompleted) {
        this.desc = desc;
        this.isCompleted = isCompleted;
        setStatus();
    }

    public String getStatus() {
        return status;
    }

    private void setStatus() {
        if (isCompleted)
            this.status = "Completed";
        else
            this.status = "Incomplete";
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
        setStatus();
    }

    @Override
    public String toString() {
        return "Task{" +
                "desc='" + desc + '\'' +
                ", status='" + status + '\'' +
                ", isCompleted=" + isCompleted +
                '}';
    }
}
