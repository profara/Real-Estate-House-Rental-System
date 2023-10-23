/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import db.DbBrokerImpl;
import repository.db.DbConnectionFactory;
import repository.db.DbRepository;
import repository.db.impl.RepositoryStan;

/**
 *
 * @author Alek
 */
public abstract class AbstractSO {
    
    protected DbBrokerImpl dbBroker;
    
    public AbstractSO(){
        dbBroker = new DbBrokerImpl();
    }
        

    public void execute(Object param) throws Exception {
        try {
            precondition(param);
            startTransaction();
            executeOperation(param);
            commitTransaction();
            System.out.println("Uspesno izvrsena operacija!");
        } catch (Exception ex) {
            System.out.println("Neuspesno izvrsena operacija!");
            rollbackTransaction();
            throw ex;
        } finally{
            closeConnection();
        }
    }

    protected abstract void precondition(Object param) throws Exception;

    protected abstract void executeOperation(Object param) throws Exception;

    private void startTransaction() throws Exception{

    }
    
    protected void closeConnection() throws Exception {
        DbConnectionFactory.getInstance().getKonekciju().close();
    }

    protected void commitTransaction() throws Exception{
        DbConnectionFactory.getInstance().getKonekciju().commit();
    }

    protected void rollbackTransaction() throws Exception{
        DbConnectionFactory.getInstance().getKonekciju().rollback();
    }
    
    

}
