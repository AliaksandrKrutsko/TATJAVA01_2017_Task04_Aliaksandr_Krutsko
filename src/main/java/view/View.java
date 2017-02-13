package view;


import dao.DaoException;
import service.ServiceException;

public interface View {

    void enterCommand() throws DaoException, ServiceException;



}
