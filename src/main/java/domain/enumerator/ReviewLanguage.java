package domain.enumerator;

/**
 *
 * @author Bartłomiej Skibiński
 */
public enum ReviewLanguage {

    SATISFACTORY("Satisfactiory"),
    NEEDS_CORRECTIONS("Needs corrections"),
    NEEDS_SUBSTANTIAL_REVISION_OR_REWRITING("Needs substantial revision or rewriting");

    private final String name;

    private ReviewLanguage(String name) {
        this.name = name;
    }

    public static ReviewLanguage getSATISFACTORY() {
        return SATISFACTORY;
    }

    public static ReviewLanguage getNEEDS_CORRECTIONS() {
        return NEEDS_CORRECTIONS;
    }

    public static ReviewLanguage getNEEDS_SUBSTANTIAL_REVISION_OR_REWRITING() {
        return NEEDS_SUBSTANTIAL_REVISION_OR_REWRITING;
    }

    public String getName() {
        return name;
    }

}
