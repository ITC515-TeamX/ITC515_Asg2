package datamanagement;



public class ListUnitsControl {

  private UnitManager unitManager_;


	
  public ListUnitsControl() {
    unitManager_ = UnitManager.getInstance();
  }


	
  public void listUnits(IUnitLister lister) {
    lister.clearUnits();
    
    UnitMap units = unitManager_.getUnits();
    for (String unitCode : units.keySet())
      lister.addUnit(units.get(unitCode));
  }
}
