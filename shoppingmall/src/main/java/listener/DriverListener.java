package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class DriverListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce)  { 
    	System.out.println("db드라이버 로딩");
        //톰캣이 로딩하는 동안에 드라이버 로딩이 실행된다.
        try {
			Class.forName("org.mariadb.jdbc.Driver");//드라이버로딩
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
}
