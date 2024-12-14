/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Saber
 */
public class chef  extends cook{
    
    
    @Override
    public String Earning() {
        double salary;
        double HoursOfWork=Double.parseDouble(chefPanel.HoursOfWorkField.getText());
        double hourlyWage=Double.parseDouble(chefPanel.hourlyWageField.getText());
        if(HoursOfWork<40){
            salary=HoursOfWork*hourlyWage;
        }
        else{
            salary=(((HoursOfWork-40)*1.5)+40)*hourlyWage;
        }
          
    return String.valueOf(salary);
    }
}
