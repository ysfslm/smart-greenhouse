package com.yfk.smartgreenhouse;

public class SGCSSM {
    private void SGCSSM() {}

    private static SGCSSM SGCSSM = null;

    public static SGCSSM getInstance () {
        if (SGCSSM == null) {
            SGCSSM = new SGCSSM();
            SGCSSM.init();
        }
        return SGCSSM;
    }



    private State myState;

    private void init() {
        transition_to(State.POWER_OFF);
    }

    private void transition_to(State target_state) {
        myState = target_state;
    }

    public State getState() {
        return myState;
    }


    public State triggerSGCSSM(Event e) {

        if ( e == Event.Failure) {
            transition_to(State.TROUBLE);
        }
        if (e == Event.Power_off) {
            transition_to(State.POWER_OFF);
        }


        switch (myState) {
            case POWER_OFF:
                switch (e) {
                    case Power_on:
                        transition_to(State.POWER_PRESENT);
                        break;
                }
                break;
            case POWER_PRESENT:
                switch (e) {
                    case Ready_to_monitor:
                        transition_to(State.READY_TO_MONITOR);
                        break;
                }
                break;
            case READY_TO_MONITOR:
                switch (e) {
                    case Start_monitoring:
                        transition_to(State.MONITORING);
                        break;
                }
                break;
            case MONITORING:
                switch (e) {
                    case Stop_monitoring:
                        transition_to(State.READY_TO_MONITOR);
                        break;
                }
                break;
            case TROUBLE:
                switch (e) {
                    case Failure_fixed:
                        transition_to(State.READY_TO_MONITOR);
                        break;
                }
                break;

        }


        return getState();
    }



}
