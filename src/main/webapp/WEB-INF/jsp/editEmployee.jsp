<!DOCTYPE html>
<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/resources/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/bootstrap.min.css">
</head>
<body>
    <h1>Employee</h1>
    <form class="form-horizontal" method="POST" modelAttribute="employee">
    <table class = "table table-bordered">
        <tr>
            <td><label for="InputFirstName">First Name</label></td>
            <td><input type="text" class="form-control" id="InputName" placeholder="First name" name="firstName" value = "${employee.firstName}" /></td>
        </tr>
        <tr>
            <td><label for="InputLastName">Last Name</label></td>
             <td><input type="text" class="form-control" id="InputLastName" placeholder="Last name" name="lastName" value = "${employee.lastName}" /></td>
        </tr>
        <tr>
            <td><label for="InputAddress">Address</label></td>
            <td><input type="text" class="form-control" id="InputAddress" placeholder="Address" name="address" value = "${employee.address}" /></td>
        </tr>
        <tr>
            <td><label for="InputPhoneNumber">Phone number</label></td>
            <td><input type="text" class="form-control" id="InputPhoneNumber" placeholder="Phone number" name="phoneNumber" value = "${employee.phoneNumber}" /></td>
        </tr>
        <tr>
            <td><label for="InputWorkPlace">Work Place</label></td>
            <td></td>
            <c:forEach var="workPlace" items="${employee.workPlaceSet}">
            <tr>
                <td></td>
                <td>
                    <a href="<c:url value='/addressBook/deleteEmployeeWorkPlace/${workPlace.id}' />" class="btn btn-danger custom-width">delete</a>
                    <label for="InputCompany">${workPlace.company.name}</label>
                    <label for="InputPosition">${workPlace.position}</label>

                </td>
            </tr>
            </c:forEach>
        </tr>

    </table>
    <div class="form-group">
        <div class="col-md-12 text-center">
            <button type="submit" class="btn btn-primary btn-lg">Save</button>
        </div>
    </div>
</form>
</body>
</html>
