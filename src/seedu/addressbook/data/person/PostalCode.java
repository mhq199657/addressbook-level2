package seedu.addressbook.data.person;

public class PostalCode {
    private String postalCode;

    public PostalCode(String postalCode){
        this.postalCode = postalCode;
    }

    /**
     *
     * @return postalCode of Address
     */
    public String getPostalCode() {
        return postalCode;
    }

    @Override
    public String toString() {
        return postalCode;
    }
}
