package com.Class.DataAccessObject;

import java.util.ArrayList;

public class DataAccessObject {
	
	protected String primaryKey = "id";

    protected String table;
    
    protected ArrayList<String> fillable;
    
    protected ArrayList<String> timestamps;
    
    protected String deleteTimestamps;
}
