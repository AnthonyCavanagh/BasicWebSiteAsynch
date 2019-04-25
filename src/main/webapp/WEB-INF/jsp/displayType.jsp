<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
    <head>
    </head>
    <body>
        <h3>Display Type</h3>
        <form:form method="POST" action="${pageContext.request.contextPath}/displayViewType" modelAttribute="displayTypeView">
             <table>
                <tr>
                    <td><form:label path="typeId">Type Id</form:label></td>
                    <td><form:input path="typeId"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Submit"/></td>
                </tr>
            </table>
        </form:form>
    </body>
</html>