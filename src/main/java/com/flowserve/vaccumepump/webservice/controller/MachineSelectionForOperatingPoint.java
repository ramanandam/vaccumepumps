package com.flowserve.vaccumepump.webservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.flowserve.vaccumepump.webservice.dto.IVacuumPumpDetails;
import com.flowserve.vaccumepump.webservice.dto.IVacuumSelectionInputs;

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
	
	}
	
	
	

}
