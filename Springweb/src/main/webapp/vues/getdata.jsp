<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.projet.autocomplete.SearchDB"%>


<%
    SearchDB db = new SearchDB();

    String query = request.getParameter("term");


    List<String> countries = db.getData(query);
    
    Iterator<String> iterator = countries.iterator();
    
    while(iterator.hasNext()) {
       String country = (String)iterator.next();
       out.println(country + ',');
    }
    

    
%>