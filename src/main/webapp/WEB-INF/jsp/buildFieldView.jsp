<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
    <head>
    </head>
    <body>   
        <h3>The Field Details</h3>
        <form:form method="POST" action="/createField" modelAttribute="fieldView">
		<table>
		    <tr>
				<td><form:label path="typeId">Type Id</form:label></td>
				<td><form:input path="typeId" /></td>
			</tr>
		   <tr>
				<td><form:label path="id">Id</form:label></td>
				<td><form:input path="id" /></td>
			</tr>
			<tr>
				<td><form:label path="name">Name</form:label></td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td><form:label path="primitive">Primitive</form:label></td>
				<td><form:input path="primitive" /></td>
			</tr>
			<tr>
				<td><form:label path="options">Option</form:label></td>
				<td><form:input path="options" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form:form>
    </body>
</html>