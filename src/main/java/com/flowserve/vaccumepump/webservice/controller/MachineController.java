package com.flowserve.vaccumepump.webservice.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.flowserve.vaccumepump.webservice.dto.IVacuumPumpDetails;
import com.flowserve.vaccumepump.webservice.dto.IVacuumSelectionInputs;
import com.flowserve.vaccumepump.webservice.model.ListValueTable;
import com.flowserve.vaccumepump.webservice.model.MachineTable;
import com.flowserve.vaccumepump.webservice.util.FormUtil;

import jakarta.servlet.http.HttpServletRequest;



@RestController
public class MachineController {
	

	private static final Logger LOGGER = Logger.getLogger(MachineController.class.getName());
	
	
	//Load tables earlier
	List<MachineTable> machineTableList=new ArrayList<>();
	List<ListValueTable> listValueTableList=new ArrayList<>();
	
	
	
	@RequestMapping(method=RequestMethod.GET,path="/hello")
	public String getHello()
	{
		return "Hello World - vaccumepump- MachineController";
	}
	
	
	/*
	 * 
	 * Pull the machineIDList as curve_id List from the Machine table respond back
	 * to UI
	 */

	@RequestMapping(value = "/vaccumepumps/rest/machineids", method = RequestMethod.GET)
	public ResponseEntity<List<String>> getList(HttpServletRequest request) throws SQLException {
		//HttpStatus errStatus = UserUtils.validateUserRoles(request, ToolkitUserRole.ROLE_ADMIN);
		/*
		 * if (errStatus != null) { return ResponseEntity.status(errStatus).body(null);
		 * }
		 */

		List<String> machineIDList = new ArrayList<>();

		// Get machineIDList from DB or some where ?

		return ResponseEntity.ok().body(machineIDList);

	}
	
	
	//ComboBox_Maschinen_ID changes in the list byuser 
	/*
	 * 
Private Sub ComboBox_Maschinen_ID_Change()

Dim Formular As Worksheet, Maschinentabelle As Worksheet
Dim ListBox_Wkst As Object
Dim a As Range
Dim col_typ As Integer, col_wkst As Integer, col_Maschinenart As Integer, col_n_nenn As Integer
Dim M_ID As String, W_ID As String, Maschinenart As Integer
Dim betr_art_1 As Boolean, betr_art_2 As Boolean
Dim search_range As Range, found_range As Range, first_row As Long, found_row As Long, found_once As Boolean

Set Formular = Worksheets("Formular")
Set Maschinentabelle = Worksheets("Maschinentabelle")
Set ListBox_Wkst = Formular.OLEObjects("ListBox_Wkst").Object

ListBox_Wkst.Clear

M_ID = ComboBox_Maschinen_ID.Value
If M_ID = "" Then Exit Sub

Application.Names("Formular_Maschinen_ID").RefersToRange = M_ID

Application.Names("Formular_Werkstoff_ID").RefersToRange = Empty
Application.Names("Formular_Maschinenart").RefersToRange = Empty
Application.Names("Formular_Nenndrehzahl").RefersToRange = Empty

col_typ = Maschinentabelle.Rows(1).Find("TYP").Column
col_wkst = Maschinentabelle.Rows(1).Find("WKST").Column
col_Maschinenart = Maschinentabelle.Rows(1).Find("Maschinenart").Column
col_n_nenn = Maschinentabelle.Rows(1).Find("NN").Column

Set search_range = Maschinentabelle.Columns(col_typ)
first_row = 0
found_row = 0
found_once = False
Do
    If Not found_once Then
        Set found_range = search_range.Find(M_ID, , , xlWhole)
        If Not found_range Is Nothing Then
            found_once = True
            found_row = found_range.Row
        End If
    Else
        If first_row = 0 Then first_row = found_range.Row
        Set found_range = search_range.FindNext(found_range)
        found_row = found_range.Row
    End If
    If (Not found_range Is Nothing) And (found_row <> first_row) Then
        W_ID = Maschinentabelle.Cells(found_row, col_wkst)
        If Listbox_ArrayIndex(W_ID, ListBox_Wkst.List()) = -1 Then
            ListBox_Wkst.AddItem W_ID
        End If
        Maschinenart = Maschinentabelle.Cells(found_row, col_Maschinenart)
        Select Case Maschinenart
            Case 1
                Application.Names("Formular_Maschinenart").RefersToRange = "1 - Einstufige Vakuumpumpe 33mbar"
            Case 2
                Application.Names("Formular_Maschinenart").RefersToRange = "2 - Einst. Vakuumpumpe 120mbar"
            Case 3
                Application.Names("Formular_Maschinenart").RefersToRange = "3 - Zweist. Vakuumpumpe 33mbar"
            Case 4
                Application.Names("Formular_Maschinenart").RefersToRange = "4 - Einst. Kompressor"
            Case 5
                Application.Names("Formular_Maschinenart").RefersToRange = "5 - Mehrst. Kompressor"
        End Select
        Application.Names("Formular_Nenndrehzahl").RefersToRange = Maschinentabelle.Cells(found_row, col_n_nenn)
        
    End If
Loop Until found_range Is Nothing Or found_row = first_row

verfuegbare_Drehzahlen

End Sub
	 * 
	 * 
	 * 
	 */
	
	
	@RequestMapping(value = "/vaccumepumps/rest/machineId/change", method = RequestMethod.POST)
	public ResponseEntity<IVacuumPumpDetails> machineIdChangedInList(@RequestBody IVacuumSelectionInputs input) {
		// HttpStatus errStatus = UserUtils.validateUserRoles(request,
		// ToolkitUserRole.ROLE_ADMIN);
		IVacuumPumpDetails respose = new IVacuumPumpDetails();
		// column B - WKST - material - Werkstoff_ID
		List<String> werkstoffIDList = new ArrayList<String>();// get these values from

		String mid = input.getMachineID();

		respose = new IVacuumPumpDetails();
		if (StringUtils.isEmpty(mid)) {
			List<String> list = new ArrayList<>();

			respose.setMachineIdList(list);
			return ResponseEntity.ok().body(respose);

		}

		// In Machine table columns A,B,D,G
		int machineType = 0;// Maschinenart=0
		for (MachineTable record : machineTableList) {
			if (mid.equals(record.getCurve_id())) {
				werkstoffIDList.add(record.getMaterial());
				machineType = record.getMachineType();
				respose.setMachineType(FormUtil.getMaschinenartDescription(machineType));
				respose.setRatedSpeedRpm(record.getNn());

			}
		}
		respose.setMaterialIdList(werkstoffIDList);

		// verfuegbare_Drehzahlen
		// Get Columns A,B,C,D,E from ListValueTable

		List<String> vacuumoperationList = new ArrayList<>();
		List<String> compressorOperationList = new ArrayList<>();
		;

		for (ListValueTable record : listValueTableList) {

			if (mid.equals(record.getCurve_id())) {

				if (werkstoffIDList.contains(record.getMaterial())) {

					int betrArt = record.getComp_pump();
					String nlValue = record.getNl();
					if (betrArt == 1) {
						vacuumoperationList.add(nlValue); // Add to first list box
					} else if (betrArt == 2) {
						compressorOperationList.add(nlValue); // Add to second list box
					}

				}

			}

		}

		return ResponseEntity.ok().body(respose);

	}
	
	
	/*
	 * Private Sub ListBox_Wkst_Click() ' Beim Anklicken eines Werkstoffs in
	 * Auswahlbox wird die Werkstoff-Zelle entsprechend belegt ' sowie die
	 * Drehzahl-Auswahlbox aktualisiert
	 * 
	 * Dim Formular As Worksheet
	 * 
	 * Set Formular = Worksheets("Formular")
	 * 
	 * Application.Names("Formular_werkstoff_ID").RefersToRange = ListBox_Wkst.Text
	 * 
	 * verfuegbare_Drehzahlen
	 * 
	 * Call Kennlinie_darstellen(Empty, Empty, Empty, Empty)
	 * 
	 * End Sub
	 */

	@RequestMapping(value = "/vaccumepumps/rest/materialId/click", method = RequestMethod.POST)
	public ResponseEntity<IVacuumPumpDetails> machineIdChangedInList1(@RequestBody IVacuumSelectionInputs input) {
		// HttpStatus errStatus = UserUtils.validateUserRoles(request,
		// ToolkitUserRole.ROLE_ADMIN);
		IVacuumPumpDetails respose = new IVacuumPumpDetails();
		// column B - WKST - material - Werkstoff_ID
		

		String mid = input.getMachineID();

		respose = new IVacuumPumpDetails();
		

		return ResponseEntity.ok().body(respose);

	}
	
	
	
	/*
	 * 
	 * Private Sub Listbox_NL_1_Click()

Dim Formular As Worksheet
Dim ListBox_NL_1 As Object, ListBox_NL_2 As Object
Dim Maschinen_ID As String, Werkstoff_ID As Integer, n As Double

Set Formular = Worksheets("Formular")
Set ListBox_NL_1 = Formular.OLEObjects("ListBox_NL_1").Object
Set ListBox_NL_2 = Formular.OLEObjects("ListBox_NL_2").Object

ListBox_NL_2.ListIndex = -1

If ListBox_NL_1.ListIndex >= 0 Then
    n = ListBox_NL_1.Text
    Maschinen_ID = Application.Names("Formular_Maschinen_ID").RefersToRange
    Werkstoff_ID = Application.Names("Formular_werkstoff_ID").RefersToRange
    Call Kennlinie_darstellen(Maschinen_ID, Werkstoff_ID, 1, n)
    Application.Names("Formular_Drehzahl").RefersToRange = n
End If

End Sub
	 * 
	 * 
	 * 
	 * 
	 */

	
	@RequestMapping(value = "/vaccumepumps/rest/vacuumoperation/click", method = RequestMethod.POST)
	public ResponseEntity<IVacuumPumpDetails> vacuumOperationClick(@RequestBody IVacuumSelectionInputs input) {

		IVacuumPumpDetails respose = new IVacuumPumpDetails();

		String maschinenId = input.getMachineID();
		String werkstoffId = input.getMaterialID();
		String vacuumOperation = input.getVacuumOperation();

		if (!org.apache.commons.lang3.StringUtils.isEmpty(vacuumOperation)) {
			double n = Double.parseDouble((vacuumOperation));
			int werkstoffId1 = Integer.parseInt(werkstoffId);

			// Call the method to display the curve
			// kennlinieDarstellen(Maschinen_ID, werkstoffId1, 1, n); -- code needs to be
			// implemented to create graphs 

			respose.setSpeedRpm(n);

		}

		respose = new IVacuumPumpDetails();

		return ResponseEntity.ok().body(respose);

	}
	
	
	
	
	
	/*
	 * Private Sub Listbox_NL_2_Click()
	 * 
	 * Dim Formular As Worksheet Dim ListBox_NL_1 As Object, ListBox_NL_2 As Object
	 * Dim Maschinen_ID As String, Werkstoff_ID As Integer, n As Double
	 * 
	 * Set Formular = Worksheets("Formular") Set ListBox_NL_1 =
	 * Formular.OLEObjects("ListBox_NL_1").Object Set ListBox_NL_2 =
	 * Formular.OLEObjects("ListBox_NL_2").Object
	 * 
	 * ListBox_NL_1.ListIndex = -1
	 * 
	 * If ListBox_NL_2.ListIndex >= 0 Then n = ListBox_NL_2.Text Maschinen_ID =
	 * Application.Names("Formular_Maschinen_ID").RefersToRange Werkstoff_ID =
	 * Application.Names("Formular_werkstoff_ID").RefersToRange Call
	 * Kennlinie_darstellen(Maschinen_ID, Werkstoff_ID, 2, n)
	 * Application.Names("Formular_Drehzahl").RefersToRange = n End If
	 * 
	 * End Sub
	 */
	
	@RequestMapping(value = "/vaccumepumps/rest/compressorperation/click", method = RequestMethod.POST)
	public ResponseEntity<IVacuumPumpDetails> compressorOperationClick(@RequestBody IVacuumSelectionInputs input) {

		IVacuumPumpDetails respose = new IVacuumPumpDetails();

		String maschinenId = input.getMachineID();
		String werkstoffId = input.getMaterialID();
		String vacuumOperation = input.getVacuumOperation();
		String compressorOperation = input.getCompressorOperation();

		if (!org.apache.commons.lang3.StringUtils.isEmpty(compressorOperation)) {
			double n = Double.parseDouble((compressorOperation));
			int werkstoffId1 = Integer.parseInt(werkstoffId);

			// Call the method to display the curve
			// kennlinieDarstellen(Maschinen_ID, werkstoffId1, 1, n); -- code needs to be
			// implemented

			respose.setSpeedRpm(n);

		}

		respose = new IVacuumPumpDetails();

		return ResponseEntity.ok().body(respose);

	}
	
	
}
