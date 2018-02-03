package domain.enumerator;

/**
 *
 * @author Bartłomiej Skibiński
 */
public enum ReviewAFU {

    CONFORM_TO_ACCEPTED_FORM("Conform to accepted from"),
    SHOULD_BE_CHANGED("Should be changed"),
    SHOULD_BE_EXPLAINED("Should be explained");

    private final String name;

    private ReviewAFU(String name) {
        this.name = name;
    }

    public static ReviewAFU getCONFORM_TO_ACCEPTED_FORM() {
        return CONFORM_TO_ACCEPTED_FORM;
    }

    public static ReviewAFU getSHOULD_BE_CHANGED() {
        return SHOULD_BE_CHANGED;
    }

    public static ReviewAFU getSHOULD_BE_EXPLAINED() {
        return SHOULD_BE_EXPLAINED;
    }

    public String getName() {
        return name;
    }

}
