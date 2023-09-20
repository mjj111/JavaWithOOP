package oop_object;

    public class Theater {
    	private TicketSeller ticketSeller;
·
    	public Theater(TicketSeller ticketSeller) {
    		this.ticketSeller = ticketSeller;
    	}

    	public void enter(Audience audience) {
    		ticketSeller.toSell(audience);
    	}
    }