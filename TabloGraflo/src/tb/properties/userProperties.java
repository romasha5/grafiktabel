package tb.properties;
import java.util.prefs.*;
/**
 * @author Roman
 *
 */

public class userProperties {
	
    private Preferences userProp;
    String cs;
    String constr;
    
    public userProperties()
    {
        userProp = Preferences.userNodeForPackage(userProperties.class);
    }
    
    public String getProperties(){
    	if(WhatIsOS.getI()==0){
    		this.cs = userProp.get("pathCS", "baseSQLite\\grafiktabel.db");
    	}
    	else if (WhatIsOS.getI()==1){
    		this.cs = userProp.get("pathCS", "baseSQLite/grafiktabel.db");
    	}
    	return cs;
    }
    
    public String getConStr(){
    	if(WhatIsOS.getI()==0){
    		this.constr = userProp.get("ConStr", "jdbc:sqlite:baseSQLite\\grafiktabel.db");
    	}
    	else if (WhatIsOS.getI()==1){
    		this.constr = userProp.get("ConStr", "jdbc:sqlite:baseSQLite/grafiktabel.db");
    	}
    	return constr;
    }

    
    public void putProperties(String cs){
    	userProp.put("pathCS", cs);
    }
    
    public void putConStr(String constr){
    	userProp.put("ConStr", constr );
    }

}
