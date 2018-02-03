package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, some street, B01, 456789";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses should be in the format of 'block number, street, unit number, postalcode'";
    public static final String ADDRESS_VALIDATION_REGEX = ".+?(?=,),.+?(?=,),.+?(?=,),.+";
    private static final String SEPERATOR = ",";
    private static final int INDEX_BLOCK = 0;
    private static final int INDEX_STREET = 1;
    private static final int INDEX_UNIT = 2;
    private static final int INDEX_POSTAL_CODE = 3;
    public final String value;
    public final Block block;
    public final Street street;
    public final Unit unit;
    public final PostalCode postalCode;
    private boolean isPrivate;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        String trimmedAddress = address.trim();
        this.isPrivate = isPrivate;
        if (!isValidAddress(trimmedAddress)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        this.value = trimmedAddress;
        String[] addressComponents = trimmedAddress.split(SEPERATOR);
        this.block = new Block(addressComponents[INDEX_BLOCK]);
        this.street = new Street(addressComponents[INDEX_STREET]);
        this.unit = new Unit(addressComponents[INDEX_UNIT]);
        this.postalCode = new PostalCode((addressComponents[INDEX_POSTAL_CODE]));


    }

    /**
     * Returns true if a given string is a valid person address.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return assembleAddressFromComponents();
    }

    private String assembleAddressFromComponents(){
        return block + SEPERATOR + street+ SEPERATOR + unit+ SEPERATOR + postalCode;
    }
    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.value.equals(((Address) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
