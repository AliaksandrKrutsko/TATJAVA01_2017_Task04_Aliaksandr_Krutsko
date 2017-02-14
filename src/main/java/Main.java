import bean.News;
import controller.command.AddNews;
import dao.DaoException;
import dao.SQLNewsDao;
import service.NewsService;
import service.ServiceException;
import service.ServiceFactory;
import view.View;
import view.ViewImpl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] argv) throws ServiceException, DaoException {

        View view = new ViewImpl();
        view.enterCommand();

    }

}
