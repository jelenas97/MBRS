<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<body>
	<%@include file="navbar.jsp"%>
    <div class="container">
        <div class="row">
            <div class="col-md-3"></div>
            <div class="col-md-6 border p-4">
                <h5 class="text-center">${class.name?cap_first} form</h5>
            </div>
            <div class="col-md-3"></div>
          </div>
     </div>
</body>
</html>