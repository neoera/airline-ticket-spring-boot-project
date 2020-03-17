package com.finartz.apt.service;

import com.finartz.apt.dto.CreateTicketRequestDto;
import com.finartz.apt.dto.CreateTicketResponseDto;
import com.finartz.apt.entity.Flight;
import com.finartz.apt.entity.Passenger;
import com.finartz.apt.entity.Payment;
import com.finartz.apt.entity.Ticket;
import com.finartz.apt.repository.FlightRepository;
import com.finartz.apt.repository.PassengerRepository;
import com.finartz.apt.repository.TicketRepository;
import com.finartz.apt.util.AptConstants;
import com.finartz.apt.viewobject.PassengerDto;
import com.finartz.apt.viewobject.SearchTicketRequest;
import com.finartz.apt.viewobject.SearchTicketResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@Transactional
public class TicketService {

    private final TicketRepository ticketRepository;
    private final PassengerRepository passengerRepository;
    private final FlightRepository flightRepository;

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy");

    @Autowired
    public TicketService(TicketRepository ticketRepository, PassengerRepository passengerRepository, FlightRepository flightRepository) {
        this.ticketRepository = ticketRepository;
        this.passengerRepository = passengerRepository;
        this.flightRepository = flightRepository;
    }

    public SearchTicketResponse searchTicket(SearchTicketRequest searchticketRequest) {
        Ticket ticket = ticketRepository.findByNumber(searchticketRequest.getNumber());
        SearchTicketResponse searchTicketResponse = new SearchTicketResponse();

        if (ticket != null) {
            searchTicketResponse.setNumber(ticket.getNumber());
            searchTicketResponse.setSeatNumber(ticket.getSeatNumber());
            searchTicketResponse.setStatus(ticket.getStatus());
            searchTicketResponse.setPaymentAmount(ticket.getPayment().getAmount().toString());
            searchTicketResponse.setPaymentDate(simpleDateFormat.format(ticket.getPayment().getDate()));

            PassengerDto passengerDto = new PassengerDto();
            passengerDto.setName(ticket.getPassenger().getName());
            passengerDto.setSurname(ticket.getPassenger().getSurname());
            passengerDto.setSurname(ticket.getPassenger().getSurname());
            passengerDto.setIdentityNumber(ticket.getPassenger().getIdentityNumber());
            searchTicketResponse.setPassengerDto(passengerDto);
        }
        return searchTicketResponse;
    }

    public CreateTicketResponseDto buyTicket(CreateTicketRequestDto createTicketRequestDto) throws Exception {
        Ticket ticket = new Ticket();
        Passenger passenger;

        if (createTicketRequestDto.getPassengerDto().getIdentityNumber() != null
                || String.valueOf(createTicketRequestDto.getPassengerDto().getIdentityNumber()).length() != 11){
           //TODO
            throw new Exception();
        }else {
            passenger = passengerRepository.findByIdentityNumber(createTicketRequestDto.getPassengerDto().getIdentityNumber());
            if (passenger == null){
                passenger = new Passenger();
                passenger.setIdentityNumber(createTicketRequestDto.getPassengerDto().getIdentityNumber());
                passenger.setName(createTicketRequestDto.getPassengerDto().getName());
                passenger.setSurname(createTicketRequestDto.getPassengerDto().getSurname());
                passenger.setAddress(createTicketRequestDto.getPassengerDto().getAddress());
                passenger.setEmail(createTicketRequestDto.getPassengerDto().getEmail());
                passenger.setTelephoneNumber(createTicketRequestDto.getPassengerDto().getTelephoneNumber());
                passenger.setDateOfBirth(simpleDateFormat.parse(createTicketRequestDto.getPassengerDto().getDateOfBirth()));
            }else{
                ticket.setPassenger(passenger);
            }

            Flight flight = flightRepository.findByFlightCode(createTicketRequestDto.getFlightCode());
            if (flight == null){
                //TODO
                throw new Exception();
            }
            ticket.setFlight(flight);
            ticket.setStatus(AptConstants.TICKET_ACTIVE_STATUS);

            Payment payment = new Payment();
            payment.setDate(new Date());
            payment.setTicket(ticket);

            double fullnessRate = (flight.getTotalSeats() - flight.getAvailableSeats()) * 100;
            double raiseRate = 10;//init value
            payment.setAmount(calculateAmount(fullnessRate, flight.getSeatPrice(), raiseRate));
            ticket.setPayment(payment);
            ticketRepository.save(ticket);

            CreateTicketResponseDto createTicketResponseDto = new CreateTicketResponseDto();
            createTicketResponseDto.setAmount(payment.getAmount().toString());
            createTicketResponseDto.setStatus(ticket.getStatus());
            createTicketResponseDto.setTicketNumber(ticket.getNumber());
            return createTicketResponseDto;
        }

    }

    private static double calculateAmount(Double fullnessRate, double starterPrice, double raiseRate) {
        int index = getIndex(fullnessRate);
        for (int i = 0; i < index; i++) {
            starterPrice = starterPrice + (starterPrice * raiseRate / 100);
        }
        return starterPrice;
    }

    private static int getIndex(Double fullnessRate) {
        return fullnessRate.intValue() / 10;
    }

    public String cancel(Long ticketNumber) {
        Ticket ticket = ticketRepository.findByNumber(ticketNumber);
        ticket.setStatus(AptConstants.TICKET_PASSIVE_STATUS);
        ticketRepository.save(ticket);
        return AptConstants.TICKET_CANCEL_PROCCESS_SUCCESS;
    }
}
