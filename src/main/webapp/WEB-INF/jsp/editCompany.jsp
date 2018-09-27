<!DOCTYPE html>
<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/resources/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/bootstrap.min.css">
    <script src="/resources/js/bootstrap.min.js"></script>
</head>
<body>
    <h1>Company</h1>
    <form class="form-horizontal" method="POST" modelAttribute="company">
    <table class = "table table-bordered">
        <tr>
            <td><label for="InputName">Name</label></td>
            <td><input type="text" class="form-control" id="InputName" placeholder="Name" name="name" value = "${company.name}" /></td>
        </tr>
        <tr>
            <td><label for="InputAddress">Address</label></td>
            <td><input type="text" class="form-control" id="InputAddress" placeholder="Address" name="address" value = "${company.address}" /></td>
        </tr>
        <tr>
            <td><label for="InputPhoneNumber">Phone number</label></td>
            <td><input type="text" class="form-control" id="InputPhoneNumber" placeholder="Phone number" name="phoneNumber" value = "${company.phoneNumber}" /></td>
        </tr>
        <tr>
            <td><label for="InputWorkPlace">Work Place</label></td>
            <td></td>
            <c:forEach var="workPlace" items="${company.workPlaceSet}">
            <tr>
                <td></td>
                <td>
                    <a href="<c:url value='/addressBook/deleteCompanyWorkPlace/${workPlace.id}' />" class="btn btn-danger custom-width">delete</a>
                    <label for="InputEmployeeFirstName">${workPlace.employee.firstName}</label>
                    <label for="InputEmployeeLastName">${workPlace.employee.lastName}</label>
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
