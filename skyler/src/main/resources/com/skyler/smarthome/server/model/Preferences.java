package com.skyler.smarthome.server.model;

import java.util.HashMap;
import java.util.Map;

public abstract class Preferences {

    private int id;
    private Map<String,String> preferences = new HashMap<>();
}
