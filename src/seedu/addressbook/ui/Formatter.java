package seedu.addressbook.ui;

import java.util.List;

import static seedu.addressbook.common.Messages.*;

public class Formatter {
    /** A decorative prefix added to the beginning of lines printed by AddressBook */
    private static final String LINE_PREFIX = "|| ";

    /** A platform independent line separator. */
    private static final String LS = System.lineSeparator();

    private static final String DIVIDER = "===================================================";

    /** Format of indexed list item */
    private static final String MESSAGE_INDEXED_LIST_ITEM = "\t%1$d. %2$s";


    /** Offset required to convert between 1-indexing and 0-indexing.  */
    public static final int DISPLAYED_INDEX_OFFSET = 1;

    /** Format of a comment input line. Comment lines are silently consumed when reading user input. */
    private static final String COMMENT_LINE_FORMAT_REGEX = "#.*";

    /**
     * Formats message to be displayed
     * @param message
     * @return a message to be displayed by Textui
     */
    public static String formatMessage(String... message) {
        StringBuilder formattedMessage = new StringBuilder();
        for (String m : message) {
            formattedMessage.append(LINE_PREFIX + m.replace("\n", LS + LINE_PREFIX));
            formattedMessage.append(LS);
        }
        return formattedMessage.toString();
    }

    /**
     * Creates a message prompt for user's input
     * @return the message to be prompted before user's input
     */
    public static String getUserInputMessage() {
        return LINE_PREFIX + "Enter command: ";
    }

    /**
     * Creates a message that Echoes user's input
     * @param fullInputLine the user input
     * @return the echo message to be displayed by Textui
     */
    public static String getEchoMessage(String fullInputLine) {
        return formatMessage("[Command entered:" + fullInputLine + "]");
    }

    /**
     * Creates a String that shows information on storage file
     * @param storageFilePath
     * @return the message on storage file information
     */
    public static String getStorageFileInfo(String storageFilePath) {
        return String.format(MESSAGE_USING_STORAGE_FILE, storageFilePath);
    }

    /**
     * Creates a message for welcome
     * @param version version of the addressBook
     * @param storageFileInfo information on the storageFile
     * @return the welcome message
     */
    public static String getWelcomeMessage(String version, String storageFileInfo) {
        return formatMessage(
                DIVIDER,
                DIVIDER,
                MESSAGE_WELCOME,
                version,
                MESSAGE_PROGRAM_LAUNCH_ARGS_USAGE,
                storageFileInfo,
                DIVIDER);
    }

    /**
     *
     * @return a goodbye message
     */
    public static String getGoodbyeMessage() {
        return formatMessage(MESSAGE_GOODBYE, DIVIDER, DIVIDER);
    }

    /**
     *
     * @return a message to inform initialisation failure
     */
    public static String getInitFailedMessage() {
        return formatMessage(MESSAGE_INIT_FAILED, DIVIDER, DIVIDER);
    }

    /**
     *
     * @param feedback to be displayed
     * @return a message containing feedback
     */
    public static String getResultMessage(String feedback) {
        return formatMessage(feedback, DIVIDER);
    }

    /**
     *
     * @param list to be displayed
     * @return a formatted message of the list
     */
    public static String getListMessage(String list){
        return formatMessage(list);
    }

    /** Formats a list of strings as a viewable indexed list. */
    public static String getIndexedListForViewing(List<String> listItems) {
        final StringBuilder formatted = new StringBuilder();
        int displayIndex = 0 + DISPLAYED_INDEX_OFFSET;
        for (String listItem : listItems) {
            formatted.append(getIndexedListItem(displayIndex, listItem)).append("\n");
            displayIndex++;
        }
        return formatted.toString();
    }

    /**
     * Formats a string as a viewable indexed list item.
     *
     * @param visibleIndex visible index for this listing
     */
    private static String getIndexedListItem(int visibleIndex, String listItem) {
        return String.format(MESSAGE_INDEXED_LIST_ITEM, visibleIndex, listItem);
    }

    /**
     * Returns true if the user input line is a comment line.
     *
     * @param rawInputLine full raw user input line.
     * @return true if input line is a comment.
     */
    private static boolean isCommentLine(String rawInputLine) {
        return rawInputLine.trim().matches(COMMENT_LINE_FORMAT_REGEX);
    }

    /**
     * Returns true if the user input line should be ignored.
     * Input should be ignored if it is parsed as a comment, is only whitespace, or is empty.
     *
     * @param rawInputLine full raw user input line.
     * @return true if the entire user input line should be ignored.
     */
    public static boolean shouldIgnore(String rawInputLine) {
        return rawInputLine.trim().isEmpty() || isCommentLine(rawInputLine);
    }


}
