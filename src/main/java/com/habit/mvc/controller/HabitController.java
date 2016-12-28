package com.habit.mvc.controller;

import com.habit.custom.server.api.dao.HabitDao;
import com.habit.custom.server.api.model.Habit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * OLTS on 28.12.2016.
 */
@Controller
public class HabitController {

    @Autowired
    @Qualifier("habitDao")
    private HabitDao habitDao;

    @RequestMapping(value = "/mvcHabit", method = RequestMethod.GET)
    public ModelAndView habit() {
        return new ModelAndView("habit", "command", new Habit());
    }

    @RequestMapping(value = "/mvcAddHabit", method = RequestMethod.POST)
    public String addHabit(@ModelAttribute("SpringWeb") Habit habit,
                           ModelMap model) {
        model.addAttribute("name", habit.getName());
        model.addAttribute("score", habit.getScore());
        habitDao.create(habit);
        return "result";
    }

    public HabitDao getHabitDao() {
        return habitDao;
    }

    public void setHabitDao(HabitDao habitDao) {
        this.habitDao = habitDao;
    }
}
