package case_study_management.dto;

import java.sql.Date;

public interface IContractDto {
    int getIdDto();

    Date getStartDateDto();

    Date getEndDateDto();

    double getTotalMoneyDto();

    double getDepositDto();

    String getNameCustomerDto();

    String getNameEmployeeDto();

    String getNameFacilityDto();
}
