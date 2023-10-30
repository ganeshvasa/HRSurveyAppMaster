package com.bbyn.rest.client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.bbyn.rest.model.ResponseGeneric;
import com.bbyn.rest.model.ResponseSurveyMaster;
import com.bbyn.rest.model.ResponseSurveyQuestion;
import com.bbyn.rest.model.ResponseUser;
import com.bbyn.rest.model.SurveyMaster;
import com.bbyn.rest.model.SurveyQuestions;
import com.bbyn.rest.model.UserProfile;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
public class MYSQLDML {
	
	private static String connURL ="jdbc:mysql://192.168.8.137:3306/bbynhr";
	private static String connUser ="root";
	private static String connPass ="vasa@123";
	private static String connDriver = "com.mysql.jdbc.Driver";
   public static void main(String[] args) {
	   
	// dbInsert("2022-06-10 10:31:02, otp", "2022-06-10 10:31:02", "A", "STC", "95650471543", "2022-06-10 10:30:02");
//	   ResponseUser result = getUser("02221u", "123456");
//         System.out.println(result.getStatus());
         
         ResponseSurveyMaster resSurveyMaster =  getSurveyMaster();
         System.out.println(resSurveyMaster.getStatus());
   }
   
   public static ResponseUser getUser(String user, String pass) {
      Connection conn = null;
      java.sql.Statement stmt = null;
      ResponseUser resUser = new ResponseUser();
      
      try {
         try {
         //   Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        	 Class.forName(connDriver);
         } catch (Exception e) {
            System.out.println(e);
      }
       
      conn =  DriverManager.getConnection(connURL, connUser, connPass);
      System.out.println("Connection is created successfully:");
      stmt = conn.createStatement();
      
      ResultSet rs = stmt.executeQuery("SELECT * FROM userprofile WHERE empID='"+user+"' and password='"+pass+"' and status='A'");

      UserProfile userPro =new UserProfile();
      while(rs.next())
      {
      
      String str1=rs.getString(1);
      String str2=rs.getString(2);
      String str3=rs.getString(3);
      String str4=rs.getString(4);
      String str5=rs.getString(5);
      String str6=rs.getString(6);
      String str7=rs.getString(7);
      
      if(str1 != null) {
      System.out.println("Record: "+str1+" "+str2+" "+str3+" "+str4+" "+str5+" "+str6+" "+str7);
      userPro.setEmpID(str1);
      userPro.setUserName(str2);
      userPro.setPassword("");
      userPro.setRoleName(str4);
      userPro.setDeptName(str5);
      userPro.setGroupName(str6);
      resUser.setUserProfile(userPro);
      resUser.setStatus("Success: Valid user:"+str1);
      resUser.setStatusCode(0);
      
      }
      
      return resUser;
      }
      
      resUser.setUserProfile(userPro);
      resUser.setStatus("Invalid user | User not found");
      resUser.setStatusCode(-1);      
      return resUser;
      } catch (SQLException excep) {
         excep.printStackTrace();
         resUser.setStatus("SQLException");
         resUser.setStatusCode(-2);
         return resUser;
      } catch (Exception excep) {
         excep.printStackTrace();
         resUser.setStatus("Exception");
         resUser.setStatusCode(-3);
         return resUser;
      } finally {
         try {
            if (stmt != null)
               conn.close();
         } catch (SQLException se) {}
         try {
            if (conn != null)
               conn.close();
         } catch (SQLException se) {
            se.printStackTrace();
         }  
      }
	
   }
   
   
   public static ResponseSurveyMaster getSurveyMaster() {
	      Connection conn = null;
	      java.sql.Statement stmt = null;
	      ResponseSurveyMaster responseSurveyMaster = new ResponseSurveyMaster();
	      List<SurveyMaster> surveyMasters = new ArrayList<SurveyMaster>();
	      try {
	         try {
	         //   Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	        	 Class.forName(connDriver);
	         } catch (Exception e) {
	            System.out.println(e);
	      }
	       
	      conn =  DriverManager.getConnection(connURL, connUser, connPass);
	      System.out.println("Connection is created successfully:");
	      stmt = conn.createStatement();
	      
	      ResultSet rs = stmt.executeQuery("SELECT surveyCode,surveryName,surveryType,status,targetDeptName,targetGroupName FROM surveymaster WHERE status='A'");

	      
	      while(rs.next())
	      {
	      SurveyMaster surveyMaster =new SurveyMaster();
	      String str1=rs.getString(1);
	      String str2=rs.getString(2);
	      String str3=rs.getString(3);
	      String str4=rs.getString(4);
	      String str5=rs.getString(5);
	      String str6=rs.getString(6);
	      
	      if(str1 != null) {
	      System.out.println("Record: "+str1+" "+str2+" "+str3+" "+str4+" "+str5+" "+str6);
	      surveyMaster.setSurveyCode(str1);
	      surveyMaster.setSurveryName(str2);
	      surveyMaster.setSurveryType(str3);
	      surveyMaster.setStatus(str4);
	      surveyMaster.setTargetDeptName(str5);
	      surveyMaster.setTargetGroupName(str6);
	      
	      surveyMasters.add(surveyMaster);
	      
	      }
	      
	   
	      }
	      
	      responseSurveyMaster.setSurveyMasters(surveyMasters);
	      responseSurveyMaster.setStatus("Success");
	      responseSurveyMaster.setStatusCode(0);	      
	      return responseSurveyMaster;
	      } catch (SQLException excep) {
	         excep.printStackTrace();
	         responseSurveyMaster.setSurveyMasters(surveyMasters);
		      responseSurveyMaster.setStatus("SQL Exception");
		      responseSurveyMaster.setStatusCode(-1);
		      return responseSurveyMaster;
	      } catch (Exception excep) {
	         excep.printStackTrace();
	         responseSurveyMaster.setSurveyMasters(surveyMasters);
		      responseSurveyMaster.setStatus("Exception");
		      responseSurveyMaster.setStatusCode(-2);
		      return responseSurveyMaster;
	      } finally {
	         try {
	            if (stmt != null)
	               conn.close();
	         } catch (SQLException se) {}
	         try {
	            if (conn != null)
	               conn.close();
	         } catch (SQLException se) {
	            se.printStackTrace();
	         }  
	      }
		
	   }
   
   
   public static ResponseSurveyQuestion getSurveyQuestions() {
	      Connection conn = null;
	      java.sql.Statement stmt = null;
	      ResponseSurveyQuestion responseSurveyMaster = new ResponseSurveyQuestion();
	      List<SurveyQuestions> surveyMasters = new ArrayList<SurveyQuestions>();
	      try {
	         try {
	         //   Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	        	 Class.forName(connDriver);
	         } catch (Exception e) {
	            System.out.println(e);
	      }
	       
	      conn =  DriverManager.getConnection(connURL, connUser, connPass);
	      System.out.println("Connection is created successfully:");
	      stmt = conn.createStatement();
	      
	      ResultSet rs = stmt.executeQuery("SELECT surveyCode,QueCode,Question,QueType,status,createdDate,updatedDate FROM surveydetail WHERE status='A'");

	      
	      while(rs.next())
	      {
	    	  SurveyQuestions surveyMaster =new SurveyQuestions();
	      String str1=rs.getString(1);
	      String str2=rs.getString(2);
	      String str3=rs.getString(3);
	      String str4=rs.getString(4);
	      String str5=rs.getString(5);
	      String str6=rs.getString(6);
	      String str7=rs.getString(7);
	      if(str1 != null) {
	      System.out.println("Record: "+str1+" "+str2+" "+str3+" "+str4+" "+str5+" "+str6);
	      surveyMaster.setSurveyCode(str1);
	      surveyMaster.setQueCode(str2);
	      surveyMaster.setQuestion(str3);
	      surveyMaster.setQueType(str4);
	      surveyMaster.setStatus(str5);
	      surveyMaster.setCreatedDate(str6);
	      surveyMaster.setUpdateDate(str7);
	      
	      surveyMasters.add(surveyMaster);
	      
	      }
	      
	   
	      }
	      
	      responseSurveyMaster.setSurveyQuestions(surveyMasters);
	      responseSurveyMaster.setStatus("Success");
	      responseSurveyMaster.setStatusCode(0);	      
	      return responseSurveyMaster;
	      } catch (SQLException excep) {
	         excep.printStackTrace();
	         responseSurveyMaster.setSurveyQuestions(surveyMasters);
		      responseSurveyMaster.setStatus("SQL Exception");
		      responseSurveyMaster.setStatusCode(-1);
		      return responseSurveyMaster;
	      } catch (Exception excep) {
	         excep.printStackTrace();
	         responseSurveyMaster.setSurveyQuestions(surveyMasters);
		      responseSurveyMaster.setStatus("Exception");
		      responseSurveyMaster.setStatusCode(-2);
		      return responseSurveyMaster;
	      } finally {
	         try {
	            if (stmt != null)
	               conn.close();
	         } catch (SQLException se) {}
	         try {
	            if (conn != null)
	               conn.close();
	         } catch (SQLException se) {
	            se.printStackTrace();
	         }  
	      }
		
	   }
   
   
   public static ResponseGeneric addQuestion(String surveyCode, String QueCode,String Question,String QueType) {
       Connection conn = null;
       java.sql.Statement stmt = null;
       ResponseGeneric resUser = new ResponseGeneric();
       
       try {
          try {
          //   Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
         	 Class.forName(connDriver);
          } catch (Exception e) {
             System.out.println(e);
       }
        
       conn =  DriverManager.getConnection(connURL, connUser, connPass);
       System.out.println("Connection is created successfully:");
       stmt = conn.createStatement();
       
       String sql = "INSERT INTO surveydetail (surveyCode,QueCode,Question,QueType,status) VALUES ('"+surveyCode+"','"+QueCode+"','"+Question+"','"+QueType+"','A')";
       stmt.executeUpdate(sql);
 
       resUser.setStatus("Success: Inserted successfully!");
       resUser.setStatusCode(0);
       return resUser;
     
       
     
       } catch (SQLException excep) {
          excep.printStackTrace();
          resUser.setStatus("SQLException");
          resUser.setStatusCode(-2);
          return resUser;
       } catch (Exception excep) {
          excep.printStackTrace();
          resUser.setStatus("Exception");
          resUser.setStatusCode(-3);
          return resUser;
       } finally {
          try {
             if (stmt != null)
                conn.close();
          } catch (SQLException se) {}
          try {
             if (conn != null)
                conn.close();
          } catch (SQLException se) {
             se.printStackTrace();
          }  
       }
    }
   
   public static ResponseGeneric deleteQuestion(String surveyCode, String QueCode) {
       Connection conn = null;
       java.sql.Statement stmt = null;
       ResponseGeneric resUser = new ResponseGeneric();
       
       try {
          try {
          //   Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
         	 Class.forName(connDriver);
          } catch (Exception e) {
             System.out.println(e);
       }
        
       conn =  DriverManager.getConnection(connURL, connUser, connPass);
       System.out.println("Connection is created successfully:");
       stmt = conn.createStatement();
       
       String sql = "UPDATE surveydetail set status = 'D' where surveyCode = '"+surveyCode+"' and QueCode ='"+QueCode+"'";
       stmt.executeUpdate(sql);
 
       resUser.setStatus("Success: Deleted successfully!");
       resUser.setStatusCode(0);
       return resUser;
     
       
     
       } catch (SQLException excep) {
          excep.printStackTrace();
          resUser.setStatus("SQLException");
          resUser.setStatusCode(-2);
          return resUser;
       } catch (Exception excep) {
          excep.printStackTrace();
          resUser.setStatus("Exception");
          resUser.setStatusCode(-3);
          return resUser;
       } finally {
          try {
             if (stmt != null)
                conn.close();
          } catch (SQLException se) {}
          try {
             if (conn != null)
                conn.close();
          } catch (SQLException se) {
             se.printStackTrace();
          }  
       }
    }
   
   public static ResponseGeneric updateQuestion(String surveyCode, String QueCode,String Question) {
       Connection conn = null;
       java.sql.Statement stmt = null;
       ResponseGeneric resUser = new ResponseGeneric();
       
       try {
          try {
          //   Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
         	 Class.forName(connDriver);
          } catch (Exception e) {
             System.out.println(e);
       }
        
       conn =  DriverManager.getConnection(connURL, connUser, connPass);
       System.out.println("Connection is created successfully:");
       stmt = conn.createStatement();
       
       String sql = "UPDATE surveydetail set Question = '"+Question+"' where surveyCode = '"+surveyCode+"' and QueCode ='"+QueCode+"' and status='A'";
       stmt.executeUpdate(sql);
 
       resUser.setStatus("Success: Updated successfully!");
       resUser.setStatusCode(0);
       return resUser;
     
       
     
       } catch (SQLException excep) {
          excep.printStackTrace();
          resUser.setStatus("SQLException");
          resUser.setStatusCode(-2);
          return resUser;
       } catch (Exception excep) {
          excep.printStackTrace();
          resUser.setStatus("Exception");
          resUser.setStatusCode(-3);
          return resUser;
       } finally {
          try {
             if (stmt != null)
                conn.close();
          } catch (SQLException se) {}
          try {
             if (conn != null)
                conn.close();
          } catch (SQLException se) {
             se.printStackTrace();
          }  
       }
    }
}