package com.habit.mvc.controller;

import com.habit.custom.server.api.dao.HabitDao;
import com.habit.custom.server.api.model.Habit;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;

/**
 * OLTS on 28.12.2016.
 */
@Controller
public class HabitController {

    @Autowired @Qualifier("habitDao")
    private HabitDao habitDao;
    @Autowired
    private Environment environment;

    @RequestMapping(value = "/mvcHabit", method = RequestMethod.GET)
    public String habit(ModelMap model) {
        model.addAttribute("createHabit", new Habit()/* Habit POJO is model in MVC */);
        return "habit" /* habit.jsp is view in MVC */;
    }

    @RequestMapping(value = "/mvcAddHabit", method = RequestMethod.POST)
    public String addHabit(@Valid Habit habit,
                           BindingResult bindingResult, ModelMap model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("error", bindingResult.getFieldErrors().get(0).getDefaultMessage());
            return "error";
        }
        model.addAttribute("name", habit.getName());
        model.addAttribute("score", habit.getScore());
        habitDao.create(habit);
        return "result";
    }

    @RequestMapping(value = "/attachmvc", method = RequestMethod.GET)
    public String attach() {
        return "attachment";
    }

    @RequestMapping(value = "/addAttach", method=RequestMethod.POST)
    public String addAttachFromForm(@RequestParam(value = "image", required = true) MultipartFile image) {
        try {
            if(!image.isEmpty()) {
                validateImage(image);
                saveImage(image);
            }
        } catch (RuntimeException e) {

            return "error";
        }
        return "home";
    }

    private void validateImage(MultipartFile image) {
        if(!image.getContentType().equals("image/jpeg")) {
            throw new RuntimeException("Only JPG images accepted");
        }
    }

    private void saveImage(MultipartFile image)
            throws RuntimeException {
        String filename = "new";
        try {
            File file = new File(getWebRootPath() + "/resources/" + filename);
            FileUtils.writeByteArrayToFile(file, image.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Unable to save image", e);
        }
    }

    public String getWebRootPath() {
        return environment.getProperty("catalina.base");
    }
}
