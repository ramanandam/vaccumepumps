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
		String machineID = input.getMachineID();// M_ID
		String V_Container = input.getV_Container();
		String p_1_Begin = input.getP_1_Begin();
		String materialID = input.getMaterialID();// Werkstoff_ID
		double drehzahl = input.getDrehzahl();
		String p_1_End = input.getP_1_End();
		double p_2 = input.getP_2();
		double T_1 = input.getT_1();
		double T_BF = input.getT_BF();
		double V_1_F = input.getV_1_F();
		String bf = Double.toString(input.getBf());

		String permissionGroup = input.getPermissionGroup();// Berechtigungsgruppe
		String V_1_norm_leakage = input.getV_1_norm_leakage();
		// Manuelle_Stoffdaten_uebertragen

		FormUtil.manuelle_Stoffdaten_uebertragen();

		if ("MANUAL_BF".equalsIgnoreCase(bf)) {
			bf = "MANUAL_BF";
			respose.setBf(Double.parseDouble(bf));
		}

		int stc_result = input.getStc_result();// stc_Ergebnis
		int stcCalculationType = input.getStcCalculationType();// stc_Berechnungsart
		List<Double> V_1_Gas_rel_List = input.getV_1_Gas_rel_List();
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
	

	
	
	/*
	 * 
	 * Sub Button_Maschinenauswahl_fuer_Evakuierungszeit()

Dim Maschinen_ID_Auswahl, Werkstoff_ID_Auswahl, n_Auswahl, t_evak_Auswahl, Fehlerart_Auswahl
Dim V_B, p_1_Beginn, t_evak_soll, t_evak_Toleranz_plus, t_evak_Toleranz_minus
Dim p_1_Ende, p_2, T_1, T_BF, V_1_F, n_nenn_Faktor, V_1_norm_Leckage
Dim Fehler As Fehlercodetyp
Dim Ber_Grp
Dim Gas, BF, V_1_Gas_rel
Dim felder_gefuellt As Boolean
Dim i As Integer, j As Integer
Dim a As Range
Dim Formular As Worksheet
Dim ListBox_Maschinenauswahl_Evak As Object
Dim listbox_array

Set Formular = Worksheets("Formular")
Set ListBox_Maschinenauswahl_Evak = Formular.OLEObjects("ListBox_Maschinenauswahl_Evak").Object

stc_Makro_Berechnung = True

ListBox_Maschinenauswahl_Evak.Clear
Application.Names("Formular_Anzahl_Datensätze_evak").RefersToRange = Empty

V_B = Application.Names("Formular_V_Behaelter").RefersToRange
p_1_Beginn = Application.Names("Formular_p_1_Beginn").RefersToRange
p_1_Ende = Application.Names("Formular_p_1_Ende").RefersToRange
p_2 = Application.Names("Formular_p_2").RefersToRange
T_1 = Application.Names("Formular_T_1").RefersToRange
T_BF = Application.Names("Formular_T_BF").RefersToRange
V_1_F = Application.Names("Formular_V_1_F").RefersToRange
BF = Application.Names("Formular_BF").RefersToRange
t_evak_soll = Application.Names("Formular_Soll_Evakuierungszeit").RefersToRange
t_evak_Toleranz_plus = Application.Names("Formular_t_evak_Toleranz_plus").RefersToRange
t_evak_Toleranz_minus = Application.Names("Formular_t_evak_Toleranz_minus").RefersToRange
Ber_Grp = Application.Names("Formular_Berechtigungsgruppe").RefersToRange
If Not IsEmpty(t_evak_Toleranz_plus) Then t_evak_Toleranz_plus = t_evak_Toleranz_plus / 100
If Not IsEmpty(t_evak_Toleranz_minus) Then t_evak_Toleranz_minus = t_evak_Toleranz_minus / 100
V_1_norm_Leckage = Application.Names("Formular_V_1_norm_Leckage").RefersToRange

If ob_evak_50Hz.Value = True Then
    n_nenn_Faktor = 1
ElseIf ob_evak_60Hz.Value = True Then
    n_nenn_Faktor = 1.2
End If

If stc_Ergebnis <> 0 Or stc_Berechnungsart <> 5 Then
' Es darf nur die relative Volumenstromverteilung vorgegeben sein, da nur diese in die Berechnung mit einfließt
    If stc_V_1_Gas_gegeben Or stc_V_1_Gas_gesamt_gegeben Or stc_m_1_Gas_gegeben Or stc_m_1_Gas_gesamt_gegeben Or stc_m_1_Gas_rel_gegeben Then
        stc_V_1_Gas_gegeben = False
        stc_V_1_Gas_gesamt_gegeben = False
        stc_m_1_Gas_gegeben = False
        stc_m_1_Gas_gesamt_gegeben = False
        stc_m_1_Gas_rel_gegeben = False
        felder_gefuellt = False
        i = 0
        For Each a In Application.Names("Formular_V_1_Gas_rel").RefersToRange
            i = i + 1
            If i > stc_Anzahl_Gase Then Exit For
            If Not IsEmpty(a) Then felder_gefuellt = True
        Next a
        If felder_gefuellt Then stc_V_1_Gas_rel_gegeben = True
    End If
    stc_Ergebnis = 0
    stc_Berechnungsart = 5
    Call stc_neu_markieren
    Exit Sub
End If

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

Call Maschinenauswahl_fuer_Evakuierungszeit(Fehler, Maschinen_ID_Auswahl, Werkstoff_ID_Auswahl, n_Auswahl, t_evak_Auswahl, Fehlerart_Auswahl, t_evak_soll, V_B, p_1_Beginn, p_1_Ende, p_2, T_1, T_BF, V_1_norm_Leckage, n_nenn_Faktor, t_evak_Toleranz_plus, t_evak_Toleranz_minus, Ber_Grp)

If IsArray(Maschinen_ID_Auswahl) Then
    For i = 1 To UBound(Maschinen_ID_Auswahl)
        If cb1_evak = True Or IsEmpty(Fehlerart_Auswahl(i)) Or (cb1_evak = False And Fehlerart_Auswahl(i) > 2) Then
            j = j + 1
        End If
    Next i
    Application.Names("Formular_Anzahl_Datensätze_evak").RefersToRange = j
    If j > 0 Then
        ReDim listbox_array(0 To j - 1, 0 To 5)
        j = 0
        For i = 1 To UBound(Maschinen_ID_Auswahl)
            If cb1_evak = True Or IsEmpty(Fehlerart_Auswahl(i)) Or (cb1_evak = False And Fehlerart_Auswahl(i) > 2) Then
                j = j + 1
                listbox_array(j - 1, 0) = Maschinen_ID_Auswahl(i)
                listbox_array(j - 1, 1) = Werkstoff_ID_Auswahl(i)
                listbox_array(j - 1, 2) = n_Auswahl(i)
                listbox_array(j - 1, 3) = t_evak_Auswahl(i)
                listbox_array(j - 1, 4) = Fehlerart_Auswahl(i)
            End If
        Next i
        ListBox_Maschinenauswahl_Evak.List() = listbox_array
    End If
Else
    Application.Names("Formular_Anzahl_Datensätze_evak").RefersToRange = Empty
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
	 */
	// Button 
	@RequestMapping(value = "/vaccumepumps/rest/machineSelectionForEvacuationTime/click", method = RequestMethod.POST)
	public ResponseEntity<IVacuumPumpDetails> machineSelectionForEvacuationTime(@RequestBody IVacuumSelectionInputs input) {
		IVacuumPumpDetails respose = new IVacuumPumpDetails();
		
		String V_B=input.getV_Container();
		String p_1_Begin=input.getP_1_Begin();
		String p_1_End=input.getP_1_End();
		double p_2 = input.getP_2();
		double T_1 = input.getT_1();
		double T_BF = input.getT_BF();
		double V_1_F = input.getV_1_F();
		String bf = Double.toString(input.getBf());
		//t_evak_soll
		String  Target_Evacuation_Time=input.getTarget_Evacuation_Time();
		double t_evak_tolerance_plus=Double.valueOf(input.getT_evak_tolerance_plus())    ;
		double t_evak_tolerance_minus=Double.valueOf(input.getForm_t_evak_tolerance_minus());
				
		String permissionGroup=input.getPermissionGroup();
		String V_1_norm_leakage=input.getV_1_norm_leakage();
		boolean ob_evak_50Hz=input.isFreieDrehzahl50Hz();
		boolean ob_evak_60Hz=input.isFreieDrehzahl60Hz();
		//also show machines with warnings  
		boolean cb1_evak=input.isCb1_evak();
		double n_nenn_Faktor = ob_evak_60Hz ? 1.2 : 1.0;
		
		boolean stc_V_1_Gas_rel_gegeben=input.isStc_V_1_Gas_gegeben();
		int stc_result = input.getStc_result();// stc_Ergebnis
		int stcCalculationType = input.getStcCalculationType();// stc_Berechnungsart
		
		
		if (stc_result != 0 || stcCalculationType != 5) {
	       
			
			if(input.isStc_m_1_Gas_gegeben()|| input.isStc_V_1_Gas_gesamt_gegeben() || input.isStc_m_1_Gas_gegeben() ||input.isStc_m_1_Gas_gesamt_gegeben() ||input.isStc_m_1_Gas_rel_gegeben() ) {
				
				 respose.setStc_V_1_Gas_gegeben(false);
			        respose.setStc_V_1_Gas_gesamt_gegeben(false);
			        respose.setStc_m_1_Gas_gegeben(false);
			        		respose.setStc_m_1_Gas_gesamt_gegeben(false);
			        				respose.setStc_m_1_Gas_rel_gegeben(false);

			        
			        				respose.setFeuchte(V_1_norm_leakage);
			        				respose.setFields_filled(false);//boolean fields_filled;//felder_gefuellt;felderGefuellt
			
			}//end if 
			
			int stc_Number_of_Gases=input.getStc_Number_of_Gases();
			List<Double> 	V_1_Gas_rel_List=input.getV_1_Gas_rel_List();
	        for (int i = 1; i <= stc_Number_of_Gases; i++) {
	            Double val = V_1_Gas_rel_List.get(i);
	            if (val != null) {
	                
	                respose.setFields_filled(true);
	                break;
	            }
	        }

	        if (respose.isFields_filled()) {
	           // stc_V_1_Gas_rel_gegeben = true;
	            respose.setStc_V_1_Gas_rel_gegeben(true);
	        }

	        //stc_result = 0;
	        respose.setStc_result(0);
	        respose.setStcCalculationType(stcCalculationType);
	       // stcCalculationType = 5;
	        FormUtil.stc_new_mark();
	        return ResponseEntity.ok().body(respose);
	    
	    }
		List<Double> Gas = new ArrayList<>();
		Map<Integer,Double> gasMap=input.getGasMap();
		List<Double> 	V_1_Gas_rel_List=input.getV_1_Gas_rel_List();
		List<Double> V_1_Gas_rel = new ArrayList<>();
		 for (int i = 1; i <= 6; i++) {
			 Double gas = gasMap.get(i);
		        if (gas == null ) break;

		        Gas.add(gas);

		        if (stc_V_1_Gas_rel_gegeben) {
		            Double rel = V_1_Gas_rel_List.get(i);
		            V_1_Gas_rel.add(rel);
		        }
		    }
		 respose.setV_1_Gas_rel(V_1_Gas_rel);
		 
		 ErrorCodeTable Fehler=new ErrorCodeTable();
		 List<String> Maschinen_ID_Auswahl = new ArrayList<>();
		    List<String> Werkstoff_ID_Auswahl = new ArrayList<>();
		    List<Double> n_Auswahl = new ArrayList<>();
		    List<Double> t_evak_Auswahl = new ArrayList<>();
		    List<Integer> Fehlerart_Auswahl = new ArrayList<>();
		    
		 
		 FormUtil.machineSelectionForEvacuationTime(Fehler, Maschinen_ID_Auswahl, Werkstoff_ID_Auswahl, n_Auswahl, t_evak_Auswahl, Fehlerart_Auswahl, t_evak_tolerance_minus, stcCalculationType, V_1_F, V_1_F, p_2, T_1, T_BF, V_1_F, null, t_evak_tolerance_plus, t_evak_tolerance_minus, V_1_norm_leakage);
				 
		 
		 int j = 0;
		    List<String[]> listbox_array = new ArrayList<>();

		    for (int i = 0; i < Maschinen_ID_Auswahl.size(); i++) {
		        Integer fehlerArt = Fehlerart_Auswahl.get(i);
		        if (cb1_evak || fehlerArt == null || (!cb1_evak && fehlerArt > 2)) {
		            j++;
		            listbox_array.add(new String[] {
		                Maschinen_ID_Auswahl.get(i),
		                Werkstoff_ID_Auswahl.get(i),
		                String.valueOf(n_Auswahl.get(i)),
		                String.valueOf(t_evak_Auswahl.get(i)),
		                fehlerArt == null ? "" : String.valueOf(fehlerArt)
		            });
		        }
		    }
		 
		 
		    respose.setNumberOfRecordsEvak(j);
		    
		    
		 // Only build the array if there are valid records
		    if (j > 0) {
		        List<String[]> listboxArray = new ArrayList<>(j);
		        j = 0;

		        for (int i = 0; i < Maschinen_ID_Auswahl.size(); i++) {
		            Integer fehlerart = Fehlerart_Auswahl.get(i);
		            if (cb1_evak || fehlerart == null || (!cb1_evak && fehlerart > 2)) {
		                String[] row = new String[5];
		                row[0] = Maschinen_ID_Auswahl.get(i);
		                row[1] = Werkstoff_ID_Auswahl.get(i);
		                row[2] = String.valueOf(n_Auswahl.get(i));
		                row[3] = String.valueOf(t_evak_Auswahl.get(i));
		                row[4] = (fehlerart == null) ? "" : fehlerart.toString();

		                listboxArray.add(row);
		                j++;
		            }
		        }

		        // Simulate assigning this to a ListBox UI
		        for (String[] row : listboxArray) {
		            System.out.printf("Machine: %s | Material: %s | RPM: %s | t_evak: %s | Error: %s%n",
		                    row[0], row[1], row[2], row[3], row[4]);
		        }
		        
		        
		        
		        
		    }else {
		        System.out.println("Keine gültigen Maschinen gefunden.");
		    }
		    
		    if(FormUtil.errorTypeCritical(Fehler)==1 || FormUtil.errorTypeCritical(Fehler)==2)
		    {
		    	 
		    	 respose.setStc_result(-1);
		    }else {
		    	respose.setStc_result(1);
		    }
		    
		   // Call Fehlertext_anzeigen(Fehler)
		    
		    FormUtil.show_error_text(Fehler);
		    respose.setStc_Makro_Berechnung(false);
		    //Call stc_neu_markieren
		    FormUtil.stc_new_mark();
		return ResponseEntity.ok().body(respose);
		
	}

}
