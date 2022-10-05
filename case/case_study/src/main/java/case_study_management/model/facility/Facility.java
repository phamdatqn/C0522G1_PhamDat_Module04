package case_study_management.model.facility;

import case_study_management.model.contract.Contract;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Facility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int area;
    private double cost;
    private String maxPeople;
    private String standardRoom;
    private String descriptionOtherConvenience;
    private String poolArea ;
    private String numberOfFloors;
    private String facilityFree;
    private boolean isDelete;


    @ManyToOne
    @JoinColumn(name = "rent_type_id",referencedColumnName = "id")
    private RentType rentType;

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    @ManyToOne
    @JoinColumn(name = "facility_type_id",referencedColumnName = "id")
    private FacilityType facilityType;

    public FacilityType getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(FacilityType facilityType) {
        this.facilityType = facilityType;
    }


    @OneToMany(mappedBy = "facility")
    private Set<Contract>contracts;

    public Set<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(Set<Contract> contracts) {
        this.contracts = contracts;
    }

    public Facility() {
    }

    public Facility(int id, String name, int area, double cost, String maxPeople, String standardRoom,
                    String descriptionOtherConvenience, String poolArea, String numberOfFloors, String facilityFree,
                    boolean isDelete, RentType rentType, FacilityType facilityType, Set<Contract> contracts) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.cost = cost;
        this.maxPeople = maxPeople;
        this.standardRoom = standardRoom;
        this.descriptionOtherConvenience = descriptionOtherConvenience;
        this.poolArea = poolArea;
        this.numberOfFloors = numberOfFloors;
        this.facilityFree = facilityFree;
        this.isDelete = isDelete;
        this.rentType = rentType;
        this.facilityType = facilityType;
        this.contracts = contracts;
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

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(String maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionOtherConvenience() {
        return descriptionOtherConvenience;
    }

    public void setDescriptionOtherConvenience(String descriptionOtherConvenience) {
        this.descriptionOtherConvenience = descriptionOtherConvenience;
    }

    public String getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(String poolArea) {
        this.poolArea = poolArea;
    }

    public String getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(String numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public String getFacilityFree() {
        return facilityFree;
    }

    public void setFacilityFree(String facilityFree) {
        this.facilityFree = facilityFree;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }
}
