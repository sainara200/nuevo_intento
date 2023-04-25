package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.TbUsuario; 

public class JPATest01 {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("clase_02");
		EntityManager em = fabrica.createEntityManager();

		List<TbUsuario> lstUsuarios = em.createQuery("Select a From TbUsuario a" ,TbUsuario.class).getResultList();
		System.out.println("==============================================");
		
		/*Mostrar cantidad de usuarios*/
		System.out.println("nro de usuarios:" +lstUsuarios.size());
		System.out.println("==============================================");
		
		/*Listar todos los usuarios*/
		System.out.println("Lista de usuarios:");
		System.out.println("-----------------");
		for(TbUsuario u: lstUsuarios){
			System.out.println("usuario: "+u.getNomUsua()+ " " + u.getApeUsua()+ " clave:"+ u.getClaUsua());
		}
		 
		System.out.println("==============================================");
		
		
		//inicializamos
		int opcion=0; 
		Scanner scanner=new Scanner(System.in);
		TbUsuario usu;
		
		EntityManager entity=Utiles.getEntityManagerFactory().createEntityManager();
		/*
		while(opcion!=5) {
			System.out.println("1.Ingresar nuevo usuario");
			System.out.println("2.Buscar usuario");
			System.out.println("3.Actualizar usuario");
			System.out.println("4.Eliminar un usuario");
			System.out.println("5.Salir de la interfaz");
			System.out.println("Elija...");
			
			opcion=scanner.nextInt();
			switch(opcion) {
			case 1:
				System.out.println("Digite el nombre;");
				usu=new TbUsuario(); 
				scanner.nextLine();
				usu.setNomUsua(scanner.nextLine());
				
				System.out.println("Digite el apellido;");
				usu.setApeUsua(scanner.nextLine()); 
				
				System.out.println("Digite la clave;");
				usu.setClaUsua(scanner.nextLine()); 
				 
				
				System.out.println("Digite el correo de usuario;");
				usu.setUsrUsua(scanner.nextLine()); 
				System.out.println(usu);
				entity.getTransaction().begin();
				entity.persist(usu);
				entity.getTransaction().commit();
				System.out.println("Usuario registrado");
				System.out.println(); 
				break;
				
				
				
			case 2:
				System.out.println("Digite el codigo del usuario a buscar");
				
				usu=new TbUsuario();
				usu=entity.find(TbUsuario.class, scanner.nextLong());
				
				if (usu!=null) {
					System.out.println(usu);
					System.out.println();
				}else {
					System.out.println();
					System.out.println("Usuario no encontrado");
					List<TbUsuario> listaUsu=new ArrayList<>();
					Query query= entity.createQuery("SELECT t FROM TbUsuario t");
					listaUsu=query.getResultList();
					for(TbUsuario usus:listaUsu) {
						System.out.println(usus);
					}
				}System.out.println();
				
				 break; 
			
		case 3:
			
			System.out.println("Digite el codigo del usuario a actualizar");
			
			usu=new TbUsuario();
			usu=entity.find(TbUsuario.class, scanner.nextLong());
			
			if (usu!=null) {
				System.out.println(usu);
				System.out.println("Digite el nombre del usuario");
				scanner.nextLine();
				usu.setNomUsua(scanner.nextLine());
				
				System.out.println("Digite el apellido;");
				usu.setApeUsua(scanner.nextLine()); 
				
				System.out.println("Digite la clave;");
				usu.setClaUsua(scanner.nextLine()); 
				 
				
				System.out.println("Digite el correo de usuario;");
				usu.setUsrUsua(scanner.nextLine()); 
				
				entity.getTransaction().begin();
				entity.merge(usu);
				entity.getTransaction().commit();
				
				System.out.println("Usuario actualizado");
				System.out.println(); 
			}else {
				System.out.println("Usuario no encontrado");
				System.out.println(); 
			}break;
			
			
case 4:
			
			System.out.println("Digite el codigo del usuario a eliminar");
			
			usu=new TbUsuario();
			usu=entity.find(TbUsuario.class, scanner.nextLong());
			
			if (usu!=null) {
				System.out.println(usu); 
				entity.getTransaction().begin();
				entity.remove(usu); 
				entity.getTransaction().commit();
				
				System.out.println("Usuario eliminado");
				System.out.println(); 
			}else {
				System.out.println("Usuario no encontrado...");
				System.out.println(); 
			}break;
				

				case 5:entity.close();Utiles.shutdown();
						break; 
			
		} 
		*/
		
		Query query=entity.createNativeQuery("{call logueo(?,?)}",TbUsuario.class);
		query.setParameter(1, "Juan");
		query.setParameter(2, "testeo1234");
		TbUsuario usut ;
		if(usut==null) {
			System.out.println("Usuario no existe");
		}else {
			
			System.out.println("Bienvenido "+ usut.getNomUsua());
			System.out.println("Tus datos son: "+usut);
			
		}System.out.println("-------------");
		
		}
		
	
	
	
	
	
	
	
	
	
	
	
	}
	
	
	
 
 







