package com.yfk.smartgreenhouse;

public enum Event {  // enumeration for CParser signals
    Power_on,
    Ready_to_charge,
    Vehicle_disconnected,
    Start_charging,
    Stop_charging,
    Vehicle_connected,
    Failure_fixed,
    Failure,
    Power_off  // init state
};
