package com.emlakcepte.controller;

import com.emlakcepte.model.Realty;
import com.emlakcepte.model.Window;
import com.emlakcepte.service.WindowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/window")
public class WindowController {
    @Autowired
    private WindowService windowService;

    @GetMapping
    public List<Window> getAll(){
        return windowService.getAllWindow();
    }
    // Şehir vitrini 10 ilandan oluşur. Şehir bazlı vitrinler oluşturun
    @PostMapping
    public Window create(@RequestBody Window window){
        windowService.createWindow(window);
        return window;
    }

}
