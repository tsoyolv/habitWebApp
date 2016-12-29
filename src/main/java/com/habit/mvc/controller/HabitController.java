package com.habit.mvc.controller;

import com.habit.custom.server.api.dao.HabitDao;
import com.habit.custom.server.api.model.Habit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * OLTS on 28.12.2016.
 */
@Controller
public class HabitController {

    @Autowired @Qualifier("habitDao")
    private HabitDao habitDao;

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
}
