package tb.properties;
import java.util.prefs.*;

public class Properties {
	
    private Preferences userProp;
    
    public Properties()
    {
        userProp = Preferences.userNodeForPackage(Properties.class);
    }
    
    public String getProperties(){
    	String cs = userProp.get("pathCS", "baseSQLite\\grafiktabel.db");
    	return cs;
    }
    
    public void putProperties(String cs){
    	userProp.put("pathCS", cs);
    }
}
