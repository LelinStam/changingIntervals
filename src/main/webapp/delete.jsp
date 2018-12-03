
<%@page import="matc.persistence.Dao,matc.entity.User"%>
<jsp:useBean id="user" class="matc.entity.User"></jsp:useBean>
<jsp:setProperty property="*" name="user"/>
<%
	Dao userDao = new Dao(User.class);
	userDao.delete(user);
	response.sendRedirect("user.jsp");
%>