package mainlibrary;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BookDao {
public static int saveBook(String callno,String name,String author,String publisher,String genre,String row,String shelf,int quantity){
	int status=0;
        DB DB=new DB();
	try{
		Connection con=DB.getConnection();
		PreparedStatement ps=con.prepareStatement("insert into Books(callno,BookName,author,publisher,genre,row,shelf,quantity) values(?,?,?,?,?,?,?,?)");
		ps.setString(1,callno);
		ps.setString(2,name);
		ps.setString(3,author);
		ps.setString(4,publisher);
                ps.setString(5,genre);
                ps.setString(6,row);
                ps.setString(7,shelf);
		ps.setInt(7,quantity);
		status=ps.executeUpdate();
		con.close();
	}catch(Exception e){System.out.println(e);}
	return status;
}

    /**
     *
     * @param Publisher
     * @return
     */
    public static boolean PublisherValidate( String Publisher)
{
    boolean status = false;
    DB DB=new DB();
    try(Connection con = DB.getConnection()) {
        PreparedStatement ps = con.prepareStatement("select * from Publisher where PublisherName = ?"); 
        ps.setString(1, Publisher);
        ResultSet rs=ps.executeQuery();
        status=rs.next();
        con.close();
    }catch(Exception e){System.out.println(e);}
    return status;
}
    
    public static int AddPublisher( String Publisher)
    {
        int status= 0;
        DB DB=new DB();
        try(Connection con = DB.getConnection()) {
		PreparedStatement ps=con.prepareStatement("insert into Publisher(PublisherName) values(?)");
		ps.setString(1,Publisher);
		status=ps.executeUpdate();
                con.close();
	}catch(Exception e){System.out.println(e);}
	return status;
        
    }

  
     public static int SaveBook(String BookN,String GenreN, String AuthorN, String PublisherN, String ShelfN, String RowN) {
           int status =0;
         try{
             DB DB = new DB();
            Connection con =DB.getConnection();
            PreparedStatement ps= con.prepareStatement("insert into `library`.`Books` ( `BookName` , `Genre`, `Author`, `Publisher`, `Shelf`, `Row`) values(?,?,?,?,?,?)");
            ps.setString(1,BookN);
            ps.setString(2,GenreN);
            ps.setString(3,AuthorN);
            ps.setString(4,PublisherN);
            ps.setString(6,RowN);
            ps.setString(5,ShelfN);
            //ps.setString(7,QN);
            status =ps.executeUpdate();
            con.close();
        }catch(Exception e){System.out.println(e);}
    return status;     }
   
    public static int Delete(int BookID)
    {
          int status= 0;
          DB DB=new DB();
        try(Connection con = DB.getConnection()) {
		PreparedStatement ps=con.prepareStatement("DELETE FROM Books where BookID=?");
		ps.setInt(1,BookID);
		status=ps.executeUpdate();
                con.close();
	}catch(Exception e){System.out.println(e);}
	return status;
        
    }
            
    
 

}
