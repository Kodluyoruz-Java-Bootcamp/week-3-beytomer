package com.emlakcepte.service;

import com.emlakcepte.repository.WindowRepository;
import com.emlakcepte.model.Window;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WindowService {
        @Autowired
        WindowRepository windowDao;

        private RealtyService realtyService;

        public void createWindow(Window window){
                windowDao.saveWindow(window);
        }

        public List<Window> getAllWindow(){
                return windowDao.getAllWindows();
        }

}
