package tb.properties;
import java.util.prefs.*;

public class userProperties {
	
    private Preferences userProp;
    
    public userProperties()
    {
        userProp = Preferences.userNodeForPackage(userProperties.class);
    }
    
    public String getProperties(){
    	String cs = userProp.get("pathCS", "baseSQLite\\grafiktabel.db");
    	return cs;
    }
    
    public String getConStr(){
    	String constr = userProp.get("ConStr", "jdbc:sqlite:baseSQLite\\grafiktabel.db");
    	return constr;
    }

    
    public void putProperties(String cs){
    	userProp.put("pathCS", cs);
    }
    
    public void putConStr(String constr){
    	userProp.put("ConStr", constr );
    }

}
