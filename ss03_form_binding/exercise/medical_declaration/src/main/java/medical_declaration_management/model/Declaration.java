package medical_declaration_management.model;

public class Declaration {
    private int id;
    private String name;
    private String birthday;
    private String gender;
    private String country;
    private String idCard;
    private String vehicle;
    private String nameVehicle;
    private String numberOfSeats;
    private String startDay;
    private String endDay;
    private String theCityHasCome;

    public Declaration() {
    }

    public Declaration(int id, String name, String birthday, String gender, String country, String idCard,
                       String vehicle, String nameVehicle, String numberOfSeats, String startDay, String endDay, String theCityHasCome) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.country = country;
        this.idCard = idCard;
        this.vehicle = vehicle;
        this.nameVehicle = nameVehicle;
        this.numberOfSeats = numberOfSeats;
        this.startDay = startDay;
        this.endDay = endDay;
        this.theCityHasCome = theCityHasCome;
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public String getNameVehicle() {
        return nameVehicle;
    }

    public void setNameVehicle(String nameVehicle) {
        this.nameVehicle = nameVehicle;
    }

    public String getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(String numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getEndDay() {
        return endDay;
    }

    public void setEndDay(String endDay) {
        this.endDay = endDay;
    }

    public String getTheCityHasCome() {
        return theCityHasCome;
    }

    public void setTheCityHasCome(String theCityHasCome) {
        this.theCityHasCome = theCityHasCome;
    }
}
