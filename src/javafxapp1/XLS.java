/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapp1;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javafx.collections.ObservableList;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/**
 *
 * @author user
 */
public class XLS {
    public void writeXLS(ObservableList<Friend> k) throws FileNotFoundException, IOException{
        Workbook wb = new HSSFWorkbook();
        Sheet sh = wb.createSheet("sheet1");
        Row row1 = sh.createRow(1);
        Row row2 = sh.createRow(2);
        row2.setHeightInPoints(20);
        row1.setHeightInPoints(20);
        sh.setColumnWidth(1, 4450);
        sh.setColumnWidth(2, 4500);
        sh.setColumnWidth(3, 4500);
        sh.setColumnWidth(4, 4700);
        // Set styles for title row
        CellStyle style1 = wb.createCellStyle();
        CellStyle style2 = wb.createCellStyle();
        CellStyle style3 = wb.createCellStyle();
        CellStyle style4 = wb.createCellStyle();
        style1.setAlignment(HorizontalAlignment.CENTER);
        style2.setAlignment(HorizontalAlignment.CENTER);
        style3.setAlignment(HorizontalAlignment.CENTER);
        style1.setBorderBottom(BorderStyle.MEDIUM_DASHED);
        style1.setBottomBorderColor(IndexedColors.GREY_25_PERCENT.getIndex());
        style2.setBorderBottom(BorderStyle.MEDIUM_DASHED);
        style2.setBottomBorderColor(IndexedColors.GREY_25_PERCENT.getIndex());
        style3.setBorderBottom(BorderStyle.MEDIUM_DASHED);
        style3.setBottomBorderColor(IndexedColors.GREY_25_PERCENT.getIndex());
                
        style1.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style2.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style3.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style1.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
        style2.setFillForegroundColor(IndexedColors.LIGHT_TURQUOISE.getIndex());
        style3.setFillForegroundColor(IndexedColors.LIGHT_YELLOW.getIndex());
        // font for titles
        Font font = wb.createFont();
        font.setBold(true);
        font.setFontHeight((short)260);
        font.setFontName("Microsoft Phagspa");
        //font for phone numbers
        Font fontn = wb.createFont();
        fontn.setFontHeight((short)230);
        fontn.setFontName("Courier New");
                       
        Cell title0 = row1.createCell(1);  Cell title1 = row1.createCell(2);
        Cell title2 = row1.createCell(3);  Cell title3 = row1.createCell(4);
        
        style1.setFont(font);
        style2.setFont(font);
        style3.setFont(font);
        style4.setFont(fontn);
        
        
        title0.setCellStyle(style1);
        title1.setCellStyle(style2);
        title2.setCellStyle(style2);
        title3.setCellStyle(style3);
        title0.setCellValue("Phone number");
        title1.setCellValue("Family name");
        title2.setCellValue("Name");
        title3.setCellValue("Date");
        int i = 3;
        for (Friend f:k){
                Row row = sh.createRow(i++);
                Cell cell0 = row.createCell(1);  Cell cell1 = row.createCell(2);
                Cell cell2 = row.createCell(3);  Cell cell3 = row.createCell(4);
                cell0.setCellStyle(style4);
                cell0.setCellValue(f.getMobile());
                cell1.setCellValue(f.getFname());
                cell2.setCellValue(f.getName());
                cell3.setCellValue(f.getDate());}
                
                FileChooser fileChooser = new FileChooser();

                  //Set extension filter
                FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("XLS files (*.xls)", "*.xls");
                fileChooser.getExtensionFilters().add(extFilter);

                Stage stage = null;
                File file = fileChooser.showSaveDialog(stage);
                  
                FileOutputStream fos = new FileOutputStream(file);
                wb.write(fos);
                fos.close();
                           
        
    }
    public void readXLS(String a) throws FileNotFoundException, IOException{
        FileInputStream fis = new FileInputStream(a);
        Workbook wb = new HSSFWorkbook(fis);
         int rows = wb.getSheetAt(0).getLastRowNum();
         for(int i=3; i<=rows; i++){
            String fn = wb.getSheetAt(0).getRow(i).getCell(1).getStringCellValue();
            String n = wb.getSheetAt(0).getRow(i).getCell(2).getStringCellValue();
            String m = wb.getSheetAt(0).getRow(i).getCell(3).getStringCellValue();
            String d = wb.getSheetAt(0).getRow(i).getCell(4).getStringCellValue();
            System.out.println(fn + "   "+ n +"   "+ m +"   " + d  );  
            }
        System.out.println("В файле количество строк = "+(rows+1)+ " ;"); 
        fis.close();
        }
}