package domain.enumerator;

/**
 *
 * @author Bartłomiej Skibiński
 */
public enum ReviewLiteratureReferences {

    ADEQUATE("Adequate"),
    INADEQUATE("Inadequate"),
    SOME_MAY_BE_OMITTED("Some may be omitted"),
    MORE_SHOULD_BE_ADDED("More should be added (see Sec. III)");

    private final String name;

    private ReviewLiteratureReferences(String name) {
        this.name = name;
    }

    public static ReviewLiteratureReferences getADEQUATE() {
        return ADEQUATE;
    }

    public static ReviewLiteratureReferences getINADEQUATE() {
        return INADEQUATE;
    }

    public static ReviewLiteratureReferences getSOME_MAY_BE_OMITTED() {
        return SOME_MAY_BE_OMITTED;
    }

    public static ReviewLiteratureReferences getMORE_SHOULD_BE_ADDED() {
        return MORE_SHOULD_BE_ADDED;
    }

    public String getName() {
        return name;
    }

}
