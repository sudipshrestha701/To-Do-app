package com.bawp.todoister.data;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.bawp.todoister.model.Task;
import com.bawp.todoister.util.TodoRoomDatabase;

import java.util.List;

public class TodoRepository {
    private final TodoDao todoDao;
    private final LiveData<List<Task>> allTasks;

    public TodoRepository(Application application) {
        TodoRoomDatabase database = TodoRoomDatabase.getDatabase(application);
        
        todoDao = database.todoDao();
        allTasks = todoDao.getTasks();
    }

    public LiveData<List<Task>> getAllTasks(){
        return allTasks;
    }

    public void insert(Task task){
        TodoRoomDatabase.databaseWriteExecutor.execute(() -> todoDao.insertTask(task));
    }

    public LiveData<Task> get(long id) {
        return todoDao.get(id);
    }

    public void update(Task task){
        TodoRoomDatabase.databaseWriteExecutor.execute(()->todoDao.Update(task));
    }

    public void delete(Task task){
        TodoRoomDatabase.databaseWriteExecutor.execute(() ->todoDao.delete(task));
    }

    public void deleteAll(){
        TodoRoomDatabase.databaseWriteExecutor.execute(() ->todoDao.deleteAll());
    }
}
