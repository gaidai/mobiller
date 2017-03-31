/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapp1;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javafx.collections.ObservableList;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
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
    public void writeXLS(ObservableList<Friend> k) throws FileNotFoundException, IOException{
        Workbook wb = new HSSFWorkbook();
        Sheet sh = wb.createSheet("sheet1");
        int i =0;
        for (Friend f:k){
        
                Row row = sh.createRow(i++);
                Cell cell0 = row.createCell(0);
                Cell cell1 = row.createCell(1);
                Cell cell2 = row.createCell(2);
                Cell cell3 = row.createCell(3);
                
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
    public void readXLS(String a){
        System.out.println(a);
                
    }

    
}
