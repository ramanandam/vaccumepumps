package com.flowserve.vaccumepump.webservice.util;

import com.flowserve.vaccumepump.webservice.model.ErrorCodeTable;

public class FormUtil {

	
	// Method to get a description based on Maschinenart value
    public static String getMaschinenartDescription(int maschinenart) {
        switch (maschinenart) {
            case 1:
                return "1 - Einstufige Vakuumpumpe 33mbar";
            case 2:
                return "2 - Einst. Vakuumpumpe 120mbar";
            case 3:
                return "3 - Zweist. Vakuumpumpe 33mbar";
            case 4:
                return "4 - Einst. Kompressor";
            case 5:
                return "5 - Mehrst. Kompressor";
            default:
                return "Unknown"; // Default case for unknown Maschinenart
        }
    }
    
    
    //stc_new_mark
	/*
	 * Sub stc_neu_markieren()
	 * 
	 * Dim ergebnis_darstellung_eingabe As Integer Dim
	 * ergebnis_darstellung_eingabe_variabel As Integer Dim
	 * ergebnis_darstellung_ausgabe As Integer Dim rgb_eingabe As Long Dim
	 * rgb_ausgabe As Long
	 * 
	 * Static stc_Berechnungsart_alt As Integer Static stc_Ergebnis_alt As Integer
	 * 
	 * If stc_Berechnungsart <> stc_Berechnungsart_alt Then
	 * ComboBox_Maschinen_ID.BackColor = RGB(255, 255, 255) ListBox_Wkst.BackColor =
	 * RGB(255, 255, 255) ComboBox_Gasstrahler.BackColor = RGB(255, 255, 255)
	 * ListBox_Gasstrahlerauswahl.BackColor = RGB(255, 255, 255)
	 * ListBox_Maschinenauswahl_Evak.BackColor = RGB(255, 255, 255)
	 * 
	 * Call stc_einfaerben(Application.Names("Formular_Berechtigungsgruppe").
	 * RefersToRange, 0) Call
	 * stc_einfaerben(Application.Names("Formular_Drehzahl").RefersToRange, 0) Call
	 * stc_einfaerben(Application.Names("Formular_p_1").RefersToRange, 0) Call
	 * stc_einfaerben(Application.Names("Formular_p_2").RefersToRange, 0) Call
	 * stc_einfaerben(Application.Names("Formular_T_1").RefersToRange, 0) Call
	 * stc_einfaerben(Application.Names("Formular_T_BF").RefersToRange, 0) Call
	 * stc_einfaerben(Application.Names("Formular_V_1_F").RefersToRange, 0) Call
	 * stc_einfaerben(Application.Names("Formular_T_FF").RefersToRange, 0) Call
	 * stc_einfaerben(Application.Names("Formular_BF").RefersToRange, 0) Call
	 * stc_einfaerben(Application.Names("Formular_V_BF_manuell").RefersToRange, 0)
	 * Call stc_einfaerben(Application.Names("Formular_Delta_p_Waermetauscher").
	 * RefersToRange, 0)
	 * 
	 * Call stc_einfaerben(Application.Names("Formular_Gas").RefersToRange, 0) Call
	 * stc_einfaerben(Application.Names("Formular_V_1_Gas_gesamt").RefersToRange, 0)
	 * Call stc_einfaerben(Application.Names("Formular_V_1_Gas_gesamt_norm").
	 * RefersToRange, 0) Call
	 * stc_einfaerben(Application.Names("Formular_V_1_Gas").RefersToRange, 0) Call
	 * stc_einfaerben(Application.Names("Formular_V_1_Gas_rel").RefersToRange, 0)
	 * Call stc_einfaerben(Application.Names("Formular_m_1_Gas").RefersToRange, 0)
	 * Call stc_einfaerben(Application.Names("Formular_m_1_Gas_rel").RefersToRange,
	 * 0) Call
	 * stc_einfaerben(Application.Names("Formular_m_1_Gas_gesamt").RefersToRange, 0)
	 * Call stc_einfaerben(Application.Names("Formular_Feuchte").RefersToRange, 0)
	 * Call stc_einfaerben(Application.Names("Formular_Psi").RefersToRange, 0) Call
	 * stc_einfaerben(Application.Names("Formular_p_SD_Dampf").RefersToRange, 0)
	 * Call stc_einfaerben(Application.Names("Formular_M_mol_mittel").RefersToRange,
	 * 0)
	 * 
	 * Call stc_einfaerben(Application.Names("Formular_P").RefersToRange, 0) Call
	 * stc_einfaerben(Application.Names("Formular_P_max").RefersToRange, 0) Call
	 * stc_einfaerben(Application.Names("Formular_p_2_max").RefersToRange, 0) Call
	 * stc_einfaerben(Application.Names("Formular_V_BF").RefersToRange, 0) Call
	 * stc_einfaerben(Application.Names("Formular_Q_WT").RefersToRange, 0) Call
	 * stc_einfaerben(Application.Names("Formular_T_2").RefersToRange, 0) Call
	 * stc_einfaerben(Application.Names("Formular_V_FF").RefersToRange, 0) Call
	 * stc_einfaerben(Application.Names("Formular_lambdas").RefersToRange, 0) Call
	 * stc_einfaerben(Application.Names("Formular_phis").RefersToRange, 0) Call
	 * stc_einfaerben(Application.Names("Formular_n_ref").RefersToRange, 0) Call
	 * stc_einfaerben(Application.Names("Formular_p_2_ref").RefersToRange, 0) Call
	 * stc_einfaerben(Application.Names("Formular_V_1_ref").RefersToRange, 0) Call
	 * stc_einfaerben(Application.Names("Formular_P_ref").RefersToRange, 0)
	 * 
	 * Call stc_einfaerben(Application.Names("Formular_V_1_Gas_gesamt_soll").
	 * RefersToRange, 0) Call
	 * stc_einfaerben(Application.Names("Formular_V_1_Toleranz_plus").RefersToRange,
	 * 0) Call stc_einfaerben(Application.Names("Formular_V_1_Toleranz_minus").
	 * RefersToRange, 0)
	 * 
	 * Call stc_einfaerben(Application.Names("Formular_V_Behaelter").RefersToRange,
	 * 0) Call
	 * stc_einfaerben(Application.Names("Formular_p_1_Beginn").RefersToRange, 0)
	 * Call stc_einfaerben(Application.Names("Formular_p_1_Ende").RefersToRange, 0)
	 * Call
	 * stc_einfaerben(Application.Names("Formular_V_1_norm_Leckage").RefersToRange,
	 * 0) Call
	 * stc_einfaerben(Application.Names("Formular_Evakuierungszeit").RefersToRange,
	 * 0)
	 * 
	 * Call stc_einfaerben(Application.Names("Formular_Soll_Evakuierungszeit").
	 * RefersToRange, 0) Call
	 * stc_einfaerben(Application.Names("Formular_t_evak_Toleranz_plus").
	 * RefersToRange, 0) Call
	 * stc_einfaerben(Application.Names("Formular_t_evak_Toleranz_minus").
	 * RefersToRange, 0)
	 * 
	 * Call
	 * stc_einfaerben(Application.Names("Formular_Gasstrahler_p_1").RefersToRange,
	 * 0) Call
	 * stc_einfaerben(Application.Names("Formular_Gasstrahler_V_1").RefersToRange,
	 * 0) Call
	 * stc_einfaerben(Application.Names("Formular_Gasstrahler_V_Treibstrom").
	 * RefersToRange, 0) Call
	 * stc_einfaerben(Application.Names("Formular_Gasstrahler_V_1_soll").
	 * RefersToRange, 0)
	 * 
	 * Call stc_einfaerben(Application.Names("Formular_T_BF_opt").RefersToRange, 0)
	 * End If
	 * 
	 * If stc_Ergebnis = 0 Then ergebnis_darstellung_eingabe = 4
	 * ergebnis_darstellung_eingabe_variabel = 3 ergebnis_darstellung_ausgabe = 1
	 * rgb_eingabe = RGB(255, 255, 0) rgb_ausgabe = RGB(255, 255, 255) If
	 * stc_Ergebnis_alt <> 0 Then TextBox_Fehler = Empty ElseIf stc_Ergebnis = 1
	 * Then ergebnis_darstellung_eingabe = 5 ergebnis_darstellung_eingabe_variabel =
	 * 5 ergebnis_darstellung_ausgabe = 5 rgb_eingabe = RGB(180, 255, 180)
	 * rgb_ausgabe = RGB(180, 255, 180) ElseIf stc_Ergebnis = -1 Then
	 * ergebnis_darstellung_eingabe = 6 ergebnis_darstellung_eingabe_variabel = 6
	 * ergebnis_darstellung_ausgabe = 6 rgb_eingabe = RGB(255, 180, 180) rgb_ausgabe
	 * = RGB(255, 180, 180) End If
	 * 
	 * If stc_Berechnungsart <> stc_Berechnungsart_alt Or stc_Ergebnis <>
	 * stc_Ergebnis_alt Then If stc_Berechnungsart = 1 Then Call
	 * stc_einfaerben(Application.Names("Formular_Berechtigungsgruppe").
	 * RefersToRange, ergebnis_darstellung_eingabe) Call
	 * stc_einfaerben(Application.Names("Formular_p_1").RefersToRange,
	 * ergebnis_darstellung_eingabe) Call
	 * stc_einfaerben(Application.Names("Formular_p_2").RefersToRange,
	 * ergebnis_darstellung_eingabe) Call
	 * stc_einfaerben(Application.Names("Formular_T_1").RefersToRange,
	 * ergebnis_darstellung_eingabe) Call
	 * stc_einfaerben(Application.Names("Formular_T_BF").RefersToRange,
	 * ergebnis_darstellung_eingabe) Call
	 * stc_einfaerben(Application.Names("Formular_BF").RefersToRange,
	 * ergebnis_darstellung_eingabe) ElseIf stc_Berechnungsart = 2 Then
	 * ComboBox_Maschinen_ID.BackColor = rgb_eingabe ListBox_Wkst.BackColor =
	 * rgb_eingabe Call
	 * stc_einfaerben(Application.Names("Formular_Berechtigungsgruppe").
	 * RefersToRange, ergebnis_darstellung_eingabe) Call
	 * stc_einfaerben(Application.Names("Formular_Drehzahl").RefersToRange,
	 * ergebnis_darstellung_eingabe) Call
	 * stc_einfaerben(Application.Names("Formular_p_1").RefersToRange,
	 * ergebnis_darstellung_eingabe) Call
	 * stc_einfaerben(Application.Names("Formular_p_2").RefersToRange,
	 * ergebnis_darstellung_eingabe) Call
	 * stc_einfaerben(Application.Names("Formular_T_1").RefersToRange,
	 * ergebnis_darstellung_eingabe) Call
	 * stc_einfaerben(Application.Names("Formular_T_BF").RefersToRange,
	 * ergebnis_darstellung_eingabe) Call
	 * stc_einfaerben(Application.Names("Formular_V_1_F").RefersToRange,
	 * ergebnis_darstellung_eingabe) Call
	 * stc_einfaerben(Application.Names("Formular_T_FF").RefersToRange,
	 * ergebnis_darstellung_eingabe) Call
	 * stc_einfaerben(Application.Names("Formular_BF").RefersToRange,
	 * ergebnis_darstellung_eingabe) Call
	 * stc_einfaerben(Application.Names("Formular_V_BF_manuell").RefersToRange,
	 * ergebnis_darstellung_eingabe) Call
	 * stc_einfaerben(Application.Names("Formular_Delta_p_Waermetauscher").
	 * RefersToRange, ergebnis_darstellung_eingabe)
	 * 
	 * Call stc_einfaerben(Application.Names("Formular_P").RefersToRange,
	 * ergebnis_darstellung_ausgabe) Call
	 * stc_einfaerben(Application.Names("Formular_P_max").RefersToRange,
	 * ergebnis_darstellung_ausgabe) Call
	 * stc_einfaerben(Application.Names("Formular_p_2_max").RefersToRange,
	 * ergebnis_darstellung_ausgabe) Call
	 * stc_einfaerben(Application.Names("Formular_V_BF").RefersToRange,
	 * ergebnis_darstellung_ausgabe) Call
	 * stc_einfaerben(Application.Names("Formular_Q_WT").RefersToRange,
	 * ergebnis_darstellung_ausgabe) Call
	 * stc_einfaerben(Application.Names("Formular_T_2").RefersToRange,
	 * ergebnis_darstellung_ausgabe) Call
	 * stc_einfaerben(Application.Names("Formular_V_FF").RefersToRange,
	 * ergebnis_darstellung_ausgabe) Call
	 * stc_einfaerben(Application.Names("Formular_lambdas").RefersToRange,
	 * ergebnis_darstellung_ausgabe) Call
	 * stc_einfaerben(Application.Names("Formular_phis").RefersToRange,
	 * ergebnis_darstellung_ausgabe) Call
	 * stc_einfaerben(Application.Names("Formular_n_ref").RefersToRange,
	 * ergebnis_darstellung_ausgabe) Call
	 * stc_einfaerben(Application.Names("Formular_p_2_ref").RefersToRange,
	 * ergebnis_darstellung_ausgabe) Call
	 * stc_einfaerben(Application.Names("Formular_V_1_ref").RefersToRange,
	 * ergebnis_darstellung_ausgabe) Call
	 * stc_einfaerben(Application.Names("Formular_P_ref").RefersToRange,
	 * ergebnis_darstellung_ausgabe)
	 * 
	 * ElseIf stc_Berechnungsart = 3 Then Call
	 * stc_einfaerben(Application.Names("Formular_Berechtigungsgruppe").
	 * RefersToRange, ergebnis_darstellung_eingabe) Call
	 * stc_einfaerben(Application.Names("Formular_p_1").RefersToRange,
	 * ergebnis_darstellung_eingabe) Call
	 * stc_einfaerben(Application.Names("Formular_p_2").RefersToRange,
	 * ergebnis_darstellung_eingabe) Call
	 * stc_einfaerben(Application.Names("Formular_T_1").RefersToRange,
	 * ergebnis_darstellung_eingabe) Call
	 * stc_einfaerben(Application.Names("Formular_T_BF").RefersToRange,
	 * ergebnis_darstellung_eingabe) Call
	 * stc_einfaerben(Application.Names("Formular_V_1_F").RefersToRange,
	 * ergebnis_darstellung_eingabe) Call
	 * stc_einfaerben(Application.Names("Formular_BF").RefersToRange,
	 * ergebnis_darstellung_eingabe) Call
	 * stc_einfaerben(Application.Names("Formular_V_1_Gas_gesamt_soll").
	 * RefersToRange, ergebnis_darstellung_eingabe) Call
	 * stc_einfaerben(Application.Names("Formular_V_1_Toleranz_plus").RefersToRange,
	 * ergebnis_darstellung_eingabe) Call
	 * stc_einfaerben(Application.Names("Formular_V_1_Toleranz_minus").
	 * RefersToRange, ergebnis_darstellung_eingabe)
	 * 
	 * 'Call stc_einfaerben(Application.Names("Formular_V_1_Gas").RefersToRange, 0)
	 * 'Call stc_einfaerben(Application.Names("Formular_m_1_Gas").RefersToRange, 0)
	 * 'Call
	 * stc_einfaerben(Application.Names("Formular_V_1_Gas_gesamt").RefersToRange, 0)
	 * 'Call stc_einfaerben(Application.Names("Formular_V_1_Gas_gesamt_norm").
	 * RefersToRange, 0) 'Call
	 * stc_einfaerben(Application.Names("Formular_m_1_Gas_gesamt").RefersToRange, 0)
	 * 
	 * ElseIf stc_Berechnungsart = 4 Then ComboBox_Maschinen_ID.BackColor =
	 * rgb_eingabe ListBox_Wkst.BackColor = rgb_eingabe Call
	 * stc_einfaerben(Application.Names("Formular_Berechtigungsgruppe").
	 * RefersToRange, ergebnis_darstellung_eingabe) Call
	 * stc_einfaerben(Application.Names("Formular_Drehzahl").RefersToRange,
	 * ergebnis_darstellung_eingabe) Call
	 * stc_einfaerben(Application.Names("Formular_p_2").RefersToRange,
	 * ergebnis_darstellung_eingabe) Call
	 * stc_einfaerben(Application.Names("Formular_T_1").RefersToRange,
	 * ergebnis_darstellung_eingabe) Call
	 * stc_einfaerben(Application.Names("Formular_T_BF").RefersToRange,
	 * ergebnis_darstellung_eingabe) Call
	 * stc_einfaerben(Application.Names("Formular_p_1_Beginn").RefersToRange,
	 * ergebnis_darstellung_eingabe) Call
	 * stc_einfaerben(Application.Names("Formular_p_1_Ende").RefersToRange,
	 * ergebnis_darstellung_eingabe) Call
	 * stc_einfaerben(Application.Names("Formular_V_Behaelter").RefersToRange,
	 * ergebnis_darstellung_eingabe) Call
	 * stc_einfaerben(Application.Names("Formular_V_1_norm_Leckage").RefersToRange,
	 * ergebnis_darstellung_eingabe)
	 * 
	 * Call
	 * stc_einfaerben(Application.Names("Formular_Evakuierungszeit").RefersToRange,
	 * ergebnis_darstellung_ausgabe) ElseIf stc_Berechnungsart = 5 Then Call
	 * stc_einfaerben(Application.Names("Formular_Berechtigungsgruppe").
	 * RefersToRange, ergebnis_darstellung_eingabe) Call
	 * stc_einfaerben(Application.Names("Formular_p_2").RefersToRange,
	 * ergebnis_darstellung_eingabe) Call
	 * stc_einfaerben(Application.Names("Formular_T_1").RefersToRange,
	 * ergebnis_darstellung_eingabe) Call
	 * stc_einfaerben(Application.Names("Formular_T_BF").RefersToRange,
	 * ergebnis_darstellung_eingabe) Call
	 * stc_einfaerben(Application.Names("Formular_p_1_Beginn").RefersToRange,
	 * ergebnis_darstellung_eingabe) Call
	 * stc_einfaerben(Application.Names("Formular_p_1_Ende").RefersToRange,
	 * ergebnis_darstellung_eingabe) Call
	 * stc_einfaerben(Application.Names("Formular_V_Behaelter").RefersToRange,
	 * ergebnis_darstellung_eingabe) Call
	 * stc_einfaerben(Application.Names("Formular_Soll_Evakuierungszeit").
	 * RefersToRange, ergebnis_darstellung_eingabe) Call
	 * stc_einfaerben(Application.Names("Formular_t_evak_Toleranz_plus").
	 * RefersToRange, ergebnis_darstellung_eingabe) Call
	 * stc_einfaerben(Application.Names("Formular_t_evak_Toleranz_minus").
	 * RefersToRange, ergebnis_darstellung_eingabe) Call
	 * stc_einfaerben(Application.Names("Formular_V_1_norm_Leckage").RefersToRange,
	 * ergebnis_darstellung_eingabe)
	 * 
	 * ListBox_Maschinenauswahl_Evak.BackColor = rgb_ausgabe ElseIf
	 * stc_Berechnungsart = 6 Then Call
	 * stc_einfaerben(Application.Names("Formular_Berechtigungsgruppe").
	 * RefersToRange, ergebnis_darstellung_eingabe) Call
	 * stc_einfaerben(Application.Names("Formular_p_1").RefersToRange,
	 * ergebnis_darstellung_eingabe) Call
	 * stc_einfaerben(Application.Names("Formular_p_2").RefersToRange,
	 * ergebnis_darstellung_eingabe) Call
	 * stc_einfaerben(Application.Names("Formular_T_1").RefersToRange,
	 * ergebnis_darstellung_eingabe) Call
	 * stc_einfaerben(Application.Names("Formular_T_BF").RefersToRange,
	 * ergebnis_darstellung_eingabe) Call
	 * stc_einfaerben(Application.Names("Formular_V_1_F").RefersToRange,
	 * ergebnis_darstellung_eingabe) Call
	 * stc_einfaerben(Application.Names("Formular_BF").RefersToRange,
	 * ergebnis_darstellung_eingabe) Call
	 * stc_einfaerben(Application.Names("Formular_V_1_Gas_gesamt_soll").
	 * RefersToRange, ergebnis_darstellung_eingabe)
	 * 
	 * Call stc_einfaerben(Application.Names("Formular_T_BF_opt").RefersToRange,
	 * ergebnis_darstellung_ausgabe) ElseIf stc_Berechnungsart = 7 Then
	 * ComboBox_Gasstrahler.BackColor = rgb_eingabe Call
	 * stc_einfaerben(Application.Names("Formular_Gasstrahler_p_1").RefersToRange,
	 * ergebnis_darstellung_eingabe) Call
	 * stc_einfaerben(Application.Names("Formular_Gasstrahler_V_1").RefersToRange,
	 * ergebnis_darstellung_ausgabe)
	 * 
	 * Call stc_einfaerben(Application.Names("Formular_Gasstrahler_V_Treibstrom").
	 * RefersToRange, ergebnis_darstellung_ausgabe) ElseIf stc_Berechnungsart = 8
	 * Then ListBox_Gasstrahlerauswahl.BackColor = rgb_ausgabe Call
	 * stc_einfaerben(Application.Names("Formular_Gasstrahler_V_1_soll").
	 * RefersToRange, ergebnis_darstellung_eingabe) Call
	 * stc_einfaerben(Application.Names("Formular_Gasstrahler_p_1").RefersToRange,
	 * ergebnis_darstellung_eingabe) End If If stc_Ergebnis = -1 Then
	 * TextBox_Fehler.BackColor = rgb_ausgabe Else TextBox_Fehler.BackColor =
	 * RGB(255, 255, 255) End If End If
	 * 
	 * If (stc_Berechnungsart > 0 And stc_Berechnungsart < 4) Or stc_Berechnungsart
	 * = 6 Then If stc_Anzahl_Gase = 0 Then Call
	 * stc_einfaerben(Application.Names("Formular_Gas").RefersToRange, 0) Call
	 * stc_einfaerben(Application.Names("Formular_V_1_Gas").RefersToRange, 0) Call
	 * stc_einfaerben(Application.Names("Formular_V_1_Gas_rel").RefersToRange, 0)
	 * Call stc_einfaerben(Application.Names("Formular_m_1_Gas").RefersToRange, 0)
	 * Call stc_einfaerben(Application.Names("Formular_m_1_Gas_rel").RefersToRange,
	 * 0) Call
	 * stc_einfaerben(Application.Names("Formular_m_1_Gas_gesamt").RefersToRange, 0)
	 * Call stc_einfaerben(Application.Names("Formular_Feuchte").RefersToRange, 0)
	 * Call stc_einfaerben(Application.Names("Formular_Psi").RefersToRange, 0) If
	 * stc_Berechnungsart < 3 Then Call
	 * stc_einfaerben(Application.Names("Formular_V_1_Gas_gesamt").RefersToRange,
	 * ergebnis_darstellung_ausgabe) Call
	 * stc_einfaerben(Application.Names("Formular_V_1_Gas_gesamt_norm").
	 * RefersToRange, ergebnis_darstellung_ausgabe) End If Else If stc_Ergebnis <> 0
	 * Then If stc_Berechnungsart = 1 Or stc_Berechnungsart = 2 Then Call
	 * stc_einfaerben(Application.Names("Formular_V_1_Gas").RefersToRange,
	 * ergebnis_darstellung_ausgabe) Call
	 * stc_einfaerben(Application.Names("Formular_V_1_Gas_gesamt").RefersToRange,
	 * ergebnis_darstellung_ausgabe) Call
	 * stc_einfaerben(Application.Names("Formular_V_1_Gas_gesamt_norm").
	 * RefersToRange, ergebnis_darstellung_ausgabe) Call
	 * stc_einfaerben(Application.Names("Formular_m_1_Gas").RefersToRange,
	 * ergebnis_darstellung_ausgabe) Call
	 * stc_einfaerben(Application.Names("Formular_m_1_Gas_rel").RefersToRange,
	 * ergebnis_darstellung_ausgabe) Call
	 * stc_einfaerben(Application.Names("Formular_m_1_Gas_gesamt").RefersToRange,
	 * ergebnis_darstellung_ausgabe) Call
	 * stc_einfaerben(Application.Names("Formular_Feuchte").RefersToRange,
	 * ergebnis_darstellung_ausgabe) Call
	 * stc_einfaerben(Application.Names("Formular_Psi").RefersToRange,
	 * ergebnis_darstellung_ausgabe) Call
	 * stc_einfaerben(Application.Names("Formular_p_SD_Dampf").RefersToRange,
	 * ergebnis_darstellung_ausgabe) Call
	 * stc_einfaerben(Application.Names("Formular_M_mol_mittel").RefersToRange,
	 * ergebnis_darstellung_ausgabe) End If Call
	 * stc_einfaerben(Application.Names("Formular_Gas").RefersToRange,
	 * ergebnis_darstellung_ausgabe) Call
	 * stc_einfaerben(Application.Names("Formular_V_1_Gas_rel").RefersToRange,
	 * ergebnis_darstellung_ausgabe) Else Call
	 * stc_einfaerben(Application.Names("Formular_Gas").RefersToRange,
	 * ergebnis_darstellung_eingabe) If stc_V_1_Gas_rel_gegeben Then Call
	 * stc_einfaerben(Application.Names("Formular_V_1_Gas_rel").RefersToRange,
	 * ergebnis_darstellung_eingabe_variabel) Else Call
	 * stc_einfaerben(Application.Names("Formular_V_1_Gas_rel").RefersToRange,
	 * ergebnis_darstellung_ausgabe) End If If stc_Berechnungsart = 1 Then If
	 * stc_V_1_Gas_gegeben Then If CheckBox_saettigen.Value = True Then Call
	 * stc_einfaerben(Application.Names("Formular_V_1_Gas").RefersToRange,
	 * ergebnis_darstellung_eingabe_variabel) Else Call
	 * stc_einfaerben(Application.Names("Formular_V_1_Gas").RefersToRange,
	 * ergebnis_darstellung_eingabe) End If Else Call
	 * stc_einfaerben(Application.Names("Formular_V_1_Gas").RefersToRange,
	 * ergebnis_darstellung_ausgabe) End If If stc_m_1_Gas_rel_gegeben Then Call
	 * stc_einfaerben(Application.Names("Formular_m_1_Gas_rel").RefersToRange,
	 * ergebnis_darstellung_eingabe_variabel) Else Call
	 * stc_einfaerben(Application.Names("Formular_m_1_Gas_rel").RefersToRange,
	 * ergebnis_darstellung_ausgabe) End If If stc_m_1_Gas_gegeben Then If
	 * CheckBox_saettigen.Value = True Then Call
	 * stc_einfaerben(Application.Names("Formular_m_1_Gas").RefersToRange,
	 * ergebnis_darstellung_eingabe_variabel) Else Call
	 * stc_einfaerben(Application.Names("Formular_m_1_Gas").RefersToRange,
	 * ergebnis_darstellung_eingabe) End If Else Call
	 * stc_einfaerben(Application.Names("Formular_m_1_Gas").RefersToRange,
	 * ergebnis_darstellung_ausgabe) End If If stc_V_1_Gas_gesamt_gegeben Then Call
	 * stc_einfaerben(Application.Names("Formular_V_1_Gas_gesamt").RefersToRange,
	 * ergebnis_darstellung_eingabe) Else Call
	 * stc_einfaerben(Application.Names("Formular_V_1_Gas_gesamt").RefersToRange,
	 * ergebnis_darstellung_ausgabe) End If If stc_m_1_Gas_gesamt_gegeben Then Call
	 * stc_einfaerben(Application.Names("Formular_m_1_Gas_gesamt").RefersToRange,
	 * ergebnis_darstellung_eingabe) Else Call
	 * stc_einfaerben(Application.Names("Formular_m_1_Gas_gesamt").RefersToRange,
	 * ergebnis_darstellung_ausgabe) End If Call
	 * stc_einfaerben(Application.Names("Formular_Feuchte").RefersToRange,
	 * ergebnis_darstellung_ausgabe) Call
	 * stc_einfaerben(Application.Names("Formular_Psi").RefersToRange,
	 * ergebnis_darstellung_ausgabe) Call
	 * stc_einfaerben(Application.Names("Formular_p_SD_Dampf").RefersToRange,
	 * ergebnis_darstellung_ausgabe) Call
	 * stc_einfaerben(Application.Names("Formular_M_mol_mittel").RefersToRange,
	 * ergebnis_darstellung_ausgabe) Call
	 * stc_einfaerben(Application.Names("Formular_V_1_Gas_gesamt_norm").
	 * RefersToRange, ergebnis_darstellung_ausgabe) ElseIf stc_Berechnungsart = 2
	 * Then If stc_V_1_Gas_gegeben Then Call
	 * stc_einfaerben(Application.Names("Formular_V_1_Gas").RefersToRange,
	 * ergebnis_darstellung_eingabe_variabel) Else Call
	 * stc_einfaerben(Application.Names("Formular_V_1_Gas").RefersToRange,
	 * ergebnis_darstellung_ausgabe) End If If stc_m_1_Gas_rel_gegeben Then Call
	 * stc_einfaerben(Application.Names("Formular_m_1_Gas_rel").RefersToRange,
	 * ergebnis_darstellung_eingabe_variabel) Else Call
	 * stc_einfaerben(Application.Names("Formular_m_1_Gas_rel").RefersToRange,
	 * ergebnis_darstellung_ausgabe) End If If stc_m_1_Gas_gegeben Then Call
	 * stc_einfaerben(Application.Names("Formular_m_1_Gas").RefersToRange,
	 * ergebnis_darstellung_eingabe_variabel) Else Call
	 * stc_einfaerben(Application.Names("Formular_m_1_Gas").RefersToRange,
	 * ergebnis_darstellung_ausgabe) End If If stc_V_1_Gas_gesamt_gegeben Then Call
	 * stc_einfaerben(Application.Names("Formular_V_1_Gas_gesamt").RefersToRange,
	 * ergebnis_darstellung_eingabe) Else Call
	 * stc_einfaerben(Application.Names("Formular_V_1_Gas_gesamt").RefersToRange,
	 * ergebnis_darstellung_ausgabe) Call
	 * stc_einfaerben(Application.Names("Formular_V_1_Gas_gesamt_norm").
	 * RefersToRange, ergebnis_darstellung_ausgabe) End If If
	 * stc_m_1_Gas_gesamt_gegeben Then Call
	 * stc_einfaerben(Application.Names("Formular_m_1_Gas_gesamt").RefersToRange,
	 * ergebnis_darstellung_eingabe) Else Call
	 * stc_einfaerben(Application.Names("Formular_m_1_Gas_gesamt").RefersToRange,
	 * ergebnis_darstellung_ausgabe) End If Call
	 * stc_einfaerben(Application.Names("Formular_Feuchte").RefersToRange,
	 * ergebnis_darstellung_ausgabe) Call
	 * stc_einfaerben(Application.Names("Formular_Psi").RefersToRange,
	 * ergebnis_darstellung_ausgabe) Call
	 * stc_einfaerben(Application.Names("Formular_p_SD_Dampf").RefersToRange,
	 * ergebnis_darstellung_ausgabe) Call
	 * stc_einfaerben(Application.Names("Formular_M_mol_mittel").RefersToRange,
	 * ergebnis_darstellung_ausgabe)
	 * 
	 * 
	 * Call
	 * stc_einfaerben(Application.Names("Formular_V_1_Gas_gesamt").RefersToRange,
	 * ergebnis_darstellung_ausgabe) Call
	 * stc_einfaerben(Application.Names("Formular_V_1_Gas_gesamt_norm").
	 * RefersToRange, ergebnis_darstellung_ausgabe) End If End If End If End If
	 * 
	 * stc_Berechnungsart_alt = stc_Berechnungsart stc_Ergebnis_alt = stc_Ergebnis
	 * 
	 * End Sub
	 */
    
    public static void stc_new_mark()
    {
    	
    }
    
    
	/*
	 * Sub Manuelle_Stoffdaten_uebertragen()
	 * 
	 * manual_M_mol_BF = Application.Names("Formular_Manual_M_mol_BF").RefersToRange
	 * manual_p_SD_BF_T_1 =
	 * Application.Names("Formular_Manual_p_SD_BF_T_1").RefersToRange
	 * manual_p_SD_BF_T_2 =
	 * Application.Names("Formular_Manual_p_SD_BF_T_2").RefersToRange
	 * manual_p_SD_BF_T_BF =
	 * Application.Names("Formular_Manual_p_SD_BF_T_BF").RefersToRange manual_c_BF =
	 * Application.Names("Formular_Manual_c_BF").RefersToRange manual_r_BF =
	 * Application.Names("Formular_Manual_r_BF").RefersToRange manual_rho_BF =
	 * Application.Names("Formular_Manual_rho_BF").RefersToRange manual_ny_BF =
	 * Application.Names("Formular_Manual_ny_BF").RefersToRange
	 * 
	 * manual_M_mol_Gas(1) =
	 * Application.Names("Formular_Manual_Gas_1_M_mol").RefersToRange
	 * manual_p_SD_Gas_T_1(1) =
	 * Application.Names("Formular_Manual_Gas_1_p_SD_Gas_T_1").RefersToRange
	 * manual_p_SD_Gas_T_2(1) =
	 * Application.Names("Formular_Manual_Gas_1_p_SD_Gas_T_2").RefersToRange
	 * manual_p_SD_Gas_T_BF(1) =
	 * Application.Names("Formular_Manual_Gas_1_p_SD_Gas_T_BF").RefersToRange
	 * manual_cp_Gas(1) =
	 * Application.Names("Formular_Manual_Gas_1_cp_Gas").RefersToRange
	 * manual_r_Gas(1) =
	 * Application.Names("Formular_Manual_Gas_1_r_Gas").RefersToRange manual_Loes(1)
	 * = Application.Names("Formular_Manual_Gas_1_Loes").RefersToRange
	 * 
	 * manual_M_mol_Gas(2) =
	 * Application.Names("Formular_Manual_Gas_2_M_mol").RefersToRange
	 * manual_p_SD_Gas_T_1(2) =
	 * Application.Names("Formular_Manual_Gas_2_p_SD_Gas_T_1").RefersToRange
	 * manual_p_SD_Gas_T_2(2) =
	 * Application.Names("Formular_Manual_Gas_2_p_SD_Gas_T_2").RefersToRange
	 * manual_p_SD_Gas_T_BF(2) =
	 * Application.Names("Formular_Manual_Gas_2_p_SD_Gas_T_BF").RefersToRange
	 * manual_cp_Gas(2) =
	 * Application.Names("Formular_Manual_Gas_2_cp_Gas").RefersToRange
	 * manual_r_Gas(2) =
	 * Application.Names("Formular_Manual_Gas_2_r_Gas").RefersToRange manual_Loes(2)
	 * = Application.Names("Formular_Manual_Gas_2_Loes").RefersToRange
	 * 
	 * End Sub
	 */
    //Sub Manuelle_Stoffdaten_uebertragen()
    public static void manual_substance_data_transferred()

    {
    	
    }

    //Gasstrom_Eingabe_read
    //Gasstrom_Eingabe_read                                                                                                                         
                                                                                                                                                                 
	 


	public static void readGasFlowInputs(double gas, double v_1_Gas, double v_1_Gas_rel, double m_1_Gas,
			double m_1_Gas_rel, double v_1_Gas_gesamt, double m_1_Gas_gesamt) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	
	/*
	 * Sub Manuelle_Stoffdaten_uebertragen()
	 * 
	 * manual_M_mol_BF = Application.Names("Formular_Manual_M_mol_BF").RefersToRange
	 * manual_p_SD_BF_T_1 =
	 * Application.Names("Formular_Manual_p_SD_BF_T_1").RefersToRange
	 * manual_p_SD_BF_T_2 =
	 * Application.Names("Formular_Manual_p_SD_BF_T_2").RefersToRange
	 * manual_p_SD_BF_T_BF =
	 * Application.Names("Formular_Manual_p_SD_BF_T_BF").RefersToRange manual_c_BF =
	 * Application.Names("Formular_Manual_c_BF").RefersToRange manual_r_BF =
	 * Application.Names("Formular_Manual_r_BF").RefersToRange manual_rho_BF =
	 * Application.Names("Formular_Manual_rho_BF").RefersToRange manual_ny_BF =
	 * Application.Names("Formular_Manual_ny_BF").RefersToRange
	 * 
	 * manual_M_mol_Gas(1) =
	 * Application.Names("Formular_Manual_Gas_1_M_mol").RefersToRange
	 * manual_p_SD_Gas_T_1(1) =
	 * Application.Names("Formular_Manual_Gas_1_p_SD_Gas_T_1").RefersToRange
	 * manual_p_SD_Gas_T_2(1) =
	 * Application.Names("Formular_Manual_Gas_1_p_SD_Gas_T_2").RefersToRange
	 * manual_p_SD_Gas_T_BF(1) =
	 * Application.Names("Formular_Manual_Gas_1_p_SD_Gas_T_BF").RefersToRange
	 * manual_cp_Gas(1) =
	 * Application.Names("Formular_Manual_Gas_1_cp_Gas").RefersToRange
	 * manual_r_Gas(1) =
	 * Application.Names("Formular_Manual_Gas_1_r_Gas").RefersToRange manual_Loes(1)
	 * = Application.Names("Formular_Manual_Gas_1_Loes").RefersToRange
	 * 
	 * manual_M_mol_Gas(2) =
	 * Application.Names("Formular_Manual_Gas_2_M_mol").RefersToRange
	 * manual_p_SD_Gas_T_1(2) =
	 * Application.Names("Formular_Manual_Gas_2_p_SD_Gas_T_1").RefersToRange
	 * manual_p_SD_Gas_T_2(2) =
	 * Application.Names("Formular_Manual_Gas_2_p_SD_Gas_T_2").RefersToRange
	 * manual_p_SD_Gas_T_BF(2) =
	 * Application.Names("Formular_Manual_Gas_2_p_SD_Gas_T_BF").RefersToRange
	 * manual_cp_Gas(2) =
	 * Application.Names("Formular_Manual_Gas_2_cp_Gas").RefersToRange
	 * manual_r_Gas(2) =
	 * Application.Names("Formular_Manual_Gas_2_r_Gas").RefersToRange manual_Loes(2)
	 * = Application.Names("Formular_Manual_Gas_2_Loes").RefersToRange
	 * 
	 * End Sub
	 */
	
	
	
	 //Umrechnung_Gasstroeme
		/*
		 * Public Sub Umrechnung_Gasstroeme(Fehler As Fehlercodetyp, V_1_Gas_gesamt,
		 * V_1_Gas, V_1_Gas_rel, m_1_Gas_gesamt, m_1_Gas, _ m_1_Gas_rel, p_1, T_1, T_BF,
		 * Gas, Ber_Grp, p_SD_Dampf, Psi, Ist_Dampf, p_SD_Gas_T_1, _ p_SD_Gas_T_BF,
		 * V_1_inert_rel_ges, Rel_Feuchte, p_2, saettigen, BF, M_mol_mittel,
		 * V_1_Gas_gesamt_norm)
		 * 
		 * '
		 * -----------------------------------------------------------------------------
		 * ------------------ ' Diese Funktion berechnet anhand der gegebenen relativen
		 * oder Absoluten Volumenströme oder ' Massenströme die jeweils fehlenden Größen
		 * am Ansaugstutzen aus. Außerdem wird ein ' Gemisch-Sättigungsdampfdruck sowie
		 * ein Gemisch-Sättigungsgrad berechnet ' ' Ein- und Ausgabeparameter ' Fehler '
		 * ' V_1_Gas_gesamt Gesamt-Gasvolumenstrom am Saugstutzen [m³/h] ' V_1_Gas
		 * Einzel-Gasvolumenströme (als Array) [m³/h] ' V_1_Gas_rel
		 * Einzel-Gasvolumenströme bezogen auf V_1_Gas_gesamt (als Array) [-] '
		 * m_1_Gas_gesamt Gesamt-Gasmassenstrom am Saugstutzen [kg/h] ' m_1_Gas
		 * Einzel-Gasmassenströme (als Array) [kg/h] ' m_1_Gas_rel
		 * Einzel-Gasmassenströme bezogen auf m_1_Gas_gesamt (als Array) [-] ' ' '
		 * Eingabgeparameter ' p_1 Ansaugdruck [mbar] ' T_1 Gastemperatur am Saugstutzen
		 * [°C] ' T_BF Temperatur der Betriebsflüssigkeit [°C] ' Gas Stoff-IDs der Gase
		 * (als Array) ' Ber_Grp Nutzer-Berechtigungsgruppe für Stoffdaten [-] ' p_2
		 * Verdichtungsdruck [mbar] ' saettigen Boolean-Variable, fall TRUE, werden die
		 * Dampf-/Inertgaskomponenten so geändert, ' dass der Ansaugstrom gesättigt ist
		 * ' BF Stoff_ID der Betriebsflüssigkeit
		 * 
		 * ' Ausgabgeparameter ' Psi Gemisch-Sättigungsgrad, der für die Korrekturformel
		 * lambda_2 maßgeblich ist (0...1) [-] ' p_SD_Dampf
		 * Gemisch-Sättigungsdampfdruck, der für die Korrekturformel lambda_2 maßgeblich
		 * ist [mbar] ' Ist_Dampf Boolean-Array, True für Gaskomponenten, die als Dampf
		 * gewertet werden ' p_SD_Gas_T_1 Sättigungsdampfdruck der Gaskomponenten bei
		 * T_1 [mbar] ' p_SD_Gas_T_BF Sättigungsdampfdruck der Gaskomponenten bei T_BF
		 * [mbar] ' V_1_inert_rel_ges Summe der relativen Inertgasvolumenströme '
		 * Rel_Feuchte Relative Feuchte des Dampfgemischs [-] ' M_mol_mittel Mittleres
		 * Molekulargewicht [g/mol] ' V_1_Gas_gesamt_norm Normierter
		 * Gesamt-Gasvolumenstrom am Saugstutzen [Nm³/h] (Normatmosphäre 1013mbar, 0°C)
		 * '
		 * -----------------------------------------------------------------------------
		 * ------------------
		 * 
		 * Dim cp_Gas, r_Gas, M_mol, rho_1 ' Wärmekapazität, Verdampfungswärme, Molare
		 * Masse und Dichte der Gaskomponenten Dim p_SD_Dampf_T_1, p_SD_Dampf_T_BF '
		 * Gemisch-Sättigigungsdampfdruck bei T_1 bzw. T_BF [mbar]
		 * 
		 * Dim Anzahl_Gase As Integer Dim Anzahl_Daempfe As Integer Dim Anzahl_Inerte As
		 * Integer Dim Einzel_Volumenstroeme_gegeben As Boolean Dim
		 * Einzel_Massenstroeme_gegeben As Boolean Dim Gesamt_Volumenstrom_gegeben As
		 * Boolean Dim Gesamt_Massenstrom_gegeben As Boolean
		 * 
		 * Dim V_1_Dampf_rel, V_1_inert_rel ' Dampf- bzw. Inertgasvolumenströme bezogen
		 * auf den Gesamtvolumenstrom (als Array) Dim V_1_Dampf_rel_ges,
		 * V_1_Dampf_rel_ges_neu ' Summe der relativen Dampf- und Inertgasvolumenströme
		 * Dim V_1_inert_rel_ges_neu
		 * 
		 * Dim V_1_Gas_rel_gesamt, m_1_Gas_rel_gesamt Dim m_1_Dampf_rel_ges,
		 * m_1_Dampf_rel_ges_neu Dim m_1_inert_rel_ges, m_1_inert_rel_ges_neu
		 * 
		 * Dim phi Dim p_SD_BF_T_BF
		 * 
		 * Dim a As Double Dim i As Integer, i_Dampf As Integer
		 * 
		 * ' Leere Variablen mit Standardwerten belegen If IsEmpty(p_1) Then p_1 = 1013
		 * If IsEmpty(p_2) Then p_2 = 1013 If IsEmpty(T_1) Then T_1 = 20 If
		 * IsEmpty(T_BF) Then T_BF = 15
		 * 
		 * M_mol_mittel = Empty
		 * 
		 * If IsEmpty(Gas) Or IsEmpty(BF) Then V_1_Gas_gesamt = Empty V_1_Gas = Empty
		 * V_1_Gas_rel = Empty m_1_Gas_gesamt = Empty m_1_Gas = Empty m_1_Gas_rel =
		 * Empty If IsEmpty(Gas) Then Call Fehlercode_zufuegen(Fehler, 233) If
		 * IsEmpty(BF) Then Call Fehlercode_zufuegen(Fehler, 232) Fehler.Abbruch = True
		 * Exit Sub End If
		 * 
		 * Psi = Empty Rel_Feuchte = Empty V_1_inert_rel_ges = Empty
		 * 
		 * Call Pruefung_Eingabeparameter(Fehler, Empty, p_1, p_2, T_1, T_BF, Empty,
		 * Empty, Empty, Empty, Empty, Ber_Grp, Empty, Empty) If Not IsArray(Gas) Then
		 * Call Fehlercode_zufuegen(Fehler, 214, "Gas") Fehler.Abbruch = True End If If
		 * Not IsEmpty(saettigen) Then If VarType(saettigen) <> vbBoolean Then Call
		 * Fehlercode_zufuegen(Fehler, 214, "saettigen") Fehler.Abbruch = True End If
		 * End If
		 * 
		 * If Not IsEmpty(V_1_Gas_gesamt) Then If IsNumeric(V_1_Gas_gesamt) Then If
		 * V_1_Gas_gesamt < 0 Then Call Fehlercode_zufuegen(Fehler, 222) Fehler.Abbruch
		 * = True End If Else Call Fehlercode_zufuegen(Fehler, 214, "V_1_Gas_gesamt")
		 * Fehler.Abbruch = True End If End If If Not IsEmpty(m_1_Gas_gesamt) Then If
		 * IsNumeric(m_1_Gas_gesamt) Then If m_1_Gas_gesamt < 0 Then Call
		 * Fehlercode_zufuegen(Fehler, 222) Fehler.Abbruch = True End If Else Call
		 * Fehlercode_zufuegen(Fehler, 214, "m_1_Gas_gesamt") Fehler.Abbruch = True End
		 * If End If
		 * 
		 * If Fehler.Abbruch Then Exit Sub
		 * 
		 * Anzahl_Gase = UBound(Gas) - LBound(Gas) + 1
		 * 
		 * ' Stoffgrößen ermitteln Call Stoffdaten_ist_Gas(Fehler, Gas, T_1, Empty,
		 * T_BF, Ber_Grp, p_SD_Gas_T_1, Empty, p_SD_Gas_T_BF, cp_Gas, r_Gas, M_mol) Call
		 * Stoffdaten_ist_BF(Fehler, BF, T_1, Empty, T_BF, Ber_Grp, Empty, Empty,
		 * p_SD_BF_T_BF, Empty, Empty, Empty, Empty, Empty)
		 * 
		 * If Fehler.Abbruch Then Exit Sub
		 * 
		 * If IsEmpty(p_SD_BF_T_BF) Then Call Fehlercode_zufuegen(Fehler, 376)
		 * Fehler.Abbruch = True End If
		 * 
		 * If p_SD_BF_T_BF > p_1 Then Call Fehlercode_zufuegen(Fehler, 372)
		 * Fehler.Abbruch = True ElseIf p_SD_BF_T_BF + 15 >= p_1 Then Call
		 * Fehlercode_zufuegen(Fehler, 374) End If
		 * 
		 * If Fehler.Abbruch Then Exit Sub
		 * 
		 * ' Massendichte der Gaskomponenten bezogen auf T_1 und p_1 berechnen ReDim
		 * rho_1(LBound(Gas) To UBound(Gas)) For i = LBound(Gas) To UBound(Gas) rho_1(i)
		 * = p_1 / (R_uni / M_mol(i) * (T_1 + 273.15) * 10) Next i
		 * 
		 * ' Komplementäre Stoffvolumen- und massenströme berechnen If Not
		 * IsEmpty(V_1_Gas) Then ' Wenn Einzel-Gasvolumenströme gegeben sind ... If Not
		 * (IsEmpty(V_1_Gas_gesamt) And IsEmpty(V_1_Gas_rel) And IsEmpty(m_1_Gas_gesamt)
		 * _ And IsEmpty(m_1_Gas) And IsEmpty(m_1_Gas_rel)) Then Call
		 * Fehlercode_zufuegen(Fehler, 208) Fehler.Abbruch = True End If If
		 * IsArray(V_1_Gas) Then If LBound(V_1_Gas) <> LBound(Gas) Or UBound(V_1_Gas) <>
		 * UBound(Gas) Then Call Fehlercode_zufuegen(Fehler, 214, "V_1_Gas")
		 * Fehler.Abbruch = True End If Else Call Fehlercode_zufuegen(Fehler, 214,
		 * "V_1_Gas") Fehler.Abbruch = True End If If Fehler.Abbruch Then Exit Sub
		 * 
		 * Einzel_Volumenstroeme_gegeben = True
		 * 
		 * ReDim V_1_Gas_rel(LBound(Gas) To UBound(Gas)) ReDim m_1_Gas(LBound(Gas) To
		 * UBound(Gas)) ReDim m_1_Gas_rel(LBound(Gas) To UBound(Gas))
		 * 
		 * For i = LBound(Gas) To UBound(Gas) If (Not IsNumeric(V_1_Gas(i))) Or
		 * V_1_Gas(i) < 0 Then Call Fehlercode_zufuegen(Fehler, 222) Fehler.Abbruch =
		 * True Exit Sub End If m_1_Gas(i) = V_1_Gas(i) * rho_1(i) Next i V_1_Gas_gesamt
		 * = 0 m_1_Gas_gesamt = 0 For i = LBound(Gas) To UBound(Gas) V_1_Gas_gesamt =
		 * V_1_Gas_gesamt + V_1_Gas(i) m_1_Gas_gesamt = m_1_Gas_gesamt + m_1_Gas(i) Next
		 * i
		 * 
		 * If V_1_Gas_gesamt > 0 Then For i = LBound(Gas) To UBound(Gas) V_1_Gas_rel(i)
		 * = V_1_Gas(i) / V_1_Gas_gesamt m_1_Gas_rel(i) = m_1_Gas(i) / m_1_Gas_gesamt
		 * Next i Else For i = LBound(Gas) To UBound(Gas) V_1_Gas_rel(i) = 1 /
		 * Anzahl_Gase Next i a = 0 For i = LBound(Gas) To UBound(Gas) a = a + rho_1(i)
		 * * V_1_Gas_rel(i) Next i For i = LBound(Gas) To UBound(Gas) m_1_Gas_rel(i) =
		 * V_1_Gas_rel(i) * rho_1(i) / a Next i End If
		 * 
		 * 
		 * ElseIf Not IsEmpty(m_1_Gas) Then ' Wenn Einzel-Gasmassenströme gegeben sind
		 * ... If Not (IsEmpty(V_1_Gas) And IsEmpty(V_1_Gas_gesamt) And
		 * IsEmpty(V_1_Gas_rel) _ And IsEmpty(m_1_Gas_gesamt) And IsEmpty(m_1_Gas_rel))
		 * Then Call Fehlercode_zufuegen(Fehler, 208) Fehler.Abbruch = True End If If
		 * IsArray(m_1_Gas) Then If LBound(m_1_Gas) <> LBound(Gas) Or UBound(m_1_Gas) <>
		 * UBound(Gas) Then Call Fehlercode_zufuegen(Fehler, 214, "m_1_Gas")
		 * Fehler.Abbruch = True End If Else Call Fehlercode_zufuegen(Fehler, 214,
		 * "m_1_Gas") Fehler.Abbruch = True End If If Fehler.Abbruch Then Exit Sub
		 * 
		 * Einzel_Massenstroeme_gegeben = True
		 * 
		 * ReDim V_1_Gas(LBound(Gas) To UBound(Gas)) ReDim V_1_Gas_rel(LBound(Gas) To
		 * UBound(Gas)) ReDim m_1_Gas_rel(LBound(Gas) To UBound(Gas))
		 * 
		 * For i = LBound(Gas) To UBound(Gas) If (Not IsNumeric(m_1_Gas(i))) Or
		 * m_1_Gas(i) < 0 Then Call Fehlercode_zufuegen(Fehler, 222) Fehler.Abbruch =
		 * True Exit Sub End If V_1_Gas(i) = m_1_Gas(i) / rho_1(i) Next i V_1_Gas_gesamt
		 * = 0 m_1_Gas_gesamt = 0 For i = LBound(Gas) To UBound(Gas) V_1_Gas_gesamt =
		 * V_1_Gas_gesamt + V_1_Gas(i) m_1_Gas_gesamt = m_1_Gas_gesamt + m_1_Gas(i) Next
		 * i
		 * 
		 * If V_1_Gas_gesamt > 0 Then For i = LBound(Gas) To UBound(Gas) V_1_Gas_rel(i)
		 * = V_1_Gas(i) / V_1_Gas_gesamt m_1_Gas_rel(i) = m_1_Gas(i) / m_1_Gas_gesamt
		 * Next i Else For i = LBound(Gas) To UBound(Gas) V_1_Gas_rel(i) = 1 /
		 * Anzahl_Gase Next i a = 0 For i = LBound(Gas) To UBound(Gas) a = a + rho_1(i)
		 * * V_1_Gas_rel(i) Next i For i = LBound(Gas) To UBound(Gas) m_1_Gas_rel(i) =
		 * V_1_Gas_rel(i) * rho_1(i) / a Next i End If
		 * 
		 * ElseIf Not IsEmpty(V_1_Gas_rel) Then ' Wenn relative Gasvolumenströme gegeben
		 * sind ... If Not (IsEmpty(V_1_Gas) And IsEmpty(m_1_Gas) _ And
		 * (IsEmpty(m_1_Gas_gesamt) Or IsEmpty(V_1_Gas_gesamt)) And
		 * IsEmpty(m_1_Gas_rel)) Then Call Fehlercode_zufuegen(Fehler, 208)
		 * Fehler.Abbruch = True End If If IsArray(V_1_Gas_rel) Then If
		 * LBound(V_1_Gas_rel) <> LBound(Gas) Or UBound(V_1_Gas_rel) <> UBound(Gas) Then
		 * Call Fehlercode_zufuegen(Fehler, 214, "V_1_Gas_rel") Fehler.Abbruch = True
		 * End If Else Call Fehlercode_zufuegen(Fehler, 214, "V_1_Gas_rel")
		 * Fehler.Abbruch = True End If If Fehler.Abbruch Then Exit Sub
		 * 
		 * ' Sorge dafür, dass Summe aller relativen Gasvolumenströme 1 ergibt
		 * 
		 * For i = LBound(Gas) To UBound(Gas) If (Not IsNumeric(V_1_Gas_rel(i))) Or
		 * V_1_Gas_rel(i) < 0 Then Call Fehlercode_zufuegen(Fehler, 222) Fehler.Abbruch
		 * = True Exit Sub End If V_1_Gas_rel_gesamt = V_1_Gas_rel_gesamt +
		 * V_1_Gas_rel(i) Next i
		 * 
		 * If V_1_Gas_rel_gesamt = 0 Then For i = LBound(Gas) To UBound(Gas)
		 * V_1_Gas_rel(i) = 1 / Anzahl_Gase Next i Else For i = LBound(Gas) To
		 * UBound(Gas) V_1_Gas_rel(i) = V_1_Gas_rel(i) / V_1_Gas_rel_gesamt Next i End
		 * If
		 * 
		 * ReDim m_1_Gas_rel(LBound(Gas) To UBound(Gas))
		 * 
		 * a = 0 For i = LBound(Gas) To UBound(Gas) a = a + rho_1(i) * V_1_Gas_rel(i)
		 * Next i
		 * 
		 * For i = LBound(Gas) To UBound(Gas) m_1_Gas_rel(i) = V_1_Gas_rel(i) * rho_1(i)
		 * / a Next i
		 * 
		 * If Not IsEmpty(V_1_Gas_gesamt) Then ' Wenn zusätzlich Gesamt-Gasvolumenstrom
		 * gegeben ist Gesamt_Volumenstrom_gegeben = True m_1_Gas_gesamt = 0
		 * 
		 * ReDim V_1_Gas(LBound(Gas) To UBound(Gas)) ReDim m_1_Gas(LBound(Gas) To
		 * UBound(Gas))
		 * 
		 * For i = LBound(Gas) To UBound(Gas) V_1_Gas(i) = V_1_Gas_gesamt *
		 * V_1_Gas_rel(i) m_1_Gas(i) = V_1_Gas(i) * rho_1(i) m_1_Gas_gesamt =
		 * m_1_Gas_gesamt + m_1_Gas(i) Next i ElseIf Not IsEmpty(m_1_Gas_gesamt) Then '
		 * Wenn zusätzlich Gesamt-Gasmassenstrom gegeben ist Gesamt_Massenstrom_gegeben
		 * = True V_1_Gas_gesamt = 0
		 * 
		 * ReDim V_1_Gas(LBound(Gas) To UBound(Gas)) ReDim m_1_Gas(LBound(Gas) To
		 * UBound(Gas))
		 * 
		 * For i = LBound(Gas) To UBound(Gas) m_1_Gas(i) = m_1_Gas_gesamt *
		 * m_1_Gas_rel(i) V_1_Gas(i) = m_1_Gas(i) / rho_1(i) V_1_Gas_gesamt =
		 * V_1_Gas_gesamt + V_1_Gas(i) Next i End If
		 * 
		 * ElseIf Not IsEmpty(m_1_Gas_rel) Then ' Wenn relative Gasmassenströme gegeben
		 * sind ... If Not (IsEmpty(V_1_Gas) And IsEmpty(V_1_Gas_rel) _ And
		 * (IsEmpty(V_1_Gas_gesamt) Or IsEmpty(m_1_Gas_gesamt)) And IsEmpty(m_1_Gas))
		 * Then Call Fehlercode_zufuegen(Fehler, 208) Fehler.Abbruch = True End If If
		 * IsArray(m_1_Gas_rel) Then If LBound(m_1_Gas_rel) <> LBound(Gas) Or
		 * UBound(m_1_Gas_rel) <> UBound(Gas) Then Call Fehlercode_zufuegen(Fehler, 214,
		 * "m_1_Gas_rel") Fehler.Abbruch = True End If Else Call
		 * Fehlercode_zufuegen(Fehler, 214, "m_1_Gas_rel") Fehler.Abbruch = True End If
		 * If Fehler.Abbruch Then Exit Sub
		 * 
		 * ' Sorge dafür, dass Summe aller relativen Gasmassenströme 1 ergibt
		 * 
		 * For i = LBound(Gas) To UBound(Gas) If (Not IsNumeric(m_1_Gas_rel(i))) Or
		 * m_1_Gas_rel(i) < 0 Then Call Fehlercode_zufuegen(Fehler, 222) Fehler.Abbruch
		 * = True Exit Sub End If m_1_Gas_rel_gesamt = m_1_Gas_rel_gesamt +
		 * m_1_Gas_rel(i) Next i
		 * 
		 * If m_1_Gas_rel_gesamt = 0 Then For i = LBound(Gas) To UBound(Gas)
		 * m_1_Gas_rel(i) = 1 / Anzahl_Gase Next i Else For i = LBound(Gas) To
		 * UBound(Gas) m_1_Gas_rel(i) = m_1_Gas_rel(i) / m_1_Gas_rel_gesamt Next i End
		 * If
		 * 
		 * ReDim V_1_Gas_rel(LBound(Gas) To UBound(Gas))
		 * 
		 * a = 0 For i = LBound(Gas) To UBound(Gas) a = a + m_1_Gas_rel(i) / rho_1(i)
		 * Next i
		 * 
		 * For i = LBound(Gas) To UBound(Gas) V_1_Gas_rel(i) = m_1_Gas_rel(i) /
		 * (rho_1(i) * a) Next i
		 * 
		 * If Not IsEmpty(V_1_Gas_gesamt) Then ' Wenn zusätzlich Gesamt-Gasvolumenstrom
		 * gegeben ist Gesamt_Volumenstrom_gegeben = True m_1_Gas_gesamt = 0
		 * 
		 * ReDim V_1_Gas(LBound(Gas) To UBound(Gas)) ReDim m_1_Gas(LBound(Gas) To
		 * UBound(Gas))
		 * 
		 * For i = LBound(Gas) To UBound(Gas) V_1_Gas(i) = V_1_Gas_gesamt *
		 * V_1_Gas_rel(i) m_1_Gas(i) = V_1_Gas(i) * rho_1(i) m_1_Gas_gesamt =
		 * m_1_Gas_gesamt + m_1_Gas(i) Next i ElseIf Not IsEmpty(m_1_Gas_gesamt) Then '
		 * Wenn zusätzlich Gesamt-Gasmassenstrom gegeben ist Gesamt_Massenstrom_gegeben
		 * = True V_1_Gas_gesamt = 0 ReDim V_1_Gas(LBound(Gas) To UBound(Gas)) ReDim
		 * m_1_Gas(LBound(Gas) To UBound(Gas))
		 * 
		 * For i = LBound(Gas) To UBound(Gas) m_1_Gas(i) = m_1_Gas_gesamt *
		 * m_1_Gas_rel(i) V_1_Gas(i) = m_1_Gas(i) / rho_1(i) V_1_Gas_gesamt =
		 * V_1_Gas_gesamt + V_1_Gas(i) Next i End If
		 * 
		 * Else ' Wenn gar keine Einzel-Mengenströme angegeben sind ... ReDim
		 * V_1_Gas_rel(LBound(Gas) To UBound(Gas)) ReDim m_1_Gas_rel(LBound(Gas) To
		 * UBound(Gas)) a = 0 For i = LBound(Gas) To UBound(Gas) V_1_Gas_rel(i) = 1 /
		 * Anzahl_Gase a = a + rho_1(i) * V_1_Gas_rel(i) Next i For i = LBound(Gas) To
		 * UBound(Gas) m_1_Gas_rel(i) = V_1_Gas_rel(i) * rho_1(i) / a Next i
		 * 
		 * If Not IsEmpty(V_1_Gas_gesamt) Then ' Wenn zusätzlich Gesamt-Gasvolumenstrom
		 * gegeben ist Gesamt_Volumenstrom_gegeben = True m_1_Gas_gesamt = 0
		 * 
		 * ReDim V_1_Gas(LBound(Gas) To UBound(Gas)) ReDim m_1_Gas(LBound(Gas) To
		 * UBound(Gas))
		 * 
		 * For i = LBound(Gas) To UBound(Gas) V_1_Gas(i) = V_1_Gas_gesamt *
		 * V_1_Gas_rel(i) m_1_Gas(i) = V_1_Gas(i) * rho_1(i) m_1_Gas_gesamt =
		 * m_1_Gas_gesamt + m_1_Gas(i) Next i ElseIf Not IsEmpty(m_1_Gas_gesamt) Then '
		 * Wenn zusätzlich Gesamt-Gasmassenstrom gegeben ist Gesamt_Massenstrom_gegeben
		 * = True V_1_Gas_gesamt = 0
		 * 
		 * ReDim V_1_Gas(LBound(Gas) To UBound(Gas)) ReDim m_1_Gas(LBound(Gas) To
		 * UBound(Gas))
		 * 
		 * For i = LBound(Gas) To UBound(Gas) m_1_Gas(i) = m_1_Gas_gesamt *
		 * m_1_Gas_rel(i) V_1_Gas(i) = m_1_Gas(i) / rho_1(i) V_1_Gas_gesamt =
		 * V_1_Gas_gesamt + V_1_Gas(i) Next i End If
		 * 
		 * End If
		 * 
		 * ' Ermittlung der kondensierbaren Gaskomponenten (= Dämpfe) ' Das sind die
		 * Gase, deren Sättigungsdampfdruck bei T_BF kleiner ist als p_1
		 * 
		 * ReDim Ist_Dampf(LBound(Gas) To UBound(Gas)) As Boolean ReDim
		 * V_1_Dampf_rel(LBound(Gas) To UBound(Gas)) As Double ReDim
		 * V_1_inert_rel(LBound(Gas) To UBound(Gas)) As Double V_1_Dampf_rel_ges = 0
		 * V_1_inert_rel_ges = 0
		 * 
		 * For i = LBound(Gas) To UBound(Gas) If p_SD_Gas_T_BF(i) <= 0 Or
		 * p_SD_Gas_T_1(i) <= 0 Then Call Fehlercode_zufuegen(Fehler, 231, i)
		 * Fehler.Abbruch = True Exit Sub End If If p_SD_Gas_T_BF(i) < p_1 Then
		 * Ist_Dampf(i) = True Anzahl_Daempfe = Anzahl_Daempfe + 1 V_1_Dampf_rel(i) =
		 * V_1_Gas_rel(i) V_1_Dampf_rel_ges = V_1_Dampf_rel_ges + V_1_Dampf_rel(i) Else
		 * Ist_Dampf(i) = False Anzahl_Inerte = Anzahl_Inerte + 1 V_1_inert_rel(i) =
		 * V_1_Gas_rel(i) V_1_inert_rel_ges = V_1_inert_rel_ges + V_1_inert_rel(i) End
		 * If Next i
		 * 
		 * If saettigen = True Then ' Wenn also das Gemisch zu sättigen ist If
		 * Anzahl_Daempfe = 0 Then Call Fehlercode_zufuegen(Fehler, 211) Fehler.Abbruch
		 * = True Exit Sub ElseIf Anzahl_Inerte = 0 Then Call
		 * Fehlercode_zufuegen(Fehler, 212) Fehler.Abbruch = True Exit Sub End If
		 * 
		 * For i_Dampf = LBound(Gas) To UBound(Gas) If Ist_Dampf(i_Dampf) Then Exit For
		 * Next i_Dampf
		 * 
		 * 'Die i_Dampf Komponente ist der erste Dampf des Gasmixes und wird maximal
		 * gesättigt
		 * 
		 * If p_SD_Gas_T_1(i_Dampf) >= p_1 Then 'kann nicht gesättigt werden Call
		 * Fehlercode_zufuegen(Fehler, 236, i_Dampf) Fehler.Abbruch = True Exit Sub End
		 * If
		 * 
		 * If V_1_inert_rel_ges = 0 Then ' Wenn zwar Stoffe als Inerte vorhanden sind,
		 * aber dafür keine Stoffmengenströme vorgegeben wurde, ' werden die
		 * Stoffverteilung pauschal auf 1/2 Dämpfe und 1/2 Inerte verteilt, um die
		 * weitere ' Berechnungen durchführen zu können V_1_Dampf_rel_ges = 0.5
		 * V_1_inert_rel_ges = 0.5 For i = LBound(Gas) To UBound(Gas) If Ist_Dampf(i)
		 * Then V_1_Dampf_rel(i) = 1 / 2 * V_1_Dampf_rel(i) V_1_Gas_rel(i) =
		 * V_1_Dampf_rel(i) Else V_1_inert_rel(i) = 1 / (2 * Anzahl_Inerte)
		 * V_1_Gas_rel(i) = V_1_inert_rel(i) End If Next i End If
		 * 
		 * a = 0 m_1_inert_rel_ges = 0 For i = LBound(Gas) To UBound(Gas) a = a +
		 * rho_1(i) * V_1_Gas_rel(i) If Not Ist_Dampf(i) Then m_1_inert_rel_ges =
		 * m_1_inert_rel_ges + rho_1(i) * V_1_inert_rel(i) End If Next i
		 * m_1_inert_rel_ges = m_1_inert_rel_ges / a
		 * 
		 * V_1_Dampf_rel(i_Dampf) = p_SD_Gas_T_1(i_Dampf) / p_1 V_1_Gas_rel(i_Dampf) =
		 * V_1_Dampf_rel(i_Dampf) V_1_Dampf_rel_ges = V_1_Dampf_rel(i_Dampf)
		 * V_1_inert_rel_ges_neu = 1 - V_1_Dampf_rel_ges
		 * 
		 * If (Anzahl_Daempfe > 1) And (i_Dampf < UBound(Gas)) Then ' Volumenströme
		 * weiterer Dämpfe mit 0 belegen Call Fehlercode_zufuegen(Fehler, 383, i_Dampf)
		 * For i = i_Dampf + 1 To UBound(Gas) If Ist_Dampf(i) Then V_1_Dampf_rel(i) = 0
		 * V_1_Gas_rel(i) = 0 End If Next i End If
		 * 
		 * For i = LBound(Gas) To UBound(Gas) ' Volumenströme der Inerte entsprechend
		 * des neu vergebenen Dampfvolumenstroms anpassen If Not Ist_Dampf(i) Then
		 * V_1_inert_rel(i) = V_1_inert_rel(i) * V_1_inert_rel_ges_neu /
		 * V_1_inert_rel_ges V_1_Gas_rel(i) = V_1_inert_rel(i) End If Next i
		 * 
		 * a = 0 For i = LBound(Gas) To UBound(Gas) a = a + rho_1(i) * V_1_Gas_rel(i)
		 * Next i For i = LBound(Gas) To UBound(Gas) m_1_Gas_rel(i) = rho_1(i) *
		 * V_1_Gas_rel(i) / a If Not Ist_Dampf(i) Then m_1_inert_rel_ges_neu =
		 * m_1_inert_rel_ges_neu + rho_1(i) * V_1_Gas_rel(i) End If Next i
		 * m_1_inert_rel_ges_neu = m_1_inert_rel_ges_neu / a
		 * 
		 * If Einzel_Volumenstroeme_gegeben Then V_1_Gas_gesamt = V_1_inert_rel_ges /
		 * V_1_inert_rel_ges_neu * V_1_Gas_gesamt m_1_Gas_gesamt = Empty m_1_Gas_rel =
		 * Empty ElseIf Einzel_Massenstroeme_gegeben Then V_1_Gas_gesamt = Empty
		 * V_1_Gas_rel = Empty m_1_Gas_gesamt = m_1_inert_rel_ges /
		 * m_1_inert_rel_ges_neu * m_1_Gas_gesamt ElseIf Gesamt_Volumenstrom_gegeben
		 * Then m_1_Gas_gesamt = Empty m_1_Gas_rel = Empty ElseIf
		 * Gesamt_Massenstrom_gegeben Then V_1_Gas_gesamt = Empty V_1_Gas_rel = Empty
		 * Else m_1_Gas_rel = Empty End If
		 * 
		 * V_1_Gas = Empty m_1_Gas = Empty
		 * 
		 * 'Rekursiver Aufruf Call Umrechnung_Gasstroeme(Fehler, V_1_Gas_gesamt,
		 * V_1_Gas, V_1_Gas_rel, m_1_Gas_gesamt, m_1_Gas, m_1_Gas_rel, p_1, T_1, T_BF,
		 * Gas, Ber_Grp, p_SD_Dampf, Psi, Empty, p_SD_Gas_T_1, p_SD_Gas_T_BF,
		 * V_1_inert_rel_ges, phi, p_2, False, BF, Empty, Empty) Rel_Feuchte = phi
		 * 
		 * Else If V_1_Dampf_rel_ges > 0 Then
		 * 
		 * p_SD_Dampf_T_1 = 0 p_SD_Dampf_T_BF = 0
		 * 
		 * For i = LBound(Gas) To UBound(Gas) If Ist_Dampf(i) Then phi = phi +
		 * V_1_Dampf_rel(i) * p_1 / p_SD_Gas_T_1(i) End If Next i
		 * 
		 * If V_1_inert_rel_ges > 0 Then V_1_Dampf_rel_ges_neu = 0 p_SD_Dampf_T_1 = 0
		 * p_SD_Dampf_T_BF = 0 For i = LBound(Gas) To UBound(Gas) If Ist_Dampf(i) Then
		 * p_SD_Dampf_T_1 = p_SD_Dampf_T_1 + V_1_Dampf_rel(i) / V_1_Dampf_rel_ges *
		 * p_SD_Gas_T_1(i) ' RAOULTsches Gesetz p_SD_Dampf_T_BF = p_SD_Dampf_T_BF +
		 * V_1_Dampf_rel(i) / V_1_Dampf_rel_ges * p_SD_Gas_T_BF(i) ' RAOULTsches Gesetz
		 * End If Next i
		 * 
		 * Else Call Fehlercode_zufuegen(Fehler, 320) End If
		 * 
		 * For i = LBound(Gas) To UBound(Gas) If Ist_Dampf(i) And p_SD_Gas_T_1(i) > p_1
		 * Then Call Fehlercode_zufuegen(Fehler, 375, i) Next i
		 * 
		 * ' Adaption an Jörgs Programm If p_SD_Dampf_T_1 >= p_1 Then If p_SD_Dampf_T_BF
		 * < p_1 Then p_SD_Dampf = p_SD_Dampf_T_BF Rel_Feuchte = 1 Psi = 1 Else ' Tritt
		 * das jemals auf? p_SD_Dampf = p_1 Rel_Feuchte = 0 Psi = 0 End If Else
		 * p_SD_Dampf = p_SD_Dampf_T_1 Rel_Feuchte = phi If phi <= 1.01 Then Psi = phi *
		 * (p_1 - p_SD_Dampf_T_1) / (p_1 - phi * p_SD_Dampf_T_1) End If If Rel_Feuchte >
		 * 1.01 Then Call Fehlercode_zufuegen(Fehler, 321) End If
		 * 
		 * End If End If
		 * 
		 * ' Mittleres Molekulargewicht bestimmen M_mol_mittel = Empty For i =
		 * LBound(Gas) To UBound(Gas) M_mol_mittel = M_mol_mittel + m_1_Gas_rel(i) /
		 * M_mol(i) Next i M_mol_mittel = 1 / M_mol_mittel
		 * 
		 * If Not IsEmpty(V_1_Gas_gesamt) Then V_1_Gas_gesamt_norm = V_1_Gas_gesamt *
		 * (273.15 / 1013.25) * p_1 / (T_1 + 273.15) Else V_1_Gas_gesamt_norm = Empty
		 * End If
		 * 
		 * Call Fehler_doppelt_entfernen(Fehler)
		 * 
		 * End Sub
		 */
public   static void conversion_gas_flows(ErrorCodeTable error, double v_1_Gas_gesamt, double v_1_Gas, double v_1_Gas_rel, double m_1_Gas_gesamt, double m_1_Gas, double m_1_Gas_rel, double p_1, double t_1, double t_BF, double gas, String berGrp, double p_SD_Dampf, double psi, double ist_Dampf, double p_SD_Gas_T_1, double p_SD_Gas_T_BF, Object object, double relativeHumidity, double p_2, boolean saturated, double bf, double m_mol_mittel, double v_1_Gas_gesamt_norm)
{
}


/*
 * Sub Gasstroeme_ausgeben(Gas, V_1_Gas, V_1_Gas_rel, m_1_Gas, m_1_Gas_rel,
 * V_1_Gas_gesamt, m_1_Gas_gesamt, Ist_Dampf, p_SD_Gas_T_BF, p_SD_Gas_T_1)
 * 
 * Dim i As Integer
 * 
 * If Not IsEmpty(V_1_Gas_rel) Then For i = 1 To UBound(Gas)
 * Application.Names("Formular_V_1_Gas_rel_" & CStr(i)).RefersToRange =
 * V_1_Gas_rel(i) Application.Names("Formular_m_1_Gas_rel_" &
 * CStr(i)).RefersToRange = m_1_Gas_rel(i)
 * Application.Names("Formular_Ist_Dampf_" & CStr(i)).RefersToRange =
 * Ist_Dampf(i) Application.Names("Formular_p_SD_Gas_T_BF_" &
 * CStr(i)).RefersToRange = p_SD_Gas_T_BF(i)
 * Application.Names("Formular_p_SD_Gas_T_1_" & CStr(i)).RefersToRange =
 * p_SD_Gas_T_1(i) If Not IsEmpty(V_1_Gas) Then
 * Application.Names("Formular_V_1_Gas_" & CStr(i)).RefersToRange = V_1_Gas(i)
 * Application.Names("Formular_m_1_Gas_" & CStr(i)).RefersToRange = m_1_Gas(i)
 * Else Application.Names("Formular_V_1_Gas_" & CStr(i)).RefersToRange = Empty
 * Application.Names("Formular_m_1_Gas_" & CStr(i)).RefersToRange = Empty End If
 * Next i Else i = 1 End If
 * 
 * For i = i To 6 Application.Names("Formular_V_1_Gas_rel_" &
 * CStr(i)).RefersToRange = Empty Application.Names("Formular_V_1_Gas_" &
 * CStr(i)).RefersToRange = Empty Application.Names("Formular_m_1_Gas_rel_" &
 * CStr(i)).RefersToRange = Empty Application.Names("Formular_m_1_Gas_" &
 * CStr(i)).RefersToRange = Empty Application.Names("Formular_Ist_Dampf_" &
 * CStr(i)).RefersToRange = Empty Application.Names("Formular_p_SD_Gas_T_BF_" &
 * CStr(i)).RefersToRange = Empty Application.Names("Formular_p_SD_Gas_T_1_" &
 * CStr(i)).RefersToRange = Empty Next i
 * 
 * Application.Names("Formular_V_1_Gas_gesamt").RefersToRange = V_1_Gas_gesamt
 * Application.Names("Formular_m_1_Gas_gesamt").RefersToRange = m_1_Gas_gesamt
 * 
 * 
 * End Sub
 */

	//Gasstroeme_ausgeben

 public static void gasStreamsOutput(double gas, double v_1_Gas, double v_1_Gas_rel, double m_1_Gas, double m_1_Gas_rel, double v_1_Gas_gesamt, double m_1_Gas_gesamt, double ist_Dampf, double p_SD_Gas_T_BF, double p_SD_Gas_T_1)
 {
	 
 }

 
 
	/*
	 * Sub Fehlertext_anzeigen(Fehler As Fehlercodetyp)
	 * 
	 * Dim Fehlerbox As Object Dim Fehlertabelle As Worksheet Dim Fehlerfilter Dim i
	 * As Integer Dim col_Fehlercode As Integer, col_Fehlerart As Integer,
	 * col_Fehlertext As Integer, col_Zusatzparameter As Integer Dim Fehlerart As
	 * Integer, Fehlertext As String Dim data_row As Integer
	 * 
	 * Set Fehlerbox = OLEObjects("Textbox_Fehler").Object Set Fehlertabelle =
	 * Worksheets("Fehlertabelle")
	 * 
	 * col_Fehlercode = Fehlertabelle.Rows(1).Find("Fehlercode").Column
	 * col_Fehlerart = Fehlertabelle.Rows(1).Find("Fehlerart").Column col_Fehlertext
	 * = Fehlertabelle.Rows(1).Find("Fehlerbeschreibung deutsch").Column
	 * col_Zusatzparameter =
	 * Fehlertabelle.Rows(1).Find("Zusatzparameter deutsch").Column
	 * 
	 * Fehlerbox = ""
	 * 
	 * Fehlerfilter = Application.Names("Formular_Fehlerfilter").RefersToRange
	 * 
	 * If Not IsEmpty(Fehler.Code) Then For i = 1 To UBound(Fehler.Code) data_row =
	 * Fehlertabelle.Columns(col_Fehlercode).Find(Fehler.Code(i)).Row Fehlerart =
	 * Fehlertabelle.Cells(data_row, col_Fehlerart) Fehlertext =
	 * Fehlertabelle.Cells(data_row, col_Fehlertext) If Not
	 * IsEmpty(Fehler.Zusatzparameter(i)) Then Fehlertext = Fehlertext & " - " &
	 * Fehlertabelle.Cells(data_row, col_Zusatzparameter) & ": " &
	 * CStr(Fehler.Zusatzparameter(i)) End If If IsEmpty(Fehlerfilter) Or Fehlerart
	 * <= Fehlerfilter Then If Fehlerart = 1 Then Fehlerbox = Fehlerbox & "Fehler: "
	 * If Fehlerart = 2 Then Fehlerbox = Fehlerbox & "Warnung: " If Fehlerart >= 3
	 * Then Fehlerbox = Fehlerbox & "Hinweis: " Fehlerbox = Fehlerbox & Fehlertext &
	 * " (Code: " & Str(Fehler.Code(i)) & ")" & vbNewLine & vbNewLine End If Next i
	 * End If If Fehler.Abbruch Then Fehlerbox = Fehlerbox & "Berechnungsabbruch !"
	 * & vbNewLine
	 * 
	 * End Sub
	 */
	
	
	//Sub Fehlertext_anzeigen(Fehler As Fehlercodetyp)
 public static void show_error_text(ErrorCodeTable error)
 {
	
	 
	 
	 
	 
 }
 
 
	/*
	 * Function Fehlerart_kritisch(Fehler As Fehlercodetyp) ' durchsucht beim
	 * übergebenen Fehler alle Codes und gibt ' den kleinsten vorhandenen
	 * Fehlerart-Wert (d.h. die ' kritischste Fehlerart) zurück, der diesem
	 * Fehlercode in ' der Fehlertabelle zugeordnet ist
	 * 
	 * Dim Fehlertabelle As Worksheet Dim i As Integer Dim f, g Dim col_Fehlercode
	 * As Integer, col_Fehlerart As Integer Dim found_range As Range, search_range
	 * 
	 * If IsEmpty(Fehler.Code) Then Exit Function
	 * 
	 * Set Fehlertabelle = Worksheets("Fehlertabelle") col_Fehlercode =
	 * Fehlertabelle.Rows(1).Find("Fehlercode", , , xlWhole).Column col_Fehlerart =
	 * Fehlertabelle.Rows(1).Find("Fehlerart").Column Set search_range =
	 * Fehlertabelle.Columns(col_Fehlercode)
	 * 
	 * For i = 1
	 * 
	 * To UBound(Fehler.Code) Set found_range = Nothing Set found_range =
	 * search_range.Find(Fehler.Code(i), , , xlWhole) If Not found_range Is Nothing
	 * Then g = Fehlertabelle.Cells(found_range.Row, col_Fehlerart)
	 * 
	 * If IsEmpty(f) Or g < f Then f = g End If Next i
	 * 
	 * Fehlerart_kritisch = f
	 * 
	 * End Function
	 */
	
	
	public static int errorTypeCritical(ErrorCodeTable error)
	{
		return 0;
		
	}
	
	
	
	/*
	 * Sub stc_neu_markieren()
	 * 
	 * Dim ergebnis_darstellung_eingabe As Integer Dim
	 * ergebnis_darstellung_eingabe_variabel As Integer Dim
	 * ergebnis_darstellung_ausgabe As Integer Dim rgb_eingabe As Long Dim
	 * rgb_ausgabe As Long
	 * 
	 * Static stc_Berechnungsart_alt As Integer Static stc_Ergebnis_alt As Integer
	 * 
	 * If stc_Berechnungsart <> stc_Berechnungsart_alt Then
	 * ComboBox_Maschinen_ID.BackColor = RGB(255, 255, 255) ListBox_Wkst.BackColor =
	 * RGB(255, 255, 255) ComboBox_Gasstrahler.BackColor = RGB(255, 255, 255)
	 * ListBox_Gasstrahlerauswahl.BackColor = RGB(255, 255, 255)
	 * ListBox_Maschinenauswahl_Evak.BackColor = RGB(255, 255, 255)
	 * 
	 * Call stc_einfaerben(Application.Names("Formular_Berechtigungsgruppe").
	 * RefersToRange, 0) Call
	 * stc_einfaerben(Application.Names("Formular_Drehzahl").RefersToRange, 0) Call
	 * stc_einfaerben(Application.Names("Formular_p_1").RefersToRange, 0) Call
	 * stc_einfaerben(Application.Names("Formular_p_2").RefersToRange, 0) Call
	 * stc_einfaerben(Application.Names("Formular_T_1").RefersToRange, 0) Call
	 * stc_einfaerben(Application.Names("Formular_T_BF").RefersToRange, 0) Call
	 * stc_einfaerben(Application.Names("Formular_V_1_F").RefersToRange, 0) Call
	 * stc_einfaerben(Application.Names("Formular_T_FF").RefersToRange, 0) Call
	 * stc_einfaerben(Application.Names("Formular_BF").RefersToRange, 0) Call
	 * stc_einfaerben(Application.Names("Formular_V_BF_manuell").RefersToRange, 0)
	 * Call stc_einfaerben(Application.Names("Formular_Delta_p_Waermetauscher").
	 * RefersToRange, 0)
	 * 
	 * Call stc_einfaerben(Application.Names("Formular_Gas").RefersToRange, 0) Call
	 * stc_einfaerben(Application.Names("Formular_V_1_Gas_gesamt").RefersToRange, 0)
	 * Call stc_einfaerben(Application.Names("Formular_V_1_Gas_gesamt_norm").
	 * RefersToRange, 0) Call
	 * stc_einfaerben(Application.Names("Formular_V_1_Gas").RefersToRange, 0) Call
	 * stc_einfaerben(Application.Names("Formular_V_1_Gas_rel").RefersToRange, 0)
	 * Call stc_einfaerben(Application.Names("Formular_m_1_Gas").RefersToRange, 0)
	 * Call stc_einfaerben(Application.Names("Formular_m_1_Gas_rel").RefersToRange,
	 * 0) Call
	 * stc_einfaerben(Application.Names("Formular_m_1_Gas_gesamt").RefersToRange, 0)
	 * Call stc_einfaerben(Application.Names("Formular_Feuchte").RefersToRange, 0)
	 * Call stc_einfaerben(Application.Names("Formular_Psi").RefersToRange, 0) Call
	 * stc_einfaerben(Application.Names("Formular_p_SD_Dampf").RefersToRange, 0)
	 * Call stc_einfaerben(Application.Names("Formular_M_mol_mittel").RefersToRange,
	 * 0)
	 * 
	 * Call stc_einfaerben(Application.Names("Formular_P").RefersToRange, 0) Call
	 * stc_einfaerben(Application.Names("Formular_P_max").RefersToRange, 0) Call
	 * stc_einfaerben(Application.Names("Formular_p_2_max").RefersToRange, 0) Call
	 * stc_einfaerben(Application.Names("Formular_V_BF").RefersToRange, 0) Call
	 * stc_einfaerben(Application.Names("Formular_Q_WT").RefersToRange, 0) Call
	 * stc_einfaerben(Application.Names("Formular_T_2").RefersToRange, 0) Call
	 * stc_einfaerben(Application.Names("Formular_V_FF").RefersToRange, 0) Call
	 * stc_einfaerben(Application.Names("Formular_lambdas").RefersToRange, 0) Call
	 * stc_einfaerben(Application.Names("Formular_phis").RefersToRange, 0) Call
	 * stc_einfaerben(Application.Names("Formular_n_ref").RefersToRange, 0) Call
	 * stc_einfaerben(Application.Names("Formular_p_2_ref").RefersToRange, 0) Call
	 * stc_einfaerben(Application.Names("Formular_V_1_ref").RefersToRange, 0) Call
	 * stc_einfaerben(Application.Names("Formular_P_ref").RefersToRange, 0)
	 * 
	 * Call stc_einfaerben(Application.Names("Formular_V_1_Gas_gesamt_soll").
	 * RefersToRange, 0) Call
	 * stc_einfaerben(Application.Names("Formular_V_1_Toleranz_plus").RefersToRange,
	 * 0) Call stc_einfaerben(Application.Names("Formular_V_1_Toleranz_minus").
	 * RefersToRange, 0)
	 * 
	 * Call stc_einfaerben(Application.Names("Formular_V_Behaelter").RefersToRange,
	 * 0) Call
	 * stc_einfaerben(Application.Names("Formular_p_1_Beginn").RefersToRange, 0)
	 * Call stc_einfaerben(Application.Names("Formular_p_1_Ende").RefersToRange, 0)
	 * Call
	 * stc_einfaerben(Application.Names("Formular_V_1_norm_Leckage").RefersToRange,
	 * 0) Call
	 * stc_einfaerben(Application.Names("Formular_Evakuierungszeit").RefersToRange,
	 * 0)
	 * 
	 * Call stc_einfaerben(Application.Names("Formular_Soll_Evakuierungszeit").
	 * RefersToRange, 0) Call
	 * stc_einfaerben(Application.Names("Formular_t_evak_Toleranz_plus").
	 * RefersToRange, 0) Call
	 * stc_einfaerben(Application.Names("Formular_t_evak_Toleranz_minus").
	 * RefersToRange, 0)
	 * 
	 * Call
	 * stc_einfaerben(Application.Names("Formular_Gasstrahler_p_1").RefersToRange,
	 * 0) Call
	 * stc_einfaerben(Application.Names("Formular_Gasstrahler_V_1").RefersToRange,
	 * 0) Call
	 * stc_einfaerben(Application.Names("Formular_Gasstrahler_V_Treibstrom").
	 * RefersToRange, 0) Call
	 * stc_einfaerben(Application.Names("Formular_Gasstrahler_V_1_soll").
	 * RefersToRange, 0)
	 * 
	 * Call stc_einfaerben(Application.Names("Formular_T_BF_opt").RefersToRange, 0)
	 * End If
	 * 
	 * If stc_Ergebnis = 0 Then ergebnis_darstellung_eingabe = 4
	 * ergebnis_darstellung_eingabe_variabel = 3 ergebnis_darstellung_ausgabe = 1
	 * rgb_eingabe = RGB(255, 255, 0) rgb_ausgabe = RGB(255, 255, 255) If
	 * stc_Ergebnis_alt <> 0 Then TextBox_Fehler = Empty ElseIf stc_Ergebnis = 1
	 * Then ergebnis_darstellung_eingabe = 5 ergebnis_darstellung_eingabe_variabel =
	 * 5 ergebnis_darstellung_ausgabe = 5 rgb_eingabe = RGB(180, 255, 180)
	 * rgb_ausgabe = RGB(180, 255, 180) ElseIf stc_Ergebnis = -1 Then
	 * ergebnis_darstellung_eingabe = 6 ergebnis_darstellung_eingabe_variabel = 6
	 * ergebnis_darstellung_ausgabe = 6 rgb_eingabe = RGB(255, 180, 180) rgb_ausgabe
	 * = RGB(255, 180, 180) End If
	 * 
	 * If stc_Berechnungsart <> stc_Berechnungsart_alt Or stc_Ergebnis <>
	 * stc_Ergebnis_alt Then If stc_Berechnungsart = 1 Then Call
	 * stc_einfaerben(Application.Names("Formular_Berechtigungsgruppe").
	 * RefersToRange, ergebnis_darstellung_eingabe) Call
	 * stc_einfaerben(Application.Names("Formular_p_1").RefersToRange,
	 * ergebnis_darstellung_eingabe) Call
	 * stc_einfaerben(Application.Names("Formular_p_2").RefersToRange,
	 * ergebnis_darstellung_eingabe) Call
	 * stc_einfaerben(Application.Names("Formular_T_1").RefersToRange,
	 * ergebnis_darstellung_eingabe) Call
	 * stc_einfaerben(Application.Names("Formular_T_BF").RefersToRange,
	 * ergebnis_darstellung_eingabe) Call
	 * stc_einfaerben(Application.Names("Formular_BF").RefersToRange,
	 * ergebnis_darstellung_eingabe) ElseIf stc_Berechnungsart = 2 Then
	 * ComboBox_Maschinen_ID.BackColor = rgb_eingabe ListBox_Wkst.BackColor =
	 * rgb_eingabe Call
	 * stc_einfaerben(Application.Names("Formular_Berechtigungsgruppe").
	 * RefersToRange, ergebnis_darstellung_eingabe) Call
	 * stc_einfaerben(Application.Names("Formular_Drehzahl").RefersToRange,
	 * ergebnis_darstellung_eingabe) Call
	 * stc_einfaerben(Application.Names("Formular_p_1").RefersToRange,
	 * ergebnis_darstellung_eingabe) Call
	 * stc_einfaerben(Application.Names("Formular_p_2").RefersToRange,
	 * ergebnis_darstellung_eingabe) Call
	 * stc_einfaerben(Application.Names("Formular_T_1").RefersToRange,
	 * ergebnis_darstellung_eingabe) Call
	 * stc_einfaerben(Application.Names("Formular_T_BF").RefersToRange,
	 * ergebnis_darstellung_eingabe) Call
	 * stc_einfaerben(Application.Names("Formular_V_1_F").RefersToRange,
	 * ergebnis_darstellung_eingabe) Call
	 * stc_einfaerben(Application.Names("Formular_T_FF").RefersToRange,
	 * ergebnis_darstellung_eingabe) Call
	 * stc_einfaerben(Application.Names("Formular_BF").RefersToRange,
	 * ergebnis_darstellung_eingabe) Call
	 * stc_einfaerben(Application.Names("Formular_V_BF_manuell").RefersToRange,
	 * ergebnis_darstellung_eingabe) Call
	 * stc_einfaerben(Application.Names("Formular_Delta_p_Waermetauscher").
	 * RefersToRange, ergebnis_darstellung_eingabe)
	 * 
	 * Call stc_einfaerben(Application.Names("Formular_P").RefersToRange,
	 * ergebnis_darstellung_ausgabe) Call
	 * stc_einfaerben(Application.Names("Formular_P_max").RefersToRange,
	 * ergebnis_darstellung_ausgabe) Call
	 * stc_einfaerben(Application.Names("Formular_p_2_max").RefersToRange,
	 * ergebnis_darstellung_ausgabe) Call
	 * stc_einfaerben(Application.Names("Formular_V_BF").RefersToRange,
	 * ergebnis_darstellung_ausgabe) Call
	 * stc_einfaerben(Application.Names("Formular_Q_WT").RefersToRange,
	 * ergebnis_darstellung_ausgabe) Call
	 * stc_einfaerben(Application.Names("Formular_T_2").RefersToRange,
	 * ergebnis_darstellung_ausgabe) Call
	 * stc_einfaerben(Application.Names("Formular_V_FF").RefersToRange,
	 * ergebnis_darstellung_ausgabe) Call
	 * stc_einfaerben(Application.Names("Formular_lambdas").RefersToRange,
	 * ergebnis_darstellung_ausgabe) Call
	 * stc_einfaerben(Application.Names("Formular_phis").RefersToRange,
	 * ergebnis_darstellung_ausgabe) Call
	 * stc_einfaerben(Application.Names("Formular_n_ref").RefersToRange,
	 * ergebnis_darstellung_ausgabe) Call
	 * stc_einfaerben(Application.Names("Formular_p_2_ref").RefersToRange,
	 * ergebnis_darstellung_ausgabe) Call
	 * stc_einfaerben(Application.Names("Formular_V_1_ref").RefersToRange,
	 * ergebnis_darstellung_ausgabe) Call
	 * stc_einfaerben(Application.Names("Formular_P_ref").RefersToRange,
	 * ergebnis_darstellung_ausgabe)
	 * 
	 * ElseIf stc_Berechnungsart = 3 Then Call
	 * stc_einfaerben(Application.Names("Formular_Berechtigungsgruppe").
	 * RefersToRange, ergebnis_darstellung_eingabe) Call
	 * stc_einfaerben(Application.Names("Formular_p_1").RefersToRange,
	 * ergebnis_darstellung_eingabe) Call
	 * stc_einfaerben(Application.Names("Formular_p_2").RefersToRange,
	 * ergebnis_darstellung_eingabe) Call
	 * stc_einfaerben(Application.Names("Formular_T_1").RefersToRange,
	 * ergebnis_darstellung_eingabe) Call
	 * stc_einfaerben(Application.Names("Formular_T_BF").RefersToRange,
	 * ergebnis_darstellung_eingabe) Call
	 * stc_einfaerben(Application.Names("Formular_V_1_F").RefersToRange,
	 * ergebnis_darstellung_eingabe) Call
	 * stc_einfaerben(Application.Names("Formular_BF").RefersToRange,
	 * ergebnis_darstellung_eingabe) Call
	 * stc_einfaerben(Application.Names("Formular_V_1_Gas_gesamt_soll").
	 * RefersToRange, ergebnis_darstellung_eingabe) Call
	 * stc_einfaerben(Application.Names("Formular_V_1_Toleranz_plus").RefersToRange,
	 * ergebnis_darstellung_eingabe) Call
	 * stc_einfaerben(Application.Names("Formular_V_1_Toleranz_minus").
	 * RefersToRange, ergebnis_darstellung_eingabe)
	 * 
	 * 'Call stc_einfaerben(Application.Names("Formular_V_1_Gas").RefersToRange, 0)
	 * 'Call stc_einfaerben(Application.Names("Formular_m_1_Gas").RefersToRange, 0)
	 * 'Call
	 * stc_einfaerben(Application.Names("Formular_V_1_Gas_gesamt").RefersToRange, 0)
	 * 'Call stc_einfaerben(Application.Names("Formular_V_1_Gas_gesamt_norm").
	 * RefersToRange, 0) 'Call
	 * stc_einfaerben(Application.Names("Formular_m_1_Gas_gesamt").RefersToRange, 0)
	 * 
	 * ElseIf stc_Berechnungsart = 4 Then ComboBox_Maschinen_ID.BackColor =
	 * rgb_eingabe ListBox_Wkst.BackColor = rgb_eingabe Call
	 * stc_einfaerben(Application.Names("Formular_Berechtigungsgruppe").
	 * RefersToRange, ergebnis_darstellung_eingabe) Call
	 * stc_einfaerben(Application.Names("Formular_Drehzahl").RefersToRange,
	 * ergebnis_darstellung_eingabe) Call
	 * stc_einfaerben(Application.Names("Formular_p_2").RefersToRange,
	 * ergebnis_darstellung_eingabe) Call
	 * stc_einfaerben(Application.Names("Formular_T_1").RefersToRange,
	 * ergebnis_darstellung_eingabe) Call
	 * stc_einfaerben(Application.Names("Formular_T_BF").RefersToRange,
	 * ergebnis_darstellung_eingabe) Call
	 * stc_einfaerben(Application.Names("Formular_p_1_Beginn").RefersToRange,
	 * ergebnis_darstellung_eingabe) Call
	 * stc_einfaerben(Application.Names("Formular_p_1_Ende").RefersToRange,
	 * ergebnis_darstellung_eingabe) Call
	 * stc_einfaerben(Application.Names("Formular_V_Behaelter").RefersToRange,
	 * ergebnis_darstellung_eingabe) Call
	 * stc_einfaerben(Application.Names("Formular_V_1_norm_Leckage").RefersToRange,
	 * ergebnis_darstellung_eingabe)
	 * 
	 * Call
	 * stc_einfaerben(Application.Names("Formular_Evakuierungszeit").RefersToRange,
	 * ergebnis_darstellung_ausgabe) ElseIf stc_Berechnungsart = 5 Then Call
	 * stc_einfaerben(Application.Names("Formular_Berechtigungsgruppe").
	 * RefersToRange, ergebnis_darstellung_eingabe) Call
	 * stc_einfaerben(Application.Names("Formular_p_2").RefersToRange,
	 * ergebnis_darstellung_eingabe) Call
	 * stc_einfaerben(Application.Names("Formular_T_1").RefersToRange,
	 * ergebnis_darstellung_eingabe) Call
	 * stc_einfaerben(Application.Names("Formular_T_BF").RefersToRange,
	 * ergebnis_darstellung_eingabe) Call
	 * stc_einfaerben(Application.Names("Formular_p_1_Beginn").RefersToRange,
	 * ergebnis_darstellung_eingabe) Call
	 * stc_einfaerben(Application.Names("Formular_p_1_Ende").RefersToRange,
	 * ergebnis_darstellung_eingabe) Call
	 * stc_einfaerben(Application.Names("Formular_V_Behaelter").RefersToRange,
	 * ergebnis_darstellung_eingabe) Call
	 * stc_einfaerben(Application.Names("Formular_Soll_Evakuierungszeit").
	 * RefersToRange, ergebnis_darstellung_eingabe) Call
	 * stc_einfaerben(Application.Names("Formular_t_evak_Toleranz_plus").
	 * RefersToRange, ergebnis_darstellung_eingabe) Call
	 * stc_einfaerben(Application.Names("Formular_t_evak_Toleranz_minus").
	 * RefersToRange, ergebnis_darstellung_eingabe) Call
	 * stc_einfaerben(Application.Names("Formular_V_1_norm_Leckage").RefersToRange,
	 * ergebnis_darstellung_eingabe)
	 * 
	 * ListBox_Maschinenauswahl_Evak.BackColor = rgb_ausgabe ElseIf
	 * stc_Berechnungsart = 6 Then Call
	 * stc_einfaerben(Application.Names("Formular_Berechtigungsgruppe").
	 * RefersToRange, ergebnis_darstellung_eingabe) Call
	 * stc_einfaerben(Application.Names("Formular_p_1").RefersToRange,
	 * ergebnis_darstellung_eingabe) Call
	 * stc_einfaerben(Application.Names("Formular_p_2").RefersToRange,
	 * ergebnis_darstellung_eingabe) Call
	 * stc_einfaerben(Application.Names("Formular_T_1").RefersToRange,
	 * ergebnis_darstellung_eingabe) Call
	 * stc_einfaerben(Application.Names("Formular_T_BF").RefersToRange,
	 * ergebnis_darstellung_eingabe) Call
	 * stc_einfaerben(Application.Names("Formular_V_1_F").RefersToRange,
	 * ergebnis_darstellung_eingabe) Call
	 * stc_einfaerben(Application.Names("Formular_BF").RefersToRange,
	 * ergebnis_darstellung_eingabe) Call
	 * stc_einfaerben(Application.Names("Formular_V_1_Gas_gesamt_soll").
	 * RefersToRange, ergebnis_darstellung_eingabe)
	 * 
	 * Call stc_einfaerben(Application.Names("Formular_T_BF_opt").RefersToRange,
	 * ergebnis_darstellung_ausgabe) ElseIf stc_Berechnungsart = 7 Then
	 * ComboBox_Gasstrahler.BackColor = rgb_eingabe Call
	 * stc_einfaerben(Application.Names("Formular_Gasstrahler_p_1").RefersToRange,
	 * ergebnis_darstellung_eingabe) Call
	 * stc_einfaerben(Application.Names("Formular_Gasstrahler_V_1").RefersToRange,
	 * ergebnis_darstellung_ausgabe)
	 * 
	 * Call stc_einfaerben(Application.Names("Formular_Gasstrahler_V_Treibstrom").
	 * RefersToRange, ergebnis_darstellung_ausgabe) ElseIf stc_Berechnungsart = 8
	 * Then ListBox_Gasstrahlerauswahl.BackColor = rgb_ausgabe Call
	 * stc_einfaerben(Application.Names("Formular_Gasstrahler_V_1_soll").
	 * RefersToRange, ergebnis_darstellung_eingabe) Call
	 * stc_einfaerben(Application.Names("Formular_Gasstrahler_p_1").RefersToRange,
	 * ergebnis_darstellung_eingabe) End If If stc_Ergebnis = -1 Then
	 * TextBox_Fehler.BackColor = rgb_ausgabe Else TextBox_Fehler.BackColor =
	 * RGB(255, 255, 255) End If End If
	 * 
	 * If (stc_Berechnungsart > 0 And stc_Berechnungsart < 4) Or stc_Berechnungsart
	 * = 6 Then If stc_Anzahl_Gase = 0 Then Call
	 * stc_einfaerben(Application.Names("Formular_Gas").RefersToRange, 0) Call
	 * stc_einfaerben(Application.Names("Formular_V_1_Gas").RefersToRange, 0) Call
	 * stc_einfaerben(Application.Names("Formular_V_1_Gas_rel").RefersToRange, 0)
	 * Call stc_einfaerben(Application.Names("Formular_m_1_Gas").RefersToRange, 0)
	 * Call stc_einfaerben(Application.Names("Formular_m_1_Gas_rel").RefersToRange,
	 * 0) Call
	 * stc_einfaerben(Application.Names("Formular_m_1_Gas_gesamt").RefersToRange, 0)
	 * Call stc_einfaerben(Application.Names("Formular_Feuchte").RefersToRange, 0)
	 * Call stc_einfaerben(Application.Names("Formular_Psi").RefersToRange, 0) If
	 * stc_Berechnungsart < 3 Then Call
	 * stc_einfaerben(Application.Names("Formular_V_1_Gas_gesamt").RefersToRange,
	 * ergebnis_darstellung_ausgabe) Call
	 * stc_einfaerben(Application.Names("Formular_V_1_Gas_gesamt_norm").
	 * RefersToRange, ergebnis_darstellung_ausgabe) End If Else If stc_Ergebnis <> 0
	 * Then If stc_Berechnungsart = 1 Or stc_Berechnungsart = 2 Then Call
	 * stc_einfaerben(Application.Names("Formular_V_1_Gas").RefersToRange,
	 * ergebnis_darstellung_ausgabe) Call
	 * stc_einfaerben(Application.Names("Formular_V_1_Gas_gesamt").RefersToRange,
	 * ergebnis_darstellung_ausgabe) Call
	 * stc_einfaerben(Application.Names("Formular_V_1_Gas_gesamt_norm").
	 * RefersToRange, ergebnis_darstellung_ausgabe) Call
	 * stc_einfaerben(Application.Names("Formular_m_1_Gas").RefersToRange,
	 * ergebnis_darstellung_ausgabe) Call
	 * stc_einfaerben(Application.Names("Formular_m_1_Gas_rel").RefersToRange,
	 * ergebnis_darstellung_ausgabe) Call
	 * stc_einfaerben(Application.Names("Formular_m_1_Gas_gesamt").RefersToRange,
	 * ergebnis_darstellung_ausgabe) Call
	 * stc_einfaerben(Application.Names("Formular_Feuchte").RefersToRange,
	 * ergebnis_darstellung_ausgabe) Call
	 * stc_einfaerben(Application.Names("Formular_Psi").RefersToRange,
	 * ergebnis_darstellung_ausgabe) Call
	 * stc_einfaerben(Application.Names("Formular_p_SD_Dampf").RefersToRange,
	 * ergebnis_darstellung_ausgabe) Call
	 * stc_einfaerben(Application.Names("Formular_M_mol_mittel").RefersToRange,
	 * ergebnis_darstellung_ausgabe) End If Call
	 * stc_einfaerben(Application.Names("Formular_Gas").RefersToRange,
	 * ergebnis_darstellung_ausgabe) Call
	 * stc_einfaerben(Application.Names("Formular_V_1_Gas_rel").RefersToRange,
	 * ergebnis_darstellung_ausgabe) Else Call
	 * stc_einfaerben(Application.Names("Formular_Gas").RefersToRange,
	 * ergebnis_darstellung_eingabe) If stc_V_1_Gas_rel_gegeben Then Call
	 * stc_einfaerben(Application.Names("Formular_V_1_Gas_rel").RefersToRange,
	 * ergebnis_darstellung_eingabe_variabel) Else Call
	 * stc_einfaerben(Application.Names("Formular_V_1_Gas_rel").RefersToRange,
	 * ergebnis_darstellung_ausgabe) End If If stc_Berechnungsart = 1 Then If
	 * stc_V_1_Gas_gegeben Then If CheckBox_saettigen.Value = True Then Call
	 * stc_einfaerben(Application.Names("Formular_V_1_Gas").RefersToRange,
	 * ergebnis_darstellung_eingabe_variabel) Else Call
	 * stc_einfaerben(Application.Names("Formular_V_1_Gas").RefersToRange,
	 * ergebnis_darstellung_eingabe) End If Else Call
	 * stc_einfaerben(Application.Names("Formular_V_1_Gas").RefersToRange,
	 * ergebnis_darstellung_ausgabe) End If If stc_m_1_Gas_rel_gegeben Then Call
	 * stc_einfaerben(Application.Names("Formular_m_1_Gas_rel").RefersToRange,
	 * ergebnis_darstellung_eingabe_variabel) Else Call
	 * stc_einfaerben(Application.Names("Formular_m_1_Gas_rel").RefersToRange,
	 * ergebnis_darstellung_ausgabe) End If If stc_m_1_Gas_gegeben Then If
	 * CheckBox_saettigen.Value = True Then Call
	 * stc_einfaerben(Application.Names("Formular_m_1_Gas").RefersToRange,
	 * ergebnis_darstellung_eingabe_variabel) Else Call
	 * stc_einfaerben(Application.Names("Formular_m_1_Gas").RefersToRange,
	 * ergebnis_darstellung_eingabe) End If Else Call
	 * stc_einfaerben(Application.Names("Formular_m_1_Gas").RefersToRange,
	 * ergebnis_darstellung_ausgabe) End If If stc_V_1_Gas_gesamt_gegeben Then Call
	 * stc_einfaerben(Application.Names("Formular_V_1_Gas_gesamt").RefersToRange,
	 * ergebnis_darstellung_eingabe) Else Call
	 * stc_einfaerben(Application.Names("Formular_V_1_Gas_gesamt").RefersToRange,
	 * ergebnis_darstellung_ausgabe) End If If stc_m_1_Gas_gesamt_gegeben Then Call
	 * stc_einfaerben(Application.Names("Formular_m_1_Gas_gesamt").RefersToRange,
	 * ergebnis_darstellung_eingabe) Else Call
	 * stc_einfaerben(Application.Names("Formular_m_1_Gas_gesamt").RefersToRange,
	 * ergebnis_darstellung_ausgabe) End If Call
	 * stc_einfaerben(Application.Names("Formular_Feuchte").RefersToRange,
	 * ergebnis_darstellung_ausgabe) Call
	 * stc_einfaerben(Application.Names("Formular_Psi").RefersToRange,
	 * ergebnis_darstellung_ausgabe) Call
	 * stc_einfaerben(Application.Names("Formular_p_SD_Dampf").RefersToRange,
	 * ergebnis_darstellung_ausgabe) Call
	 * stc_einfaerben(Application.Names("Formular_M_mol_mittel").RefersToRange,
	 * ergebnis_darstellung_ausgabe) Call
	 * stc_einfaerben(Application.Names("Formular_V_1_Gas_gesamt_norm").
	 * RefersToRange, ergebnis_darstellung_ausgabe) ElseIf stc_Berechnungsart = 2
	 * Then If stc_V_1_Gas_gegeben Then Call
	 * stc_einfaerben(Application.Names("Formular_V_1_Gas").RefersToRange,
	 * ergebnis_darstellung_eingabe_variabel) Else Call
	 * stc_einfaerben(Application.Names("Formular_V_1_Gas").RefersToRange,
	 * ergebnis_darstellung_ausgabe) End If If stc_m_1_Gas_rel_gegeben Then Call
	 * stc_einfaerben(Application.Names("Formular_m_1_Gas_rel").RefersToRange,
	 * ergebnis_darstellung_eingabe_variabel) Else Call
	 * stc_einfaerben(Application.Names("Formular_m_1_Gas_rel").RefersToRange,
	 * ergebnis_darstellung_ausgabe) End If If stc_m_1_Gas_gegeben Then Call
	 * stc_einfaerben(Application.Names("Formular_m_1_Gas").RefersToRange,
	 * ergebnis_darstellung_eingabe_variabel) Else Call
	 * stc_einfaerben(Application.Names("Formular_m_1_Gas").RefersToRange,
	 * ergebnis_darstellung_ausgabe) End If If stc_V_1_Gas_gesamt_gegeben Then Call
	 * stc_einfaerben(Application.Names("Formular_V_1_Gas_gesamt").RefersToRange,
	 * ergebnis_darstellung_eingabe) Else Call
	 * stc_einfaerben(Application.Names("Formular_V_1_Gas_gesamt").RefersToRange,
	 * ergebnis_darstellung_ausgabe) Call
	 * stc_einfaerben(Application.Names("Formular_V_1_Gas_gesamt_norm").
	 * RefersToRange, ergebnis_darstellung_ausgabe) End If If
	 * stc_m_1_Gas_gesamt_gegeben Then Call
	 * stc_einfaerben(Application.Names("Formular_m_1_Gas_gesamt").RefersToRange,
	 * ergebnis_darstellung_eingabe) Else Call
	 * stc_einfaerben(Application.Names("Formular_m_1_Gas_gesamt").RefersToRange,
	 * ergebnis_darstellung_ausgabe) End If Call
	 * stc_einfaerben(Application.Names("Formular_Feuchte").RefersToRange,
	 * ergebnis_darstellung_ausgabe) Call
	 * stc_einfaerben(Application.Names("Formular_Psi").RefersToRange,
	 * ergebnis_darstellung_ausgabe) Call
	 * stc_einfaerben(Application.Names("Formular_p_SD_Dampf").RefersToRange,
	 * ergebnis_darstellung_ausgabe) Call
	 * stc_einfaerben(Application.Names("Formular_M_mol_mittel").RefersToRange,
	 * ergebnis_darstellung_ausgabe)
	 * 
	 * 
	 * Call
	 * stc_einfaerben(Application.Names("Formular_V_1_Gas_gesamt").RefersToRange,
	 * ergebnis_darstellung_ausgabe) Call
	 * stc_einfaerben(Application.Names("Formular_V_1_Gas_gesamt_norm").
	 * RefersToRange, ergebnis_darstellung_ausgabe) End If End If End If End If
	 * 
	 * stc_Berechnungsart_alt = stc_Berechnungsart stc_Ergebnis_alt = stc_Ergebnis
	 * 
	 * End Sub
	 */
 
	
	//Sub stc_neu_markieren()
	
	 
	// OperatingPointForSelectedMachine
	//Manuelle_Stoffdaten_uebertragen
	
	
	//Sub Manuelle_Stoffdaten_uebertragen()

	/*
	 * manual_M_mol_BF = Application.Names("Formular_Manual_M_mol_BF").RefersToRange
	 * manual_p_SD_BF_T_1 =
	 * Application.Names("Formular_Manual_p_SD_BF_T_1").RefersToRange
	 * manual_p_SD_BF_T_2 =
	 * Application.Names("Formular_Manual_p_SD_BF_T_2").RefersToRange
	 * manual_p_SD_BF_T_BF =
	 * Application.Names("Formular_Manual_p_SD_BF_T_BF").RefersToRange manual_c_BF =
	 * Application.Names("Formular_Manual_c_BF").RefersToRange manual_r_BF =
	 * Application.Names("Formular_Manual_r_BF").RefersToRange manual_rho_BF =
	 * Application.Names("Formular_Manual_rho_BF").RefersToRange manual_ny_BF =
	 * Application.Names("Formular_Manual_ny_BF").RefersToRange
	 * 
	 * manual_M_mol_Gas(1) =
	 * Application.Names("Formular_Manual_Gas_1_M_mol").RefersToRange
	 * manual_p_SD_Gas_T_1(1) =
	 * Application.Names("Formular_Manual_Gas_1_p_SD_Gas_T_1").RefersToRange
	 * manual_p_SD_Gas_T_2(1) =
	 * Application.Names("Formular_Manual_Gas_1_p_SD_Gas_T_2").RefersToRange
	 * manual_p_SD_Gas_T_BF(1) =
	 * Application.Names("Formular_Manual_Gas_1_p_SD_Gas_T_BF").RefersToRange
	 * manual_cp_Gas(1) =
	 * Application.Names("Formular_Manual_Gas_1_cp_Gas").RefersToRange
	 * manual_r_Gas(1) =
	 * Application.Names("Formular_Manual_Gas_1_r_Gas").RefersToRange manual_Loes(1)
	 * = Application.Names("Formular_Manual_Gas_1_Loes").RefersToRange
	 * 
	 * manual_M_mol_Gas(2) =
	 * Application.Names("Formular_Manual_Gas_2_M_mol").RefersToRange
	 * manual_p_SD_Gas_T_1(2) =
	 * Application.Names("Formular_Manual_Gas_2_p_SD_Gas_T_1").RefersToRange
	 * manual_p_SD_Gas_T_2(2) =
	 * Application.Names("Formular_Manual_Gas_2_p_SD_Gas_T_2").RefersToRange
	 * manual_p_SD_Gas_T_BF(2) =
	 * Application.Names("Formular_Manual_Gas_2_p_SD_Gas_T_BF").RefersToRange
	 * manual_cp_Gas(2) =
	 * Application.Names("Formular_Manual_Gas_2_cp_Gas").RefersToRange
	 * manual_r_Gas(2) =
	 * Application.Names("Formular_Manual_Gas_2_r_Gas").RefersToRange manual_Loes(2)
	 * = Application.Names("Formular_Manual_Gas_2_Loes").RefersToRange
	 * 
	 * End Sub
	 */
	public static void manuelle_Stoffdaten_uebertragen() {
        System.out.println("Manual substance data transferred.");
    }
	
	
	//
	
	/*
	 * Sub Gasstrom_Eingaben_einlesen(Gas, V_1_Gas, V_1_Gas_rel, m_1_Gas, m_1_Gas_rel, V_1_Gas_gesamt, m_1_Gas_gesamt)
' Alle eingegebenen Gase und Gasvolumen-/-massenströme in Variablen einlesen

Dim i As Integer

For i = 1 To stc_Anzahl_Gase
    If Not IsEmpty(Application.Names("Formular_Gas_" & CStr(i)).RefersToRange) Then
        If i = 1 Then
            ReDim Gas(1 To 1)
            If stc_V_1_Gas_rel_gegeben Then
                ReDim V_1_Gas_rel(1 To 1)
            ElseIf stc_V_1_Gas_gegeben Then
                ReDim V_1_Gas(1 To 1)
            ElseIf stc_m_1_Gas_rel_gegeben Then
                ReDim m_1_Gas_rel(1 To 1)
            ElseIf stc_m_1_Gas_gegeben Then
                ReDim m_1_Gas(1 To 1)
            End If
        Else
            ReDim Preserve Gas(1 To i)
            If stc_V_1_Gas_rel_gegeben Then
                ReDim Preserve V_1_Gas_rel(1 To i)
            ElseIf stc_V_1_Gas_gegeben Then
                ReDim Preserve V_1_Gas(1 To i)
            ElseIf stc_m_1_Gas_rel_gegeben Then
                ReDim Preserve m_1_Gas_rel(1 To i)
            ElseIf stc_m_1_Gas_gegeben Then
                ReDim Preserve m_1_Gas(1 To i)
            End If
        End If
        Gas(i) = Application.Names("Formular_Gas_" & CStr(i)).RefersToRange
        If Not IsNumeric(Gas(i)) Then
            If UCase(Gas(i)) = "MANUAL_GAS_1" Then Gas(i) = "MANUAL_GAS_1"
            If UCase(Gas(i)) = "MANUAL_GAS_2" Then Gas(i) = "MANUAL_GAS_2"
        End If
        If stc_V_1_Gas_rel_gegeben Then
            V_1_Gas_rel(i) = Application.Names("Formular_V_1_Gas_rel_" & CStr(i)).RefersToRange
        ElseIf stc_V_1_Gas_gegeben Then
            V_1_Gas(i) = Application.Names("Formular_V_1_Gas_" & CStr(i)).RefersToRange
        ElseIf stc_m_1_Gas_rel_gegeben Then
            m_1_Gas_rel(i) = Application.Names("Formular_m_1_Gas_rel_" & CStr(i)).RefersToRange
        ElseIf stc_m_1_Gas_gegeben Then
            m_1_Gas(i) = Application.Names("Formular_m_1_Gas_" & CStr(i)).RefersToRange
        End If
    Else
        Exit For
    End If
Next i
If stc_V_1_Gas_gesamt_gegeben Then V_1_Gas_gesamt = Application.Names("Formular_V_1_Gas_gesamt").RefersToRange
If stc_m_1_Gas_gesamt_gegeben Then m_1_Gas_gesamt = Application.Names("Formular_m_1_Gas_gesamt").RefersToRange

End Sub
	 * 
	 * 
	 * 
	 * 
	 */
	
	
	 


	public static void gasFlowInputRead(double gas, double v_1_Gas, double v_1_Gas_rel, double m_1_Gas,
			double m_1_Gas_rel, double v_1_Gas_Total_Volume, double v_1_Gas_Total) {
		// TODO Auto-generated method stub
		
	}
	
	//Call Umrechnung_Gasstroeme(Fehler, V_1_Gas_gesamt, V_1_Gas, V_1_Gas_rel, m_1_Gas_gesamt, m_1_Gas, m_1_Gas_rel, p_1, T_1, T_BF, Gas, Ber_Grp, Empty, Empty, Empty, Empty, Empty, Empty, Empty, p_2, saettigen, BF, Empty, Empty)
	public static void conversionGasFlows()
	{
		
	}
	
	
	/*
	 * Public Sub Betriebspunkt(Fehler As Fehlercodetyp, betr_art, Maschinen_ID As String, Werkstoff_ID, n, p_1, p_2, T_1, T_BF, Gas, _
                         V_1_Gas_rel, BF, V_1_F, Ber_Grp, V_1_Gas_gesamt, P_mech, V_BF, lambda, lambda_ges, phi, phi_ges, V_BF_manuell, _
                         Delta_p_Waermetauscher, n_ref, p_2_ref, V_1_ref, P_ref, V_1_Gas_gesamt_norm)

' -----------------------------------------------------------------------------------------------
' Diese Funktion berechnet für eine vorgegebene Maschine, Drehzahl und Betriebsbedingungen den sich
' ergebenden Betriebspunkt in Form von Gasvolumenstrom, Leistungsaufnahme und
' Betriebsflüssigkeitsvolumenstrom. Die Korrekturfaktoren lambda und phi werden ebenfalls ausgegeben
' Die Betriebsart der Maschine (1 - Vakuumbetrieb, 2 - Kompressorbetrieb) wird entweder automatisch
' ermittelt (bei Vorgabe von empty für betr_art) oder sie kann über die Variable betr_art beim
' Aufruf vorgegeben werden
'
' Ein- und Ausgabeparameter
'   Fehler
'   betr_art                        Betriebsart
'
' Eingabgeparameter
'   Maschinen_ID                    Maschinen-ID
'   Werkstoff_ID                    Werkstoff-ID
'   n                               Drehzahl [U/min]
'   p_1                             Ansaugdruck [mbar]
'   p_2                             Verdichtungsdruck [mbar]
'   T_1                             Gastemperatur am Saugstutzen [°C]
'   T_BF                            Temperatur der Betriebsflüssigkeit [°C]
'   Gas                             Stoff_IDs der Gase (als Array)
'   V_1_Gas_rel                     relative Volumenstromverteilung der Gase am Saugstutzen (als Array) [-]
'   BF                              Stoff_ID der Betriebsflüssigkeit
'   V_1_F                           Volumenstrom der mitgeförderten Flüssigkeit [m³/h] (falls Feld nicht leer; alternativ zu V_BF_manuell)
'   Ber_Grp                         Nutzer-Berechtigungsgruppe für Stoffauswahl [-]
'   V_BF_manuell                    manuelle Vorgabe des Betriebsflüssigkeitsstroms [m³/h] (falls Feld nicht leer; alternativ zu V_1_F und Delta_p_Waermetauscher)
'   Delta_p_Waermetauscher          manuelle Vorgabe des Druckverlusts im Wärmetauscher [mbar] (falls Feld nicht leer; alternativ zu V_BF_manuell)

' Ausgabeparameter
'   V_1_Gas_gesamt                  Gesamt-Gasvolumenstrom am Saugstutzen [m³/h]
'   P_mech                          Leistungsaufnahme [kW]
'   V_BF                            Betriebsflüssigkeitsvolumenstrom [m³/h]
'   lambda                          Einzelkorrekturfaktoren für Volumenstrom lambda [-] (als Array)
'   lambda_ges                      Produkt aller Einzelkorrekturfaktoren lambda [-]
'   phi                             Einzelkorrekturfaktoren phi für Leistung [-] (als Array)
'   phi_ges                         Produkt aller Einzelkorrekturfaktoren phi [-]
'   n_ref                           Referenzdrehzahl [U/min]
'   p_2_ref                         Referenzverdichtungsdruck [mbar]
'   V_1_ref                         Referenzvolumenstrom [m³/h]
'   P_ref                           Referenzleistung [kW]
'   V_1_Gas_gesamt_norm             Normierter Gesamt-Gasvolumenstrom am Saugstutzen [Nm³/h] (Normatmosphäre 1013mbar, 0°C)
' -----------------------------------------------------------------------------------------------

Dim Maschinendaten As Maschinendatentyp
Dim p_SD_Gas_T_1, p_SD_Gas_T_BF
Dim p_SD_BF_T_1, p_SD_BF_T_BF
Dim p_SD_Dampf, Psi, Rel_Feuchte
Dim rho_BF, ny_BF, c_BF, r_BF
Dim M_mol_Gas, M_mol_BF
Dim r_Gas, cp_Gas
Dim Loeslichkeit
Dim V_1_inert_rel_ges
Dim p_x
Dim V_1_Liste, P_mech_Liste, V_BF_Liste
Dim T_BF_misch, V_1_F_hilf, Delta_p_Waermetauscher_zulaessig

If Fehler.Abbruch Then Exit Sub

V_1_Gas_gesamt = Empty
V_1_Gas_gesamt_norm = Empty
P_mech = Empty
V_BF = Empty
lambda = Empty
lambda_ges = Empty
phi = Empty
phi_ges = Empty

' Leere Variablen mit Standardwerten belegen
If IsEmpty(p_1) Then p_1 = 1013
If IsEmpty(p_2) Then p_2 = 1013
If IsEmpty(T_1) Then T_1 = 20
If IsEmpty(T_BF) Then T_BF = 15

If IsEmpty(Gas) Then
    Call Fehlercode_zufuegen(Fehler, 233)
    Fehler.Abbruch = True
End If
If IsEmpty(BF) Then
    Call Fehlercode_zufuegen(Fehler, 232)
    Fehler.Abbruch = True
End If

Call Pruefung_Eingabeparameter(Fehler, n, p_1, p_2, T_1, T_BF, Empty, Empty, betr_art, V_1_F, V_1_Gas_rel, Ber_Grp, V_BF_manuell, Delta_p_Waermetauscher)
If Fehler.Abbruch Then Exit Sub

' Bei manueller Vorgabe eines manuellen Betriebsflüssigkeitsstroms darf weder ein
' Zusatzflüssigkeitsstrom noch ein Druckverlust im Wärmetauscher gegeben sein
If (Not IsEmpty(V_BF_manuell)) And Not (IsEmpty(V_1_F) And IsEmpty(Delta_p_Waermetauscher)) Then
    Call Fehlercode_zufuegen(Fehler, 238)
    Fehler.Abbruch = True
End If

'If Not IsEmpty(Delta_p_Waermetauscher) Then
'    If Delta_p_Waermetauscher > (p_2 - p_1) Then
'        call Fehlercode_zufuegen(Fehler,

' Betrieb bestimmen, falls sie nicht schon vorgegeben wird
If IsEmpty(betr_art) Then betr_art = Betriebsart(p_1)

Call Hole_Maschinendaten(Maschinendaten, Fehler, Maschinen_ID, Werkstoff_ID, betr_art, Ber_Grp)
If Fehler.Abbruch Then Exit Sub

' Standard-Drehzahl = Nenndrehzahl
If IsEmpty(n) Then n = Maschinendaten.n_nenn

If betr_art = 1 Then
    p_x = p_1
Else
    p_x = p_2
End If

Call Listendatenpunkt(Fehler, Maschinen_ID, Werkstoff_ID, CDbl(n), CInt(betr_art), CDbl(p_x), V_1_Liste, P_mech_Liste, V_BF_Liste)
If Fehler.Abbruch Then Exit Sub

If Not IsEmpty(Delta_p_Waermetauscher) Then
    Delta_p_Waermetauscher_zulaessig = p_2 - p_1 + (p_1 - 1013) * (1 - Log(p_1) / 20)
    If Delta_p_Waermetauscher > Delta_p_Waermetauscher_zulaessig Then
        Call Fehlercode_zufuegen(Fehler, 239, Round(Delta_p_Waermetauscher_zulaessig) - 1)
        Fehler.Abbruch = True
    End If
End If
If Fehler.Abbruch Then Exit Sub

' Korrektur des Betriebsflüssigkeitsstroms für Gegendrücke bzw. Ansaugdrücke <> 1013mbar sowie Druckverlust im Wärmetauscher
If betr_art = 1 Then
    If p_1 < 1013 Then V_BF = V_BF_Liste * ((p_2 - p_1) / (1013 - p_1)) ^ 0.75  ' entsprechend Jörgs Programm
    If Not IsEmpty(Delta_p_Waermetauscher) Then
        Delta_p_Waermetauscher_zulaessig = p_2 - p_1 + (p_1 - 1013) * (1 - Log(p_1) / 20)
        If Delta_p_Waermetauscher > Delta_p_Waermetauscher_zulaessig Then
            Call Fehlercode_zufuegen(Fehler, 239, Round(Delta_p_Waermetauscher_zulaessig) - 1)
            Fehler.Abbruch = True
            Exit Sub
        Else
            V_BF = V_BF * Sqr((p_2 - p_1 - Delta_p_Waermetauscher) / (p_2 - p_1))
        End If
    End If
Else
    If p_2 > 1013 Then V_BF = V_BF_Liste * Sqr((p_2 - p_1) / (p_2 - 1013))
    ' If p_2 > 1013 Then V_BF = V_BF_Liste * ((p_2 - p_1) / (p_2 - 1013)) ^ 0.75  ' wäre analog zur oberen Formel
    If Not IsEmpty(Delta_p_Waermetauscher) Then Call Fehlercode_zufuegen(Fehler, 381) ' Wärmetauscherdruckverlust bei Kompressoren nicht berücksichtigt
End If

' Korrektur des Betriebsflüssigkeitsstroms für andere Dichten bzw. Viskositäten als die von Wasser
' Dichte und Viskosität der Betriebsflüssigkeit ermitteln
Call Stoffdaten_ist_BF(Fehler, BF, T_1, Empty, T_BF, Ber_Grp, Empty, Empty, Empty, Empty, Empty, rho_BF, ny_BF, Empty)
If Fehler.Abbruch Then Exit Sub

If IsEmpty(rho_BF) Then 'Falls keine Dichte der Betriebsflüssigkeit verfügbar ist, wird die von Wasser angenommen
    rho_BF = 1000
    Call Fehlercode_zufuegen(Fehler, 377)
End If
If IsEmpty(ny_BF) Then 'Falls keine Viskosität der Betriebsflüssigkeit verfügbar ist, wird die von Wasser angenommen
    ny_BF = 1
    Call Fehlercode_zufuegen(Fehler, 378)
End If

If ny_BF < 60 Then
    V_BF = V_BF * Sqr(1000 / rho_BF) * (1 - 0.015 * ny_BF) / 0.985
    If ny_BF > 15 Then Call Fehlercode_zufuegen(Fehler, 363)
Else
    V_BF = 0
    Call Fehlercode_zufuegen(Fehler, 364)
End If

If Not IsEmpty(V_BF_manuell) Then
    If V_BF_manuell >= V_BF Then
        V_1_F_hilf = V_BF_manuell - V_BF ' Fasse die Differenz als mitgeförderte Zusatzflüssigkeit auf (für Leistungskorrektur)
    Else
        Call Fehlercode_zufuegen(Fehler, 380, Round(V_BF, 2))
    End If
    V_BF = V_BF_manuell
Else
    V_1_F_hilf = V_1_F
End If

' Ermittlung der Misch-Betriebsflüssigkeitstemperatur, die sich bei Flüssigkeitsmitförderung ergibt
If IsEmpty(V_1_F) Or IsEmpty(V_BF) Or V_BF = 0 Then
    T_BF_misch = T_BF
Else
    T_BF_misch = (T_BF * V_BF + T_1 * V_1_F) / (V_BF + V_1_F)
End If

Call Stoffdaten_ist_Gas(Fehler, Gas, T_1, Empty, T_BF_misch, Ber_Grp, p_SD_Gas_T_1, Empty, p_SD_Gas_T_BF, cp_Gas, r_Gas, M_mol_Gas)
Call Stoffdaten_ist_BF(Fehler, BF, T_1, Empty, T_BF_misch, Ber_Grp, p_SD_BF_T_1, Empty, p_SD_BF_T_BF, c_BF, r_BF, rho_BF, ny_BF, M_mol_BF)

If IsEmpty(p_SD_BF_T_BF) Then
    Call Fehlercode_zufuegen(Fehler, 376)
    Fehler.Abbruch = True
End If

If p_SD_BF_T_BF > p_1 Then
    Call Fehlercode_zufuegen(Fehler, 372)
    Fehler.Abbruch = True
End If

If Fehler.Abbruch Then Exit Sub

Call Umrechnung_Gasstroeme(Fehler, Empty, Empty, V_1_Gas_rel, Empty, Empty, Empty, p_1, T_1, T_BF_misch, Gas, Ber_Grp, p_SD_Dampf, Psi, Empty, Empty, Empty, V_1_inert_rel_ges, Rel_Feuchte, p_2, False, BF, Empty, Empty)
If IsEmpty(Gas) Then V_1_inert_rel_ges = 1

Call Loeslichkeit_berechnen(Fehler, Gas, BF, T_BF_misch, Loeslichkeit)

Call Berechne_Lambda(Fehler, lambda_ges, lambda, p_1, p_2, p_SD_Dampf, Psi, T_1, T_BF_misch, V_1_Gas_rel, n, ny_BF, rho_BF, p_SD_BF_T_BF, Loeslichkeit, V_1_F, M_mol_Gas, Maschinendaten, Maschinen_ID, Werkstoff_ID, betr_art, Rel_Feuchte, n_ref, p_2_ref, V_1_ref)
Call Berechne_Phi(Fehler, phi_ges, phi, p_1, p_2, n, ny_BF, rho_BF, V_1_F_hilf, Maschinen_ID, Werkstoff_ID, Maschinendaten, betr_art, P_ref)
If Fehler.Abbruch Then Exit Sub

V_1_Gas_gesamt = V_1_Liste * lambda_ges
P_mech = P_mech_Liste * phi_ges

V_1_Gas_gesamt_norm = V_1_Gas_gesamt * (273.15 / 1013.25) * p_1 / (T_1 + 273.15)

Call Pruefung(Fehler, Maschinen_ID, Werkstoff_ID, betr_art, n, Maschinendaten, p_1, p_2, T_1, T_BF, rho_BF, ny_BF, V_1_Gas_gesamt, V_1_F, Gas, V_1_Gas_rel, p_SD_Gas_T_1, p_SD_Gas_T_BF)
Call Fehler_doppelt_entfernen(Fehler)

End Sub

	 * 
	 * 
	 * 
	 */
	
	//Call Betriebspunkt(Fehler, Empty, M_ID, W_ID, n, p_1, p_2, T_1, T_BF, Gas, V_1_Gas_rel, BF, V_1_F, Ber_Grp, V_1_Gas_gesamt, P_mech, V_BF, lambda, lambda_ges, phi, phi_ges, V_BF_manuell, Delta_p_Waermetauscher, n_ref, p_2_ref, V_1_ref, P_ref, V_1_Gas_gesamt_norm)
	public static void operatingPoint(ErrorCodeTable error, Object object, String m_ID, String w_ID, double n, double p_1, double p_2, double t_1, double t_BF, double gas, double v_1_Gas_rel, String bF, double v_1_F, int ber_Grp, double v_1_Gas_gesamt, double p_mech, double v_BF, double lambda, double lambda_ges, double phi, double phi_ges, double v_BF_manuell, double delta_p_Waermetauscher, int n_ref, double p_2_ref, double v_1_ref, double p_ref, double v_1_Gas_gesamt_norm)
	{
		
	}

/*
 * 
 * Public Sub Waermebilanz(Fehler As Fehlercodetyp, V_1_Gas_gesamt, P_mech, V_BF, V_1_Gas_rel, p_1, p_2, T_1, T_BF, Gas, BF, _
                        V_1_F, T_FF, Ber_Grp, T_2, Q_WT, V_FF, m_1_inert, m_1_Dampf_nicht_kondensiert, m_1_Dampf_kondensiert)

' -----------------------------------------------------------------------------------------------
' Diese Funktion ermittelt für einen bestimmten Betriebspunkt über eine Wärmebilanz die Auslass-
' temperatur T_2, den für den Umlaufbetrieb am Wärmetauscher abzuführenden Wärmestrom sowie
' den für den Kombinationsbetrieb notwendigen Frischflüssigkeitsvolumenstrom
'
' Ein- und Ausgabeparameter
'   Fehler
'
' Eingabgeparameter
'   V_1_Gas_gesamt                  Gesamt-Gasvolumenstrom am Saugstutzen [m³/h]
'   P_mech                          Leistungsaufnahme [kW]
'   V_BF                            Betriebsflüssigkeitsstrom [m³/h]
'   V_1_Gas_rel                     relative Volumenstromverteilung der Gase am Saugstutzen (als Array) [-]
'   p_1                             Ansaugdruck [mbar]
'   p_2                             Verdichtungsdruck [mbar]
'   T_1                             Gastemperatur am Saugstutzen [°C]
'   T_BF                            Temperatur der Betriebsflüssigkeit [°C]
'   Gas                             Stoff_IDs der Gase (als Array)
'   BF                              Stoff_ID der Betriebsflüssigkeit
'   V_1_F                           Volumenstrom der mitgeförderten Flüssigkeit [m³/h]
'   T_FF                            Frischflüssigkeitstemperatur [°C]
'   Ber_Grp                         Nutzer-Berechtigungsgruppe für Stoffdaten [-]

' Ausgabeparameter
'   T_2                             Stofftemperatur am Druckstutzen [°C]
'   Q_WT                            Notwendige Wärmeleistung eines Wärmetauschers für den Umlaufbetrieb [kW]
'   V_FF                            notwendiger Frischflüssigkeitsbedarf für Kombinationsbetrieb (nur bei Vorgabe von T_FF) [m³/h]
'   m_1_inert                       Massenströme der inerten Gasanteile des geförderten Gasstroms (als Array) [kg/h]
'   m_1_Dampf_nicht_kondensiert     Massenströme der nicht innerhalb der Maschine kondensierenden Dampfanteile des geförderten Gasstroms (als Array) [kg/h]
'   m_1_Dampf_kondensiert           Massenströme der innerhalb der Maschine kondensierenden Dampfanteile des geförderten Gasstroms (als Array) [kg/h]
'
' -----------------------------------------------------------------------------------------------

Dim m_2_Gas
Dim rho
Dim p_SD_Gas_T_2, cp_Gas, r_Gas, M_mol_Gas
Dim p_SD_BF_T_2, c_BF, r_BF, rho_BF, ny_BF, M_mol_BF
Dim V_1_Gas, V_1_inert, V_1_Dampf, V_1_Dampf_nicht_kondensiert, V_1_Dampf_kondensiert
Dim V_1_Dampf_gesamt, V_1_inert_gesamt, V_1_Dampf_nicht_kondensiert_gesamt
Dim m_2_BF_Dampf, p_BF_Dampf, p_SD_2_Summe
Dim Q_Kondensation, Q_Verdampfung
Dim H_1, H_2, H_BF
Dim phi_alt
Dim T_2_input_1, T_2_input_2, T_2_output_1, T_2_output_2
Dim Fehler_intern As Fehlercodetyp

Dim i As Integer, j As Integer, k As Integer
Dim a As Double, b As Double

m_1_inert = Empty
m_1_Dampf_nicht_kondensiert = Empty
m_1_Dampf_kondensiert = Empty

Call Pruefung_Eingabeparameter(Fehler, Empty, p_1, p_2, T_1, T_BF, Empty, Empty, Empty, V_1_F, V_1_Gas_rel, Ber_Grp, Empty, Empty)
' gegeben sein muss: T_BF, T_1, p_1, p_2, Gas, V_1_Gas_rel (beide als Array), V_1_Gas_gesamt (>0)

If Fehler.Abbruch Then Exit Sub

If IsEmpty(Gas) Or IsEmpty(BF) Then Exit Sub
If Not IsArray(Gas) Then Exit Sub
If V_1_Gas_gesamt <= 0 Or V_BF = 0 Then Exit Sub

ReDim V_1_Gas(LBound(Gas) To UBound(Gas)) As Double
ReDim V_1_inert(LBound(Gas) To UBound(Gas)) As Double
ReDim V_1_Dampf(LBound(Gas) To UBound(Gas)) As Double
ReDim V_1_Dampf_nicht_kondensiert(LBound(Gas) To UBound(Gas)) As Double
ReDim V_1_Dampf_kondensiert(LBound(Gas) To UBound(Gas)) As Double
ReDim m_2_Gas(LBound(Gas) To UBound(Gas)) As Double
ReDim m_1_inert(LBound(Gas) To UBound(Gas)) As Double
ReDim m_1_Dampf_nicht_kondensiert(LBound(Gas) To UBound(Gas)) As Double
ReDim m_1_Dampf_kondensiert(LBound(Gas) To UBound(Gas)) As Double

' Ermittlung von T_2 im Newton-Verfahren, max. 10 Schritte
For j = 1 To 10
    If j = 1 Then
        T_2_input_1 = T_BF
    Else
        T_2_input_1 = T_2_input_1 - (T_2_input_1 - T_2_output_1) / (1 - (T_2_output_2 - T_2_output_1) / (T_2_input_2 - T_2_input_1))
    End If
    
    For k = 1 To 2  ' Berechnung der Wärmebilanz bei 2 benachbarten Temperaturstellen (Delta T = 1K), um daraus numerisch die Ableitung zu bilden
        If k = 1 Then
            T_2 = T_2_input_1
        Else
            T_2_input_2 = T_2_input_1 + 1
            T_2 = T_2_input_2
        End If
    
        ' Ermittlung der notwendigen Stroffgrößen bei T_2
        Call Stoffdaten_ist_Gas(Fehler_intern, Gas, T_1, T_2, T_BF, Ber_Grp, Empty, p_SD_Gas_T_2, Empty, cp_Gas, r_Gas, M_mol_Gas)
        Call Stoffdaten_ist_BF(Fehler_intern, BF, T_1, T_2, T_BF, Ber_Grp, Empty, p_SD_BF_T_2, Empty, c_BF, r_BF, rho_BF, ny_BF, M_mol_BF)
        
        If Fehler_intern.Abbruch Then
            Call Fehlercode_zufuegen(Fehler, 223)
            Fehler.Abbruch = True
            Exit Sub
        End If
        
        V_1_Dampf_gesamt = 0
        V_1_inert_gesamt = 0
        m_2_BF_Dampf = 0
        p_BF_Dampf = 0
        phi_alt = 0
        p_SD_2_Summe = 0
        
        ' Einteilung der angesaugten Gase in Kondensations- und Inertgasanteile
        For i = LBound(Gas) To UBound(Gas)
            V_1_Gas(i) = V_1_Gas_gesamt * V_1_Gas_rel(i)
            If p_SD_Gas_T_2(i) < p_2 Then
                V_1_Dampf(i) = V_1_Gas(i)
                V_1_inert(i) = 0
                V_1_Dampf_gesamt = V_1_Dampf_gesamt + V_1_Dampf(i)
                p_SD_2_Summe = p_SD_2_Summe + p_SD_Gas_T_2(i)
            Else
                V_1_Dampf(i) = 0
                V_1_inert(i) = V_1_Gas(i)
                V_1_inert_gesamt = V_1_inert_gesamt + V_1_inert(i)
            End If
        Next i
        p_SD_2_Summe = p_SD_2_Summe + p_SD_BF_T_2
        For i = LBound(Gas) To UBound(Gas)
            If p_SD_Gas_T_2(i) < p_2 Then
                V_1_Dampf_nicht_kondensiert(i) = p_SD_Gas_T_2(i) ^ 2 / (p_2 * p_SD_2_Summe) * V_1_Gas_gesamt
                If V_1_Dampf_nicht_kondensiert(i) > V_1_Dampf(i) Then
                    V_1_Dampf_nicht_kondensiert(i) = V_1_Dampf(i)
                End If
                V_1_Dampf_kondensiert(i) = V_1_Dampf(i) - V_1_Dampf_nicht_kondensiert(i)
                phi_alt = phi_alt + V_1_Dampf_nicht_kondensiert(i) / V_1_Gas_gesamt * p_2 / p_SD_Gas_T_2(i)
            Else
                V_1_Dampf_kondensiert(i) = 0
                V_1_Dampf_nicht_kondensiert(i) = 0
            End If
            rho = p_1 / (R_uni / M_mol_Gas(i) * (T_1 + 273.15) * 10)
            m_1_inert(i) = rho * V_1_inert(i)
            m_1_Dampf_nicht_kondensiert(i) = rho * V_1_Dampf_nicht_kondensiert(i)
            m_1_Dampf_kondensiert(i) = rho * V_1_Dampf_kondensiert(i)
            m_2_Gas(i) = m_1_inert(i) + m_1_Dampf_nicht_kondensiert(i)
        Next i
        m_2_BF_Dampf = M_mol_BF * p_1 / (R_uni * (T_1 + 273.15) * 10) * (1 - phi_alt) * p_SD_BF_T_2 / p_2 * V_1_Gas_gesamt
        
        ' Berechnung der eingehenden Enthalpieströme am Saugstutzen (H_1) und BF-Anschluss (H_BF) [kW]
        H_1 = 0
        For i = LBound(Gas) To UBound(Gas)
            H_1 = H_1 + m_2_Gas(i) / 3600 * cp_Gas(i) * (T_1 + 273.15)    ' Enthalphiestrom der angesaugten, nicht kondensierten Gasströme
                                                                          ' die kondensierten Anteile werden bei der Kondensationswärme berücksichtigt
        Next i
        H_1 = H_1 + V_1_F / 3600 * rho_BF * c_BF * (T_1 + 273.15)         ' Enthalpiestrom der mitgeförderten (Betriebs-)Flüssigkeit
        H_BF = V_BF / 3600 * rho_BF * c_BF * (T_BF + 273.15)              ' Enthalpiestrom der Betriebsflüssigkeit
        
        ' Berechnung der freigesetzten Wärme durch die kondensierten Gasanteile [kW]
        Q_Kondensation = 0
        For i = LBound(Gas) To UBound(Gas)
            Q_Kondensation = Q_Kondensation + m_1_Dampf_kondensiert(i) / 3600 * r_Gas(i)
        Next i
        
        ' Berechnung der entzogenen Wärme durch die Verdampfung der Betriebsflüssigkeit ' [kW]
        Q_Verdampfung = m_2_BF_Dampf * r_BF / 3600
        
        ' Ausgehender Enthalphiestrom am Druckstutzen ergibt sich aus der Wärmebilanz [kW]
        H_2 = H_1 + H_BF + P_mech + Q_Kondensation - Q_Verdampfung
        
        ' Berechnung von T_2 [°C]
        a = 0
        For i = LBound(Gas) To UBound(Gas)
            a = a + m_2_Gas(i) / 3600 * cp_Gas(i)
        Next i
        T_2 = H_2 / (a + (V_1_F + V_BF) / 3600 * rho_BF * c_BF) - 273.15

        If k = 1 Then
            T_2_output_1 = T_2
        Else
            T_2_output_2 = T_2
        End If
    Next k
    If Abs(T_2_output_1 - T_2_input_1) < 0.5 Then Exit For
Next j

If j > 10 Then Call Fehlercode_zufuegen(Fehler, 369)

phi_alt = 0
For i = LBound(Gas) To UBound(Gas)
    phi_alt = phi_alt + V_1_Dampf_nicht_kondensiert(i) / V_1_Gas_gesamt * p_2 / p_SD_Gas_T_2(i)
Next i
phi_alt = phi_alt + m_2_BF_Dampf * (R_uni * (T_1 + 273.15) * 10) / (M_mol_BF * p_1) / V_1_Gas_gesamt * p_2 / p_SD_BF_T_2

T_2 = T_2_output_1

' Abzuführende Wärme am Wärmetauscher bei Umlaufbetrieb [kW]
Q_WT = V_BF / 3600 * rho_BF * c_BF * (T_2 - T_BF)
If Q_WT < 0 Then Call Fehlercode_zufuegen(Fehler, 368)

' Frischflüssigkeitsbedarf (bei Vorgabe von T_FF) [m³/h]
If Not IsEmpty(T_FF) Then
    If T_FF < T_BF Then
        If T_BF < T_2 Then
            V_FF = V_BF * (T_2 - T_BF) / (T_2 - T_FF)
        Else
            V_FF = Empty
            Call Fehlercode_zufuegen(Fehler, 366)
        End If
    Else
        V_FF = Empty
        Call Fehlercode_zufuegen(Fehler, 367)
    End If
End If

Call Fehler_doppelt_entfernen(Fehler)

End Sub

 * 
 * 
 * 
 */
	
//Call Waermebilanz(Fehler, V_1_Gas_gesamt, P_mech, V_BF, V_1_Gas_rel, p_1, p_2, T_1, T_BF, Gas, BF, V_1_F, T_FF, Ber_Grp, T_2, Q_WT, V_FF, Empty, Empty, Empty)
	
	public static void  heatBalance(ErrorCodeTable error, double v_1_Gas_gesamt, double p_mech, double v_BF, double v_1_Gas_rel, double p_1, double p_2, double t_1, double t_BF, double gas, String bF, double v_1_F, double t_FF, int ber_Grp, double t_2, double q_WT, double v_FF, Object object, Object object2, Object object3)
	{
		
	}
	
	
	//Call Max_Leistung(Fehler, betr_art, M_ID, W_ID, n, p_1, p_2, T_1, T_BF, Gas, V_1_Gas_rel, BF, V_1_F, V_BF_manuell, Delta_p_Waermetauscher, Ber_Grp, P_mech_max, p_2_max)
	public static void  max_power(ErrorCodeTable error, double betr_art, String m_ID, String w_ID, double n, double p_1, double p_2, double t_1, double t_BF, double gas, double v_1_Gas_rel, String bF, double v_1_F, double v_BF_manuell, double delta_p_Waermetauscher, int ber_Grp, double p_mech_max, double p_2_max)
	{
		
	}

	
	
}
