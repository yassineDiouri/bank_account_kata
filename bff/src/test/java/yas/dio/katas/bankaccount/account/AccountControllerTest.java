package yas.dio.katas.bankaccount.account;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import yas.dio.katas.bankaccount.statement.StatementDTO;

import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AccountController.class)
class AccountControllerTest {

    @MockitoBean
    private AccountService accountService;

    @Autowired
    private MockMvc mockMvc;

    @Nested
    class GetStatement {
        @Test
        void should_return_ok_with_returned_statement_from_service() throws Exception {
            //given
            final Long accountId = 1L;
            final double balance = 100d;

            Mockito.when(accountService.getStatement(anyLong()))
                    .thenReturn(StatementDTO.builder().balance(balance).build());
            //when
            mockMvc.perform(get("/accounts/{id}", accountId))
                    //then
                    .andExpect(status().isOk())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                    .andExpect(jsonPath("$.balance").value(100));
        }
    }

    @Nested
    class Deposit {
        @Test
        void should_return_ok_when_service_does_not_throws_exception() throws Exception {
            //given
            final Long accountId = 1L;
            final String amount = "100.0";

            doNothing().when(accountService).deposit(anyLong(), anyDouble());
            //when
            mockMvc.perform(put("/accounts/{id}", accountId)
                            .contentType(MediaType.TEXT_PLAIN)
                            .content(amount))
                    //then
                    .andExpect(status().isOk());
        }

        @Test
        void should_return_bad_request_when_amount_is_empty() throws Exception {
            //given
            final Long accountId = 1L;
            final String amount = "";

            doThrow(IllegalArgumentException.class).when(accountService).deposit(anyLong(), anyDouble());
            //when
            mockMvc.perform(put("/accounts/{id}", accountId)
                            .contentType(MediaType.TEXT_PLAIN)
                            .content(amount))
                    //then
                    .andExpect(status().isBadRequest());
        }
    }

    @Nested
    class Withdraw {
        @Test
        void should_return_ok_when_service_does_not_throws_exception() throws Exception {
            //given
            final Long accountId = 1L;
            final String amount = "100.0";

            doNothing().when(accountService).deposit(anyLong(), anyDouble());
            //when
            mockMvc.perform(post("/accounts/{id}", accountId)
                            .contentType(MediaType.TEXT_PLAIN)
                            .content(amount))
                    //then
                    .andExpect(status().isOk());
        }

        @Test
        void should_return_bad_request_when_amount_is_empty() throws Exception {
            //given
            final Long accountId = 1L;
            final String amount = "";

            doThrow(IllegalArgumentException.class).when(accountService).deposit(anyLong(), anyDouble());
            //when
            mockMvc.perform(post("/accounts/{id}", accountId)
                            .contentType(MediaType.TEXT_PLAIN)
                            .content(amount))
                    //then
                    .andExpect(status().isBadRequest());
        }
    }
}