package seedu.addressbook.data.person;

public class Contact {
    public String value;
    private boolean isPrivate;

    public Contact(boolean isPrivate) {
        this.isPrivate = isPrivate;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || ((other.getClass() == this.getClass()) // instanceof handles nulls
                && this.value.equals(((Contact) other).value)); // state check
    }
}
