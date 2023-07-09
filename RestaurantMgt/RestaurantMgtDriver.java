package HibernateProj.RestaurantMgt;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class RestaurantMgtDriver {

	private static final Scanner scan = new Scanner(System.in);
	
	
	
	
	
	
	static void showMenu1() {
		System.out.println("|===============================================|");
		System.out.println("|	Press 1 to add restaurant in system	|");
		System.out.println("|	Press 2 to display all restaurants	by id |");
		System.out.println("|	Press 3 to Update restaurant	by id	|");
		System.out.println("|	Press 4 to Delete Restaurants	by id	|");
		System.out.println("|	Press 5 to exit			|");
		System.out.println("|===============================================|");

	}
	
	public static void main(String args[])
	{
		Configuration config=new Configuration().configure().addAnnotatedClass(RestaurantsMgt.class);
		SessionFactory sessionFact = config.buildSessionFactory();
		Session session = sessionFact.openSession();
		insertRest(session);
		
		


		int restop;
		do {
			showMenu1();
			System.out.print("=========Enter your option=========");
			restop = scan.nextInt();
			switch(restop)
			{
			case 1:
				System.out.println("Insert All Data");
				insertRest(session);
				break;		

			case 2:
				System.out.println("Display By id Data");
				updateRestDetails(session);
				break;

			case 3:
				System.out.println("Delete the Data");
				deleteRest(session);
				break;

			default:
				if(restop != 5)
					System.out.println("Enter proper options...");
			}

		}while(restop != 6);

	}
	
	
	
	
		private static void insertRest(Session session)
		{
			session.beginTransaction();
			Integer insertKey = (Integer) session.save(getRestaurantName());
			session.getTransaction().commit();
			System.out.println("Inser restaurant with ID"+insertKey);
//			session.close();
		}
		
		private static void readRestById(Session session)
		{
			System.out.println("Enter id of restaurant for searching");
			int restaurantId = scan.nextInt();
			RestaurantsMgt restFromDb=session.get(RestaurantsMgt.class, restaurantId);
			if(restFromDb != null)
			{
				System.out.println(restFromDb);
			}
			else
			{
				System.out.println("Restaurant with this id is not present!!!!!!!");
			}			
		}
		
		private static void updateRestDetails(Session session)
		{
			System.out.println("Enter the restaurant id for updating ");
			int restaurantId = scan.nextInt();
			RestaurantsMgt restFromDb=session.get(RestaurantsMgt.class, restaurantId);
			if(restFromDb != null)
			{
				System.out.println("Enter Rest Name");
				restFromDb.setRestaurantName(scan.next());
				
				System.out.println("Enter Rest Avg Cost");
				restFromDb.setAvgCost(scan.nextInt());
				
				System.out.println("Enter Rating");
				restFromDb.setRating(scan.nextInt());
				
				System.out.println("Enter rest Owner Name");
				restFromDb.setOwnerName(scan.next());
				
				Integer updatedRecordId =(Integer)session.save(restFromDb);
				
				session.beginTransaction().commit();
//				session.close();
				
				System.out.println("updated record with id :"+ updatedRecordId);
				
			}
			else
			{
				System.out.println("Restaurant with this id is not present!!!!!!");
			}
		}

		private static void deleteRest(Session session)
		{
			System.out.println("Enter the rest id for delete");
			int restaurantId=scan.nextInt();
			RestaurantsMgt restFromDb=session.get(RestaurantsMgt.class, restaurantId);
			if(restFromDb != null)
			{
				session.beginTransaction();
				session.delete(restFromDb);
				session.getTransaction().commit();
//				session.close();
			
			}
			else
			{
				System.out.println("Restaurant with this id is not present!!!!!!");
			}

			
		}

		
		private static RestaurantsMgt getRestaurantName() {
			RestaurantsMgt restObj=new RestaurantsMgt();
			

			
			System.out.println("Enter Rest Name");
			restObj.setRestaurantName(scan.next());
			
			System.out.println("Enter Rest Avg Cost");
			restObj.setAvgCost(scan.nextInt());
			
			System.out.println("Enter Rating");
			restObj.setRating(scan.nextInt());
			
			System.out.println("Enter rest Owner Name");
			restObj.setOwnerName(scan.next());
			
			return 	restObj;
		}
}

