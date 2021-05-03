package com.example.jetpackdemo.vM_and_Room.Model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class VmUser {
    @PrimaryKey(autoGenerate = true)
    int id;
    String name;
    String address;

    public VmUser() {
    }

    public VmUser(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "VmUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
