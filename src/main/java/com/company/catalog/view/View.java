package com.company.catalog.view;


import com.company.catalog.dao.DaoException;
import com.company.catalog.service.ServiceException;

public interface View {

    void enterCommand() throws DaoException, ServiceException;



}
