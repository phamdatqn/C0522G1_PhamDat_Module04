package case_study_management.dto;

import case_study_management.model.facility.FacilityType;
import case_study_management.model.facility.RentType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class FacilityDto implements Validator {
    private int id;

    @NotBlank(message = "Tên dịch vụ không được để trống.")
    @Pattern(regexp = "^([\\p{Lu}][\\p{Ll}0-9]{1,8})(\\s([\\p{Lu}]|[\\p{Ll}][\\p{Ll}0-9]{1,10}))*$",
            message = "Tên dịch vụ được phép chứa số, và các kí tự đầu tiên của mỗi từ phải viết hoa.")
    private String name;


    @Min(value = 1, message = "Phải la số dương.")
    private int area;

    @Min(value = 1, message = "Phải la số dương.")
    private double cost;

    @NotBlank(message = "Số người tối đa không được để trống.")
    @Pattern(regexp = "^[1-9]\\d*$", message = "Số người tối đa phải là số nguyên dương.")
    private String maxPeople;
    private String standardRoom;
    private String descriptionOtherConvenience;

    @Pattern(regexp = "^[1-9]\\d*$", message = "Diện tích hồ bơi phải là số nguyên dương.")
    private String poolArea;

    @Pattern(regexp = "^[1-9]\\d*$", message = "Số tầng phải là số nguyên dương.")
    private String numberOfFloors;
    private String facilityFree;
    private boolean isDelete;
    private RentType rentType;

    @NotNull
    private FacilityType facilityType;

    public FacilityDto() {
    }

    public FacilityDto(int id, String name, int area, double cost, String maxPeople, String standardRoom,
                       String descriptionOtherConvenience, String poolArea, String numberOfFloors,
                       String facilityFree, boolean isDelete, RentType rentType, FacilityType facilityType) {
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
    }

    public FacilityDto(int id) {
        this.id = id;
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

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public FacilityType getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(FacilityType facilityType) {
        this.facilityType = facilityType;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
