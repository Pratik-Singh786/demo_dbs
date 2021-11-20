package com.example.demodbs.Service;

import com.example.demodbs.DbUtils.DbOperations;
import com.example.demodbs.Models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService  //DbManager get converted into UserService
{
    @Autowired
    DbOperations dbOperations;

    private static Logger logger= LoggerFactory.getLogger(UserService.class);
    @Autowired
    DbOperations con;

    public  void UserService() throws SQLException
    {
        logger.info("ok i am gonna create  user table now");
       //getConnection();

    }



    // deafult port of mysql=3306
    //postgress-5432
    //java database connectivity
    //username password amazon +vpn

   // @Autowired

  // DbOperations con;
     //constructor dependency injection
   /* public UserService(DbOperations operations,@Value("${test.my_prop}")String my_prop)
    {
        this.con=operations;
        logger.info("prop is {}",my_prop);
    }*/



    //Hibernate -create ,read ,update ,delete  //efficient
    public  void insertUser(User user)  throws SQLException   //doubtful inserstion needs to be checked once
    {
       String sql="insert into user(name,country,age) values (\"" + user.getName() + "\", \"" + user.getCountry() + "\", " + user.getAge() + ")";
       Statement st1=con.getConnection().createStatement();
       int rows_modified= st1.executeUpdate(sql);
       logger.info("no of users inserted :"+ rows_modified);


    }

  //  private jd
  //  private jd
    public List<User> getUsers() throws SQLException
    {
        String sql="select * from user";
        Statement st2=con.getConnection().createStatement();
         ResultSet result=st2.executeQuery(sql);
         List<User> user_list=new ArrayList<>();

         while(result.next())
         {                                                 // this is not a scalable thing suppose someone in future  deleted a column my whole code will be affected
             int id=result.getInt(1);
             String name=result.getString(2);
             String country=result.getString(3);
             int age=result.getInt(4);
             User user=new User(id,name,country,age);
             user_list.add(user);


         }
         return user_list;


    }

    public User getUser(int id) throws SQLException
    {
        String sql="select * from user where id=" + id;
        Statement st2=con.getConnection().createStatement();
        ResultSet result=st2.executeQuery(sql);

        while(result.next())
        {
            int id1=result.getInt(1);
            String name=result.getString(2);
            String country=result.getString(3);
            int age=result.getInt(4);

            User user=new User(id1,name,country,age);
            return user;


        }
        logger.info("Entered id user not found !!"+id);
        return null;
       // throw new Exception("No user found");

    }

    public void deleteUser(int id) throws SQLException
    {
        String sql="delete id from user where id="+id;
        Statement st2=con.getConnection().createStatement();
        ResultSet result=st2.executeQuery(sql);
        logger.info("the given id user has been deleted");


    }










}
