package com.flowserve.vaccumepump.webservice.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.flowserve.vaccumepump.webservice.dto.IVacuumPumpDetails;
import com.flowserve.vaccumepump.webservice.dto.IVacuumSelectionInputs;
import com.flowserve.vaccumepump.webservice.model.ErrorCodeTable;
import com.flowserve.vaccumepump.webservice.util.FormUtil;

@RestController
public class MachineSelectionForOperatingPoint {
	/*
	 * 
	 * Sub Button_Maschinenauswahl()

Dim Maschinen_ID, Werkstoff_ID, n, betr_art, V_1_Gas_gesamt, P_mech, V_BF, Fehlerart_Auswahl
Dim Formular As Worksheet
Dim ListBox_Maschinenauswahl As Object
Dim listbox_array
Dim ControlBox_Feste_Drehzahl As Object
Dim Fehler As Fehlercodetyp
Dim p_1, p_2, T_1, T_BF, V_1_Gas_gesamt_soll, V_1_Gas_rel, Gas, BF, V_1_F
Dim i As Integer, j As Integer
Dim n_fest
Dim n_nenn_Faktor
Dim V_1_Toleranz_plus, V_1_Toleranz_minus
Dim Ber_Grp
Dim a As Range
Dim felder_gefuellt As Boolean

Set Formular = Worksheets("Formular")
Set ListBox_Maschinenauswahl = Formular.OLEObjects("Listbox_Maschinenauswahl").Object

If OptionButton_Feste_Drehzahl_50Hz.Value = True Then
    n_nenn_Faktor = 1
ElseIf OptionButton_Feste_Drehzahl_60Hz.Value = True Then
    n_nenn_Faktor = 1.2
End If


ListBox_Maschinenauswahl.Clear

V_1_Gas_gesamt_soll = Application.Names("Formular_V_1_Gas_gesamt_soll").RefersToRange
p_1 = Application.Names("Formular_p_1").RefersToRange
p_2 = Application.Names("Formular_p_2").RefersToRange
T_1 = Application.Names("Formular_T_1").RefersToRange
T_BF = Application.Names("Formular_T_BF").RefersToRange
V_1_F = Application.Names("Formular_V_1_F").RefersToRange
BF = Application.Names("Formular_BF").RefersToRange
V_1_Toleranz_plus = Application.Names("Formular_V_1_Toleranz_plus").RefersToRange
V_1_Toleranz_minus = Application.Names("Formular_V_1_Toleranz_minus").RefersToRange

Ber_Grp = Application.Names("Formular_Berechtigungsgruppe").RefersToRange

If Not IsEmpty(V_1_Toleranz_plus) Then V_1_Toleranz_plus = V_1_Toleranz_plus / 100
If Not IsEmpty(V_1_Toleranz_minus) Then V_1_Toleranz_minus = V_1_Toleranz_minus / 100

If stc_Ergebnis <> 0 Or stc_Berechnungsart <> 3 Then
    ' Nur die relative Volumenstromverteilung fließt in die Berechnung mit ein
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
    Application.Names("Formular_Anzahl_Datensätze").RefersToRange = Empty
    stc_Ergebnis = 0
    stc_Berechnungsart = 3
    Call stc_neu_markieren
    Exit Sub
End If

stc_Makro_Berechnung = True

' Einlesen der relativen Volumenstromverteilung der einzelnen Gaskomponenten, sofern gegeben

For i = 1 To 6
    If Not IsEmpty(Application.Names("Formular_Gas_" & CStr(i)).RefersToRange) Then
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
        If stc_V_1_Gas_rel_gegeben Then
            V_1_Gas_rel(i) = Application.Names("Formular_V_1_Gas_rel_" & CStr(i)).RefersToRange
        End If
    Else
        Exit For
    End If
Next i

Call Maschinenauswahl(Fehler, Maschinen_ID, Werkstoff_ID, n, betr_art, V_1_Gas_gesamt, P_mech, V_BF, Fehlerart_Auswahl, V_1_Gas_gesamt_soll, p_1, p_2, T_1, T_BF, Gas, V_1_Gas_rel, BF, V_1_F, n_nenn_Faktor, n_fest, V_1_Toleranz_plus, V_1_Toleranz_minus, Ber_Grp)

If IsArray(Maschinen_ID) Then
    For i = 1 To UBound(Maschinen_ID)
        If CheckBox_Auswahl_mit_Warnungen = True Or IsEmpty(Fehlerart_Auswahl(i)) Or (CheckBox_Auswahl_mit_Warnungen = False And Fehlerart_Auswahl(i) > 2) Then
            j = j + 1
        End If
    Next i
    Application.Names("Formular_Anzahl_Datensätze").RefersToRange = j
    If j > 0 Then
        ReDim listbox_array(0 To j - 1, 0 To 5)
        j = 0
        For i = 1 To UBound(Maschinen_ID)
            If CheckBox_Auswahl_mit_Warnungen = True Or IsEmpty(Fehlerart_Auswahl(i)) Or (CheckBox_Auswahl_mit_Warnungen = False And Fehlerart_Auswahl(i) > 2) Then
                j = j + 1
                listbox_array(j - 1, 0) = Maschinen_ID(i)
                listbox_array(j - 1, 1) = Werkstoff_ID(i)
                listbox_array(j - 1, 2) = n(i)
                listbox_array(j - 1, 3) = V_1_Gas_gesamt(i)
                listbox_array(j - 1, 4) = P_mech(i)
                listbox_array(j - 1, 5) = betr_art(i)
            End If
        Next i
        ListBox_Maschinenauswahl.List() = listbox_array
    End If
Else
    Application.Names("Formular_Anzahl_Datensätze").RefersToRange = Empty
End If

If Fehlerart_kritisch(Fehler) = 1 Or Fehlerart_kritisch(Fehler) = 2 Then
    stc_Ergebnis = -1
Else
    stc_Ergebnis = 1
End If
Call Fehlertext_anzeigen(Fehler)

stc_Makro_Berechnung = False

Call stc_neu_markieren

End Sub
	 * 
	 * 
	 * 
	 */
	
	//Button name :Maschinenauswahl für Betriebspunkt English : Machine selection for operating point
	@RequestMapping(value = "/vaccumepumps/rest/machineSelectionForOperatingPoint/click", method = RequestMethod.POST)
	public ResponseEntity<IVacuumPumpDetails> machineSelectionForOperatingPoint(@RequestBody IVacuumSelectionInputs input) {
		IVacuumPumpDetails respose = new IVacuumPumpDetails();
		
		
		
		respose.setV_1_Toleranz_plus(input.getV_1_Toleranz_plus()/100);
		respose.setV_1_Toleranz_minus(input.getV_1_Toleranz_minus()/100);
		if(input.isFreieDrehzahl50Hz())
		{
			respose.setnNominalFactor(1.0);
		}else if(input.isFreieDrehzahl60Hz()) {
			respose.setnNominalFactor(1.2);
		}
		
		if (input.getStc_result() != 0 && input.getStcCalculationType() != 3) {
			respose.setStc_V_1_Gas_gegeben(false);
			respose.setStc_m_1_Gas_gegeben(false);
			respose.setStc_m_1_Gas_gesamt_gegeben(false);
			respose.setStc_m_1_Gas_rel_gegeben(false);
			respose.setFields_filled(false);

			int i = 0;
			List<Double> V_1_Gas_rel_List = input.getV_1_Gas_rel_List();

			for (Double value : V_1_Gas_rel_List) {
				i++;
				if (i > input.getStc_Number_of_Gases())
					break;
				if (value != null) {
					respose.setFields_filled(true);
				}
			}

			if (respose.isFields_filled()) {
				respose.setStc_V_1_Gas_rel_gegeben(true);
			}

			respose.setStc_result(0);
			respose.setStcCalculationType(3);

			FormUtil.stc_new_mark();

		}
		
		respose.setStc_Makro_Berechnung(true);
		Map<Integer,Double> gasMap=input.getGasMap();
		
		 Map<Integer,Double> V_1_Gas_relMap=input.getV_1_Gas_relMap();
		
		 // Processing gas components
        List<Double> gasComponents = new ArrayList<>();
        List<Double> v1GasRelComponents = new ArrayList<>();
        
        for (int i = 1; i <= 6; i++) {
            Double gasValue = gasMap.get(i);
            if (gasValue != null) {
                gasComponents.add(gasValue);
                if (respose.isStc_V_1_Gas_rel_gegeben()) {
                    v1GasRelComponents.add(V_1_Gas_relMap.get(i));
                }
            } else {
                break;
            }
        }
    	ErrorCodeTable fehler = new ErrorCodeTable();
		String machineID=input.getMachineID();
				String  Werkstoff_ID=input.getMaterialID();
				double n = Double.parseDouble((input.getVacuumOperation()));
		double p_1=input.getP_1();
		double p_2=input.getP_2();
		double T_1=input.getT_1();
		double T_BF=input.getT_BF();
		double V_1_Gas_gesamt_soll=input.getV_1_Gas_gesamt_soll();
		double  V_1_Gas_rel=input.getV_1_Gas_rel();
		double V_1_Gas_Total_Volume=input.getV_1_Gas_Total_Volume(); ;
		double Gas=input.getGas();
		
		double  BF=input.getBf();
		double V_1_F=input.getV_1_F();
		double T_BF_opt=input.getOptimizedBFtemperature();
		String Berechtigungsgruppe=input.getPermissionGroup();
		boolean felder_gefuellt=input.isFields_filled();
		int stcCalculationType = 6;
		double P_mech = 0;
		double betr_art = 0;
		int[] errorTypeSelection = null;//fehlerartAuswahl;
		int n_fest = 0;
		String Ber_Grp = null;
       // Call Maschinenauswahl(Fehler, Maschinen_ID, Werkstoff_ID, n, betr_art, V_1_Gas_gesamt, P_mech, V_BF, Fehlerart_Auswahl, V_1_Gas_gesamt_soll, p_1, p_2, T_1, T_BF, Gas, V_1_Gas_rel, BF, V_1_F, n_nenn_Faktor, n_fest, V_1_Toleranz_plus, V_1_Toleranz_minus, Ber_Grp)
        FormUtil.machineSelection(fehler,machineID,Werkstoff_ID,n,betr_art,V_1_Gas_Total_Volume,P_mech,input.getV_BF(),errorTypeSelection,V_1_Gas_gesamt_soll,p_1,p_2,T_BF,Gas,V_1_Gas_rel,BF,V_1_F,input.getnNominalFactor(),n_fest,input.getV_1_Toleranz_plus(),input.getV_1_Toleranz_minus(),Ber_Grp);
		
        if (machineID != null) {
        	
        	
        
        
        
        return ResponseEntity.ok().body(respose);
		
	}
	
	
	

}
