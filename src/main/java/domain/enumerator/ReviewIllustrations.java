package domain.enumerator;

/**
 *
 * @author Bartłomiej Skibiński
 */
public enum ReviewIllustrations {

    ADEQUATE("Adequate"),
    INADEQUATE_TECHNICAL_QUALITY("Inadequate technical quality"),
    NON_VERY_INFORMATIVE("Non very informative"),
    SOME_MAY_BE_OMMITED("Some may be omitted (see Sec. III)"),
    MOORE_SHOULD_BE_ADDED("More should be added (see Sec. III)");

    private final String name;

    private ReviewIllustrations(String name) {
        this.name = name;
    }

    public static ReviewIllustrations getADEQUATE() {
        return ADEQUATE;
    }

    public static ReviewIllustrations getINADEQUATE_TECHNICAL_QUALITY() {
        return INADEQUATE_TECHNICAL_QUALITY;
    }

    public static ReviewIllustrations getNON_VERY_INFORMATIVE() {
        return NON_VERY_INFORMATIVE;
    }

    public static ReviewIllustrations getSOME_MAY_BE_OMMITED() {
        return SOME_MAY_BE_OMMITED;
    }

    public static ReviewIllustrations getMOORE_SHOULD_BE_ADDED() {
        return MOORE_SHOULD_BE_ADDED;
    }

    public String getName() {
        return name;
    }

}
