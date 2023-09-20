package oop_object;

    public class TicketSeller {
    	private TicketOffice ticketOffice;

    	public TicketSeller(TicketOffice ticketOffice) {
    		this.ticketOffice = ticketOffice;
    	}

    	public void toSell(Audience audience) {
    		ticketOffice.plusAmount(audience.buy(ticketOffice.getTicket()));
    	}
    }
