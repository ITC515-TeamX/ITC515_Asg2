package datamanagement;

import java.util.List;
import org.jdom.*;

public class UnitManager {

  private static UnitManager self_ = null;
  private UnitMap unitManager_;


  
  public static UnitManager getInstance() {
    if (self_ == null)
      self_ = new UnitManager();
    return self_;
  }


  
  private UnitManager() {
    unitManager_ = new UnitMap();
  }


  
  public IUnit getUnit(String unitCode) {
    IUnit iu = unitManager_.get(unitCode);
    if (iu == null) {
      iu = createUnit(unitCode);
    }
    return iu;

  }


  
  private IUnit createUnit(String unitCode) {    
    @SuppressWarnings("unchecked")
    List<Element> unitElements = (List<Element>) XmlFileManager.getInstance().getDocument()
                                 .getRootElement().getChild("unitTable")
                                 .getChildren("unit");
    
    for (Element el : unitElements ) {
      String uid = el.getAttributeValue("uid");
      if (unitCode.equals(uid)) {
        String unitName = el.getAttributeValue("name");
        float psCutoff = Float.valueOf(el.getAttributeValue("ps")).floatValue();
        float crCutoff = Float.valueOf(el.getAttributeValue("cr")).floatValue();
        float diCutoff = Float.valueOf(el.getAttributeValue("di")).floatValue();
        float hdCutoff = Float.valueOf(el.getAttributeValue("hd")).floatValue();
        float aeCutoff = Float.valueOf(el.getAttributeValue("ae")).floatValue();
        int asg1Weight = Integer.valueOf(el.getAttributeValue("asg1wgt")).intValue();
        int asg2Weight = Integer.valueOf(el.getAttributeValue("asg2wgt")).intValue();
        int examWeight = Integer.valueOf(el.getAttributeValue("examwgt")).intValue();
        StudentUnitRecordList studentRecords = StudentUnitRecordManager.getInstance().getRecordsByUnit(unitCode);
        
        IUnit unit = new Unit(unitCode, unitName,
                            psCutoff, crCutoff, diCutoff, hdCutoff, aeCutoff, 
                            asg1Weight, asg2Weight, examWeight, 
                            studentRecords);
        
        unitManager_.put(unitCode, unit);
        return unit;
      }
    }
    throw new RuntimeException("DBMD: createUnit : unit not in file");
  }


  
  public UnitMap getUnits() {
    @SuppressWarnings("unchecked")
    List<Element> unitElements = (List<Element>) XmlFileManager.getInstance().getDocument()
                                 .getRootElement().getChild("unitTable")
                                 .getChildren("unit");
    
    UnitMap units = new UnitMap();
    for (Element el : unitElements) {
      String unitCode = el.getAttributeValue("uid");
      String unitName = el.getAttributeValue("name");
      IUnit unit = new UnitProxy(unitCode, unitName);
      units.put(unitCode, unit);
    } // unit maps are filled with PROXY units
    return units;
  }

}
