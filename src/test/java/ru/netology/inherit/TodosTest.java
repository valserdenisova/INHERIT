package ru.netology.inherit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {

    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchInTodos() {
        SimpleTask simpleTask = new SimpleTask(1, "Сделать домашнее задание");

        String[] subtasks = {"Прочитать главу", "Просмотреть видео", "Пройти опрос", "Сделать домашнее задание"};
        Epic epic = new Epic(3, subtasks);

        Meeting meeting = new Meeting(3, "Изучение новой темы", "Обучение", "1 марта в 12:00");

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic};
        Task[] actual = todos.search("Сделать");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchInTodosAll() {
        SimpleTask simpleTask = new SimpleTask(1, "Сделать домашнее задание");

        String[] subtasks = {"Прочитать главу", "Просмотреть видео", "Пройти опрос", "Сделать домашнее задание"};
        Epic epic = new Epic(3, subtasks);

        Meeting meeting = new Meeting(3, "Сделать домашнее задание", "Обучение", "1 марта в 12:00");

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.search("Сделать");

        Assertions.assertArrayEquals(expected, actual);
    }
}