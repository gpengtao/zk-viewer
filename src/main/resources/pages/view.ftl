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
<h2>zookeeper viewer, address ${zkAddress}</h2>

<#if errMsg != "">
    <h4>
        <span style="color: red; ">Error</span>
    </h4>
    <p>${errMsg}</p>
<#else>
    <h4>path : ${view.path} </h4>

    <h4>data :</h4>

    <#if view.data != "">
        <script>
            try {
                document.write("<pre>" + JSON.stringify(${view.data}, null, "    ") + "</pre>");
            } catch (err) {
                document.write("<pre>" + '${view.data}' + "</pre>");
            }
        </script>
    </#if>

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

        <#list view.childrenPath ? keys as key>
            <tr>
                <td>#</td>
                <td>${key}</td>
                <td>
                    <a class="btn btn-primary" type="button" href="/zk-view/?path=${view.childrenPath[key]}">view</a>
                </td>
            </tr>
        </#list>
        </tbody>
    </table>
</#if>

</body>
<script src="http://code.jquery.com/jquery.js"/>
<script src="../../js/bootstrap.min.js"/>
</html>
