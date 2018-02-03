package domain.enumerator;

/**
 *
 * @author Bartłomiej Skibiński
 */
public enum ReviewTables {

    ADEQUATE("Adequate"),
    SHOULD_BE_REARRANGED_TO_IMPROVE_CLARITY("Should be rearranged to improve clarity"),
    SOME_MAY_BE_OMITTED("Some may be omitted"),
    MORE_SHOULD_BE_ADDED("More should be added (see Sec. III");

    private final String name;

    private ReviewTables(String name) {
        this.name = name;
    }

    public static ReviewTables getADEQUATE() {
        return ADEQUATE;
    }

    public static ReviewTables getSHOULD_BE_REARRANGED_TO_IMPROVE_CLARITY() {
        return SHOULD_BE_REARRANGED_TO_IMPROVE_CLARITY;
    }

    public static ReviewTables getSOME_MAY_BE_OMITTED() {
        return SOME_MAY_BE_OMITTED;
    }

    public static ReviewTables getMORE_SHOULD_BE_ADDED() {
        return MORE_SHOULD_BE_ADDED;
    }

    public String getName() {
        return name;
    }

}
