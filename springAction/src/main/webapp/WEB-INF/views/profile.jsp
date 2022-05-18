<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
  <head>
    <title>Spitter</title>
    <link rel="stylesheet" 
          type="text/css" 
          href="<c:url value="/resources/style.css" />" >
  </head>
  <body>
    <div class="spittleView">
      <div class="spittleMessage"><c:out value="${spitter.username}" /></div>
      <div>
        <span class="spittleTime"><c:out value="${spitter.firstName}" /></span>
        <span class="spittleTime"><c:out value="${spitter.lastName}" /></span>
      </div>
    </div>
  </body>
</html>