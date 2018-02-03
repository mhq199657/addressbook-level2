package seedu.addressbook.data.person;

/**
 * Represents unit number in Person's address
 */
public class Unit {
    private String unit;

    public Unit(String unit) {
        this.unit = unit;
    }

    /**
     *
     * @return Unit of Address
     */
    public String getUnit() {
        return unit;
    }
}
