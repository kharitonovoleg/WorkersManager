<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>

<html>
<head>
    <title>Workers Page</title>

    <style type="text/css">
        .tg {
            border-collapse: collapse;
            border-spacing: 0;
            border-color: #ccc;
        }

        .tg td {
            font-family: Arial, sans-serif;
            font-size: 14px;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #fff;
        }

        .tg th {
            font-family: Arial, sans-serif;
            font-size: 14px;
            font-weight: normal;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #f0f0f0;
        }

        .tg .tg-4eph {
            background-color: #f9f9f9
        }
    </style>
</head>

<body>

<a href="../../index.jsp">Back to main menu</a>

<br/>
<br/>

<h1>Workers List</h1>

<input type="search" name="search" placeholder="Search"/>
<input type="submit" value="Search">
<br/>
<br/>

<c:if test="${!empty listWorkers}">
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="120">First Name</th>
            <th width="120">Second Name</th>
            <th width="120">Phone</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listWorkers}" var="workers">
            <tr>
                <td>${workers.id}</td>
                <td><a href="<c:url value='/workersdata/${workers.id}' />" target="_blank">${workers.firstName}</a></td>
                <td>${workers.secondName}</td>
                <td>${workers.phone}</td>
                <td><a href="<c:url value='/update/${workers.id}' />">Edit</a></td>
                <td><a href="<c:url value='/remove/${workers.id}' />">Delete</a></td>

            </tr>
        </c:forEach>
    </table>
</c:if>

<h1>Add worker</h1>

<c:url var="addAction" value="/workers/add"/>

<form:form action="${addAction}" commandName="workers">
    <table>
        <c:if test="${!empty workers.firstName}">
            <tr>
                <td>
                    <form:label path="id">
                        <spring:message text="id"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="id" readonly="true" size="8" disabled="true"/>
                    <form:hidden path="id"/>
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="firstName">
                    <spring:message text="First Name"/>
                </form:label>
            </td>
            <td>
                <form:input path="firstName"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="secondName">
                    <spring:message text="Second Name"/>
                </form:label>
            </td>
            <td>
                <form:input path="secondName"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="phone">
                    <spring:message text="Phone"/>
                </form:label>
            </td>
            <td>
                <form:input path="phone"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${!empty workers.firstName}">
                    <input type="submit"
                           value="<spring:message text="Edit worker"/>"/>
                </c:if>
                <c:if test="${empty workers.firstName}">
                    <input type="submit"
                           value="<spring:message text="Add worker"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>