public class RMIClient {

   public static void main(String[] args) {
      try {
         // Register RmiJdbc Driver in jdbc DriverManager
         // On some platforms with some java VMs, newInstance() is necessary...
         Class.forName("org.objectweb.rmijdbc.Driver").newInstance();

         // our JDBC url that will be used at the server machine.
		 // The property 'singletonConnection = true' is recommended.
         String url = "jdbc:jstels:dbf:dbffiles?singletonConnection=true";

         // in this example an RMI host will point to local host
         String rmiHost = "//" + java.net.InetAddress.getLocalHost().getHostName();

         // RmiJdbc URL is of the form:
         // jdbc:rmi://<rmiHostName[:port]>/<jdbc-url>
         java.sql.Connection c = java.sql.DriverManager.getConnection("jdbc:rmi:" + rmiHost + "/" + url);

         // these Connection, Statement and ResultSet objects are remote!
         // All is occurring at the server side!
         java.sql.Statement st = c.createStatement();
         java.sql.ResultSet rs = st.executeQuery("SELECT  prod.descr AS \"Product\", regs.regionname AS \"Region\", " +
		"minprice, stdprice, FORMATDATETIME(startdate, \'dd " +
		"MMMMM yyyy\' ) AS \"Start Date\", FORMATDATETIME(enddate, \'dd MMMMM yyyy\') " +
		"AS \"End Date\" FROM \"prices.dbf\" ps JOIN \"regions.dbf\" regs ON " +
		"ps.regionid = regs.id JOIN \"products.dbf\" prod ON prod.prodid = ps.prodid " +
		"\nORDER BY \"Product\"");

         java.sql.ResultSetMetaData md = rs.getMetaData();
         while (rs.next()) {
            System.out.print("\n");
            for (int i = 1; i <= md.getColumnCount(); i++) {
               System.out.print(rs.getString(i) + "\t");
            }
         }

        rs.close();
        st.close();
        c.close();
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}
