/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.triskel.cmi.ejb.dao;

import com.triskel.cmi.ejb.dao.EmpresaDao;
import com.triskel.cmi.ejb.dao.EmpresaDao;
import java.util.Properties;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.apache.openjpa.persistence.PersistenceException;

import org.junit.After;
import org.junit.Before;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/**
 * Clase para configurar el persistence context y realizar pruebas unitarias
 * @author wwlopez
 */
public class GenericoTest {
    protected static final Logger logger = LogManager.getLogger(GenericoTest.class);
           
    static EntityManager entityManager;
    static EmpresaDao empresaDao;
    
    
    @After
    public void cerraSession(){
        logger.error("cerraSession");
       entityManager.close();
    }

    @Before
    public void iniciarContenedor(){
        
        logger.error("iniciarContenedor");
       
            
        
        Properties props = new Properties();
        props.put("openjpa.Log", "DefaultLeve=WARN,SQL=TRACE");
        props.put("openjpa.ConnectionDriverName", "org.postgresql.Driver");
        props.put("openjpa.ConnectionURL", "jdbc:postgresql://localhost:5432/tris_cmi");
        props.put("openjpa.ConnectionUserName", "postgres");
        props.put("openjpa.ConnectionPassword", "root");
        props.put("openjpa.DynamicEnhancementAgent","false");
                
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("cmi-ejbPU", props);
        entityManager = factory.createEntityManager();
        
        empresaDao = new EmpresaDao();
        empresaDao.setEntityManager(entityManager);
       
    }
            
}


/*
COBIS 5


public class BranchTestBase {
	
	protected static ILogger logger = LogFactory .getLogger(BranchTestBase.class);
	
	
	static BranchTxServiceImpl branchTxServiceImpl;	
	static TellerDrawerManagerImpl tellerDrawerManagerImpl;
	static OfficeManagerImpl officeManagerImpl;
	static NotificationManagerImpl notificationManagerImpl;	
	static DenominationManagerImpl denominationManagerImpl;	
	static EntityManager em;

	@After
	public void pseudoBlueprintContainerClose() {
		// logger.logDebug("pseudoBlueprintContainerClose");
		em.close();
	}
	
	@Before
	public void pseudoBlueprintContainerInit() {
		// logger.logDebug("pseudoBlueprintContainerInit");
		branchTxServiceImpl = new BranchTxServiceImpl();
		TransactionManagerImpl transactionManagerImpl = new TransactionManagerImpl();
		tellerDrawerManagerImpl = new TellerDrawerManagerImpl();
		OfficeManagerImpl officeManagerImpl = new OfficeManagerImpl();
		DenominationManagerImpl denominationManagerImpl = new DenominationManagerImpl();
		NotificationManagerImpl notificationManagerImpl = new NotificationManagerImpl();
		
		
		//LoanManagerImpl loanManagerImpl = new LoanManagerImpl();
//		FraudControlManagerImpl fraudControlManagerImpl = new FraudControlManagerImpl();
//		CampaignManagerImpl campaignManagerImpl = new CampaignManagerImpl();

		JournalDAOImpl journalDAOImpl = new JournalDAOImpl();
		TransactionDAOImpl transactionDAOImpl = new TransactionDAOImpl();
		TellerDrawerDAOImpl tellerDrawerDAOImpl = new TellerDrawerDAOImpl();
		OfficeDAOImpl officeDAOImpl = new OfficeDAOImpl();	
		DenominationDAOImpl denominationDAOImpl = new DenominationDAOImpl();
		
		
		branchTxServiceImpl.setTransactionManager(transactionManagerImpl);
		branchTxServiceImpl.setTellerDrawerManager(tellerDrawerManagerImpl);
		branchTxServiceImpl.setTellerDrawerManager(tellerDrawerManagerImpl);
		branchTxServiceImpl.setOfficeManager(officeManagerImpl);
		branchTxServiceImpl.setNotificationManager(notificationManagerImpl);
		branchTxServiceImpl.setDenominationManager(denominationManagerImpl);		
		
		//branchTxServiceImpl.setLoanManager(loanManagerImpl);
		notificationManagerImpl.setOfficeManager(officeManagerImpl);

		tellerDrawerManagerImpl.setTellerDrawerDAO(tellerDrawerDAOImpl);
		tellerDrawerManagerImpl.setTransactionDAO(transactionDAOImpl);
		tellerDrawerManagerImpl.setNotificationManager(notificationManagerImpl);
		tellerDrawerManagerImpl.setTransactionManager(transactionManagerImpl);
		
		transactionManagerImpl.setJournalDAO(journalDAOImpl);
		transactionManagerImpl.setTellerDrawerDAO(tellerDrawerDAOImpl);
		transactionManagerImpl.setTransactionDAO(transactionDAOImpl);
		
		denominationManagerImpl.setDenominationDAO(denominationDAOImpl);
		
		
		officeManagerImpl.setOfficeDAO(officeDAOImpl);
		officeManagerImpl.setTransactionDAO(transactionDAOImpl);
		officeManagerImpl.setTellerDrawerDAO(tellerDrawerDAOImpl);
		
		
		String username="falta";
		String officeId="1";
		String roleId="3";
		String processDate="10/25/2013";
		String servername="CTSSRV";

		CobisSession wCobisSession = new CobisSession( "878889", "1",username, roleId, "", "COBIS", officeId, "termx", servername, "1");
		int ssn = (int) Math.abs(System.currentTimeMillis());
		if (ssn < 0)
			ssn = ssn * -1;
		Server wServer = new Server("CTSSRV", Integer.toString(ssn),processDate);
		CobisContext wCobisContext = new CobisContext(wCobisSession,wServer);
		ContextRepository.setContext(wCobisContext);

		
		Properties props = new Properties();
		props.put("openjpa.Log", "DefaultLevel=WARN,SQL=TRACE");
		props.put("openjpa.ConnectionDriverName","com.sybase.jdbc3.jdbc.SybDriver");
		props.put("openjpa.ConnectionURL","jdbc:sybase:Tds:192.168.64.241:5000");
		props.put("openjpa.ConnectionUserName", "sa");
		props.put("openjpa.ConnectionPassword", "sybjfq2k14");
		
		//HARDENING
		
		Properties props = new Properties();
		props.put("openjpa.Log", "DefaultLevel=WARN,SQL=TRACE");
		props.put("openjpa.ConnectionDriverName","com.sybase.jdbc3.jdbc.SybDriver");
		props.put("openjpa.ConnectionURL","jdbc:sybase:Tds:192.168.66.205:5000");
		props.put("openjpa.ConnectionUserName", "desarrollo");
		props.put("openjpa.ConnectionPassword", "desarrollo");
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("branchTest", props);
		em = factory.createEntityManager();
		journalDAOImpl.setEntityManager(em);		
		tellerDrawerDAOImpl.setEntityManager(em);	
		officeDAOImpl.setEntityManager(em);
		transactionDAOImpl.setEntityManager(em);
		denominationDAOImpl.setEntityManager(em);
		
	}

}



*/