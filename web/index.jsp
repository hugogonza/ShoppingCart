<%-- 
    Document   : index
    Created on : Nov 5, 2013, 6:58:42 PM
    Author     : HugoCésar
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping cart Page</title>
    </head>
    <body>
        <h1>Shopping cart</h1>
        
        <a href="controller?action=list">Display the contents</a>
        <br/>
        
        <form action="controller" method="POST">
            <input type="hidden" name="action" value="add"/>
            Merchandise: <input type="text" name="merchandise"/>
            <br/>
            <input type="submit" value="add"/>
        </form>
        
        <form action="controller" method="POST">
            <input type="hidden" name="action" value="delete"/>
            Merchandise: <input type="text" name="merchandise"/>
            <br/>
            <input type="submit" value="delete"/>
        </form>
        
                    <h1>Cart</h1>
            <ul>
                <c:forEach items="${contents}" var="c">
                    
                <li>${c}</li>    
                </c:forEach>
                
            </ul>
    </body>
</html>
