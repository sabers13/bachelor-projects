/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Saber
 */
public class assistant extends cook{

    double salary;
        double totalSale=Double.parseDouble(assistantPanel.totalSaleField.getText());
        double wage=Double.parseDouble(assistantPanel.wageField.getText());
    
    @Override
    public String Earning() {
        salary=wage+(0.03*totalSale);
        return String.valueOf(salary);
    }
    
}
