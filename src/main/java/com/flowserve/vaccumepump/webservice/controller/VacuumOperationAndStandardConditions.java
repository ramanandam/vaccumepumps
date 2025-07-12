package com.flowserve.vaccumepump.webservice.controller;



import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.flowserve.vaccumepump.webservice.dto.GasHeater;
import com.flowserve.vaccumepump.webservice.dto.IVacuumPumpDetails;
import com.flowserve.vaccumepump.webservice.dto.IVacuumSelectionInputs;
import com.flowserve.vaccumepump.webservice.model.ErrorCodeTable;
import com.flowserve.vaccumepump.webservice.util.FormUtil;

import jakarta.servlet.http.HttpServletRequest;

// Gas lamp - only for vacuum operation and standard conditions, i.e. air (20°C) / water (15°C or 30°C)

@RestController
public class VacuumOperationAndStandardConditions {
	
	
	
	/*/
	 * 
	 * Sub Button_Gasstrahler_Betriebspunkt()

Dim Fehler As Fehlercodetyp
Dim G_ID, M_ID, n, p_1, V_1_Gas, V_Treibstrom

If stc_Ergebnis <> 0 Or stc_Berechnungsart <> 7 Then
    stc_Ergebnis = 0
    stc_Berechnungsart = 7
    Call stc_neu_markieren
    Exit Sub
End If

If ComboBox_Gasstrahler.ListIndex < 0 Then Exit Sub

G_ID = ComboBox_Gasstrahler.List(ComboBox_Gasstrahler.ListIndex, 0)
M_ID = ComboBox_Gasstrahler.List(ComboBox_Gasstrahler.ListIndex, 1)
n = ComboBox_Gasstrahler.List(ComboBox_Gasstrahler.ListIndex, 2)
p_1 = Application.Names("Formular_Gasstrahler_p_1").RefersToRange

Call Gasstrahler_Betriebspunkt(Fehler, G_ID, M_ID, p_1, V_1_Gas, V_Treibstrom)

Call Fehlertext_anzeigen(Fehler)
If Fehlerart_kritisch(Fehler) = 1 Or Fehlerart_kritisch(Fehler) = 2 Then
    stc_Ergebnis = -1
Else
    stc_Ergebnis = 1
End If

stc_Makro_Berechnung = True

Application.Names("Formular_Gasstrahler_V_1").RefersToRange = V_1_Gas
Application.Names("Formular_Gasstrahler_V_Treibstrom").RefersToRange = V_Treibstrom

stc_Makro_Berechnung = False
Call stc_neu_markieren

End Sub
	 * 
	 */
	
	
	@RequestMapping(value = "/vaccumepumps/rest/GasRadiatorOperatingPointButton/click", method = RequestMethod.GET)
	public ResponseEntity<IVacuumPumpDetails> gasRadiatorOperatingPointButton(@RequestBody IVacuumSelectionInputs input) throws SQLException {
		
		IVacuumPumpDetails response = new IVacuumPumpDetails();
		int stc_result=input.getStc_result();
		int stcCalculationType=input.getStcCalculationType();
		
		// Check calculation state
		if (stc_result != 0 || stcCalculationType != 7) {
	        
	        response.setStc_result(0);

	        response.setStcCalculationType(7);
	        FormUtil.stc_new_mark();
	        return ResponseEntity.ok().body(response);
	    }
		
		if(input.getGasHeaterList().size()==0)
		{
			// Ensure a selection was made
			return ResponseEntity.ok().body(response);
		}
		
		GasHeater gasHeater=input.getGasHeaterList().get(0);
		
		// ===== Core Logic Equivalent to Gasstrahler_Betriebspunkt Call =====
	    // Below is placeholder logic. Replace this with actual computation logic.
	    // Simulating a function that sets V_1_Gas and V_Treibstrom based on inputs
		
		double p_1=input.getP_1();
		//Public Sub Gasstrahler_Betriebspunkt(Fehler As Fehlercodetyp, Gasstrahler_ID, Maschinen_ID, p_1, V_1_Gas, V_Treibstrom)
		ErrorCodeTable error=new ErrorCodeTable();
		double V_1_Gas=0;
		double V_Treibstrom=0;
		FormUtil.gasJetOperatingPoint(error,gasHeater.getG_ID(),gasHeater.getM_ID(),p_1,V_1_Gas,V_Treibstrom);
        

		FormUtil.show_error_text(error);
		if(FormUtil.errorTypeCritical(error)==1 ||FormUtil.errorTypeCritical(error)==2)
		{
			response.setStc_result(-1);
		}else {
			response.setStc_result(1);
		}

		response.setStc_Macro_Calculation(true);
		//Formular_Gasstrahler_V_1  
		response.setGas_Emitter_V_1(V_1_Gas);
		
		response.setGasJet_V_DriveCurrent(V_Treibstrom);
		response.setStc_Macro_Calculation(false);
		
		
		FormUtil.stc_new_mark();
		return ResponseEntity.ok().body(response);

	}

}

