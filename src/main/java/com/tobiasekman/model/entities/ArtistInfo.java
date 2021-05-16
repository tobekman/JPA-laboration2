package com.tobiasekman.model.entities;

import jakarta.persistence.*;

@Entity
public class ArtistInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String fullName;
    private int age;
    @Lob
    private String bio;

    public ArtistInfo() {

    }

    public ArtistInfo(String fullName, int age, String bio) {
        this.fullName = fullName;
        this.age = age;
        this.bio = bio;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
