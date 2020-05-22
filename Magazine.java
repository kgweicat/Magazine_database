import linkedlist.IDedObject;

/**
 *
 * @author Che-Wei (Joanne) Chou
 */
public class Magazine implements IDedObject {

    private int magazineID;
    private String magazineName;
    private String publisherName;

    /**
     * Construct a magazine object with the given parameters
     *
     * @param id
     * @param magazine
     * @param publisher
     */
    public Magazine(int id, String magazine, String publisher) {
        magazineID = id;
        magazineName = magazine;
        publisherName = publisher;
    }

    /**
     * Print out the ID of the magazine.
     */
    @Override
    public void printID() {
        System.out.println(magazineID);
    }

    /**
     * get the id.
     *
     * @return the id of the magazine.
     */
    @Override
    public int getID() {
        return magazineID;
    }

    public String magazineName() {
        return magazineName;
    }

    public String publisherName() {
        return publisherName;
    }

    /**
     * toString
     *
     * @return magazine info formatted in
     * magazineID\nmagazineName\npublishedName
     */
    @Override
    public String toString() {
        String result = "";
        result += magazineID + "\n";
        result += magazineName + "\n";
        result += publisherName + "\n";
        return result;
    }

}
