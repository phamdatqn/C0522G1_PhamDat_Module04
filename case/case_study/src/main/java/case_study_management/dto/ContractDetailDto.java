package case_study_management.dto;

import case_study_management.model.contract.Contract;
import case_study_management.model.facility.AttachFacility;

public class ContractDetailDto {
    private int id;
    private int amount;
    private boolean isDelete;
    private Contract contract;
    private AttachFacility attachFacility;

    public ContractDetailDto() {
    }

    public ContractDetailDto(int id, int amount, boolean isDelete, Contract contract, AttachFacility attachFacility) {
        this.id = id;
        this.amount = amount;
        this.isDelete = isDelete;
        this.contract = contract;
        this.attachFacility = attachFacility;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public AttachFacility getAttachFacility() {
        return attachFacility;
    }

    public void setAttachFacility(AttachFacility attachFacility) {
        this.attachFacility = attachFacility;
    }
}
