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
                    case Ready_to_monitor:
                        transition_to(State.READY_TO_MONITOR);
                        break;
                }
                break;
            case READY_TO_MONITOR:
                // only following event(s) are valid: vehicle_connected
                switch (e) {
                    case Start_monitoring:
                        transition_to(State.START_MONITORING);
                        break;
                }
                break;
            case MONITORING:
                switch (e) {
                    // only following event(s) are valid: stop_charging
                    case Stop_monitoring:
                        transition_to(State.STOP_MONITORING);
                        break;
                }
                break;
            case TROUBLE:
                switch (e) {
                    // only following event(s) are valid: failer_fixed
                    case Failure_fixed:
                        transition_to(State.READY_TO_MONITOR);
                        break;
                }
                break;

        }


        return getState();
    }



}
