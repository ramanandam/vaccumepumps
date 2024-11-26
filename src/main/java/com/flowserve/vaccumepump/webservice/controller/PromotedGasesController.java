package com.flowserve.vaccumepump.webservice.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.flowserve.vaccumepump.webservice.dto.IVacuumPumpDetails;
import com.flowserve.vaccumepump.webservice.dto.IVacuumSelectionInputs;
import com.flowserve.vaccumepump.webservice.model.ErrorCodeTable;
import com.flowserve.vaccumepump.webservice.model.GasRadiatorTable;
import com.flowserve.vaccumepump.webservice.model.MachineTable;
import com.flowserve.vaccumepump.webservice.model.SubstanceNameTable;
import com.flowserve.vaccumepump.webservice.util.FormUtil;
@RestController
public class PromotedGasesController {

	
	
	
	
	/*
	 * Sub Button_Gasstroeme_berechnen()
	 * 
	 * Dim Gas, V_1_Gas_rel, V_1_Gas, V_1_Gas_gesamt, m_1_Gas_rel, m_1_Gas,
	 * m_1_Gas_gesamt, V_1_Gas_gesamt_norm Dim p_1, p_2, T_1, T_BF, p_SD_Dampf, Psi,
	 * Ist_Dampf, p_SD_Gas_T_1, p_SD_Gas_T_BF Dim Rel_Feuchte, BF, M_mol_mittel Dim
	 * saettigen As Boolean Dim Fehler As Fehlercodetyp Dim Ber_Grp
	 * 
	 * Dim i As Integer
	 * 
	 * If stc_Ergebnis <> 0 Or stc_Berechnungsart <> 1 Then stc_Ergebnis = 0
	 * stc_Berechnungsart = 1 Call stc_neu_markieren Exit Sub End If
	 * 
	 * Call Manuelle_Stoffdaten_uebertragen
	 * 
	 * Ber_Grp = Application.Names("Formular_Berechtigungsgruppe").RefersToRange BF
	 * = Application.Names("Formular_BF").RefersToRange
	 * 
	 * ' Übernehme Stoff_IDs und Volumen- bzw. alternativ Massenströme in ein Array
	 * Call Gasstrom_Eingaben_einlesen(Gas, V_1_Gas, V_1_Gas_rel, m_1_Gas,
	 * m_1_Gas_rel, V_1_Gas_gesamt, m_1_Gas_gesamt)
	 * 
	 * p_1 = Application.Names("Formular_p_1").RefersToRange p_2 =
	 * Application.Names("Formular_p_2").RefersToRange T_1 =
	 * Application.Names("Formular_T_1").RefersToRange T_BF =
	 * Application.Names("Formular_T_BF").RefersToRange saettigen =
	 * CheckBox_saettigen.Value
	 * 
	 * Call Umrechnung_Gasstroeme(Fehler, V_1_Gas_gesamt, V_1_Gas, V_1_Gas_rel,
	 * m_1_Gas_gesamt, m_1_Gas, m_1_Gas_rel, p_1, T_1, T_BF, Gas, Ber_Grp,
	 * p_SD_Dampf, Psi, Ist_Dampf, p_SD_Gas_T_1, p_SD_Gas_T_BF, Empty, Rel_Feuchte,
	 * p_2, saettigen, BF, M_mol_mittel, V_1_Gas_gesamt_norm)
	 * 
	 * stc_Makro_Berechnung = True
	 * 
	 * If Not Fehler.Abbruch Then Call Gasstroeme_ausgeben(Gas, V_1_Gas,
	 * V_1_Gas_rel, m_1_Gas, m_1_Gas_rel, V_1_Gas_gesamt, m_1_Gas_gesamt, Ist_Dampf,
	 * p_SD_Gas_T_BF, p_SD_Gas_T_1)
	 * 
	 * Application.Names("Formular_V_1_Gas_gesamt_norm").RefersToRange =
	 * V_1_Gas_gesamt_norm
	 * 
	 * Application.Names("Formular_p_1").RefersToRange = p_1
	 * Application.Names("Formular_p_2").RefersToRange = p_2
	 * Application.Names("Formular_T_1").RefersToRange = T_1
	 * Application.Names("Formular_T_BF").RefersToRange = T_BF
	 * 
	 * Application.Names("Formular_p_SD_Dampf").RefersToRange = p_SD_Dampf If Not
	 * IsEmpty(Rel_Feuchte) Then Application.Names("Formular_Feuchte").RefersToRange
	 * = Rel_Feuchte * 100 Else Application.Names("Formular_Feuchte").RefersToRange
	 * = Empty End If Application.Names("Formular_Psi").RefersToRange = Psi
	 * Application.Names("Formular_M_mol_mittel").RefersToRange = M_mol_mittel
	 * 
	 * Call Fehlertext_anzeigen(Fehler)
	 * 
	 * If Fehlerart_kritisch(Fehler) = 1 Or Fehlerart_kritisch(Fehler) = 2 Then
	 * stc_Ergebnis = -1 Else stc_Ergebnis = 1 End If
	 * 
	 * stc_Makro_Berechnung = False Call stc_neu_markieren
	 * 
	 * End Sub
	 */
	
	
	
	
	//calculate Gas flow button
	//Button_Gasstroeme_berechnen
	//Gasströme berechnen button 
	@RequestMapping(value = "/vaccumepumps/rest/promotedgases/calculateaasflowbutton", method = RequestMethod.POST)
	public ResponseEntity<IVacuumPumpDetails> operatingfluidChange(@RequestBody IVacuumSelectionInputs input) {

		IVacuumPumpDetails respose = new IVacuumPumpDetails();
		// Define variables (equivalent to Dim in VB)
	     double gas = 0, V_1_Gas_rel = 0, V_1_Gas = 0, V_1_Gas_gesamt = 0, m_1_Gas_rel = 0, m_1_Gas = 0, m_1_Gas_gesamt = 0, V_1_Gas_gesamt_norm = 0;
	     double p_1, p_2, T_1, T_BF, p_SD_Dampf = 0, Psi = 0, Ist_Dampf = 0, p_SD_Gas_T_1 = 0, p_SD_Gas_T_BF = 0;
	     double Rel_Feuchte=0, bf, M_mol_mittel = 0;
	     boolean saturated;// CheckBox_saettigen
	     ErrorCodeTable error = null;
	     String berGrp;
	  // Assume these are class-level or instance-level variables
	      int stcErgebnis=input.getStc_result();
	      int stcBerechnungsart=input.getStcCalculationType();
	    
	      if (stcErgebnis != 0 || stcBerechnungsart != 1) {
	            stcErgebnis = 0;
	            stcBerechnungsart = 1;
	            FormUtil.stc_new_mark();//Call stc_neu_markieren
	            //return respose;
	        }else {
	        	
	        	FormUtil.manual_substance_data_transferred();
	        	berGrp=input.getPermissionGroup();
	        	bf=input.getBf();
	        	 // Read input data into variables
	        	FormUtil.readGasFlowInputs(gas, V_1_Gas, V_1_Gas_rel, m_1_Gas, m_1_Gas_rel, V_1_Gas_gesamt, m_1_Gas_gesamt);
	        	p_1 = input.getP_1();
	        	p_2 = input.getP_2();
	        	T_1 = input.getT_1();
	        	T_BF = input.getT_BF();
	        	saturated = input.isCheckBox_saturate();
	        	//Call Umrechnung_Gasstroeme(Fehler, V_1_Gas_gesamt, V_1_Gas, V_1_Gas_rel, m_1_Gas_gesamt, m_1_Gas, m_1_Gas_rel, p_1, T_1, T_BF, Gas, Ber_Grp, p_SD_Dampf, Psi, Ist_Dampf, p_SD_Gas_T_1, p_SD_Gas_T_BF, Empty, Rel_Feuchte, p_2, saettigen, BF, M_mol_mittel, V_1_Gas_gesamt_norm)
	        	
	        	FormUtil.conversion_gas_flows(error, V_1_Gas_gesamt, V_1_Gas, V_1_Gas_rel, m_1_Gas_gesamt, m_1_Gas, m_1_Gas_rel, p_1, T_1, T_BF, gas, berGrp, p_SD_Dampf, Psi, Ist_Dampf, p_SD_Gas_T_1, p_SD_Gas_T_BF, null, Rel_Feuchte, p_2, saturated, bf, M_mol_mittel, V_1_Gas_gesamt_norm);
	        	respose.setStc_Makro_Berechnung(true);
	        	
	        	
	        	
	        	if (!error.getErrorType().equalsIgnoreCase("abort")) {
	                //gasstroemeAusgeben
	        		//Call Gasstroeme_ausgeben(Gas, V_1_Gas, V_1_Gas_rel, m_1_Gas, m_1_Gas_rel, V_1_Gas_gesamt, m_1_Gas_gesamt, Ist_Dampf, p_SD_Gas_T_BF, p_SD_Gas_T_1)
	        		FormUtil.gasStreamsOutput(gas, V_1_Gas, V_1_Gas_rel, m_1_Gas, m_1_Gas_rel, V_1_Gas_gesamt, m_1_Gas_gesamt, Ist_Dampf, p_SD_Gas_T_BF, p_SD_Gas_T_1);
	            }
	        	
	        	 
	        	respose.setV_1_Gas_total_norm(V_1_Gas_gesamt_norm);
	        	respose.setP_1(p_1);
	        	respose.setP_2(p_2);
	        	respose.setT_1(T_1);
	        	respose.setT_BF(T_BF);
	        	
	        	
	        //	Application.Names("Formular_p_SD_Dampf").RefersToRange = p_SD_Dampf
			/*
			 * If Not IsEmpty(Rel_Feuchte) Then
			 * Application.Names("Formular_Feuchte").RefersToRange = Rel_Feuchte * 100 Else
			 * Application.Names("Formular_Feuchte").RefersToRange = Empty End If
			 * Application.Names("Formular_Psi").RefersToRange = Psi
			 * Application.Names("Formular_M_mol_mittel").RefersToRange = M_mol_mittel
			 */
	        	respose.setP_SD_Dampf(p_SD_Dampf);
	        	String str = Rel_Feuchte+"";
	        	if(StringUtils.isNoneBlank(str))
	        	{
	        		respose.setFeuchte(Rel_Feuchte * 100+"");
	        	}else {
	        		
	        		respose.setFeuchte(StringUtils.EMPTY);
	        	}                             
	        	 
	        	
	        	
	        	respose.setPsi(Psi);
	        	respose.setM_mol_mittel(M_mol_mittel);
	        	
	        	// Call Fehlertext_anzeigen(Fehler)
	        	FormUtil.show_error_text(error);
	        	int stc_result=input.getStc_result();
	        	if(FormUtil.errorTypeCritical(error)==1 ||FormUtil.errorTypeCritical(error)==2)
	        	{
	        		respose.setStc_result(-1);
	        	}else {
	        		
	        		respose.setStc_result(1);
	        	}
	        	
	        	respose.setStc_Macro_Calculation(false);
	        	

	        		
	        		//Call stc_neu_markieren
	        	
	        	FormUtil.stc_new_mark();
	        	
	        	 
	        }

		
		return ResponseEntity.ok().body(respose);

	}
	
	
	/*
	 * Private Sub Workbook_Open()
	 * 
	 * Dim Formular As Worksheet, Maschinentabelle As Worksheet, Stoffnamentabelle
	 * As Worksheet Dim Gasstrahlertabelle As Worksheet Dim ComboBox_Maschinen_ID As
	 * ComboBox Dim ComboBox_Gasstrahler As ComboBox Dim a As Range Dim i As
	 * Integer, j As Integer Dim M_ID, M_ID_alt, G_ID, n Dim ComboBox_array,
	 * combobox_array2 Dim entry Dim col_G_ID, col_M_ID, col_n Dim col_stoffname,
	 * col_Stoff_ID, col_Sprachcode Dim dataset_row Dim Stoffname, Stoff_ID,
	 * Sprachcode
	 * 
	 * Set Formular = Worksheets("Formular") Set ComboBox_Maschinen_ID =
	 * Formular.OLEObjects("ComboBox_Maschinen_ID").Object Set ComboBox_Gasstrahler
	 * = Formular.OLEObjects("ComboBox_Gasstrahler").Object
	 * 
	 * Set Maschinentabelle = Worksheets("Maschinentabelle") Set Stoffnamentabelle =
	 * Worksheets("Stoffnamentabelle") Set Gasstrahlertabelle =
	 * Worksheets("Gasstrahlertabelle")
	 * 
	 * 
	 * ComboBox_Maschinen_ID.Clear
	 * 
	 * dataset_row = CONST_dataset_row_start Do M_ID =
	 * Maschinentabelle.Cells(dataset_row, 1) If (Not IsEmpty(M_ID)) And (M_ID <>
	 * M_ID_alt) Then ComboBox_Maschinen_ID.AddItem M_ID M_ID_alt = M_ID End If
	 * dataset_row = dataset_row + 1 Loop Until IsEmpty(M_ID)
	 * 
	 * ReDim ComboBox_array(800, 4) i = 0 ComboBox_Gasstrahler.Clear col_G_ID =
	 * Gasstrahlertabelle.Rows(1).Find("TYP", , , xlWhole).Column col_M_ID =
	 * Gasstrahlertabelle.Rows(1).Find("PUMPE", , , xlWhole).Column col_n =
	 * Gasstrahlertabelle.Rows(1).Find("RPM", , , xlWhole).Column dataset_row =
	 * CONST_dataset_row_start Do G_ID = Gasstrahlertabelle.Cells(dataset_row,
	 * col_G_ID) If Not IsEmpty(G_ID) Then M_ID =
	 * Gasstrahlertabelle.Cells(dataset_row, col_M_ID) n =
	 * Gasstrahlertabelle.Cells(dataset_row, col_n) ComboBox_array(i, 0) = G_ID
	 * ComboBox_array(i, 1) = M_ID ComboBox_array(i, 2) = n ComboBox_array(i, 3) =
	 * G_ID & " - " & M_ID & " - " & Str(n) & " U/min" i = i + 1 End If dataset_row
	 * = dataset_row + 1 Loop Until IsEmpty(G_ID) If i > 0 Then ReDim
	 * combobox_array2(i - 1, 4) For j = 0 To i - 1 combobox_array2(j, 0) =
	 * ComboBox_array(j, 0) combobox_array2(j, 1) = ComboBox_array(j, 1)
	 * combobox_array2(j, 2) = ComboBox_array(j, 2) combobox_array2(j, 3) =
	 * ComboBox_array(j, 3) Next j
	 * Formular.OLEObjects("ComboBox_Gasstrahler").Object.List() = combobox_array2
	 * End If
	 * 
	 * col_stoffname = Stoffnamentabelle.Rows(1).Find("NAME", , , xlWhole).Column
	 * col_Sprachcode = Stoffnamentabelle.Rows(1).Find("Sprachcode", , ,
	 * xlWhole).Column col_Stoff_ID = Stoffnamentabelle.Rows(1).Find("Stoff_ID", , ,
	 * xlWhole).Column ReDim combobox_array2(800, 1) dataset_row =
	 * CONST_dataset_row_start i = 0 Do Stoffname =
	 * Stoffnamentabelle.Cells(dataset_row, col_stoffname) Stoff_ID =
	 * Stoffnamentabelle.Cells(dataset_row, col_Stoff_ID) Sprachcode =
	 * Stoffnamentabelle.Cells(dataset_row, col_Sprachcode) If Not
	 * IsEmpty(Stoffname) And Sprachcode = "de" Then combobox_array2(i, 0) =
	 * Stoffname combobox_array2(i, 1) = Stoff_ID i = i + 1 End If dataset_row =
	 * dataset_row + 1 Loop Until IsEmpty(Stoffname) If i > 0 Then ReDim
	 * ComboBox_array(i - 1, 2) For j = 0 To i - 1 ComboBox_array(j, 0) =
	 * combobox_array2(j, 0) ComboBox_array(j, 1) = combobox_array2(j, 1) Next j End
	 * If
	 * 
	 * Formular.OLEObjects("ComboBox_Gas_1").Object.List() = ComboBox_array
	 * Formular.OLEObjects("ComboBox_Gas_2").Object.List() = ComboBox_array
	 * Formular.OLEObjects("ComboBox_Gas_3").Object.List() = ComboBox_array
	 * Formular.OLEObjects("ComboBox_Gas_4").Object.List() = ComboBox_array
	 * Formular.OLEObjects("ComboBox_Gas_5").Object.List() = ComboBox_array
	 * Formular.OLEObjects("ComboBox_Gas_6").Object.List() = ComboBox_array
	 * Formular.OLEObjects("ComboBox_BF").Object.List() = ComboBox_array
	 * Formular.OLEObjects("ComboBox_Manual_Gas_1").Object.List() = ComboBox_array
	 * Formular.OLEObjects("ComboBox_Manual_Gas_2").Object.List() = ComboBox_array
	 * Formular.OLEObjects("ComboBox_Manual_BF").Object.List() = ComboBox_array
	 * 
	 * Formular.OLEObjects("ComboBox_Gas_1").Object.ListIndex = -1
	 * Formular.OLEObjects("ComboBox_Gas_2").Object.ListIndex = -1
	 * Formular.OLEObjects("ComboBox_Gas_3").Object.ListIndex = -1
	 * Formular.OLEObjects("ComboBox_Gas_4").Object.ListIndex = -1
	 * Formular.OLEObjects("ComboBox_Gas_5").Object.ListIndex = -1
	 * Formular.OLEObjects("ComboBox_Gas_6").Object.ListIndex = -1
	 * Formular.OLEObjects("ComboBox_Manual_Gas_1").Object.ListIndex = -1
	 * Formular.OLEObjects("ComboBox_Manual_Gas_2").Object.ListIndex = -1
	 * Formular.OLEObjects("ComboBox_Manual_BF").Object.ListIndex = -1
	 * 
	 * End Sub
	 */


	
	
	//Load 6 lists in Promoted Gas Foms when page laoding ..
	@RequestMapping(value = "/vaccumepumps/rest/promotedgases/loadlists", method = RequestMethod.GET)
	public ResponseEntity<IVacuumPumpDetails> loadListInPromotedGases(@RequestBody IVacuumSelectionInputs input) throws SQLException {
		
		List<MachineTable>       MachineTableList=new ArrayList<>();
		List<SubstanceNameTable> substanceNameTableList=new ArrayList<>();
		List<GasRadiatorTable>   gasRadiatorTable=new ArrayList<>();
		
		//Get above tables data from DB ...
		

		List<String> comboBox_Gas_List = new ArrayList<>();
		Map<String,SubstanceNameTable> substanceNameTableMap = new HashMap<>();
        for(SubstanceNameTable record: substanceNameTableList)
        {
        	comboBox_Gas_List.add(record.getMedium_name());
        	substanceNameTableMap.put(record.getMedium_name(), record);
        }
		
        IVacuumPumpDetails respose = new IVacuumPumpDetails();
        respose.setComboBox_Gas_List(comboBox_Gas_List);
        respose.setSubstanceNameTableMap(substanceNameTableMap);

		return ResponseEntity.ok().body(respose);

	}
	
	
	
	
	
}
