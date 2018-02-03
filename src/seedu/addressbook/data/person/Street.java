package seedu.addressbook.data.person;

/**
 * Represents the Street of Person's Address
 */
public class Street {
    private String street;

    public Street(String street){
        this.street = street;
    }

    /**
     *
     * @return street of the address
     */
    public String getStreet() {
        return street;
    }

    @Override
    public String toString(){
        return street;
    }
}
