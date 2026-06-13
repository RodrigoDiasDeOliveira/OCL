package com.triminds.tlp.rfid;

import com.triminds.tlp.rfid.controller.RfidTagController;
import com.triminds.tlp.rfid.service.RfidTagService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class RfidTagControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnAllRfidTags() throws Exception {
        mockMvc.perform(get("/api/rfid"))
                .andExpect(status().isOk());
    }

    @Test
    void shouldReturnRfidEvents() throws Exception {
        mockMvc.perform(get("/api/rfid/events"))
                .andExpect(status().isOk());
    }
}