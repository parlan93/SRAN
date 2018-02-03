package domain.enumerator;

/**
 *
 * @author Bartłomiej Skibiński
 */
public enum ReviewPresentation {

    ADEQUATE("Adequate"),
    TOO_BRIEF_FOR_CLARITY("Too brief for clarity"),
    TOO_COMPREHENSIVE_SHOULD_BE_SHORTENED("Too comprehensive, should be shortended"),
    GENERAL_ORGANISATION_UNSUITABLE("General organisation unsuitable"),
    BADLY_WRITTEN_HARDLY_READABLE("Badly written, hardly readable"),
    CONTAINS_IRRELEVANT_MATERIAL("Contains irrelevant material");

    private final String name;

    private ReviewPresentation(String name) {
        this.name = name;
    }

    public static ReviewPresentation getADEQUATE() {
        return ADEQUATE;
    }

    public static ReviewPresentation getTOO_BRIEF_FOR_CLARITY() {
        return TOO_BRIEF_FOR_CLARITY;
    }

    public static ReviewPresentation getTOO_COMPREHENSIVE_SHOULD_BE_SHORTENED() {
        return TOO_COMPREHENSIVE_SHOULD_BE_SHORTENED;
    }

    public static ReviewPresentation getGENERAL_ORGANISATION_UNSUITABLE() {
        return GENERAL_ORGANISATION_UNSUITABLE;
    }

    public static ReviewPresentation getBADLY_WRITTEN_HARDLY_READABLE() {
        return BADLY_WRITTEN_HARDLY_READABLE;
    }

    public static ReviewPresentation getCONTAINS_IRRELEVANT_MATERIAL() {
        return CONTAINS_IRRELEVANT_MATERIAL;
    }

    public String getName() {
        return name;
    }

}
