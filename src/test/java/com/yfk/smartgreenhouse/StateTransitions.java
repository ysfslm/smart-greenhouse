package com.yfk.smartgreenhouse;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.jupiter.api.Assertions.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StateTransitions {


    SGCSSM sgcssm = SGCSSM.getInstance();

    @Test
    public void SGCSSM_TC_1_Test_Transition_From_POWER_OFF_to_POWER_PRESENT() {
        System.out.println(sgcssm.getState());
        assertEquals(sgcssm.triggerSGCSSM(Event.Power_on), State.POWER_PRESENT);
        System.out.println(sgcssm.getState());
    }

    @Test
    public void SGCSSM_TC_2_Test_Transition_From_POWER_PRESENT_to_READY_TO_MONITOR() {
        System.out.println(sgcssm.getState());
        assertEquals(sgcssm.triggerSGCSSM(Event.Ready_to_monitor),State.READY_TO_MONITOR);
        System.out.println(sgcssm.getState());

    }
    @Test
    public void SGCSSM_TC_3_Test_Transition_From_READY_TO_MONITOR_to_MONITORING() {
        System.out.println(sgcssm.getState());
        assertEquals(sgcssm.triggerSGCSSM(Event.Start_monitoring),State.MONITORING);
        System.out.println(sgcssm.getState());

    }
    @Test
    public void SGCSSM_TC_4_Test_Transition_MONITORING_to_READY_TO_MONITOR() {
        System.out.println(sgcssm.getState());
        assertEquals(sgcssm.triggerSGCSSM(Event.Stop_monitoring),State.READY_TO_MONITOR);
        System.out.println(sgcssm.getState());
    }
    @Test
    public void SGCSSM_TC_5_Test_Transition_From_TROUBLE_to_READY_TO_MONITOR() {
        System.out.println(sgcssm.getState());
        assertEquals(sgcssm.triggerSGCSSM(Event.Failure_fixed),State.READY_TO_MONITOR);
        System.out.println(sgcssm.getState());
    }


}
