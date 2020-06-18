package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public class ForumUser {
    private final int id;
    private final String userName;
    private final char sex;
    private final LocalDate birthDate;
    private final int postNumber;

    private final LocalDate bordreDate = LocalDate.of(2000, 06, 18);

    public ForumUser(int id, String userName, char sex, LocalDate birthDate, int postNumber) {
        this.id = id;
        this.userName = userName;
        this.sex = sex;
        this.birthDate = birthDate;
        this.postNumber = postNumber;
    }

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public char getSex() {
        return sex;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public int getPostNumber() {
        return postNumber;
    }

    public LocalDate getBordreDate() {
        return bordreDate;
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", sex=" + sex +
                ", birthDate=" + birthDate +
                ", postNumber=" + postNumber +
                '}';
    }
}
