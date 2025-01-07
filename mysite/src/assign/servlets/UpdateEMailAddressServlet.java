package assign.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import assign.dbaccess.EMailAddressVOO;
import assign.dbaccess.EMailBO;
import assign.dbaccess.EMailValidationException;

public class UpdateEMailAddressServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String errors = "";
		//Step1: capture input and populate the VO
		EMailAddressVOO eMailAddressVO = new EMailAddressVOO();
		// Get registration details and set to the EMailAddress
		//Step:1
		HttpSession session = request.getSession();
		//eMailAddressVO.seteMailID(request.getParameter("emailid"));
		eMailAddressVO.seteMailID((String) session.getAttribute("emailid"));
		eMailAddressVO.setwPhone(request.getParameter("wphone"));
		eMailAddressVO.setmPhone(request.getParameter("mphone"));

		// Step2: Do processing or Business logic
		 EMailBO eMailBO = new EMailBO();
		
		 try{
		 	eMailBO.updatePhoneEMailAddress(eMailAddressVO);
		 }catch (EMailValidationException emve){
			 errors = emve.getErrorMessage();
		 }
		 catch (Exception e){
		 e.printStackTrace();
		 }
		 
		//step3: Response Back
		if (errors.equals("")) {
			response.sendRedirect("/mysite/home.jsp");
		} else {
			request.getSession().setAttribute("Errors", errors);
			response.sendRedirect("/mysite/displayrecordupdate.jsp");
		}
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException {
doGet(request, response);
}

}
