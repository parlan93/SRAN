package domain.enumerator;

/**
 *
 * @author Bartłomiej Skibiński
 */
public enum ReviewConclusionDrawn {

    ADEQUATE("Adequate"),
    NOT_JUSTIFIED("Not justified"),
    SUFFER_FROM_SUBSTANTIAL_OMISSIONS("Suffer from substantial omissions"),
    SUFFER_FROM_LOOSE_GENERALISATIONS("Suffer from loose generalisations");

    private final String name;

    private ReviewConclusionDrawn(String name) {
        this.name = name;
    }

    public static ReviewConclusionDrawn getADEQUATE() {
        return ADEQUATE;
    }

    public static ReviewConclusionDrawn getNOT_JUSTIFIED() {
        return NOT_JUSTIFIED;
    }

    public static ReviewConclusionDrawn getSUFFER_FROM_SUBSTANTIAL_OMISSIONS() {
        return SUFFER_FROM_SUBSTANTIAL_OMISSIONS;
    }

    public static ReviewConclusionDrawn getSUFFER_FROM_LOOSE_GENERALISATIONS() {
        return SUFFER_FROM_LOOSE_GENERALISATIONS;
    }

    public String getName() {
        return name;
    }

}
