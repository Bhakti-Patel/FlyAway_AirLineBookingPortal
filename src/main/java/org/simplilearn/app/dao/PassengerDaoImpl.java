package org.simplilearn.app.dao;

import java.util.ArrayList;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.simplilearn.app.entities.Airlines;
import org.simplilearn.app.entities.Flight;
import org.simplilearn.app.entities.Passenger;
import org.simplilearn.app.entities.TicketSummary;
import org.simplilearn.app.util.HibConfig;



public class PassengerDaoImpl implements PassengerDao {

	@Override
	public int savePassengerDetails(Passenger psg) {

		String msg = null;
		int passengerId = 0;

		System.out.println("Inside PassengerDaoImpl savePassengerDetails()..............");
		SessionFactory factory = HibConfig.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		try {
			passengerId = (Integer) session.save(psg);
			tx.commit();
		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			session.close();
		}
		return passengerId;

	}

	@Override
	public int saveFlightDetails(int passengerId, int airlineId,Date departureDate) {
		String message = null;
		int bookingId = 0;
		Flight flt = new Flight();
		System.out.println("Inside PassengerDaoImpl saveFlightDetails()..............");
		SessionFactory factory = HibConfig.getSessionFactory();
		Session session = factory.openSession();

		Query query1 = session
				.createQuery("select a from org.simplilearn.app.entities.Airlines a where a.airlineId = :airlineId");
		query1.setParameter("airlineId", airlineId);
		Query query2 = session.createQuery(
				"select p from org.simplilearn.app.entities.Passenger p where p.passengerId= :passengerId");
		query2.setParameter("passengerId", passengerId);

		Airlines a = (Airlines) (query1.uniqueResult());
		Passenger p = (Passenger) (query2.uniqueResult());

		Transaction tx = session.beginTransaction();

		try {

			flt.setAirlineId(airlineId);
			flt.setPassengerId(passengerId);
			flt.setTotalSeats(p.getTotalSeats());
			flt.setTicketPrice(a.getTicketPrice() * p.getTotalSeats());
			flt.setDepartureDate(departureDate);

			bookingId = (Integer) session.save(flt);
			tx.commit();
		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			session.close();
		}
		return bookingId;
	}

	public List getFlightDetails(int bookingId) {

		System.out.println("Inside PassengerDaoImpl getFlightDetails()..............");
		SessionFactory factory = HibConfig.getSessionFactory();
		Session session = factory.openSession();
		Query query = session
				.createQuery("SELECT \n"
						+ "    p.firstName,\n"
						+ "    p.lastName,\n"
						+ "    a.airlineName,\n"
						+ "    a.flightNo,\n"
						+ "    a.source,\n"
						+ "    a.destination,\n"
						+ "    f.departureDate,\n"
						+ "    a.departureTime,\n"
						+ "    f.totalSeats,\n"
						+ "    f.ticketPrice,\n"
						+ "    a.airlineId\n"
						+ "FROM\n"
						+ "    org.simplilearn.app.entities.Passenger p,\n"
						+ "    org.simplilearn.app.entities.Airlines a,\n"
						+ "    org.simplilearn.app.entities.Flight  f \n"
						+ "WHERE \n"
						+ "f.bookingId=: bookingId\n"
						+      "AND\n"
						+ "	a.airlineId=f.airlineId\n"
						+ "    AND\n"
						+ "    f.passengerId=p.passengerId");
		query.setParameter("bookingId", bookingId);
		
		/*
		 * List result =(List)query.list();
		 * 
		 * for(int i=0;i<result.size();i++)
		 * System.out.println("result.get(i)..........."+result.get(i));
		 * 
		 * 
		 * return result;
		 */
		
		Iterator iterator= query.list().iterator();
		TicketSummary tkt= new TicketSummary();
		ArrayList<TicketSummary> tktDetails= new ArrayList<>();
		    while(iterator.hasNext()){
		        Object[] o= (Object[]) iterator.next();
		        tkt.setFirstName((String)o[0]);
		        tkt.setLastName((String)o[1]);
		        tkt.setAirlineName((String)o[2]);
		        String flightNo =(String)(o[3]);
		        tkt.setFlightNo(flightNo);
		        tkt.setSource((String)o[4]);
		        tkt.setDestination((String)o[5]);
		        
		       
				
					
					try {
						
						
						 Date departureDate =(Date)o[6];
						 System.out.println("Departure Date in DAO. before.........."+departureDate);
						departureDate =new SimpleDateFormat("yyyy-MM-dd").parse(departureDate.toString()) ;
						 System.out.println("Departure Date in DAO. after.........."+departureDate);
						tkt.setDepartureDate(departureDate);
				        String departureTime = (String)o[7];
				        System.out.println("Departure Time in DAO. before.........."+departureTime);
				        System.out.println("Departure Time in DAO. After.........."+departureTime);
				        tkt.setDepartureTime(departureTime);
					} catch (ParseException e) {
						
						e.printStackTrace();
					}
					 
				
		       
		       
		        tkt.setTotalSeats((Integer)o[8]);
		        tkt.setTicketPrice((Integer)(o[9]));
		        tkt.setAirlineId((Integer)(o[10]));
		        tktDetails.add(tkt);
				
		    }
		    System.out.println("TktDetails :::::::::::::::::::"+tktDetails);
		    return tktDetails;
	}

}
