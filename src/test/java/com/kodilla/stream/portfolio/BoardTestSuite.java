package com.kodilla.stream.portfolio;

import org.junit.Assert;
import org.junit.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class BoardTestSuite {
    public Board prepareTestData() {
        //users
        User user1 = new User("developer1", "John Smith");
        User user2 = new User("projectmanager1", "Nina White");
        User user3 = new User("developer2", "Emilia Stephanson");
        User user4 = new User("developer3", "Konrad Bridge");
        //tasks
        Task task1 = new Task("Microservice for taking temperature",
                "Write and test the microservice taking\n" +
                        "the temperaure from external service",
                user1,
                user2,
                LocalDate.now().minusDays(20),
                LocalDate.now().plusDays(30));
        Task task2 = new Task("HQLs for analysis",
                "Prepare some HQL queries for analysis",
                user1,
                user2,
                LocalDate.now().minusDays(20),
                LocalDate.now().minusDays(5));
        Task task3 = new Task("Temperatures entity",
                "Prepare entity for temperatures",
                user3,
                user2,
                LocalDate.now().minusDays(20),
                LocalDate.now().plusDays(15));
        Task task4 = new Task("Own logger",
                "Refactor company logger to meet our needs",
                user3,
                user2,
                LocalDate.now().minusDays(10),
                LocalDate.now().plusDays(25));
        Task task5 = new Task("Optimize searching",
                "Archive data searching has to be optimized",
                user4,
                user2,
                LocalDate.now(),
                LocalDate.now().plusDays(5));
        Task task6 = new Task("Use Streams",
                "use Streams rather than for-loops in predictions",
                user4,
                user2,
                LocalDate.now().minusDays(15),
                LocalDate.now().minusDays(2));
        //taskLists
        TaskList taskListToDo = new TaskList("To do");
        taskListToDo.addTask(task1);
        taskListToDo.addTask(task3);
        TaskList taskListInProgress = new TaskList("In progress");
        taskListInProgress.addTask(task5);
        taskListInProgress.addTask(task4);
        taskListInProgress.addTask(task2);
        TaskList taskListDone = new TaskList("Done");
        taskListDone.addTask(task6);
        //board
        Board project = new Board("Project Weather Prediction");
        project.addTaskList(taskListToDo);
        project.addTaskList(taskListInProgress);
        project.addTaskList(taskListDone);
        return project;
    }

    @Test
    public void testAddTaskList() {
        //Given
        Board project = prepareTestData();
        //When

        //Then
        Assert.assertEquals(3, project.getTaskLists().size());
    }
    //Test z zadania 6
    // wykorzystaniem sum() i count()
    @Test
    public void testAddTaskListAverageWorkingOnTask() {
        //Given
        Board project = prepareTestData();

        //When
        //tworzę roboczą listę zadań o takiej samej nazwie
        List<TaskList> inProgressTasks = new ArrayList<>();
        //dodaję do niej listę "In progress"
        inProgressTasks.add(new TaskList("In progress"));
        //Tworzę i uruchamiam strumień na kolekcji getTaskLists() i przypisuję wynik do zmiennej countTasks.
        long countTasks = project.getTaskLists().stream()
                //filtruję i do mojego strumienia trafią tylko te listy, które znajdują się na liście inProgressTasks
                .filter(inProgressTasks::contains)
                //spłaszczenie strumienia, trafią do niego konkretne zadania a nie obiekty je przechowujące
                .flatMap(tl -> tl.getTasks().stream())
                //przetwarzamy strumień na strumień dat, mówiących o tym kiedy zadanie zostało utworzone
                .map(t -> t.getCreated())
                //.filter(d -> d.compareTo(LocalDate.now().minusDays(10)) <= 0)
                .count();

        List<TaskList> inProgressTasks1 = new ArrayList<>();
        //dodaję do niej listę "In progress"
        inProgressTasks1.add(new TaskList("In progress"));
        //Tworzę i uruchamiam strumień na kolekcji getTaskLists() i przypisuję wynik do zmiennej countTasks.
        long countDays = project.getTaskLists().stream()
                //filtruję i do mojego strumienia trafią tylko te listy, które znajdują się na liście inProgressTasks1
                .filter(inProgressTasks1::contains)
                //spłaszczenie strumienia, trafią do niego konkretne zadania a nie obiekty je przechowujące
                .flatMap(tl -> tl.getTasks().stream())
                //przetwarzamy strumień na strumień dat, mówiących o tym kiedy zadanie zostało utworzone
                .map(t -> t.getCreated())
                //przetwarzam strumień na strumień ilości dni między datami
                .mapToLong(t -> ChronoUnit.DAYS.between(t, LocalDate.now()))
                //zsumowanie ilości dni
                .sum();
        long average = countDays / countTasks;

        //Then
        Assert.assertEquals(10, average);
    }
    // Z wykorzystaniem average()
    @Test
    public void testAddTaskListAverageWorkingOnTask1() {
        //Given
        Board project = prepareTestData();

        //When
        List<TaskList> inProgressTasks1 = new ArrayList<>();
        //dodaję do niej listę "In progress"
        inProgressTasks1.add(new TaskList("In progress"));
        //Tworzę i uruchamiam strumień na kolekcji getTaskLists() i przypisuję wynik do zmiennej countTasks.
        double countAverage = project.getTaskLists().stream()
                //filtruję i do mojego strumienia trafią tylko te listy, które znajdują się na liście inProgressTasks1
                .filter(inProgressTasks1::contains)
                //spłaszczenie strumienia, trafią do niego konkretne zadania a nie obiekty je przechowujące
                .flatMap(tl -> tl.getTasks().stream())
                //przetwarzamy strumień na strumień dat, mówiących o tym kiedy zadanie zostało utworzone
                .map(t -> t.getCreated())
                //przetwarzam strumień na strumień ilości dni między datami
                .mapToDouble(t -> ChronoUnit.DAYS.between(t, LocalDate.now()))
                //liczę średnią
                .average().getAsDouble();

        //Then
        Assert.assertEquals(10, countAverage, 0);
    }
}