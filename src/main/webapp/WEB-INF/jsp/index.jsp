<!DOCTYPE html>
<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="../resources/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="../resources/css/bootstrap.min.css">
</head>
<body>
<h1>Address BOOK</h1>
    <form>
    <a href="<c:url value='/addressBook/editEmployee/0' />" class="btn btn-success custom-width">New Emlpoyee</a>
    <a href="<c:url value='/addressBook/editCompany/0' />" class="btn btn-success custom-width">New Company</a>
    <table class = "table table-striped">
        <tr>
            <td>#</td>
            <td>First name</td>
            <td>Last name</td>
            <td>Address</td>
            <td>Phone number</td>
            <td></td>
         </tr>

         <c:forEach var="Employee" items="${employeeList}">
           <tr>
             <td>${Employee.id}</td>
             <td>${Employee.firstName}</td>
             <td>${Employee.lastName}</td>
             <td>${Employee.address}</td>
             <td>${Employee.phoneNumber}</td>
             <td>
                <a href="<c:url value='/addressBook/editEmployee/${Employee.id}' />" class="btn btn-success custom-width">edit</a>
                <a href="<c:url value='/addressBook/deleteEmployee/${Employee.id}' />" class="btn btn-danger custom-width">delete</a>
             </td>
           </tr>
          </c:forEach>
          <c:forEach var="Company" items="${companyList}">
            <tr>
                <td>${Company.id}</td>
                <td>${Company.name}</td>
                <td></td>
                <td>${Company.address}</td>
                <td>${Company.phoneNumber}</td>
                <td>
                    <a href="<c:url value='/addressBook/editCompany/${Company.id}' />" class="btn btn-success custom-width">edit</a>
                    <a href="<c:url value='/addressBook/deleteCompany/${Company.id}' />" class="btn btn-danger custom-width">delete</a>
                </td>
            </tr>
          </c:forEach>
    </table>
    </form>
</body>
</html>
