package com.kodilla.stream.forumuser;

import com.kodilla.stream.book.Book;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Forum {
    private final List<ForumUser> theUserList = new ArrayList<>();

    public Forum() {
        theUserList.add(new ForumUser(1, "Adam", 'M', LocalDate.of(2020, 12, 12), 10));
        theUserList.add(new ForumUser(2, "Adam1", 'M', LocalDate.of(2020, 12, 12), 10));
        theUserList.add(new ForumUser(3, "Adam2", 'M', LocalDate.of(1999, 2, 12), 10));
        theUserList.add(new ForumUser(4, "Adam3", 'M', LocalDate.of(2001, 12, 12), 100));
        theUserList.add(new ForumUser(5, "Ewa", 'K', LocalDate.of(2003, 12, 12), 100));
    }
    public List<ForumUser> getUserList() {
        return new ArrayList<>(theUserList);
    }
}