package com.flowserve.vaccumepump.webservice.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.flowserve.vaccumepump.webservice.dto.IVacuumPumpDetails;
import com.flowserve.vaccumepump.webservice.dto.IVacuumSelectionInputs;
import com.flowserve.vaccumepump.webservice.util.FormUtil;

@RestController
public class EvacuationTimeController {
	
	


	/*
	 *
	 * Sub Button_Evakuierungszeit_berechnen()

Dim M_ID, W_ID
Dim V_B, p_1_Beginn, t_evak
Dim p_1_Ende, p_2, T_1, T_BF, V_1_F, n, V_1_norm_Leckage
Dim Fehler As Fehlercodetyp
Dim Ber_Grp
Dim Gas, BF, V_1_Gas_rel
Dim felder_gefuellt As Boolean
Dim a As Range
Dim i As Integer

V_B = Application.Names("Formular_V_Behaelter").RefersToRange
p_1_Beginn = Application.Names("Formular_p_1_Beginn").RefersToRange

M_ID = Application.Names("Formular_Maschinen_ID").RefersToRange
W_ID = Application.Names("Formular_werkstoff_ID").RefersToRange
n = Application.Names("Formular_Drehzahl").RefersToRange
p_1_Ende = Application.Names("Formular_p_1_Ende").RefersToRange
p_2 = Application.Names("Formular_p_2").RefersToRange
T_1 = Application.Names("Formular_T_1").RefersToRange
T_BF = Application.Names("Formular_T_BF").RefersToRange
V_1_F = Application.Names("Formular_V_1_F").RefersToRange
BF = Application.Names("Formular_BF").RefersToRange
Ber_Grp = Application.Names("Formular_Berechtigungsgruppe").RefersToRange
V_1_norm_Leckage = Application.Names("Formular_V_1_norm_Leckage").RefersToRange

Call Manuelle_Stoffdaten_uebertragen

If UCase(BF) = "MANUAL_BF" Then BF = "MANUAL_BF"

If stc_Ergebnis <> 0 Or stc_Berechnungsart <> 4 Then
    ' Es darf nur die relative Volumenstromverteilung der Gase vorgegeben sein
    If stc_V_1_Gas_gegeben Or stc_V_1_Gas_gesamt_gegeben Or stc_m_1_Gas_gegeben Or stc_m_1_Gas_gesamt_gegeben Or stc_m_1_Gas_rel_gegeben Then
        stc_V_1_Gas_gegeben = False
        stc_V_1_Gas_gesamt_gegeben = False
        stc_m_1_Gas_gegeben = False
        stc_m_1_Gas_gesamt_gegeben = False
        stc_m_1_Gas_rel_gegeben = False
        felder_gefuellt = False
        For Each a In Application.Names("Formular_V_1_Gas_rel").RefersToRange
            i = i + 1
            If i > stc_Anzahl_Gase Then Exit For
            If Not IsEmpty(a) Then felder_gefuellt = True
        Next a
        If felder_gefuellt Then stc_V_1_Gas_rel_gegeben = True
    End If
    stc_Ergebnis = 0
    stc_Berechnungsart = 4
    Call stc_neu_markieren
    Exit Sub
End If

For i = 1 To 6
    If Not IsEmpty(Application.Names("Formular_Gas_" & CStr(i)).RefersToRange) Then
        stc_Anzahl_Gase = i
        If i = 1 Then
            ReDim Gas(1 To 1)
            If stc_V_1_Gas_rel_gegeben Then
                ReDim V_1_Gas_rel(1 To 1)
            End If
        Else
            ReDim Preserve Gas(1 To i)
            If stc_V_1_Gas_rel_gegeben Then
                ReDim Preserve V_1_Gas_rel(1 To i)
            End If
        End If
        Gas(i) = Application.Names("Formular_Gas_" & CStr(i)).RefersToRange
        If Not IsNumeric(Gas(i)) Then
            If UCase(Gas(i)) = "MANUAL_GAS_1" Then Gas(i) = "MANUAL_GAS_1"
            If UCase(Gas(i)) = "MANUAL_GAS_2" Then Gas(i) = "MANUAL_GAS_2"
        End If

        If stc_V_1_Gas_rel_gegeben Then
            V_1_Gas_rel(i) = Application.Names("Formular_V_1_Gas_rel_" & CStr(i)).RefersToRange
        End If
    Else
        Exit For
    End If
Next i

Call Evakuierungszeit(Fehler, M_ID, W_ID, n, V_B, p_1_Beginn, p_1_Ende, p_2, T_1, T_BF, V_1_norm_Leckage, Ber_Grp, t_evak)

Call Fehlertext_anzeigen(Fehler)
If Fehlerart_kritisch(Fehler) = 1 Or Fehlerart_kritisch(Fehler) = 2 Then
    stc_Ergebnis = -1
Else
    stc_Ergebnis = 1
End If

stc_Makro_Berechnung = True

Application.Names("Formular_Evakuierungszeit").RefersToRange = t_evak
Application.Names("Formular_V_Behaelter").RefersToRange = V_B
Application.Names("Formular_p_1_Ende").RefersToRange = p_1_Ende
Application.Names("Formular_p_1_Beginn").RefersToRange = p_1_Beginn
Application.Names("Formular_p_2").RefersToRange = p_2
Application.Names("Formular_T_1").RefersToRange = T_1
Application.Names("Formular_T_BF").RefersToRange = T_BF
Application.Names("Formular_Drehzahl").RefersToRange = n

If Not IsEmpty(V_1_Gas_rel) Then
    For i = 1 To stc_Anzahl_Gase
        Application.Names("Formular_V_1_Gas_rel_" & CStr(i)).RefersToRange = V_1_Gas_rel(i)
    Next i
End If

stc_Makro_Berechnung = False

Call stc_neu_markieren

End Sub
	 *
	 */
	
	
	
	
	@RequestMapping(value = "/vaccumepumps/rest/calculateEvacuationTime/click", method = RequestMethod.POST)
	public ResponseEntity<IVacuumPumpDetails> calculateEvacuationTime(@RequestBody IVacuumSelectionInputs input) {
		IVacuumPumpDetails respose = new IVacuumPumpDetails();
		String machineID=input.getMachineID();//M_ID
		String V_Container=input.getV_Container();
		String p_1_Begin=input.getP_1_Begin();
		String materialID=input.getMaterialID();//Werkstoff_ID
		double drehzahl=input.getDrehzahl();
		String p_1_End=input.getP_1_End();
		double p_2=input.getP_2();
		double T_1=input.getT_1();
		double T_BF=input.getT_BF();
		double V_1_F=input.getV_1_F();
		String bf=Double.toString(input.getBf());
		
		String permissionGroup=input.getPermissionGroup();//Berechtigungsgruppe
		String V_1_norm_leakage=input.getV_1_norm_leakage();
		//Manuelle_Stoffdaten_uebertragen
		
		FormUtil.manuelle_Stoffdaten_uebertragen();
		
		
		 if ("MANUAL_BF".equalsIgnoreCase(bf)) {
			 bf = "MANUAL_BF";
			 respose.setBf(Double.parseDouble(bf));
	        }
		 
		 int stc_result=input.getStc_result();//stc_Ergebnis
		 int stcCalculationType=input.getStcCalculationType();//stc_Berechnungsart
		 List<Double> V_1_Gas_rel_List=input.getV_1_Gas_rel_List();
			if (stc_result != 0 || stcCalculationType != 4) {
				respose.setStc_V_1_Gas_rel_gegeben(false);

				// fields_filled

				for (Double val : V_1_Gas_rel_List) {
					if (val != null) {

						respose.setFields_filled(true);
						break;
					}
				}
				if (respose.isFields_filled())
					respose.setStc_V_1_Gas_rel_gegeben(true);

				// stc_Ergebnis = 0;

				respose.setStc_result(0);
				respose.setStcCalculationType(4);
				// callStcNeuMarkieren();
				FormUtil.stc_new_mark();
				return ResponseEntity.ok().body(respose);
			}
		
		
		
		
		
		
		return ResponseEntity.ok().body(respose);
	}

}
