package domain.enumerator;

/**
 *
 * @author Bartłomiej Skibiński
 */
public enum ReviewAbstract {

    CLEAR_AND_ADEQUATE("Clear and adequate"),
    SHOULD_BE_REWRITTEN("Should be rewritting (or missing)");

    private final String name;

    private ReviewAbstract(String name) {
        this.name = name;
    }

    public static ReviewAbstract getCLEAR_AND_ADEQUATE() {
        return CLEAR_AND_ADEQUATE;
    }

    public static ReviewAbstract getSHOULD_BE_REWRITTEN() {
        return SHOULD_BE_REWRITTEN;
    }

    public String getName() {
        return name;
    }

}
