package org.lv326java.two.travelagency.controllers.admin;

import org.lv326java.two.travelagency.controllers.Security;
import org.lv326java.two.travelagency.controllers.constants.ActionConstants;
import org.lv326java.two.travelagency.controllers.constants.ControllerUrls;
import org.lv326java.two.travelagency.controllers.constants.ParametersEnum;
import org.lv326java.two.travelagency.controllers.constants.ViewUrls;
import org.lv326java.two.travelagency.dto.LoginDto;
import org.lv326java.two.travelagency.dto.UserDto;
import org.lv326java.two.travelagency.services.RoleService;
import org.lv326java.two.travelagency.services.ServiceDaoConteiner;
import org.lv326java.two.travelagency.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "AdminUserServlet")
public class AdminUserServlet extends HttpServlet {

    private UserService userService;
    private RoleService roleService;

    public AdminUserServlet() {
        ServiceDaoConteiner serviceDaoConteiner = ServiceDaoConteiner.get();
        userService = serviceDaoConteiner.getUserService();
        roleService = serviceDaoConteiner.getRoleService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (Security.isActiveSession(request, response)) {
            HttpSession session = request.getSession(false);
            LoginDto loginDto = (LoginDto) session.getAttribute(ParametersEnum.LOGIN_DTO.toString());
            if (Security.isAdmin(loginDto)) {
                String id = request.getParameter(ParametersEnum.USER_ID.toString());
                UserDto userDto;
                switch (request.getParameter(ParametersEnum.ACTION.toString())) {
                    case ActionConstants.EDIT_FORM:
                        userDto = userService.getUserDtoById(Long.parseLong(id));
                        request.setAttribute(ParametersEnum.CURRENT_USER.toString(), userDto);
                        request.setAttribute(ParametersEnum.ROLE_DTO_LIST.toString(), roleService.getAll());
//                        request.setAttribute(ParametersEnum.ACTION.toString(), ActionConstants.UPDATE);
                        request.getRequestDispatcher(ViewUrls.ADMIN_USER_UPDATE_JSP.toString())
                                .forward(request, response);
                        break;
                    case ActionConstants.UPDATE:
                        userDto = new UserDto(
                                request.getParameter(ParametersEnum.LOGIN.toString()),
                                //request.getParameter(ParametersEnum.PASSWORD.toString()),
                                null,
                                request.getParameter(ParametersEnum.FIRST_NAME.toString()),
                                request.getParameter(ParametersEnum.LAST_NAME.toString()),
                                request.getParameter(ParametersEnum.ROLE_ID.toString()));
                        userDto.setId(id);
                        userService.updateUser(userDto);
                        response.sendRedirect(request.getContextPath() + ControllerUrls.ADMINUSER_SERVLET);
                        break;
                    case ActionConstants.DELETE:
                        userService.deleteUseryById(Long.parseLong(id));
                        response.sendRedirect(request.getContextPath() + ControllerUrls.ADMINUSER_SERVLET);
                        break;
                }
            } else {
                request.getRequestDispatcher(ViewUrls.USER_CABINET_JSP.toString()).forward(request, response);
            }
        } else

        {
            getServletConfig()
                    .getServletContext()
                    .getRequestDispatcher(ControllerUrls.LOGOUT_SERVLET.toString())
                    .forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        if (Security.isActiveSession(request, response)) {
            HttpSession session = request.getSession(false);
            LoginDto loginDto = (LoginDto) session.getAttribute(ParametersEnum.LOGIN_DTO.toString());
            if (Security.isAdmin(loginDto)) {
                request.setAttribute(ParametersEnum.USER_DTO_LIST.toString(), userService.getAllUsers());
                request.getRequestDispatcher(ViewUrls.ADMIN_USERS_JSP.toString()).forward(request, response);
            } else {
                request.getRequestDispatcher(ViewUrls.USER_CABINET_JSP.toString()).forward(request, response);
            }
        } else {
            getServletConfig()
                    .getServletContext()
                    .getRequestDispatcher(ControllerUrls.LOGOUT_SERVLET.toString())
                    .forward(request, response);
        }
    }
}

