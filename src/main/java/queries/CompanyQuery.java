package queries;

import entities.CompanyEntity;
import utils.loggers.CompanyLogger;

import java.util.List;

public class CompanyQuery extends QuerySetup {
    private CompanyEntity companyEntity;
    private List<CompanyEntity> listCompanyEntity;

    public CompanyQuery() {
        super();
    }

    public List<CompanyEntity> getAllCompanies() {

        //Get all companies using 'createQuery' operation
        listCompanyEntity = manager.createQuery("FROM company").getResultList();

        return listCompanyEntity;
    }

    public CompanyEntity getCompanyById(int id) {

        //Get company by id using 'find' operation
        companyEntity = manager.find(CompanyEntity.class, id);

        return companyEntity;
    }

    public List<CompanyEntity> getCompanyByName(String name) {
        //Get companies by name using 'createQuery' operation
        listCompanyEntity = manager.createQuery("SELECT cm FROM company cm WHERE cm.name = :name").setParameter("name", name).getResultList();
        return listCompanyEntity;
    }

    public int insertCompany(CompanyEntity company) {
        //Begin transaction
        transaction.begin();
        //Create a new company using 'persist' operation
        manager.persist(company);

        try {
            //Commit transaction
            transaction.commit();
            return company.getId();

        } catch (Exception e) {
            //Rollback transaction
            transaction.rollback();
            CompanyLogger.logger.info("Database was not updated");
            return -1;
        }
    }

    public int updateCompanyName(int id, String name, String phoneNumber, String email, String address) {

        companyEntity = getCompanyById(id);

        if (companyEntity != null) {
            //Update company attributes
            companyEntity.setName(name);
            companyEntity.setPhoneNumber(phoneNumber);
            companyEntity.setEmail(email);
            companyEntity.setAddress(address);

            //Begin transaction
            transaction.begin();
            //Update company using 'merge' operation
            manager.merge(companyEntity);

            try {
                //Commit transaction
                transaction.commit();
                return companyEntity.getId();

            } catch (Exception e) {
                //Rollback transaction
                transaction.rollback();
                CompanyLogger.logger.info("Database was not updated");
                return -1;
            }

        } else {
            CompanyLogger.logger.info("Company was not found");
            return -1;
        }
    }

    public int deleteCompany(int id) {

        companyEntity = getCompanyById(id);

        if (companyEntity != null) {

            //Begin transaction
            transaction.begin();
            //Delete company using 'remove' operation
            manager.remove(companyEntity);

            try {
                //Commit transaction
                transaction.commit();
                return companyEntity.getId();

            } catch (Exception e) {
                //Rollback transaction
                transaction.rollback();
                CompanyLogger.logger.info("Database was not updated");
                return -1;
            }

        } else {
            CompanyLogger.logger.info("Company was not found");
            return -1;
        }
    }
}
