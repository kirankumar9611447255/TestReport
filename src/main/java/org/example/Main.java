package org.example;

import org.report.ReportFacade.ReportFacade;
import org.report.ReportFacade.ReportFacadeImpl;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("======================================");
        String input = "2343225,2345,us_east,RedTeam,ProjectApple,3445s \n" +
                "1223456,2345,us_west,BlueTeam,ProjectBanana,2211s \n" +
                "3244332,2346,eu_west,YellowTeam3,ProjectCarrot,4322s \n" +
                "1233456,2345,us_west,BlueTeam,ProjectDate,2221s \n" +
                "3244132,2346,eu_west,YellowTeam3,ProjectEgg,4122s ";

        ReportFacade facade= new ReportFacadeImpl();
        facade.generateReports(input);
        System.out.println("======================================");
    }
}