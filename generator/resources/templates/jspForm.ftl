<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
  <head>
    <style>
      table,
      th,
      td {
        border: 1px solid black;
      }
    </style>
  </head>
  <body>
    <%@include file="navbar.jsp"%>
    <div class="container">
      <div class="row">
        <div class="col-md-3"></div>
        <div class="col-md-6 border p-4">
          <h5 class="text-center">${class.name?cap_first} form</h5>
        </div>
        <h6>The table element</h6>

        <table>
          <tr>
            <th>Month</th>
            <th>Savings</th>
          </tr>
          <tr>
            <td>January</td>
            <td>$100</td>
          </tr>
          <tr>
            <td>February</td>
            <td>$80</td>
          </tr>
        </table>
        <div class="col-md-3"></div>
      </div>
    </div>
  </body>
</html>
