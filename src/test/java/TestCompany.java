import data.CompanyData;
import entities.CompanyEntity;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import utils.crud.CompanyCrud;
import utils.loggers.CompanyLogger;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class TestCompany {

    CompanyCrud companyCrud = new CompanyCrud();

    @Test
    @Description("Get all companies")
    public void getAllCompanies() {
        CompanyLogger.logger.info("Test: Get all companies");
        companyCrud.getAllCompanies();
    }

    @Test
    @Description("Get companies by name")
    public void getCompanyByName() {
        CompanyLogger.logger.info("Test: Get companies by name");
        List<CompanyEntity> companiesByName = companyCrud.getCompanyByName(CompanyData.COMPANY_BY_NAME);
        if (companiesByName.size() != 0) {
            companiesByName.forEach(company -> assertThat(company.getName().toLowerCase(), equalTo(CompanyData.COMPANY_BY_NAME.toLowerCase())));
        } else {
            System.out.printf("The company with name %s was not found%n", CompanyData.COMPANY_BY_NAME);
        }
    }

    @Test
    @Description("Get company by id")
    public void getCompanyById() {
        CompanyLogger.logger.info("Test: Get company by id");
        CompanyEntity company = companyCrud.getCompanyById(CompanyData.COMPANY_BY_ID);
        assertThat(company.getId(), equalTo(CompanyData.COMPANY_BY_ID));
    }

    @Test
    @Description("Insert new company")
    public void insertNewCompany() {
        CompanyLogger.logger.info("Test: Insert new company");
        companyCrud.insertNewCompany(
                CompanyData.NEW_COMPANY.getId(),
                CompanyData.NEW_COMPANY.getName(),
                CompanyData.NEW_COMPANY.getEmail(),
                CompanyData.NEW_COMPANY.getAddress(),
                CompanyData.NEW_COMPANY.getPhone());

        CompanyEntity newCompany = companyCrud.getCompanyById(CompanyData.NEW_COMPANY.getId());
        assertThat(newCompany.getId(), equalTo(CompanyData.NEW_COMPANY.getId()));
        assertThat(newCompany.getName(), equalTo(CompanyData.NEW_COMPANY.getName()));
        assertThat(newCompany.getEmail(), equalTo(CompanyData.NEW_COMPANY.getEmail()));
        assertThat(newCompany.getAddress(), equalTo(CompanyData.NEW_COMPANY.getAddress()));
        assertThat(newCompany.getPhone(), equalTo(CompanyData.NEW_COMPANY.getPhone()));

        companyCrud.deleteCompany(newCompany.getId());
    }

    @Test
    @Description("Update new company")
    public void updateCompany() {
        CompanyLogger.logger.info("Test: Update new company");
        companyCrud.insertNewCompany(
                CompanyData.NEW_COMPANY.getId(),
                CompanyData.NEW_COMPANY.getName(),
                CompanyData.NEW_COMPANY.getEmail(),
                CompanyData.NEW_COMPANY.getAddress(),
                CompanyData.NEW_COMPANY.getPhone());

        CompanyEntity newCompany = companyCrud.getCompanyById(CompanyData.NEW_COMPANY.getId());
        assertThat(newCompany.getId(), equalTo(CompanyData.NEW_COMPANY.getId()));
        assertThat(newCompany.getName(), equalTo(CompanyData.NEW_COMPANY.getName()));
        assertThat(newCompany.getEmail(), equalTo(CompanyData.NEW_COMPANY.getEmail()));
        assertThat(newCompany.getAddress(), equalTo(CompanyData.NEW_COMPANY.getAddress()));
        assertThat(newCompany.getPhone(), equalTo(CompanyData.NEW_COMPANY.getPhone()));

        companyCrud.updateCompany(
                newCompany.getId(),
                CompanyData.UPDATE_COMPANY.getName(),
                CompanyData.UPDATE_COMPANY.getEmail(),
                CompanyData.UPDATE_COMPANY.getAddress(),
                CompanyData.UPDATE_COMPANY.getPhone());
        companyCrud.getCompanyById(CompanyData.UPDATE_COMPANY.getId());

        CompanyEntity updatedCompany = companyCrud.getCompanyById(newCompany.getId());

        assertThat(updatedCompany.getName(), equalTo(CompanyData.UPDATE_COMPANY.getName()));
        assertThat(updatedCompany.getEmail(), equalTo(CompanyData.UPDATE_COMPANY.getEmail()));
        assertThat(updatedCompany.getAddress(), equalTo(CompanyData.UPDATE_COMPANY.getAddress()));
        assertThat(updatedCompany.getPhone(), equalTo(CompanyData.UPDATE_COMPANY.getPhone()));

        companyCrud.deleteCompany(updatedCompany.getId());
    }

    @Test
    @Description("Delete company")
    public void deleteCompany() {
        CompanyLogger.logger.info("Test: Delete company");
        companyCrud.insertNewCompany(
                CompanyData.NEW_COMPANY.getId(),
                CompanyData.NEW_COMPANY.getName(),
                CompanyData.NEW_COMPANY.getEmail(),
                CompanyData.NEW_COMPANY.getAddress(),
                CompanyData.NEW_COMPANY.getPhone());

        CompanyEntity newCompany = companyCrud.getCompanyById(CompanyData.NEW_COMPANY.getId());
        assertThat(newCompany.getId(), equalTo(CompanyData.NEW_COMPANY.getId()));
        assertThat(newCompany.getName(), equalTo(CompanyData.NEW_COMPANY.getName()));
        assertThat(newCompany.getEmail(), equalTo(CompanyData.NEW_COMPANY.getEmail()));
        assertThat(newCompany.getAddress(), equalTo(CompanyData.NEW_COMPANY.getAddress()));
        assertThat(newCompany.getPhone(), equalTo(CompanyData.NEW_COMPANY.getPhone()));

        companyCrud.deleteCompany(newCompany.getId());
        CompanyEntity removedCompany = companyCrud.getCompanyById(newCompany.getId());
        assertThat(removedCompany, equalTo(null));
    }
}
