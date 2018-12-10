
<%@page import="matc.persistence.Dao,matc.entity.Workout"%>
<jsp:useBean id="workout" class="matc.entity.Workout"></jsp:useBean>
<jsp:setProperty property="*" name="workout"/>
<%
	Dao workoutDao = new Dao(Workout.class);
	workoutDao.delete(workout);
	response.sendRedirect("my-workouts.jsp");
%>