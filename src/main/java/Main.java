import com.company.catalog.dao.DaoException;
import com.company.catalog.service.ServiceException;
import com.company.catalog.view.View;
import com.company.catalog.view.ViewImpl;


public class Main {

    public static void main(String[] argv) throws ServiceException, DaoException {

        View view = new ViewImpl();
        view.enterCommand();

    }

}
