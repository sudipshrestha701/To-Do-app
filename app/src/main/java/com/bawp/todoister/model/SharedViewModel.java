package com.bawp.todoister.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SharedViewModel extends ViewModel {
    private final MutableLiveData<Task> selectedItem = new MutableLiveData<>();
    private boolean isEdit=false;
    public void selectItem(Task task){
        selectedItem.setValue(task);
    }

    public LiveData<Task> getSelectedItem(){
        return selectedItem;
    }
    public void setisEdit(boolean isEdit){
        this.isEdit = isEdit;
    }
    public boolean getisEdit(){
        return isEdit;
    }
}
