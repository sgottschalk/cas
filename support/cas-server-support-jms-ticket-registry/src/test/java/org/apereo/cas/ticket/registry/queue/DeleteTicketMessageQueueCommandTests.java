package org.apereo.cas.ticket.registry.queue;

import org.apereo.cas.JmsTicketRegistryQueueIdentifier;
import org.apereo.cas.authentication.CoreAuthenticationTestUtils;
import org.apereo.cas.ticket.TicketGrantingTicketImpl;
import org.apereo.cas.ticket.expiration.NeverExpiresExpirationPolicy;
import org.apereo.cas.util.junit.EnabledIfContinuousIntegration;
import org.apereo.cas.util.junit.EnabledIfPortOpen;

import lombok.val;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This is {@link DeleteTicketMessageQueueCommandTests}.
 *
 * @author Misagh Moayyed
 * @since 5.2.0
 */
@EnabledIfContinuousIntegration
@EnabledIfPortOpen(port = 61616)
@Tag("ActiveMQ")
public class DeleteTicketMessageQueueCommandTests extends AbstractTicketMessageQueueCommandTests {

    @Test
    public void verifyDeleteTicket() {
        val ticket = new TicketGrantingTicketImpl("TGT", CoreAuthenticationTestUtils.getAuthentication(), NeverExpiresExpirationPolicy.INSTANCE);
        ticketRegistry.getObject().addTicket(ticket);
        val cmd = new DeleteTicketMessageQueueCommand(new JmsTicketRegistryQueueIdentifier(), ticket.getId());
        cmd.execute(ticketRegistry.getObject());
        assertTrue(ticketRegistry.getObject().getTickets().isEmpty());
    }
}
