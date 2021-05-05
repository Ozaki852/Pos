import javax.swing.*;
import java.sql.*;

class CDM_dbma {
	String password = "861203";//mySQL�n�J�K�X
	Connection connection;
    Statement statement;
    
	CDM_dbma(){}
	
	public void DB_precedingOperation() {//��Ʈw�e�m�@�~
		try{
            Class.forName("com.mysql.jdbc.Driver");
		} 
		catch(Exception e){
			JOptionPane.showMessageDialog(null,"MySQL�X�ʵ{���w�˥���!"); 
		}
	}
	
	public void updateRD_in_TB_productInfo(int productCount,String productID){//��s�w�s���
        Connection connection;
        PreparedStatement statement;
        ResultSet result;
        String cmdData;
        
        DB_precedingOperation();

        try{  
              cmdData = "UPDATE productInfo SET productCount= ? WHERE productID= ?";
              connection = DriverManager.getConnection("jdbc:mysql://localhost/posdb?user=root&password="+password);
              statement = connection.prepareStatement(cmdData);
              statement.setInt(1,productCount);
              statement.setString(2,productID);
              statement.executeUpdate();
              JOptionPane.showMessageDialog(null,"�w�s��s���\!");
              statement.close();
        } 
        catch(SQLException e){
           JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!");
        }           
	}
	
	public void updateRD_in_TB_staffInfo_clockOFF(String clockOFF,String staffID){//��s���d���
        Connection connection;
        PreparedStatement statement;
        ResultSet result;
        String cmdData;
        
        DB_precedingOperation();

        try{  
              cmdData = "UPDATE staffInfo SET clockOFF= ? WHERE staffID= ?";
              connection = DriverManager.getConnection("jdbc:mysql://localhost/posdb?user=root&password="+password);
              statement = connection.prepareStatement(cmdData);
              statement.setString(1,clockOFF);
              statement.setString(2,staffID);
              statement.executeUpdate();
              statement.close();
        } 
        catch(SQLException e){
           JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!");
        }           
	}
	
	public void updateRD_in_TB_staffInfo_hours(int hours,String staffID){//��s���d���
        Connection connection;
        PreparedStatement statement;
        ResultSet result;
        String cmdData;
        
        DB_precedingOperation();

        try{  
              cmdData = "UPDATE staffInfo SET hours= ? WHERE staffID= ?";
              connection = DriverManager.getConnection("jdbc:mysql://localhost/posdb?user=root&password="+password);
              statement = connection.prepareStatement(cmdData);
              statement.setInt(1,hours);
              statement.setString(2,staffID);
              statement.executeUpdate();
              statement.close();
        } 
        catch(SQLException e){
           JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!");
        }           
	}
	
	public int get_rowSize_of_tradingRecord_by_date(String sDate,String eDate){//���o�Τ���d�ߪ����������Ƶ���
		Connection connection;
        PreparedStatement statement;
        ResultSet result;
        String cmdData;
        int size=0;
        
        DB_precedingOperation();
        
        try{
               cmdData = "SELECT * FROM tradingRecord WHERE date BETWEEN ? AND ?";
               connection = DriverManager.getConnection("jdbc:mysql://localhost/posdb?user=root&password="+password);
               statement = connection.prepareStatement(cmdData);
               statement.setString(1,sDate);
               statement.setString(2,eDate);
               result = statement.executeQuery();
               while( result.next() ){ 
               		size = result.getRow();
               }
               statement.close();
        } 
        catch(SQLException e){
                JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!");
        } 
        return(size);            
	}
	
	public int get_rowSize_of_tradingRecord_by_customerID(String customerID){//���o���U�Ƚs���d�ߪ����������Ƶ���
		Connection connection;
        PreparedStatement statement;
        ResultSet result;
        String cmdData;
        int size=0;
        
        DB_precedingOperation();
        
        try{
               cmdData = "SELECT * FROM tradingRecord WHERE customerID = ?";
               connection = DriverManager.getConnection("jdbc:mysql://localhost/posdb?user=root&password="+password);
               statement = connection.prepareStatement(cmdData);
               statement.setString(1,customerID);
               result = statement.executeQuery();
               while( result.next() ){ 
               		size = result.getRow();
               }
               statement.close();
        } 
        catch(SQLException e){
                JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!");
        } 
        return(size);            
	}
	
	public int get_rowSize_of_staffInfo_by_date(String sDate,String eDate){//�Τ�����o���u��Ƶ���
		Connection connection;
        PreparedStatement statement;
        ResultSet result;
        String cmdData;
        int size=0;
        
        DB_precedingOperation();
        
        try{
               cmdData = "SELECT * FROM staffInfo WHERE date BETWEEN ? AND ?";
               connection = DriverManager.getConnection("jdbc:mysql://localhost/posdb?user=root&password="+password);
               statement = connection.prepareStatement(cmdData);
               statement.setString(1,sDate);
               statement.setString(2,eDate);
               result = statement.executeQuery();
               while( result.next() ){ 
               		size = result.getRow();
               }
               statement.close();
        } 
        catch(SQLException e){
                JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!");
        } 
        return(size);            
	}
	
	public int get_rowSize_of_staffInfo_by_staffID(String staffID){//��¾���u�s�����o���u��Ƶ���
		Connection connection;
        PreparedStatement statement;
        ResultSet result;
        String cmdData;
        int size=0;
        
        DB_precedingOperation();
        
        try{
               cmdData = "SELECT * FROM staffInfo WHERE staffID = ?";
               connection = DriverManager.getConnection("jdbc:mysql://localhost/posdb?user=root&password="+password);
               statement = connection.prepareStatement(cmdData);
               statement.setString(1,staffID);
               result = statement.executeQuery();
               while( result.next() ){ 
               		size = result.getRow();
               }
               statement.close();
        } 
        catch(SQLException e){
                JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!");
        } 
        return(size);            
	}
	
	public int get_rowSize_of_deliveryInfo(String sDate,String eDate){//���o�v�t������Ƶ���
		Connection connection;
        PreparedStatement statement;
        ResultSet result;
        String cmdData;
        int size=0;
        
        DB_precedingOperation();
        
        try{
               cmdData = "SELECT * FROM deliveryInfo WHERE date BETWEEN ? AND ?";
               connection = DriverManager.getConnection("jdbc:mysql://localhost/posdb?user=root&password="+password);
               statement = connection.prepareStatement(cmdData);
               statement.setString(1,sDate);
               statement.setString(2,eDate);
               result = statement.executeQuery();
               while( result.next() ){ 
               		size = result.getRow();
               }
               statement.close();
        } 
        catch(SQLException e){
                JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!");
        } 
        return(size);            
	}
	
	public int get_rowSize_of_productInfo(String productType){//���o�ӫ~�w�s��Ƶ���
		Connection connection;
        PreparedStatement statement;
        ResultSet result;
        String cmdData;
        int size=0;
        
        DB_precedingOperation();
        
        try{
               cmdData = "SELECT * FROM productInfo WHERE productID LIKE ?";
               connection = DriverManager.getConnection("jdbc:mysql://localhost/posdb?user=root&password="+password);
               statement = connection.prepareStatement(cmdData);
               statement.setString(1,productType);
               result = statement.executeQuery();
               while( result.next() ){ 
               		size = result.getRow();
               }
               statement.close();
        } 
        catch(SQLException e){
                JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!");
        } 
        return(size);            
	}
	
	public String[][] findRD_in_TB_tradingRecord_by_date(String sDate,String eDate,int rowSize){//�Τ���j�M�������
         Connection connection;
         PreparedStatement statement;
         ResultSet result;
         String cmdData;

         String date="", time="", productID="", item="", discount="", customer="";
         int quantity=0, subtotal=0;
         String[][] searchResult = new String[rowSize][8];
 
         DB_precedingOperation();

         try{
                cmdData = "SELECT * FROM tradingRecord WHERE date BETWEEN ? AND ?";
                connection = DriverManager.getConnection("jdbc:mysql://localhost/posdb?user=root&password="+password);
                statement = connection.prepareStatement(cmdData);
                statement.setString(1,sDate);
                statement.setString(2,eDate);
                result = statement.executeQuery();
                int i=0;
                while( result.next() ){
                	date = result.getString("date");
                	time = result.getString("time");
                	productID = result.getString("productID");
                	item = result.getString("item");
                	quantity = result.getInt("quantity");
                	subtotal = result.getInt("subtotal");
                	discount = result.getString("discount");
                	customer = result.getString("customerID");
                	searchResult[i][0] = date;
                    searchResult[i][1] = time;
                    searchResult[i][2] = productID;
                    searchResult[i][3] = item;
                    searchResult[i][4] = String.valueOf(quantity);
                    searchResult[i][5] = String.valueOf(subtotal);
                    searchResult[i][6] = discount;
                    searchResult[i][7] = customer;
                    i++;
                }
                statement.close();
         } 
         catch(SQLException e){
                 JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!");
         } 
         return(searchResult);            
	}
	
	public String[][] findRD_in_TB_tradingRecord_by_customerID(String customerID,int rowSize){//���U�Ƚs���j�M�������
        Connection connection;
        PreparedStatement statement;
        ResultSet result;
        String cmdData;

        String date="", time="", productID="", item="", discount="", customer="";
        int quantity=0, subtotal=0;
        String[][] searchResult = new String[rowSize][8];

        DB_precedingOperation();

        try{
               cmdData = "SELECT * FROM tradingRecord WHERE customerID = ? ";
               connection = DriverManager.getConnection("jdbc:mysql://localhost/posdb?user=root&password="+password);
               statement = connection.prepareStatement(cmdData);
               statement.setString(1,customerID);
               result = statement.executeQuery();
               int i=0;
               while( result.next() ){
            	   date = result.getString("date");
               	   time = result.getString("time");
               	   productID = result.getString("productID");
               	   item = result.getString("item");
               	   quantity = result.getInt("quantity");
               	   subtotal = result.getInt("subtotal");
               	   discount = result.getString("discount");
               	   customer = result.getString("customerID");
               	   searchResult[i][0] = date;
               	   searchResult[i][1] = time;
               	   searchResult[i][2] = productID;
               	   searchResult[i][3] = item;
               	   searchResult[i][4] = String.valueOf(quantity);
               	   searchResult[i][5] = String.valueOf(subtotal);
               	   searchResult[i][6] = discount;
               	   searchResult[i][7] = customer;
               	   i++;
               }
               statement.close();
        } 
        catch(SQLException e){
                JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!");
        } 
        return(searchResult);            
	}
	
	public String[][] findRD_in_TB_staffInfo_by_date(String sDate,String eDate,int rowSize){//�Τ���j�M���u��T
        Connection connection;
        PreparedStatement statement;
        ResultSet result;
        String cmdData;

        String date="",staffID="",name="",position="",clockON="",clockOFF="";
        int hours=0;
        String[][] searchResult = new String[rowSize][7];

        DB_precedingOperation();

        try{
               cmdData = "SELECT * FROM staffInfo WHERE date BETWEEN ? AND ?";
               connection = DriverManager.getConnection("jdbc:mysql://localhost/posdb?user=root&password="+password);
               statement = connection.prepareStatement(cmdData);
               statement.setString(1,sDate);
               statement.setString(2,eDate);
               result = statement.executeQuery();
               int i=0;
               while( result.next() ){
               	   date = result.getString("date");
               	   staffID = result.getString("staffID");
               	   name = result.getString("staffName");
               	   position = result.getString("position");
               	   clockON = result.getString("clockON");
               	   clockOFF = result.getString("clockOFF");
               	   hours = result.getInt("hours");
               	   searchResult[i][0] = date;
                   searchResult[i][1] = staffID;
                   searchResult[i][2] = name;
                   searchResult[i][3] = position;
                   searchResult[i][4] = clockON;
                   searchResult[i][5] = clockOFF;
                   searchResult[i][6] = String.valueOf(hours);
                   i++;
               }
               statement.close();
        } 
        catch(SQLException e){
                JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!");
        } 
        return(searchResult);            
	}
	
	public String[][] findRD_in_TB_staffInfo_by_staffID(String staffID,int rowSize){//��¾���u���j�M���u��T
        Connection connection;
        PreparedStatement statement;
        ResultSet result;
        String cmdData;

        String date="",staff="",name="",position="",clockON="",clockOFF="";
        int hours=0;
        String[][] searchResult = new String[rowSize][7];

        DB_precedingOperation();

        try{
               cmdData = "SELECT * FROM staffInfo WHERE staffID = ?";
               connection = DriverManager.getConnection("jdbc:mysql://localhost/posdb?user=root&password="+password);
               statement = connection.prepareStatement(cmdData);
               statement.setString(1,staffID);
               result = statement.executeQuery();
               int i=0;
               while( result.next() ){
               	   date = result.getString("date");
               	   staff = result.getString("staffID");
               	   name = result.getString("staffName");
               	   position = result.getString("position");
               	   clockON = result.getString("clockON");
               	   clockOFF = result.getString("clockOFF");
               	   hours = result.getInt("hours");
               	   searchResult[i][0] = date;
                   searchResult[i][1] = staff;
                   searchResult[i][2] = name;
                   searchResult[i][3] = position;
                   searchResult[i][4] = clockON;
                   searchResult[i][5] = clockOFF;
                   searchResult[i][6] = String.valueOf(hours);
                   i++;
               }
               statement.close();
        } 
        catch(SQLException e){
                JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!");
        } 
        return(searchResult);            
	}
	
	public String[][] findRD_in_TB_deliveryInfo(String sDate,String eDate,int rowSize){//�j�M�v�t��T
        Connection connection;
        PreparedStatement statement;
        ResultSet result;
        String cmdData;

        String date="",customerID="",customerName="",contact="",address="";
        String[][] searchResult = new String[rowSize][5];

        DB_precedingOperation();

        try{
               cmdData = "SELECT * FROM deliveryInfo WHERE date BETWEEN ? AND ?";
               connection = DriverManager.getConnection("jdbc:mysql://localhost/posdb?user=root&password="+password);
               statement = connection.prepareStatement(cmdData);
               statement.setString(1,sDate);
               statement.setString(2,eDate);
               result = statement.executeQuery();
               int i=0;
               while( result.next() ){
               	   date = result.getString("date");
               	   customerID = result.getString("customerID");
               	   customerName = result.getString("customerName");
               	   contact = result.getString("contact");
               	   address = result.getString("address");
               	   searchResult[i][0] = date;
                   searchResult[i][1] = customerID;
                   searchResult[i][2] = customerName;
                   searchResult[i][3] = contact;
                   searchResult[i][4] = address;
                   i++;
               }
               statement.close();
        } 
        catch(SQLException e){
                JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!");
        } 
        return(searchResult);            
	}
	
	public String[][] findRD_in_TB_productInfo(String productType, int rowSize){//�j�M���~�w�s
        Connection connection;
        PreparedStatement statement;
        ResultSet result;
        String cmdData;

        String productID="",item="";
        int productCount = 0;
        String[][] searchResult = new String[rowSize][3];

        DB_precedingOperation();
        try{
               cmdData = "SELECT * FROM productInfo WHERE productID LIKE ?";
               connection = DriverManager.getConnection("jdbc:mysql://localhost/posdb?user=root&password="+password);
               statement = connection.prepareStatement(cmdData);
               statement.setString(1,productType);
               result = statement.executeQuery();
               int i=0;
               while( result.next() ){
            	   productID = result.getString("productID");
            	   item = result.getString("item");
            	   productCount = result.getInt("productCount");
               	   searchResult[i][0] = productID;
                   searchResult[i][1] = item;
                   searchResult[i][2] = String.valueOf(productCount);
                   i++;
               }
               statement.close();
        } 
        catch(SQLException e){
                JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!");
        } 
        return(searchResult);            
	}
	
    public void insertRD_into_TB_tradingRecord(String[] trading){//�ǤJ����������
    	Connection connection;
        PreparedStatement statement;
        String cmdData;

        DB_precedingOperation();

        try{//�s�W�@�����������ƨ��ƪ�  
        	cmdData = "INSERT INTO tradingRecord(date,time,productID,item,quantity,subtotal,discount,customerID)VALUES(?,?,?,?,?,?,?,?)";
        	connection = DriverManager.getConnection("jdbc:mysql://localhost/posdb?user=root&password="+password);
            statement = connection.prepareStatement(cmdData);
            statement.setString(1,trading[0]);
            statement.setString(2,trading[1]);
            statement.setString(3,trading[2]);
            statement.setString(4,trading[3]);
            statement.setInt(5,Integer.parseInt(trading[4]));
            statement.setInt(6,Integer.parseInt(trading[5]));
            statement.setString(7,trading[6]);
            statement.setString(8,trading[7]);
            statement.executeUpdate();
            statement.close();
        } 
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,"�g�J��������o�Ϳ��~!");
        }
    } 
    
    public void insertRD_into_TB_staffInfo(String[] staff){//�ǤJ���u���
    	Connection connection;
        PreparedStatement statement;
        String cmdData;

        DB_precedingOperation();

        try{//�s�W�@�����������ƨ��ƪ�  
        	cmdData = "INSERT INTO staffInfo(date,staffID,staffName,position,clockON,clockOFF,hours)VALUES(?,?,?,?,?,?,?)";
        	connection = DriverManager.getConnection("jdbc:mysql://localhost/posdb?user=root&password="+password);
            statement = connection.prepareStatement(cmdData);
            statement.setString(1,staff[0]);
            statement.setString(2,staff[1]);
            statement.setString(3,staff[2]);
            statement.setString(4,staff[3]);
            statement.setString(5,staff[4]);
            statement.setString(6,staff[5]);
            statement.setInt(7,Integer.parseInt(staff[6]));
            statement.executeUpdate();
            statement.close();
        } 
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,"�g�J���d��Ƶo�Ϳ��~!");
        }
    }
    
    public void insertRD_into_TB_deliveryInfo(String date,String customer,String[] delivery){//�ǤJ�v�t��T
    	Connection connection;
        PreparedStatement statement;
        String cmdData;

        DB_precedingOperation();

        try{//�s�W�@���v�t��T���ƪ�  
        	cmdData = "INSERT INTO deliveryInfo(date,customerID,customerName,contact,address)VALUES(?,?,?,?,?)";
        	connection = DriverManager.getConnection("jdbc:mysql://localhost/posdb?user=root&password="+password);
            statement = connection.prepareStatement(cmdData);
            statement.setString(1,date);
            statement.setString(2,customer);
            statement.setString(3,delivery[0]);
            statement.setString(4,delivery[1]);
            statement.setString(5,delivery[2]);
            statement.executeUpdate();
            statement.close();
        } 
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,"�g�J�v�t��T�o�Ϳ��~!");
        }
    }
	
    public void insertRD_into_TB_productInfo(String productID, String productName){//�ǤJ�ӫ~��T
    	Connection connection;
        PreparedStatement statement;
        String cmdData;

        DB_precedingOperation();

        try{//�s�W�ӫ~��ƪ�  
        	cmdData = "INSERT INTO productInfo(productID,item,productCount)VALUES(?,?,?)";
        	connection = DriverManager.getConnection("jdbc:mysql://localhost/posdb?user=root&password="+password);
            statement = connection.prepareStatement(cmdData);
            statement.setString(1,productID);
            statement.setString(2,productName);
            statement.setInt(3,10);//�w�]�s�f�q��10
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null,"���\�g�J�ӫ~��T!");
            statement.close();
        } 
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,"�g�J�ӫ~��T�o�Ϳ��~!");
        }
        
    }
    
    public void createTB_tradingRecord(){//�إߥ��������ƪ�
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost/posdb?user=root&password="+password);
            statement = connection.createStatement();
            String createTB = "CREATE TABLE tradingRecord("+
            				  "date             VARCHAR(15),"+            //���
            				  "time             VARCHAR(15),"+            //�ɶ�
                              "productID        VARCHAR(15),"+			  //�f��
							  "item           	VARCHAR(15),"+            //�~��
                              "quantity         INT,"+                    //�ƶq
							  "subtotal         INT,"+					  //�p�p
							  "discount         VARCHAR(15),"+            //�馩
                              "customerID       VARCHAR(15))";            //�U�Ƚs��
            statement.executeUpdate(createTB);
            JOptionPane.showMessageDialog(null,"���������ƪ�إߦ��\!");
            statement.close();
        } 
		catch(SQLException e){
			if(statement != null) 
               JOptionPane.showMessageDialog(null,"���������ƪ�w�s�b,���~��ާ@!");
			else
               JOptionPane.showMessageDialog(null,"MySQL�L�k�Ұ�!");
        } 
		catch(Exception e){
            JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!");
        }
    }
    
    public void createTB_staffInfo(){//�إ߭��u��Ƹ�ƪ�
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost/posdb?user=root&password="+password);
            statement = connection.createStatement();
            String createTB = "CREATE TABLE staffInfo("+
            				  "date             VARCHAR(15),"+            //���
            				  "staffID          VARCHAR(15),"+            //�u��
            				  "staffName        VARCHAR(15),"+            //�m�W
            				  "position         VARCHAR(15),"+            //¾��
                              "clockON          VARCHAR(15),"+			  //�W�Z
							  "clockOFF         VARCHAR(15),"+            //�U�Z
                              "hours            INT)";                    //�ɼ�
            statement.executeUpdate(createTB);
            JOptionPane.showMessageDialog(null,"���u��T��ƪ�إߦ��\!");
            statement.close();
        } 
		catch(SQLException e){
            if(statement != null) 
                  JOptionPane.showMessageDialog(null,"���u��T��ƪ�w�s�b,���~��ާ@!"); 
            else
                JOptionPane.showMessageDialog(null,"MySQL�L�k�Ұ�!");
        } 
		catch(Exception e){
            JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!");
        }
    }
    
    public void createTB_deliveryInfo(){//�إߦv�t��T��ƪ�
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost/posdb?user=root&password="+password);
            statement = connection.createStatement();
            String createTB = "CREATE TABLE deliveryInfo("+
            				  "date             VARCHAR(15),"+		       //������
            				  "customerID       VARCHAR(15) PRIMARY KEY,"+ //�U�Ƚs��
            				  "customerName     VARCHAR(15),"+             //�U�ȩm�W
            				  "contact          VARCHAR(15),"+             //�s���q��
            				  "address          VARCHAR(40))";             //�a�}
            statement.executeUpdate(createTB);
            JOptionPane.showMessageDialog(null,"�v�t��T��ƪ�إߦ��\!");
            statement.close();
        } 
		catch(SQLException e){
            if(statement != null) 
                  JOptionPane.showMessageDialog(null,"���u��T��ƪ�w�s�b,���~��ާ@!"); 
            else
                JOptionPane.showMessageDialog(null,"MySQL�L�k�Ұ�!");
        } 
		catch(Exception e){
            JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!");
        }
    }

    public void createTB_productInfo(){//�إ߮w�s��ƪ�
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost/posdb?user=root&password="+password);
            statement = connection.createStatement();
            String createTB = "CREATE TABLE productInfo("+
            				  "productID        VARCHAR(15) PRIMARY KEY,"+//�f��
            				  "item             VARCHAR(15),"+            //�ӫ~
            				  "productCount     INT)";			          //�ӫ~�w�s
            statement.executeUpdate(createTB);
            JOptionPane.showMessageDialog(null,"�w�s��ƪ�إߦ��\!");
            statement.close();
        } 
		catch(SQLException e){
            if(statement != null) 
                  JOptionPane.showMessageDialog(null,"�w�s��ƪ�w�s�b,���~��ާ@!"); 
            else
                JOptionPane.showMessageDialog(null,"MySQL�L�k�Ұ�!");
        } 
		catch(Exception e){
            JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!");
        }
    }
    
    public void createDB(){//�إ߸�Ʈwposdbdb
    	DB_precedingOperation();

        try{//�إ� posdb��Ʈw
            connection = DriverManager.getConnection("jdbc:mysql://localhost/?user=root&password="+password);
            statement = connection.createStatement();
            String createDB = "CREATE DATABASE posdb";
            
            statement.executeUpdate(createDB);
            JOptionPane.showMessageDialog(null,"�w��ϥέ��t�R���myPos2.0�I\nPOS�t�θ�Ʈw�إߦ��\!");
            statement.close();   
        } 
        catch(SQLException e){
            if(statement != null) 
                JOptionPane.showMessageDialog(null,"�w��ϥέ��t�R���myPos2.0�I\nPOS�t�θ�Ʈw�w�s�b,���~��ާ@!");
            else
                JOptionPane.showMessageDialog(null,"MySQL�L�k�Ұ�!");
        } 
        catch(Exception e){
             JOptionPane.showMessageDialog(null,"��Ʈw�ާ@�o�ͨ�L���~!");
        }
    } 
    //end for: public void createDB()
}