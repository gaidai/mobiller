/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapp1;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/**
 *
 * @author user
 */
public class XLS {
    public void writeXLS(String a) throws FileNotFoundException, IOException{
        Workbook wb = new HSSFWorkbook();
        Sheet sh = wb.createSheet("sheet1");
        
        
        
                Row row = sh.createRow(0);
                Cell cell0 = row.createCell(0);
                Cell cell1 = row.createCell(1);
                Cell cell2 = row.createCell(2);
                Cell cell3 = row.createCell(3);
                
                cell0.setCellValue("a");
                cell1.setCellValue("b");
                cell2.setCellValue("c");
                cell3.setCellValue("d");
                
                
        FileOutputStream fos = new FileOutputStream(a + ".xls");
        
        
        
        
        
        wb.write(fos);
        fos.close();
    
        
    }
    public void readXLS(String a){
        System.out.println(a);
                
    }
}
