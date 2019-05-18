package Controlador;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Arrendador;
import model.Estudiante;
import model.Login;
import model.Vivienda;

@ManagedBean
@SessionScoped

public class ControladorLogin {
	
	 private static final String PERSISTENCE_UNIT_NAME = "proyecto";
	 private static EntityManagerFactory factory;
	 
	 private Login login;
	 private Estudiante estudiante;
	 private Arrendador arrendador;
	 private Vivienda vivienda;
	 private List<Login>logins;
	 public Login seleccionado;
	 
	 
	 public ControladorLogin() {
		 this.login= new Login();
		 this.estudiante=new Estudiante();
		 this.arrendador= new Arrendador();
		 this.vivienda= new Vivienda();
		 
		 
	 }

	 public void guardar() {
	        System.out.println("Inicio prueba Agregar");
	       
	        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	        EntityManager em = factory.createEntityManager();
	        em.getTransaction().begin();
	        em.persist(this.estudiante);
	        this.login.setUsuario(this.estudiante.getID_Estudiante());
	        this.login.setTipo_Usuario("Estudiante");
	        this.login.setID_Estudiante(this.estudiante.getID_Estudiante());
	        em.persist(this.login);   
	        em.getTransaction().commit();
	        em.close();
	    }
	 
	 public String guardarArrendador() {
	        System.out.println("Inicio prueba Agregar");
	       
	        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	        EntityManager em = factory.createEntityManager();
	        em.getTransaction().begin();
	        em.persist(this.arrendador);
	        this.login.setUsuario(this.arrendador.getID_Arrendador());
	        this.login.setTipo_Usuario("Arrendador");
	        this.login.setID_Arrendador(this.arrendador.getID_Arrendador());
	        em.persist(this.login);
	        em.getTransaction().commit();
	        em.close();
	        
	        return "login.xhtml";
	    }
	 
	 public String ingresar(){
		 System.out.println("Inicio prueba Agregar");
	       
	        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	        EntityManager em = factory.createEntityManager();
	        em.getTransaction().begin();
		 
	        Login consultaingresar = new Login();
	        consultaingresar=em.find(Login.class, this.login.getUsuario());
	        
	        em.close();
	        
	        if(consultaingresar!=null && consultaingresar.getContraseña().equals(this.login.getContraseña())) {
	        	
	        	if(consultaingresar.getTipo_Usuario().equals("Arrendador")) {
	        		
	        		return "mostrarViviendas.xhtml";
	        	}
	        	
	        	
	        }else {
	        	
	        	return "";
	        }
			return "mostrarViviendas.xhtml";
	        
	        
	        
	        
	        
	 }
	 
	 public void guardarVivienda() {
		 
		 System.out.println("Inicio prueba agregar vivienda");
		 
		 factory= Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		 EntityManager em= factory.createEntityManager();
		 em.getTransaction().begin();
		 em.persist(this.vivienda);
		
		 
		 em.getTransaction().commit();
		 em.close();
	 }
	 
	 public  Login getSeleccionado() {
	        System.out.println("Inicio Prueba toma");
	        return seleccionado;
	    }
	    public void setSeleccionado(Login login) {
	        System.out.println("Inicio Prueba recibe");
	        this.seleccionado=login;
	    }

	   
	    public Login getLogin() {
	       
	        return login;
	    }

	    public void setProducto(Login login) {
	        this.login = login;
	    }
	   
	    public List<Login> getLogins() {
	        return logins;
	    }
	   
	    public void setLogins(List<Login> logins) {
	        this.logins = logins;
	    }

		public Estudiante getEstudiante() {
			return estudiante;
		}

		public void setEstudiante(Estudiante estudiante) {
			this.estudiante = estudiante;
		}

		public void setLogin(Login login) {
			this.login = login;
		}

		public Arrendador getArrendador() {
			return arrendador;
		}

		public void setArrendador(Arrendador arrendador) {
			this.arrendador = arrendador;
		}

		public Vivienda getVivienda() {
			return vivienda;
		}

		public void setVivienda(Vivienda vivienda) {
			this.vivienda = vivienda;
		}
	    
	    
	   
	}
	 
	 

