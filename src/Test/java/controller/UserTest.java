package controller;

import matc.controller.AddUser;
import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserTest {

    @Mock
    HttpServletRequest request;

    @Mock
    HttpServletResponse response;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    public void testServlet() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        when(request.getParameter("username")).thenReturn("la");
        when(request.getParameter("password")).thenReturn("password");
        when(request.getParameter("confirmPassword")).thenReturn("password");
        when(request.getParameter("firstName")).thenReturn("La");
        when(request.getParameter("lastName")).thenReturn("La");
        when(request.getParameter("email")).thenReturn("me@me.com");
        when(request.getParameter("dateOfBirth")).thenReturn("2018-09-09");

        AddUser addUser = new AddUser();
        addUser.doPost(request, response);

    }
}