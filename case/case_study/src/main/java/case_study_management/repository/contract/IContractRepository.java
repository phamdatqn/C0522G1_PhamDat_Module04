package case_study_management.repository.contract;

import case_study_management.dto.IContractDto;
import case_study_management.model.contract.Contract;
import case_study_management.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface IContractRepository extends JpaRepository<Contract,Integer> {
    @Query(value = "select * from contract where customer_id like %:keySearch% and is_delete = false", nativeQuery = true)
    Page<Contract> findByNameCustomer(@Param("keySearch") String keySearch, Pageable pageable);

   @Query(value = "select * from contract where customer_id like %:keySearch% and is_delete = false", nativeQuery = true)
   List<IContractDto> findByNa(@Param("keySearch") String keySearch, Pageable pageable);

//    int getIdDto();
//    Date getStartDate();
//    Date getEndDate();
//    double getTotalMoney();
//    double getDeposit();
//    String getNameCustomerDto();
//    String getNameEmployeeDto();
//    String getNameFacilityDto();

    @Query(value = "select contract.id as contractId, contract.start_date ,contract.end_date , contract.deposit as deposit, facility.name as facilityName,"+
            "employee.name as employeeName, customer.name as customerName,(facility.cost + contract.deposit + sum(ifnull(contract_detail.amount, 0) * ifnull(attach_facility.cost, 0)))"+
            "as totalMoney from contract left join facility on contract.facility_id = facility.id"+
            "left join employee on contract.employee_id = employee.id"+
            "left join customer on contract.customer_id = customer.id"+
            "left join contract_detail on contract_detail.contract_id = contract.id"+
            "left join attach_facility on attach_facility.id = contract_detail.attach_facility_id"+
            "where contract.is_delete = false and facility_type.id !=3 "+
           " group by contract.id",
            countQuery = "select count(*)"+
    "from contract"+
    "left join facility on contract.facility_id = facility.id"+
    "left join employee on contract.employee_id = employee.id"+
    "left join contract_detail on contract_detail.contract_id = contract.id"+
    "left join attach_facility on attach_facility.id = contract_detail.attach_facility_id"+
    "where contract.is_delete = false"+
    "group by contract.id",
            nativeQuery = true)
    List<IContractDto> findByNameCustomerDto(@Param("keySearch")String search);

    @Query(value = "update contract is_delete=1 where id= :idDelete and is_delete=0",nativeQuery = true)
    void deleteByIdContract(@Param("idDelete") int id);
}
