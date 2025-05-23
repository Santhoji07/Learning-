 import java.sql.*;  
    class connect
    {
    public static void main(String args[]) {
        try {
            //Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/MCA","root","password");
            System.out.println("Success");
            con.close();

        } catch(Exception e) {
            System.out.println(e);
        }
    }
}

/*
Installing mysql
*****************
sudo apt-get install mysql-server
sudo apt-get install mysql-client
sudo apt install libmariadb-java

mysql --version
sudo systemctl stop mysql.service - to stop mysql service
sudo systemctl status mysql.service - to check the status
sudo systemctl start mysql.service - start the mysql service

To alter root password
**********************
sudo mysql -u root - login without password
mysql>ALTER USER  'root'@'localhost' IDENTIFIED BY 'password'; - to alter the root password
mysql>quit;
sudo killall -u mysql - to kil all mysql services
sudo systemctl restart mysql.service - restart mysql service
sudo mysql -u root -p - set the password as password

or
sudo mysql -u root
mysql > SELECT User, Host FROM mysql.user;
mysql > DROP USER 'root'@'localhost';
mysql > CREATE USER 'root'@'localhost' IDENTIFIED BY 'password';
mysql > GRANT ALL PRIVILEGES ON *.* TO 'root'@'localhost' WITH GRANT OPTION;
mysql > FLUSH PRIVILEGES;
Exit mysql (either by inserting CTRL+D or quit in the MySQL command prompt) and try to reconnect with the following command:
> mysql -u root -p
Enter password: password

***************************

Create database : mysql> create database MCA;
mysql> use MCA;
Database changed
mysql> show tables;
Empty set (0.00 sec)

****************************


Steps in terminal
admin-mca@mcalab1:~/Desktop$ javac connect.java
admin-mca@mcalab1:~/Desktop$ export CLASSPATH=$CLASSPATH:/home/admin-mca/Desktop/mysql-connector-java-8.0.30.jar (by keeping mysql-connector-java-8.0.30.jar in desktop)
admin-mca@mcalab1:~/Desktop$ java connect
Success
*/
