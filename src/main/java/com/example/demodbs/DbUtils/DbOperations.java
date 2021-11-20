package com.example.demodbs.DbUtils;

import com.example.demodbs.Service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
@Component
public class DbOperations
{

    private static  Connection con;
    private static Logger logger = LoggerFactory.getLogger(UserService.class);
    // deafult port of mysql=3306
    //postgress-5432
    //java database connectivity
    //username password amazon +vpn


   public Connection getConnection() throws SQLException
   {
        if (con == null) {
            logger.info("i am getting the connection from driver Manager");
            //Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/users","root","");
        }
        createTable();
        return con;

    }

    public void createTable() throws SQLException {
        String sql = "create table if not exists user(id INT primary key auto_increment,name  VARCHAR(30),country VARCHAR(30), age INT)";
        Statement st = con.createStatement();
        boolean result = st.execute(sql); //return true if the result is ResultSet data;
        logger.info("Reslt of the query is:" + result);

        //  st.executeQuery(); used most times when we have to retrieve the data like with select statement;

        //   st.executeUpdate();  number of rows which are being affected.


    }
}
