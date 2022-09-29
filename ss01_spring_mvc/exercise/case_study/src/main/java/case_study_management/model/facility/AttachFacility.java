package case_study_management.model.facility;

import case_study_management.model.contract.ContractDetail;

import javax.persistence.*;
import java.util.Set;

@Entity
public class AttachFacility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double cost;
    private String unit;
    private String status;
    private boolean isDelete;

    @OneToMany(mappedBy = "attachFacility")
    private Set<ContractDetail> contractDetail;

    public Set<ContractDetail> getContractDetail() {
        return contractDetail;
    }

    public void setContractDetail(Set<ContractDetail> contractDetail) {
        this.contractDetail = contractDetail;
    }

    public AttachFacility() {
    }

    public AttachFacility(int id, String name, double cost, String unit, String status, boolean isDelete,
                          Set<ContractDetail> contractDetail) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.unit = unit;
        this.status = status;
        this.isDelete = isDelete;
        this.contractDetail = contractDetail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }
}
