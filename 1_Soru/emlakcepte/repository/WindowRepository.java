package com.emlakcepte.repository;

import com.emlakcepte.model.Window;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class WindowRepository {
    private static List<Window> windows =new ArrayList<>();

    public void saveWindow(Window window){
        windows.add(window);
    }

    public List<Window>getAllWindows(){
        return windows;
    }
}
