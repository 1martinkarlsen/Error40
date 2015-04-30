/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.AdminDashboardLine;
import Model.AuthentificationStub;
import Interfaces.DataMapperIF;
import Model.DataMapperStub;
import Model.SellerDashboardLine;
import java.util.Map;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rasmus
 */
public class ControlTestFailsafe {
    
    @Test
    public void testGetSellerDashboardLines() throws Exception {
        DataMapperStub mapper = new DataMapperStub();
        AuthentificationStub au = new AuthentificationStub();
        Control control = new Control(mapper, au);
        
        Map<Integer, SellerDashboardLine> lines = control.getSellerDashboardLines();
        
        //assertThat(mapper.getAllSellerDashboardLines(), is(1));
        //assertThat(mapper.getAllSellerDashboardLinesCount, is(1));
        
        assertThat(lines.size(), is(1));
        assertThat(lines.get(1448).getBudget_used(), is(500));
    }
}