package com.flowserve.vaccumepump.webservice.controller;

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
public class OperatingPointForSelectedMachine {

	/*
	 * Sub Button_Betriebspunkt_berechnen()
	 * 
	 * Dim M_ID As String, W_ID Dim p_1, p_2, T_1, T_BF, V_1_F, V_1_Gas,
	 * V_1_Gas_gesamt, V_1_Gas_gesamt_norm, P_mech, P_mech_max, V_BF, p_2_max Dim
	 * m_1_Gas, m_1_Gas_rel, m_1_Gas_gesamt Dim p_SD_Dampf, Psi, Ist_Dampf,
	 * p_SD_Gas_T_1, p_SD_Gas_T_BF, Rel_Feuchte, M_mol_mittel Dim V_BF_manuell,
	 * Delta_p_Waermetauscher, saettigen Dim n Dim Fehler As Fehlercodetyp Dim
	 * lambda, lambda_ges, phi, phi_ges Dim T_FF, V_FF, T_2, Q_WT Dim betr_art,
	 * Ber_Grp Dim Chart_Saugvermoegen As Chart Dim a As Range Dim felder_gefuellt
	 * As Boolean Dim n_ref, p_2_ref, V_1_ref, P_ref
	 * 
	 * Dim Gas, BF Dim V_1_Gas_rel Dim i As Integer Dim j As Integer
	 * 
	 * M_ID = Application.Names("Formular_Maschinen_ID").RefersToRange W_ID =
	 * Application.Names("Formular_werkstoff_ID").RefersToRange n =
	 * Application.Names("Formular_Drehzahl").RefersToRange p_1 =
	 * Application.Names("Formular_p_1").RefersToRange p_2 =
	 * Application.Names("Formular_p_2").RefersToRange T_1 =
	 * Application.Names("Formular_T_1").RefersToRange T_BF =
	 * Application.Names("Formular_T_BF").RefersToRange V_1_F =
	 * Application.Names("Formular_V_1_F").RefersToRange BF =
	 * Application.Names("Formular_BF").RefersToRange T_FF =
	 * Application.Names("Formular_T_FF").RefersToRange Ber_Grp =
	 * Application.Names("Formular_Berechtigungsgruppe").RefersToRange V_BF_manuell
	 * = Application.Names("Formular_V_BF_manuell").RefersToRange
	 * Delta_p_Waermetauscher =
	 * Application.Names("Formular_Delta_p_Waermetauscher").RefersToRange saettigen
	 * = CheckBox_saettigen.Value
	 * 
	 * Call Manuelle_Stoffdaten_uebertragen
	 * 
	 * If UCase(BF) = "MANUAL_BF" Then BF = "MANUAL_BF"
	 * 
	 * If stc_Ergebnis <> 0 Or stc_Berechnungsart <> 2 Then ' Es darf nur die
	 * relative Volumenstromverteilung der Gase vorgegeben sein If
	 * stc_V_1_Gas_gesamt_gegeben Or stc_m_1_Gas_gesamt_gegeben Then
	 * stc_V_1_Gas_gesamt_gegeben = False stc_m_1_Gas_gesamt_gegeben = False '
	 * felder_gefuellt = False ' For Each a In
	 * Application.Names("Formular_V_1_Gas_rel").RefersToRange ' i = i + 1 ' If i >
	 * stc_Anzahl_Gase Then Exit For ' If Not IsEmpty(a) Then felder_gefuellt = True
	 * ' Next a ' If felder_gefuellt Then stc_V_1_Gas_rel_gegeben = True End If
	 * stc_Ergebnis = 0 stc_Berechnungsart = 2 Call stc_neu_markieren Exit Sub End
	 * If
	 * 
	 * ' Übernehme Stoff_IDs und Volumen- bzw. alternativ Massenströme in ein Array
	 * Call Gasstrom_Eingaben_einlesen(Gas, V_1_Gas, V_1_Gas_rel, m_1_Gas,
	 * m_1_Gas_rel, V_1_Gas_gesamt, m_1_Gas_gesamt)
	 * 
	 * Call Umrechnung_Gasstroeme(Fehler, V_1_Gas_gesamt, V_1_Gas, V_1_Gas_rel,
	 * m_1_Gas_gesamt, m_1_Gas, m_1_Gas_rel, p_1, T_1, T_BF, Gas, Ber_Grp, Empty,
	 * Empty, Empty, Empty, Empty, Empty, Empty, p_2, saettigen, BF, Empty, Empty)
	 * If Not Fehler.Abbruch Then V_1_Gas = Empty V_1_Gas_gesamt = Empty m_1_Gas =
	 * Empty m_1_Gas_rel = Empty m_1_Gas_gesamt = Empty End If Call
	 * Betriebspunkt(Fehler, Empty, M_ID, W_ID, n, p_1, p_2, T_1, T_BF, Gas,
	 * V_1_Gas_rel, BF, V_1_F, Ber_Grp, V_1_Gas_gesamt, P_mech, V_BF, lambda,
	 * lambda_ges, phi, phi_ges, V_BF_manuell, Delta_p_Waermetauscher, n_ref,
	 * p_2_ref, V_1_ref, P_ref, V_1_Gas_gesamt_norm) Call Waermebilanz(Fehler,
	 * V_1_Gas_gesamt, P_mech, V_BF, V_1_Gas_rel, p_1, p_2, T_1, T_BF, Gas, BF,
	 * V_1_F, T_FF, Ber_Grp, T_2, Q_WT, V_FF, Empty, Empty, Empty) Call
	 * Max_Leistung(Fehler, betr_art, M_ID, W_ID, n, p_1, p_2, T_1, T_BF, Gas,
	 * V_1_Gas_rel, BF, V_1_F, V_BF_manuell, Delta_p_Waermetauscher, Ber_Grp,
	 * P_mech_max, p_2_max) Call Umrechnung_Gasstroeme(Fehler, V_1_Gas_gesamt,
	 * V_1_Gas, V_1_Gas_rel, m_1_Gas_gesamt, m_1_Gas, m_1_Gas_rel, p_1, T_1, T_BF,
	 * Gas, Ber_Grp, p_SD_Dampf, Psi, Ist_Dampf, p_SD_Gas_T_1, p_SD_Gas_T_BF, Empty,
	 * Rel_Feuchte, p_2, Empty, BF, M_mol_mittel, V_1_Gas_gesamt_norm)
	 * 
	 * Call Fehlertext_anzeigen(Fehler) If Fehlerart_kritisch(Fehler) = 1 Or
	 * Fehlerart_kritisch(Fehler) = 2 Then stc_Ergebnis = -1 Else stc_Ergebnis = 1
	 * End If
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
	 * Application.Names("Formular_P").RefersToRange = P_mech
	 * Application.Names("Formular_P_max").RefersToRange = P_mech_max
	 * Application.Names("Formular_p_2_max").RefersToRange = p_2_max
	 * Application.Names("Formular_V_BF").RefersToRange = V_BF
	 * 
	 * Application.Names("Formular_p_1").RefersToRange = p_1
	 * Application.Names("Formular_p_2").RefersToRange = p_2
	 * Application.Names("Formular_T_1").RefersToRange = T_1
	 * Application.Names("Formular_T_BF").RefersToRange = T_BF
	 * Application.Names("Formular_Drehzahl").RefersToRange = n
	 * Application.Names("Formular_lambda").RefersToRange = lambda_ges If Not
	 * IsEmpty(lambda) Then Application.Names("Formular_lambda_1").RefersToRange =
	 * lambda(1) Application.Names("Formular_lambda_2").RefersToRange = lambda(2)
	 * Application.Names("Formular_lambda_3").RefersToRange = lambda(3)
	 * Application.Names("Formular_lambda_4").RefersToRange = lambda(4)
	 * Application.Names("Formular_lambda_5").RefersToRange = lambda(5)
	 * Application.Names("Formular_lambda_6").RefersToRange = lambda(6)
	 * Application.Names("Formular_lambda_7").RefersToRange = lambda(7)
	 * Application.Names("Formular_lambda_8").RefersToRange = lambda(8)
	 * Application.Names("Formular_lambda_9").RefersToRange = lambda(9) Else
	 * Application.Names("Formular_lambdas").RefersToRange = Empty End If
	 * Application.Names("Formular_phi").RefersToRange = phi_ges If Not IsEmpty(phi)
	 * Then Application.Names("Formular_phi_6").RefersToRange = phi(6)
	 * Application.Names("Formular_phi_7").RefersToRange = phi(7)
	 * Application.Names("Formular_phi_8").RefersToRange = phi(8)
	 * Application.Names("Formular_phi_9").RefersToRange = phi(9) Else
	 * Application.Names("Formular_phis").RefersToRange = Empty End If
	 * Application.Names("Formular_n_ref").RefersToRange = n_ref
	 * Application.Names("Formular_p_2_ref").RefersToRange = p_2_ref
	 * Application.Names("Formular_V_1_ref").RefersToRange = V_1_ref
	 * Application.Names("Formular_P_ref").RefersToRange = P_ref
	 * Application.Names("Formular_T_2").RefersToRange = T_2
	 * Application.Names("Formular_Q_WT").RefersToRange = Q_WT
	 * Application.Names("Formular_V_FF").RefersToRange = V_FF stc_Makro_Berechnung
	 * = False
	 * 
	 * Call stc_neu_markieren
	 * 
	 * Set Chart_Saugvermoegen = Formular.ChartObjects.Item(1).Chart
	 * 
	 * End Sub
	 */

	// machine selection For Operating Point Button
	@RequestMapping(value = "/vaccumepumps/rest/machineButtonselectionForOperatingPoint/change", method = RequestMethod.POST)
	public ResponseEntity<IVacuumPumpDetails> operatingfluidChange(@RequestBody IVacuumSelectionInputs input) {
		ErrorCodeTable error = new ErrorCodeTable();
		IVacuumPumpDetails respose = new IVacuumPumpDetails();

		String M_ID = input.getMachineID(); // formularData.get("Formular_Maschinen_ID");
		String W_ID = input.getMaterialID();// (String) formularData.get("Formular_werkstoff_ID");
		double n = input.getDrehzahl();// (double) formularData.get("Formular_Drehzahl");
		double p_1 = input.getP_1();// (double) formularData.get("Formular_p_1");
		double p_2 = input.getP_2();// (double) formularData.get("Formular_p_2");
		double T_1 = input.getT_BF();// (double) formularData.get("Formular_T_1");
		double T_BF = input.getT_BF();// (double) formularData.get("Formular_T_BF");
		double V_1_F = (double) input.getV_1_F();// (double) formularData.get("Formular_V_1_F");
		String BF = String.valueOf(input.getBf());// (String) formularData.get("Formular_BF");
		double T_FF = input.getT_FF();// (double) formularData.get("Formular_T_FF");
		int Ber_Grp = input.getAuthorizationGroup();// (int) formularData.get("Formular_Berechtigungsgruppe");
		double V_BF_manuell = input.getV_BF_manuell();// (double) formularData.get("Formular_V_BF_manuell");
		double Delta_p_Waermetauscher = input.getDelta_p_Waermetauscher();// (double)
																			// formularData.get("Formular_Delta_p_Waermetauscher");
		boolean saettigen = input.isCheckBox_saturate();// (boolean) formularData.get("CheckBox_saettigen");

		double phi = input.getPhi();
		double lambda = input.getLambda();
		double V_FF = input.getV_FF();
		// Initialize placeholders for outputs
		double V_1_Gas_gesamt_norm = 0;
		double P_mech = 0, P_mech_max = 0, V_BF = 0, lambda_ges = 0, phi_ges = 0, T_2 = 0, Q_WT = 0;
		int n_ref = 0;
		double p_2_ref = 0, V_1_ref = 0, P_ref = 0;

		// Call Manuelle_Stoffdaten_uebertragen

		FormUtil.manuelle_Stoffdaten_uebertragen();
		if ("MANUAL_BF".equalsIgnoreCase(BF)) {
			BF = "MANUAL_BF";
		}

		int stc_Result = input.getStc_result();

		int stcCalculationType = input.getStcCalculationType();

		boolean stc_V_1_Gas_Total_Provided = input.isStc_V_1_Gas_Total_Provided();
		boolean stc_m_1_Gas_Total_Given = input.isStc_m_1_Gas_Total_Given();

		/*
		 * If stc_Ergebnis <> 0 Or stc_Berechnungsart <> 2 Then If
		 * stc_V_1_Gas_gesamt_gegeben Or stc_m_1_Gas_gesamt_gegeben Then
		 * stc_V_1_Gas_gesamt_gegeben = False stc_m_1_Gas_gesamt_gegeben = False End If
		 * stc_Ergebnis = 0 stc_Berechnungsart = 2 Call stc_neu_markieren Exit Sub End
		 * If
		 */

		if (stc_Result != 0 || stcCalculationType != 2) {
			if (stc_V_1_Gas_Total_Provided || stc_m_1_Gas_Total_Given) {
				stc_V_1_Gas_Total_Provided = false;
				stc_m_1_Gas_Total_Given = false;

			}
			stc_Result = 0;
			stcCalculationType = 2;

		}

		double gas = input.getGas();
		double V_1_Gas_rel = input.getV_1_Gas_rel();
		double V_1_Gas = input.getV_1_Gas();
		double m_1_Gas = input.getM_1_Gas();
		double m_1_Gas_rel = input.getM_1_Gas_rel();
		double V_1_Gas_gesamt = input.getV_1_Gas_Total_Volume();
		double V_1_Gas_Total = V_1_Gas_gesamt;
		double p_2_max = input.getP_2_max();
		double V_1_Gas_Total_Volume = V_1_Gas_gesamt; // V_1_Gas_gesamt
		// Übernehme Stoff_IDs und Volumen- bzw. alternativ Massenströme in ein Array
		// transfer SubstanceIds And Flow Rates To Array

		// Sub Gasstrom_Eingaben_einlesen(Gas, V_1_Gas, V_1_Gas_rel, m_1_Gas,
		// m_1_Gas_rel, V_1_Gas_gesamt, m_1_Gas_gesamt)
		FormUtil.gasFlowInputRead(gas, V_1_Gas, V_1_Gas_rel, m_1_Gas, m_1_Gas_rel, V_1_Gas_Total_Volume, V_1_Gas_Total);
		// Call Umrechnung_Gasstroeme(Fehler, V_1_Gas_gesamt, V_1_Gas, V_1_Gas_rel,
		// m_1_Gas_gesamt, m_1_Gas, m_1_Gas_rel, p_1, T_1, T_BF, Gas, Ber_Grp, Empty,
		// Empty, Empty, Empty, Empty, Empty, Empty, p_2, saettigen, BF, Empty, Empty)
		FormUtil.conversion_gas_flows(error, V_1_Gas_gesamt, V_1_Gas, V_1_Gas_rel, V_1_Gas_gesamt, m_1_Gas, m_1_Gas_rel,
				p_1, T_1, T_BF, m_1_Gas_rel, BF, p_2, V_1_Gas_gesamt, T_2, gas, T_BF, gas, V_1_Gas_Total, p_2_ref,
				stc_m_1_Gas_Total_Given, V_BF, V_1_Gas_Total_Volume, V_1_Gas_gesamt_norm);

		if (true) {// Need to analyze this condition lateron
			V_1_Gas = 0.0; // Assuming double
			V_1_Gas_gesamt = 0.0;
			m_1_Gas = 0.0;
			m_1_Gas_rel = 0.0;
			V_1_Gas_Total = 0.0;
		}

		// Call Betriebspunkt(Fehler, Empty, M_ID, W_ID, n, p_1, p_2, T_1, T_BF, Gas,
		// V_1_Gas_rel, BF, V_1_F, Ber_Grp, V_1_Gas_gesamt, P_mech, V_BF, lambda,
		// lambda_ges, phi, phi_ges, V_BF_manuell, Delta_p_Waermetauscher, n_ref,
		// p_2_ref, V_1_ref, P_ref, V_1_Gas_gesamt_norm)
		FormUtil.operatingPoint(error, null, M_ID, W_ID, n, p_1, p_2, T_1, T_BF, gas, V_1_Gas_rel, BF, V_1_F, Ber_Grp,
				V_1_Gas_gesamt, P_mech, V_BF, lambda, lambda_ges, phi, phi_ges, V_BF_manuell, Delta_p_Waermetauscher,
				n_ref, p_2_ref, V_1_ref, P_ref, V_1_Gas_gesamt_norm);

		// Call Waermebilanz(Fehler, V_1_Gas_gesamt, P_mech, V_BF, V_1_Gas_rel, p_1,
		// p_2, T_1, T_BF, Gas, BF, V_1_F, T_FF, Ber_Grp, T_2, Q_WT, V_FF, Empty, Empty,
		// Empty)
		FormUtil.heatBalance(error, V_1_Gas_gesamt, P_mech, V_BF, V_1_Gas_rel, p_1, p_2, T_1, T_BF, gas, BF, V_1_F,
				T_FF, Ber_Grp, T_2, Q_WT, V_FF, null, null, null);
		// Call Max_Leistung(Fehler, betr_art, M_ID, W_ID, n, p_1, p_2, T_1, T_BF, Gas,
		// V_1_Gas_rel, BF, V_1_F, V_BF_manuell, Delta_p_Waermetauscher, Ber_Grp,
		// P_mech_max, p_2_max)
		double betr_art = 0;// do not know this filed from where to extract as of now temp value given
		FormUtil.max_power(error, betr_art, M_ID, W_ID, n, p_1, p_2, T_1, T_BF, gas, V_1_Gas_rel, BF, V_1_F,
				V_BF_manuell, Delta_p_Waermetauscher, Ber_Grp, P_mech_max, p_2_max);
		// Call Umrechnung_Gasstroeme(Fehler, V_1_Gas_gesamt, V_1_Gas, V_1_Gas_rel,
		// m_1_Gas_gesamt, m_1_Gas, m_1_Gas_rel, p_1, T_1, T_BF, Gas, Ber_Grp,
		// p_SD_Dampf, Psi, Ist_Dampf, p_SD_Gas_T_1, p_SD_Gas_T_BF, Empty, Rel_Feuchte,
		// p_2, Empty, BF, M_mol_mittel, V_1_Gas_gesamt_norm)
		FormUtil.conversion_gas_flows(error, V_1_Gas_gesamt, V_1_Gas, V_1_Gas_rel, V_1_Gas_gesamt, m_1_Gas, m_1_Gas_rel,
				p_1, T_1, T_BF, V_1_Gas_gesamt, W_ID, p_2, V_1_Gas_Total, T_2, gas, T_BF, BF, V_1_Gas_Total_Volume,
				p_2_max, stc_m_1_Gas_Total_Given, V_BF, betr_art, V_1_Gas_gesamt_norm);
		// Call Fehlertext_anzeigen(Fehler)
		FormUtil.show_error_text(error);

		/*
		 * If Fehlerart_kritisch(Fehler) = 1 Or Fehlerart_kritisch(Fehler) = 2 Then
		 * stc_Ergebnis = -1 Else stc_Ergebnis = 1 End If
		 */

		if (FormUtil.errorTypeCritical(error) == 1 || FormUtil.errorTypeCritical(error) == 2) {

			respose.setStc_result(-1);
		} else {
			respose.setStc_result(-1);
		}

		respose.setStc_Makro_Berechnung(true);

		// If Not Fehler.Abbruch Then Call Gasstroeme_ausgeben(Gas, V_1_Gas,
		// V_1_Gas_rel, m_1_Gas, m_1_Gas_rel, V_1_Gas_gesamt, m_1_Gas_gesamt, Ist_Dampf,
		// p_SD_Gas_T_BF, p_SD_Gas_T_1)
		if (true) {// Need to analyze this condition lateron If Not Fehler.Abbruch

			FormUtil.gasStreamsOutput(V_1_Gas_Total, V_1_Gas_Total_Volume, V_1_Gas_rel, m_1_Gas, m_1_Gas_rel,
					V_1_Gas_gesamt_norm, V_1_Gas_gesamt, T_2, T_BF, gas);
		}

//		 Application.Names("Formular_V_1_Gas_gesamt_norm").RefersToRange = V_1_Gas_gesamt_norm

		respose.setV_1_Gas_total_norm(V_1_Gas_Total_Volume);
		// Application.Names("Formular_p_1").RefersToRange = p_1
		respose.setP_1(p_1);

		// Application.Names("Formular_p_2").RefersToRange = p_2
		respose.setP_2(p_2);
		// Application.Names("Formular_T_1").RefersToRange = T_1
		respose.setT_1(T_1);
		// Application.Names("Formular_T_BF").RefersToRange = T_BF
		respose.setT_BF(T_BF);

		double p_SD_Dampf = 0;// need to analyze this filed
		// Application.Names("Formular_p_SD_Dampf").RefersToRange = p_SD_Dampf
		respose.setP_SD_Dampf(p_SD_Dampf);

		double Rel_Feuchte = 0;// Rel_humidity
		/*
		 * If Not IsEmpty(Rel_Feuchte) Then
		 * Application.Names("Formular_Feuchte").RefersToRange = Rel_Feuchte * 100 Else
		 * Application.Names("Formular_Feuchte").RefersToRange = Empty End If
		 */
		if (Rel_Feuchte == 0) {
			respose.setFeuchte(String.valueOf(Rel_Feuchte * 100));
		} else {
			respose.setFeuchte("");
		}

		double Psi = 0;
		// Application.Names("Formular_Psi").RefersToRange = Psi;

		respose.setPsi(Psi);

		// Application.Names("Formular_M_mol_mittel").RefersToRange = M_mol_mittel
		double M_mol_mittel = 0;
		respose.setM_mol_mittel(M_mol_mittel);
		// Application.Names("Formular_P").RefersToRange = P_mech
		respose.setP(String.valueOf(P_mech));
		// Application.Names("Formular_P_max").RefersToRange = P_mech_max
		respose.setP_max(String.valueOf(P_mech_max));
		// Application.Names("Formular_p_2_max").RefersToRange = p_2_max
		respose.setP_2_max(p_2_max);
		// Application.Names("Formular_V_BF").RefersToRange = V_BF
		respose.setV_BF(String.valueOf(V_BF));

		// Application.Names("Formular_p_1").RefersToRange = p_1
		respose.setP_1(p_1);
		// Application.Names("Formular_p_2").RefersToRange = p_2
		respose.setP_2(p_2);
		// Application.Names("Formular_T_1").RefersToRange = T_1
		respose.setT_1(T_1);
		// Application.Names("Formular_T_BF").RefersToRange = T_BF
		respose.setT_BF(T_BF);
		// Application.Names("Formular_Drehzahl").RefersToRange = n
		// respose.setDrehzahl(n);
		respose.setSpeedRpm(n);
		// Application.Names("Formular_lambda").RefersToRange = lambda_ges
		respose.setLambda(String.valueOf(lambda_ges));

		/*
		 * If Not IsEmpty(lambda) Then
		 * Application.Names("Formular_lambda_1").RefersToRange = lambda(1)
		 * Application.Names("Formular_lambda_2").RefersToRange = lambda(2)
		 * Application.Names("Formular_lambda_3").RefersToRange = lambda(3)
		 * Application.Names("Formular_lambda_4").RefersToRange = lambda(4)
		 * Application.Names("Formular_lambda_5").RefersToRange = lambda(5)
		 * Application.Names("Formular_lambda_6").RefersToRange = lambda(6)
		 * Application.Names("Formular_lambda_7").RefersToRange = lambda(7)
		 * Application.Names("Formular_lambda_8").RefersToRange = lambda(8)
		 * Application.Names("Formular_lambda_9").RefersToRange = lambda(9) Else
		 * Application.Names("Formular_lambdas").RefersToRange = Empty End If
		 */

		if (lambda != 0) {
			respose.setLambda_1(input.getLambda_1());
			respose.setLambda_2(input.getLambda_2());
			respose.setLambda_3(input.getLambda_3());
			respose.setLambda_4(input.getLambda_4());
			respose.setLambda_5(input.getLambda_5());
			respose.setLambda_6(input.getLambda_6());
			respose.setLambda_7(input.getLambda_7());
			respose.setLambda_8(input.getLambda_8());
			respose.setLambda_9(input.getLambda_9());
		} else {
			respose.setLambda("");
		}

		respose.setPhi(String.valueOf(phi));
		if (phi != 0) {
			/*
			 * Application.Names("Formular_phi_6").RefersToRange = phi(6)
			 * Application.Names("Formular_phi_7").RefersToRange = phi(7)
			 * Application.Names("Formular_phi_8").RefersToRange = phi(8)
			 * Application.Names("Formular_phi_9").RefersToRange = phi(9)
			 */

			respose.setPhi_6(input.getPhi_6());
			respose.setPhi_7(input.getPhi_7());
			respose.setPhi_8(input.getPhi_8());
			respose.setPhi_9(input.getPhi_9());

		} else {

			respose.setPhi("");

		}

		respose.setN_ref(input.getN_ref());

		// Application.Names("Formular_n_ref").RefersToRange = n_ref
		// Application.Names("Formular_p_2_ref").RefersToRange = p_2_ref

		respose.setP_2_ref(input.getP_2_ref());

		// Application.Names("Formular_V_1_ref").RefersToRange = V_1_ref
		respose.setV_1_ref(input.getV_1_ref());

		// Application.Names("Formular_P_ref").RefersToRange = P_ref

		respose.setP_ref(input.getP_ref());
		;

		// Application.Names("Formular_T_2").RefersToRange = T_2

		respose.setT_2(input.getT_2());

		// Application.Names("Formular_Q_WT").RefersToRange = Q_WT
		respose.setQ_WT(input.getQ_WT());
		// Application.Names("Formular_V_FF").RefersToRange = V_FF
		respose.setV_FF(input.getV_BF());
		respose.setStc_Makro_Berechnung(false);

		// Call stc_neu_markieren
		FormUtil.stc_new_mark();

		/// Set Chart_Saugvermoegen = Formular.ChartObjects.Item(1).Chart
		// Prepare the chart Saugvermoegen ...Suction capacity chart ....

		return ResponseEntity.ok().body(respose);

	}

	/*
	 * Sub Button_BF_Temperatur_optimieren()
	 * 
	 * Dim Fehler As Fehlercodetyp Dim Maschinen_ID, Werkstoff_ID, n Dim Formular As
	 * Worksheet Dim p_1, p_2, T_1, T_BF, V_1_Gas_gesamt_soll, V_1_Gas_rel, Gas, BF,
	 * V_1_F, T_BF_opt Dim Ber_Grp Dim a As Range Dim felder_gefuellt As Boolean Dim
	 * i As Integer
	 * 
	 * Set Formular = Worksheets("Formular")
	 * 
	 * stc_Makro_Berechnung = True
	 * 
	 * Maschinen_ID = Application.Names("Formular_Maschinen_ID").RefersToRange
	 * Werkstoff_ID = Application.Names("Formular_werkstoff_ID").RefersToRange n =
	 * Application.Names("Formular_Drehzahl").RefersToRange V_1_Gas_gesamt_soll =
	 * Application.Names("Formular_V_1_Gas_gesamt_soll").RefersToRange p_1 =
	 * Application.Names("Formular_p_1").RefersToRange p_2 =
	 * Application.Names("Formular_p_2").RefersToRange T_1 =
	 * Application.Names("Formular_T_1").RefersToRange T_BF =
	 * Application.Names("Formular_T_BF").RefersToRange V_1_F =
	 * Application.Names("Formular_V_1_F").RefersToRange BF =
	 * Application.Names("Formular_BF").RefersToRange Ber_Grp =
	 * Application.Names("Formular_Berechtigungsgruppe").RefersToRange
	 * 
	 * If stc_Ergebnis <> 0 Or stc_Berechnungsart <> 6 Then ' Es darf nur die
	 * relative Volumenstromverteilung vorgegeben sein, da nur diese in die
	 * Berechnung mit einfließt If stc_V_1_Gas_gegeben Or stc_V_1_Gas_gesamt_gegeben
	 * Or stc_m_1_Gas_gegeben Or stc_m_1_Gas_gesamt_gegeben Or
	 * stc_m_1_Gas_rel_gegeben Then stc_V_1_Gas_gegeben = False
	 * stc_V_1_Gas_gesamt_gegeben = False stc_m_1_Gas_gegeben = False
	 * stc_m_1_Gas_gesamt_gegeben = False stc_m_1_Gas_rel_gegeben = False
	 * felder_gefuellt = False For Each a In
	 * Application.Names("Formular_V_1_Gas_rel").RefersToRange i = i + 1 If i >
	 * stc_Anzahl_Gase Then Exit For If Not IsEmpty(a) Then felder_gefuellt = True
	 * Next a If felder_gefuellt Then stc_V_1_Gas_rel_gegeben = True End If
	 * stc_Ergebnis = 0 stc_Berechnungsart = 6 Call stc_neu_markieren Exit Sub End
	 * If
	 * 
	 * 
	 * ' Einlesen der relativen Volumenstromverteilung der einzelnen Gaskomponenten,
	 * sofern gegeben
	 * 
	 * For i = 1 To 6 If Not IsEmpty(Application.Names("Formular_Gas_" &
	 * CStr(i)).RefersToRange) Then If i = 1 Then ReDim Gas(1 To 1) If
	 * stc_V_1_Gas_rel_gegeben Then ReDim V_1_Gas_rel(1 To 1) End If Else ReDim
	 * Preserve Gas(1 To i) If stc_V_1_Gas_rel_gegeben Then ReDim Preserve
	 * V_1_Gas_rel(1 To i) End If End If Gas(i) = Application.Names("Formular_Gas_"
	 * & CStr(i)).RefersToRange If stc_V_1_Gas_rel_gegeben Then V_1_Gas_rel(i) =
	 * Application.Names("Formular_V_1_Gas_rel_" & CStr(i)).RefersToRange End If
	 * Else Exit For End If Next i
	 * 
	 * 
	 * Call Optimale_BF_Temperatur(Fehler, CStr(Maschinen_ID), Werkstoff_ID, n, p_1,
	 * p_2, T_1, T_BF, Gas, V_1_Gas_rel, BF, V_1_F, Ber_Grp, V_1_Gas_gesamt_soll,
	 * T_BF_opt)
	 * 
	 * Application.Names("Formular_T_BF_opt").RefersToRange = T_BF_opt
	 * 
	 * Call Fehlertext_anzeigen(Fehler) If Fehlerart_kritisch(Fehler) = 1 Or
	 * Fehlerart_kritisch(Fehler) = 2 Then stc_Ergebnis = -1 Else stc_Ergebnis = 1
	 * End If
	 * 
	 * stc_Makro_Berechnung = False
	 * 
	 * Call stc_neu_markieren
	 * 
	 * End Sub
	 * 
	 * 
	 * 
	 */

	// Optimize BF temperature

	@RequestMapping(value = "/vaccumepumps/rest/buttomOptimizeBFTemperature/change", method = RequestMethod.POST)
	public ResponseEntity<IVacuumPumpDetails> buttomOptimizeBFTemperature(@RequestBody IVacuumSelectionInputs input) {
		IVacuumPumpDetails respose = new IVacuumPumpDetails();
		
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
		
		double Gas=input.getGas();
		
		double  BF=input.getBf();
		double V_1_F=input.getV_1_F();
		double T_BF_opt=input.getOptimizedBFtemperature();
		String Berechtigungsgruppe=input.getPermissionGroup();
		boolean felder_gefuellt=input.isFields_filled();
		int stcCalculationType = 6;
		 if (input.getStc_result()!=0  || input.getStcCalculationType()!=6) {
		 
				if (input.isStc_V_1_Gas_gegeben() || input.isStc_V_1_Gas_gesamt_gegeben()
						|| input.isStc_m_1_Gas_gegeben() || input.isStc_m_1_Gas_gesamt_gegeben()

						|| input.isStc_m_1_Gas_rel_gegeben()

				)
		    {
		    	
					respose.setStc_V_1_Gas_gegeben(false);
					respose.setStc_V_1_Gas_gesamt_gegeben(false);
					respose.setStc_m_1_Gas_gegeben(false);
					respose.setStc_m_1_Gas_gesamt_gegeben(false);
					respose.setStc_m_1_Gas_rel_gegeben(false);
					respose.setFields_filled(false)
					
		    }
		 
		 
		 }
		return ResponseEntity.ok().body(respose);
		
	}
	
	
	
}
