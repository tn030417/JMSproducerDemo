<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<title>Hello</title>
</head>
<body>

	<h1>Producer home page</h1>
	
	<form:form method="GET" action="addProducer" >
		<input type="submit"  value="Add producer"  >
	</form:form>
	
	<form:form method="GET" action="stopAllProducers" >
		<input type="submit"  value="Stop All Producers"  >
	</form:form>

</body>
</html>