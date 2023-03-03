package com.yfk.smartgreenhouse;

import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.Alphanumeric.class)
public class StateTransitions {


    SGFSM fsm = SGFSM.getInstance();

    @Test
    public void FSM_TC_1_Test_Transition_From_POWER_OFF_to_POWER_PRESENT() {
        assertEquals(fsm.triggerFMS(Event.Power_on), State.POWER_PRESENT);
    }

    @Test
    public void FSM_TC_2_Test_Transition_From_POWER_PRESENT_to_READY_TO_MONITOR() {
        assertEquals(fsm.triggerFMS(Event.Ready_to_monitor),State.READY_TO_MONITOR);

    }
    @Test
    public void FSM_TC_3_Test_Transition_From_READY_TO_MONITOR_to_START_MONITORING() {
        assertEquals(fsm.triggerFMS(Event.Ready_to_monitor),State.START_MONITORING);

    }
    @Test
    public void FSM_TC_4_Test_Transition_MONITORING_to_STOP_MONITORING() {
        assertEquals(fsm.triggerFMS(Event.Stop_monitoring),State.STOP_MONITORING);

    }
    @Test
    public void FSM_TC_5_Test_Transition_From_POWER_OFF_to_TROUBLE() {
        assertEquals(fsm.triggerFMS(Event.Failure),State.TROUBLE);
    }
    @Test
    public void FSM_TC_6_Test_Transition_From_READY_TO_C() {
        assertEquals(fsm.triggerFMS(Event.Failure_fixed),State.READY_TO_MONITOR);
    }
}
