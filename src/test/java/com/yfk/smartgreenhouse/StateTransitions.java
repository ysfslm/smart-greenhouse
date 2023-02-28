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
    public void FSM_TC_2_Test_Transition_From_POWER_PRESENT_to_READY_TO_CHARGE() {
        assertEquals(fsm.triggerFMS(Event.Ready_to_charge),State.READY_TO_CHARGE);

    }
    @Test
    public void FSM_TC_3_Test_Transition_From_READY_TO_CHARGE_to_VEHICLE_CONNECTED() {
        assertEquals(fsm.triggerFMS(Event.Vehicle_connected),State.VEHICLE_CONNECTED);

    }
    @Test
    public void FSM_TC_4_Test_Transition_From_VEHICLE_CONNECTED_to_VEHICLE_CHARGING() {
        assertEquals(fsm.triggerFMS(Event.Start_charging),State.VEHICLE_CHARGING);

    }
    @Test
    public void FSM_TC_5_Test_Transition_From_VEHICLE_CHARGING_to_VEHICLE_CONNECTED() {
        assertEquals(fsm.triggerFMS(Event.Stop_charging),State.VEHICLE_CONNECTED);

    }
    @Test
    public void FSM_TC_6_Test_Transition_From_VEHICLE_CONNECTED_to_READY_TO_CHARGE() {
        assertEquals(fsm.triggerFMS(Event.Vehicle_disconnected),State.READY_TO_CHARGE);

    }
    @Test
    public void FSM_TC_7_Test_Transition_From_POWER_OFF_to_TROUBLE() {
        assertEquals(fsm.triggerFMS(Event.Failure),State.TROUBLE);
    }
    @Test
    public void FSM_TC_8_Test_Transition_From_READY_TO_CHARGE() {
        assertEquals(fsm.triggerFMS(Event.Failure_fixed),State.READY_TO_CHARGE);
    }
}
