
package javafxapp1;

import java.io.*;
import java.net.URL;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ResourceBundle;
import java.util.StringTokenizer;
import javafx.animation.RotateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.util.Duration;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


/**
 *
 * @author user
 */
public class FXML1DocumentController implements Initializable {
    
    @FXML
    public Label label;
    public Label label1;
    public Label label2;
    public Label label3;
    public MenuItem expXlS;
    public MenuItem impXlS;
    public MenuItem exp;
    public MenuItem imp;
    @FXML
    public Button button0;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button selectsql;
    private Button insertsql;
    /**
     *
     */
    public TextField c1;

    /**
     *
     */
    public TextField c2;

    /**
     *
     */
    public TextField c3;
    private ObservableList<Friend> K = FXCollections.observableArrayList();
    @FXML
    private TableView<Friend> tablebook;
 
    @FXML
    private TableColumn<Friend, Integer> numb;
 
    @FXML
    private TableColumn<Friend, String> fname;
 
    @FXML
    private TableColumn<Friend, String> name;
 
    @FXML
    private TableColumn<Friend, String> mobile;
    @FXML
    private TableColumn<Friend, String> date;
    
    String n = "";
    public void moive (Label a) {
        
        int con = 15;
             
          RotateTransition R1 = new RotateTransition(Duration.seconds(0.25), a);  
          R1.setByAngle(con);
          R1.setCycleCount(6);
          R1.setAutoReverse(true);
          R1.play();
    }
        
    @FXML
    private void impAction(ActionEvent event) throws IOException {
        readfile();
    }
    
    public void createFile(){
    try(FileWriter fw = new FileWriter("mobilesfile.txt")) {
        fw.close();
    } catch (IOException e) {
        System.err.println(e.getMessage());
    }
    }

     public void writeInfoFile() throws FileNotFoundException, UnsupportedEncodingException, IOException{
    
    
     try {PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("mobilesfile.txt", true), "UTF-8")); {
        for(int i = 0; i  <K.size(); i++){
            pw.write( numb.getCellData(i) + "^"  + fname.getCellData(i) + "^" + name.getCellData(i) + "^" + mobile.getCellData(i) + "^" + date.getCellData(i) +"\r\n");
                  //  pw.println( K.set(selectedIndex, new Friend(numb.getCellData(selectedIndex)-1, fname.getCellData(selectedIndex), name.getCellData(selectedIndex), mobile.getCellData(selectedIndex))));
     }
        pw.close();
          al ("Information Dialog","Данные записаны в файл :","mobilesfile.txt");
    }} catch (FileNotFoundException e) {
        
        System.out.println("ошибка записи в файл");
        }
   }
     
     public void readfile() throws IOException {
            FileReader fr = null;
        try {
            fr = new FileReader("mobilesfile.txt");
        } catch (FileNotFoundException ex) {
            label.setText("File was not found");
        }
             String tst ;
          try {  BufferedReader bfr = new  BufferedReader (fr);
           while ((tst = bfr.readLine()) != null) {
            
           StringTokenizer stt = new StringTokenizer(tst , "^");
           while(stt.hasMoreTokens()) {
            String nu = stt.nextToken();
           String f = stt.nextToken();
           String na = stt.nextToken();
           String m = stt.nextToken();
           String d = stt.nextToken();
           
           K.add(new Friend(K.size()+1, f, na, m , d));    
           }}} catch (IOException e) {
            // log error
          } 
                //while ((sCurrentLine = bfr.readLine()) != null) {
		//		System.out.println(sCurrentLine);
		//	}
           al("Information Dialog","Данные извлечены из файла :","mobilesfile.txt");
     }
    @FXML
    private void expAction(ActionEvent event) throws UnsupportedEncodingException, IOException {
      writeInfoFile();
    }
   
    @FXML
    private void expXLSAction(ActionEvent event) throws UnsupportedEncodingException, IOException {
        TextInputDialog ();
        al("Information Dialog","Operation sucessful","XlS file was saved");
        
    }
    @FXML
    private void impXLSAction(ActionEvent event)throws UnsupportedEncodingException, IOException{
      //  XLS xi = new XLS();
      // TextInputDialog ();
       
       TextOutDialog() ;
        //al("Information Dialog","Operation sucessful","XlS file saved");
       // alert2();
    }
    
    @FXML
    private void selectsqlButtonAction(ActionEvent event) throws ClassNotFoundException, SQLException {
        System.out.println("selectsqlButtonAction");
                            
        SQLsel tab = new SQLsel();
        SQLsel.selectsql();
    }
    @FXML
    private void insertsqlButtonAction(ActionEvent event) throws ClassNotFoundException, SQLException {
        System.out.println("selectsqlButtonAction");
        int selectedIndex = tablebook.getSelectionModel().getSelectedIndex();                    
        SQLins tab = new SQLins();
        SQLins.insertsql(mobile.getCellData(selectedIndex), fname.getCellData(selectedIndex), name.getCellData(selectedIndex),date.getCellData(selectedIndex));
    }
    
    @FXML
    private void handleButton0Action(ActionEvent event) {
        System.out.println(c2.getText());
                            
        c2.setText("");
    }
    
    @FXML
    private void handleButton1Action(ActionEvent event) {
        
        int selectedIndex = tablebook.getSelectionModel().getSelectedIndex();
        K.remove(selectedIndex);
        while(selectedIndex + 1 <=K.size()){
        K.set(selectedIndex, new Friend(numb.getCellData(selectedIndex)-1, fname.getCellData(selectedIndex), name.getCellData(selectedIndex), mobile.getCellData(selectedIndex),date.getCellData(selectedIndex)));
        selectedIndex++;
        }
        System.out.println("удален выделенный элемент");
    }
    
    @FXML
    private void handleButton2Action(ActionEvent event) throws ParseException {
        System.out.println("change");
        int selectedIndex = tablebook.getSelectionModel().getSelectedIndex();
        K.set(selectedIndex, new Friend(numb.getCellData(selectedIndex), c1.getText(), c2.getText(), c3.getText(), getdate()));
    }
    
    @FXML
    private void handleButton3Action(ActionEvent event) throws ParseException {
        System.out.println("save");
        
        if( n.equals(c1.getText())) { 
            System.out.println("c1 empty");
            moive(label1);
        } else if(n.equals(c2.getText())) {
            System.out.println("c2 empty");
            moive(label2);
        } else if(n.equals(c3.getText())) {
            System.out.println("c3 empty");
            moive(label3);
        } else {
            System.out.println("Новая строка в списке-листе");
            wr();}
    }
    
    @FXML 
    public void initialize(URL location, ResourceBundle resources) {
       
 
        // устанавливаем тип и значение которое должно хранится в колонке
        numb.setCellValueFactory(new PropertyValueFactory<Friend, Integer>("numb"));
        fname.setCellValueFactory(new PropertyValueFactory<Friend, String>("fname"));
        name.setCellValueFactory(new PropertyValueFactory<Friend, String>("name"));
        mobile.setCellValueFactory(new PropertyValueFactory<Friend, String>("mobile"));
        date.setCellValueFactory(new PropertyValueFactory<Friend, String>("date"));
 
        // заполняем таблицу данными
        tablebook.setItems(K);
    }
    
        public void initData() {
        K.add(new Friend(K.size()+1, "Alex", "qwerty", "alex@mail.com","0"));
        K.add(new Friend(K.size()+1, "Bob", "dsfsdfw", "bob@mail.com","0"));
        K.add(new Friend(K.size()+1, "Jeck", "dsfdsfwe", "Jeck@mail.com","0"));
        K.add(new Friend(K.size()+1, "Mike", "iueern", "mike@mail.com","0"));
        K.add(new Friend(K.size()+1, "colin", "woeirn", "colin@mail.com","0"));
        }
        public void wr() throws ParseException {
            K.add(new Friend(K.size()+1, c1.getText(), c2.getText(), c3.getText(), getdate() ));
        }
 
    String year;
    String month;
    String day;
    Date date1 ;
    String time ;
    Alert alert;
  //  Date parsedDate;
    public String getdate () throws ParseException{
        
        date1 = new Date();
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy. MM. dd  hh:mm");
         
        time = format1.format(date1);
       // parsedDate = new SimpleDateFormat("yyyy.MM.dd  hh:mm").parse("16.04.2004");
        
        return time;
     
    }
    
    public void al (String a,String b,String c){
       alert = new Alert(AlertType.INFORMATION);
       alert.setTitle(a);
       alert.setHeaderText(b);
       alert.setContentText(c);

       alert.showAndWait();
   
   }
    public void alert2 (){
        Alert alert2 = new Alert(AlertType.CONFIRMATION);
        XLS xl = new XLS();
       


       alert2.showAndWait();
       
    }
    public void TextInputDialog () throws IOException{
        TextInputDialog txtdialog = new TextInputDialog ();
        txtdialog.setHeaderText("Write the name for new XlS file:");
        txtdialog.setTitle("Input the name");
        txtdialog.getEditor();
        ButtonType apply = new ButtonType("appllly", ButtonData.APPLY);
        ButtonType ok= new ButtonType("oookkkk", ButtonData.OK_DONE);
        ButtonType cancelar = new ButtonType( "cancellar", ButtonData.CANCEL_CLOSE);
        txtdialog.getEditor().setPromptText("Enter address");
        Optional<String> result = txtdialog.showAndWait();
        txtdialog.getDialogPane().getButtonTypes().setAll( ok, cancelar);


	if (result.isPresent()) {
		String filename = result.get().trim();
                XLS x = new XLS();
		x.writeXLS(filename);
	}
    }    
    public void  TextOutDialog () {
        try{
              FileChooser fileChooser = new FileChooser();
              //Set extension filter
              FileChooser.ExtensionFilter xlsFilter = new FileChooser.ExtensionFilter("XLS files (*.xls)", "*.xls");
              FileChooser.ExtensionFilter txtFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
              fileChooser.getExtensionFilters().add(xlsFilter);
              fileChooser.getExtensionFilters().add(txtFilter);
              
              //Show open file dialog
              Stage chooser = new Stage();
              
              File file = fileChooser.showOpenDialog(chooser);
              
              
              if( file.getPath()!= null ){ 
              XLS choserxls = new XLS();
              choserxls.readXLS(file.getPath());
              } else {  chooser.close();}
        } catch ( NullPointerException e ){}
    }
   /* public void Filechooser(){
     FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Save Image");
      final Label labelSelectedDirectory = new Label();
         
        
                DirectoryChooser directoryChooser = new DirectoryChooser();
                File selectedDirectory = 
                        directoryChooser.showDialog(JavaFXAp);
                 
                if(selectedDirectory == null){
                    labelSelectedDirectory.setText("No Directory selected");
                }else{
                    labelSelectedDirectory.setText(selectedDirectory.getAbsolutePath());
                }
             
            
              
        
        
    }*/
}