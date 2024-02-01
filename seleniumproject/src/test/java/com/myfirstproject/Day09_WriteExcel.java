package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.apache.poi.ss.usermodel.*;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Day09_WriteExcel {
    @Test
    public void writeExcelTest() {


//        Store the path of the file as string and open the file

        String path = "resources/Capitals.xlsx";
//        Open the workbook
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            Workbook workbook = WorkbookFactory.create(fileInputStream);

//        Open the first worksheet
            Sheet sheet1 = workbook.getSheetAt(0); // index start at 0
            //  Sheet sheet1 = workbook.getSheet("Sheet1"); // use the title of the sheet as well

//        Go to the first row
            Row row1 = sheet1.getRow(0);  // returns first row

//        Write and save the workbook
            // Without following 4 steps, we cannot send and write anything in Excel
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            workbook.write(fileOutputStream);



//        Create a cell on the 3rd column (2nd index) on the first row
            Cell r1c3 = row1.createCell(2);  // Creates a cell in the 3rd column

//        Write "POPULATION" on that cell
//        To write anything on the Excel sheet, we need to save the workbook first using FileOutputStream
            r1c3.setCellValue("POPULATION");

//        Create a cell on the 2nd row 3rd cell(index2), and write 150000

//        Create a cell on the 3rd row 3rd cell(index2), and write 250000
//        Create a cell on the 4th row 3rd cell(index2), and write 54000



//        Close the file
            fileOutputStream.close();
            fileInputStream.close();
//        Close the workbook
            workbook.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}