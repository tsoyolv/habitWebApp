package com.habit.mvc.view;

import com.habit.custom.server.api.model.Habit;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * OLTS on 04.01.2017.
 */
public class HabitXlsView extends AbstractXlsView {

    @Override
    protected void buildExcelDocument(Map<String, Object> model,
                                      org.apache.poi.ss.usermodel.Workbook workbook,
                                      HttpServletRequest request,
                                      HttpServletResponse response) throws Exception {
        // change the file name
        response.setHeader("Content-Disposition", "attachment; filename=\"my-xls-file.xls\"");

        @SuppressWarnings("unchecked")
        List<Habit> habits = (List<Habit>) model.get("habit");

        // create excel xls sheet
        Sheet sheet = workbook.createSheet("Spring MVC AbstractXlsView");

        // create header row
        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("ID");
        header.createCell(1).setCellValue("Name");
        header.createCell(2).setCellValue("Score");

        // Create data cells
        int rowCount = 1;
        for (Habit habit : habits){
            Row courseRow = sheet.createRow(rowCount++);
            courseRow.createCell(0).setCellValue(habit.getId());
            courseRow.createCell(1).setCellValue(habit.getName());
            courseRow.createCell(2).setCellValue(habit.getScore());
        }
    }
}
