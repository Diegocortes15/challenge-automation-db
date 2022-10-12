package utils.crud;

import entities.CompanyEntity;
import queries.CompanyQuery;
import utils.loggers.CompanyLogger;

import java.util.List;

public class CompanyCrud {
    CompanyQuery companyQuery = new CompanyQuery();
    List<CompanyEntity> companyEntityList;
    CompanyEntity companyEntity;

    //Execute queries and print the results

    public void getAllCompanies() {
        companyEntityList = companyQuery.getAllCompanies();

        if (companyEntityList.size() != 0) {
            for (CompanyEntity com :
                    companyEntityList) {
                printCompanyInfo(com);
                System.out.println();
            }
        } else {
            CompanyLogger.logger.info("No companies were found");
        }
    }

    public CompanyEntity getCompanyById(int id) {
        companyEntity = companyQuery.getCompanyById(id);

        if (companyEntity != null) {
            printCompanyInfo(companyEntity);
        } else {
            CompanyLogger.logger.info(String.format("The company with id %s wasn't found", id));
        }
        return companyEntity;
    }

    public List<CompanyEntity> getCompanyByName(String name) {
        companyEntityList = companyQuery.getCompanyByName(name);

        if (companyEntityList.size() != 0) {
            for (CompanyEntity com :
                    companyEntityList) {
                printCompanyInfo(com);
                System.out.println();
            }
        } else {
            CompanyLogger.logger.info(String.format("The company with name '%s' wasn't found", name));
        }
        return companyEntityList;
    }

    public void insertNewCompany(int id, String name, String email, String address, String phone) {

        companyEntity = new CompanyEntity();
        companyEntity.setId(id);
        companyEntity.setName(name);
        companyEntity.setEmail(email);
        companyEntity.setAddress(address);
        companyEntity.setPhoneNumber(phone);

        int companyId = companyQuery.insertCompany(companyEntity);

        if (companyId != -1) {
            CompanyLogger.logger.info(String.format("A new company with id %s was created", id));
        } else {
            CompanyLogger.logger.info("No company was created");
        }
    }

    public void updateCompany(int id, String name, String email, String address, String phone) {

        int companyId = companyQuery.updateCompanyName(id, name, phone, email, address);

        if (companyId != -1) {
            CompanyLogger.logger.info(String.format("The company with id %s was updated", id));
        } else {
            CompanyLogger.logger.info("No company was updated");
        }
    }

    public void deleteCompany(int id) {

        int companyId = companyQuery.deleteCompany(id);

        if (companyId != -1) {
            CompanyLogger.logger.info(String.format("The company with id %s was deleted", id));
        } else {
            CompanyLogger.logger.info("No company was deleted");
        }

    }

    //print the company information
    public void printCompanyInfo(CompanyEntity company) {
        System.out.printf("Company Id: %s", company.getId());
        System.out.printf("Company name: %s", company.getName());
        System.out.printf("Company email: %s", company.getEmail());
        System.out.printf("Company phone: %s", company.getPhone());
        System.out.printf("Company address: %s", company.getAddress());
    }


}
