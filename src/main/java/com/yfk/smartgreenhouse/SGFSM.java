package com.yfk.smartgreenhouse;

public class SGFSM {
    private void SGFSM() {}

    private static SGFSM sgfsm = null;

    public static SGFSM getInstance () {
        if (sgfsm == null) {
            sgfsm = new SGFSM();
            sgfsm.init(); // set state to POWER_OFF
        }
        return sgfsm;
    }



    private State myState;

    private void init() {
        transition_to(State.POWER_OFF);   // default transition
    }

    private void transition_to(State target_state) {
        myState = target_state;
    }

    public State getState() {
        return myState;   // default transition
    }
    // FMS

    public State triggerFMS(Event e) {
        // in any state, following events are valid: failure, power_off
        if ( e == Event.Failure) {
            transition_to(State.TROUBLE);
        }
        if (e == Event.Power_off) {
            transition_to(State.POWER_OFF);
        }
        switch (myState) {
            case POWER_OFF:
                // only following event(s) are valid: power_on
                switch (e) {
                    case Power_on:
                        transition_to(State.POWER_PRESENT);
                        break;
                }
                break;
            case POWER_PRESENT:
                // only following event(s) are valid: ready_to_charge
                switch (e) {
                    case Ready_to_charge:
                        transition_to(State.READY_TO_CHARGE);
                        break;
                }
                break;
            case READY_TO_CHARGE:
                // only following event(s) are valid: vehicle_connected
                switch (e) {
                    case Vehicle_connected:
                        transition_to(State.VEHICLE_CONNECTED);
                        break;
                }
                break;
            case VEHICLE_CONNECTED:
                // only following event(s) are valid: start_charging, vehicle_disconnected
                switch (e) {
                    case Start_charging:
                        transition_to(State.VEHICLE_CHARGING);
                        break;
                    case Vehicle_disconnected:
                        transition_to(State.READY_TO_CHARGE);
                        break;
                }
                break;
            case VEHICLE_CHARGING:
                switch (e) {
                    // only following event(s) are valid: stop_charging
                    case Stop_charging:
                        transition_to(State.VEHICLE_CONNECTED);
                        break;
                }
                break;
            case TROUBLE:
                switch (e) {
                    // only following event(s) are valid: failer_fixed
                    case Failure_fixed:
                        transition_to(State.READY_TO_CHARGE);
                        break;
                }
                break;

        }
        return getState();
    }
}
