package org.emmakema47.todolistapp;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import org.emmakema47.todolistapp.utils.TodoListDAO;

public class TodoListController {

    @FXML
    private TextField taskInput;

    @FXML
    private ListView<String> taskList;

    private TodoListDAO todoListDAO;

    public TodoListController() {
        this.todoListDAO = new TodoListDAO();
    }

    @FXML
    public void initialize() {
        loadTasks();
    }

    @FXML
    private void addTask() {
        String taskDescription = taskInput.getText().trim();
        if (!taskDescription.isEmpty()) {
            todoListDAO.addTask(taskDescription);
            loadTasks();
            taskInput.clear();
        }
    }

    @FXML
    private void markCompleted() {
        String selectedTask = taskList.getSelectionModel().getSelectedItem();
        if (selectedTask != null) {
            todoListDAO.markTaskCompleted(selectedTask);
            loadTasks();
        }
    }

    @FXML
    private void removeTask() {
        String selectedTask = taskList.getSelectionModel().getSelectedItem();
        if (selectedTask != null) {
            todoListDAO.removeTask(selectedTask);
            loadTasks();
        }
    }

    private void loadTasks() {
        taskList.getItems().clear();
        taskList.getItems().addAll(todoListDAO.getTasks());
    }
}
