package formulas;

import Interfaces.Scene1Controller.*;
import static formulas.Formule.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import licenta.entity.User;
import java.io.Reader;
import java.net.MalformedURLException;
import java.nio.charset.Charset;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Test  {
    

    public static void main(String[] args) throws IOException, Exception{
         
    List<User> users = new ArrayList<User>();
    String url = "http://localhost:8080/user/list";
    InputStream is = new URL(url).openStream();
    try {
      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
      String jsonText = readAll(rd);
      JSONArray jsonArr = new JSONArray(jsonText);
      
      for(int i = 0; i < jsonArr.length(); i++) {
          String firstName = jsonArr.getJSONObject(i).getString("firstName");
          String lastName = jsonArr.getJSONObject(i).getString("lastName");
          String gender = jsonArr.getJSONObject(i).getString("gender");
          int age = jsonArr.getJSONObject(i).getInt("age");
          double salary = jsonArr.getJSONObject(i).getDouble("salary");
          double loaned_sum = jsonArr.getJSONObject(i).getDouble("loaned_sum");
          int period = jsonArr.getJSONObject(i).getInt("period");
          double interest_rate = jsonArr.getJSONObject(i).getDouble("interest_rate");
          double dae = jsonArr.getJSONObject(i).getDouble("dae");
          double monthly_payment = jsonArr.getJSONObject(i).getDouble("monthly_payment");
          double total_amount = jsonArr.getJSONObject(i).getDouble("total_amount");
          int score = jsonArr.getJSONObject(i).getInt("score");
          String eligibility = jsonArr.getJSONObject(i).getString("eligibility");
          
          User u = new User(lastName,firstName,gender,age,salary,loaned_sum,period,
                        interest_rate,dae,monthly_payment,total_amount,score,eligibility);
          users.add(u);
          
      }
        
      System.out.println(users.get(0).getFirstName());
      System.out.println(users.get(0).getSalary());
      
      // call aici
    } finally {
      is.close();
    }

    }
    
 private static String readAll(Reader rd) throws IOException {
    StringBuilder sb = new StringBuilder();
    int cp;
    while ((cp = rd.read()) != -1) {
      sb.append((char) cp);
    }
    return sb.toString();
  }
 
 public static User getUserInfo(TextArea a) throws MalformedURLException, IOException {
    String url = "http://localhost:8080/user/latest";
    InputStream is = new URL(url).openStream();
    User user = null;
    try {
      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
      String jsonText = readAll(rd);
      JSONObject json = new JSONObject(jsonText);
      
    user = new User(json.getString("lastName"),json.getString("firstName"),json.getString("gender"),json.getInt("age"),json.getDouble("salary"),
              json.getDouble("loaned_sum"),json.getInt("period"),json.getDouble("interest_rate"),json.getDouble("dae"),json.getDouble("monthly_payment"),
          json.getDouble("total_amount"),json.getInt("score"),json.getString("eligibility"));
      
      a.appendText("Credit details:"+"\n"+"\n");
      a.appendText("Client's last name: "+json.getString("lastName")+"\n");
      a.appendText("Client's first name: "+json.getString("firstName")+"\n");
      a.appendText("Client's gender: "+json.getString("gender")+"\n");
      a.appendText("Client's age: "+json.getInt("age")+ " years"+"\n");
      a.appendText("Client's salary: "+json.getDouble("salary")+ " lei"+"\n");
      a.appendText("Desired amount of money: "+json.getDouble("loaned_sum")+ " lei"+"\n");
      a.appendText("Loan period: "+json.getInt("period")+ " year/years"+"\n");
      a.appendText("Credit's interest rate: "+json.getDouble("interest_rate")+ " %"+"\n");
      a.appendText("DAE: "+json.getDouble("dae")+ " %"+"\n");
      a.appendText("Client's monthly payment: "+json.getDouble("monthly_payment")+ " lei"+"\n");
      a.appendText("Total payment:: "+json.getDouble("total_amount")+ " lei"+"\n");
      a.appendText("Credit's score: "+json.getInt("score") +" points"+"\n");
      a.appendText("Is the client eligibile for the desired credit: "+json.getString("eligibility")+"\n");
      
      //doar atat in interfata ca sa afiseze in text box
//     User u = getUserInfo();
//      area.append(u.getFirstName()); text2
      
    } finally {
      is.close();
    }
    
    return user;
 }
 //agumente insertUser din interfata parsate
 public static void insertUser(String lname, String fname, int age1, String gender1,int period1,double amount1, double salary1) throws ClientProtocolException, IOException {
    CloseableHttpClient client = HttpClients.createDefault();
    HttpPost httpPost = new HttpPost("http://localhost:8080/user/add");
    // variabile aici
    
    double loaned_sum= amount1;
    String firstName = fname;
    String lastName=lname;
   
    int age=age1;
    String gender =gender1;
    double salary=salary1;
    int period=period1;
    double interest_rate = computeInterestRate( amount1);
    double dae = computeDAE(interest_rate,period);
    double monthly_payment = computeMonthlyPayment( loaned_sum, interest_rate, period);
    double total_amount=computeTotal(interest_rate,loaned_sum,period);
    int score=computeScore(salary,loaned_sum,period);
    String eligibility=computeClass(score);
    //coimnpleteaza cu parametrii din interfata si modifica formulele astfel incat sa fie return type,nu void
     // aici din interfata parsari etc
   
    
    
    String json = "{"
            + "\"last_name\":\""+lastName+"\","
            + "\"first_name\":\""+firstName+"\","
            + "\"gender\":\""+gender+"\","
            + "\"age\":\""+age+"\","
            + "\"salary\":\""+salary+"\","
            + "\"loaned_sum\":\""+loaned_sum+"\","
            + "\"period\":\""+period+"\","
            + "\"interest_rate\":\""+interest_rate+"\","
            + "\"DAE\":\""+dae+"\","
            + "\"monthly_payment\":\""+monthly_payment+"\","
            + "\"total_amount\":\""+total_amount+"\","
            + "\"score\":\""+score+"\","
            + "\"eligibility\":\""+eligibility+"\""
            + "}";
    StringEntity entity = new StringEntity(json);
    httpPost.setEntity(entity);
    httpPost.setHeader("Accept", "application/json");
    httpPost.setHeader("Content-type", "application/json");
    CloseableHttpResponse response = client.execute(httpPost);
    StatusLine s1 = response.getStatusLine();
    System.out.print(s1.getStatusCode());
    client.close();
 }
 
// {
//  "name": "John",
//   "age": 12,
//  "password": "test123",
//  "email": "test@yahoo.com",
//  "notification": "push"
//}
    
//List<User> getUsers() {
//       String Url = "http://localhost:8080/user/list";
//       List<User> users = new ArrayList<User>();
//       
//       try(InputStream is = new URL(Url).openStream()){
//
//            JsonArray reader =  Json.createReader(new InputStreamReader(is, "UTF-8")).readArray();
//            
//            for(int i=0; i<reader.size(); i++) {
//                JsonObject user = reader.get(i).asJsonObject();
//                String lastName = user.getString("lastName");
//                String firstName = user.getString("firstName");
//                String gender = user.getString("gender");
//                int age=user.getInt("age");
//                JsonNumber s = user.getJsonNumber("salary");
//                double salary = s.doubleValue();
//                JsonNumber ls=user.getJsonNumber("loaned_sum");
//                double loaned_sum=ls.doubleValue();
//                int period=user.getInt("period");
//                JsonNumber ir=user.getJsonNumber("interest_rate");
//                double interest_rate=ir.doubleValue();
//                
//                JsonNumber mp=user.getJsonNumber("monthly_payment");
//                double monthly_payment=mp.doubleValue();
//                
//                JsonNumber ta=user.getJsonNumber("total_amount");
//                double total_amount=ta.doubleValue();
//                JsonNumber de=user.getJsonNumber("dae");
//                double dae=de.doubleValue();
//                int score=user.getInt("score");
//                String eligibility = user.getString("eligibility");
//
//                User u = new User(lastName,firstName,gender,age,salary,loaned_sum,period,
//                        interest_rate,dae,monthly_payment,total_amount,score,eligibility);
//                users.add(u);
//                
//               
//            }
//        }
//        catch(IOException e){
//            e.printStackTrace();
//        }
//       
//       return users;
//    }
//    

}
