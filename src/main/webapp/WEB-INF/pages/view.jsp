<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>zk-viewer</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
    <link href="../../css/bootstrap.min.css" rel="stylesheet" media="screen">
</head>
<body>
<h1>zookeeper viewer, address ${zkAddress}</h1>

<c:if test="${errMsg != null}">
    <h3>
        <span style="color: red; ">Error</span>
    </h3>
    <p>${errMsg}</p>
</c:if>

<c:if test="${errMsg == null}">
    <h2>path : ${view.path} </h2>

    <h2>data : ${view.data}</h2>

    <a class="btn btn-block btn-info" type="button" href="/zk-view/?path=${view.parentPath}">up</a>

    <table class="table table-striped">
        <thead>
        <tr>
            <th>#</th>
            <th>child</th>
            <th>operator</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${view.childrenPath}" var="entry" varStatus="status">
            <tr>
                <td>${status.count}</td>
                <td>${entry.key}</td>
                <td>
                    <a class="btn btn-primary" type="button" href="/zk-view/?path=${entry.value}">view</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>

</body>
<script src="http://code.jquery.com/jquery.js"/>
<script src="../../js/bootstrap.min.js"/>
</html>
