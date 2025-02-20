package ru.netology.inherit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TasksTest {

    @Test
    public void shouldFindSimpleTask() {
        Task simpleTask = new SimpleTask(1, "Сделать домашнее задание");

        boolean expected = true;
        boolean actual = simpleTask.matches("Сделать");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotFindSimpleTask() {
        Task simpleTask = new SimpleTask(1, "Сделать домашнее задание");

        boolean expected = false;
        boolean actual = simpleTask.matches("Написать");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindEpicTask() {
        String[] subtasks = {"Прочитать главу", "Просмотреть видео", "Пройти опрос", "Сделать домашнее задание"};
        Task epicTask = new Epic(2, subtasks);

        boolean expected = true;
        boolean actual = epicTask.matches("опрос");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotFindEpicTask() {
        String[] subtasks = {"Прочитать главу", "Просмотреть видео", "Пройти опрос", "Сделать домашнее задание"};
        Task epicTask = new Epic(2, subtasks);

        boolean expected = false;
        boolean actual = epicTask.matches("задачу");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindMeeting() {
        Task meeting = new Meeting(3, "Изучение новой темы", "Обучение", "1 марта в 12:00");

        boolean expected = true;
        boolean actual = meeting.matches("новой темы");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotFindMeeting() {
        Task meeting = new Meeting(3, "Изучение новой темы", "Обучение", "1 марта в 12:00");

        boolean expected = false;
        boolean actual = meeting.matches("1 июня");

        Assertions.assertEquals(expected, actual);
    }
}
